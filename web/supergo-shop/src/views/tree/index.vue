<template>
  <div class="app-container">

    <el-row>
      <el-col :span="12">
        <el-button-group class="handleBtnBox">
          <el-button @click="addNew">新建</el-button>
          <el-button @click="deleteP">删除</el-button>
          <el-button @click="putStatus">提交审核</el-button>
          <el-button >运费模板</el-button>
          <el-button @click="$router.go(0)">刷新</el-button>
        </el-button-group>
      </el-col>

       <el-col :span="6" :offset="6">
          状态：
           <el-select v-model="searchSelect" placeholder="请选择" class="searchSelect">
            <el-option
              v-for="item in searchStatusList"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>

          产品名称：
          <el-input v-model="seachName" placeholder="请输入产品名称" class="searchInp"></el-input>
          <el-button icon="el-icon-search" circle @click="searchFn"></el-button>
       </el-col>
    </el-row>

    

    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      @selection-change="handleSelectionChange"
      >
      <el-table-column
      type="selection"
      width="35"
      >
    </el-table-column>
      <el-table-column align="center" label="产品ID" width="200">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="产品名称">
        <template slot-scope="scope">
          {{ scope.row.goodsName }}
        </template>
      </el-table-column>
      <el-table-column label="一级分类" width="200" align="center">
        <template slot-scope="scope">
          <span>{{scope.row.category1Id}}</span>
        </template>
      </el-table-column>
      <el-table-column label="二级分类" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.category2Id }}
        </template>
      </el-table-column>
      <el-table-column label="三级分类" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.category3Id }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="状态" width="300" align="center">
        <template slot-scope="scope">
          <!-- <el-tag :type="scope.row.auditStatus | statusFilter">{{ scope.row.auditStatus }}</el-tag> -->

          <div class="tag-group">
            <el-tag
              v-for="item in scope.row.auditStatusList"
              :key="item.label"
              :type="item.type"
              effect="plain">
              {{ item.label }}
            </el-tag>
          </div>

        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="操作" width="200">
        <template slot-scope="scope">
          <el-button type="primary" @click="editProduct(scope.row.id)">修改</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <el-pagination
     class="pageBox"
      background
      layout="prev, pager, next"
      :total="total"
      @current-change="changePage"
      >
    </el-pagination>

  </div>
</template>

<script>
import { getList,getcategoryName,sendDelete,sendStatus } from '@/api/table2'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      listLoading: true,
      total:0,
      category:[],
      selectList:[],
      searchSelect:'',
      searchStatusList:[
        { value: '', label: '全部' },
        { value: 0, label: '未申请' },
        { value: 1, label: '审核通过' },
        { value: 2, label: '申请中' },
        { value: 3, label: '已驳回' },
      ],
      seachName:''
    }
  },
  created() {
    this.fetchData({page:0})
  },
  methods: {
    fetchData(params) {
      this.listLoading = true
      getList(params).then(response => {

        this.total=response.data.total
        this.list = response.data.rows
        
          //获取品类
          getcategoryName().then(res=>{
            this.category=res.data;
            if(!(sessionStorage.getItem('typeList'))){
              //本地存储
              sessionStorage.setItem("typeList",JSON.stringify(this.category));  
            }
          })
        

        this.list.forEach(item=>{
          // 显示状态
          item.auditStatusList=[
            { type: 'info', label: '未申请' },
            { type: 'info', label: '审核通过' },
            { type: 'info', label: '申请中' },
            { type: 'info', label: '已驳回' },
          ]

          item.auditStatusList[item.auditStatus].type='';

          

          //显示品类
          if(item.category1Id || item.category2Id || item.category3Id){
              item.category1Id=this.filterType(item,'category1Id')
              item.category2Id=this.filterType(item,'category2Id')
              item.category3Id=this.filterType(item,'category3Id')
          }else{
            item.category1Id = item.category2Id  = item.category3Id = '未填'
          }
      })
       
        this.listLoading = false
      })

    },
    addNew(){
      this.$router.push('/example')
    },
    deleteP(){

      if(!this.selectList.length){
         this.$message.error('请选中需要删除的产品列表');
         return;
      }

      this.$confirm('确定删除？').then(res=>{

            sendDelete(this.selectList).then(res=>{
                this.$message.success('删除成功！');
                this.fetchData({page:0})
            })

      }).catch(res=>{
        // 取消删除
      });

       
    },
    searchFn(){
        this.fetchData({page:0,name:this.seachName,status:this.searchSelect})
    },
    changePage(pageNum){
        this.fetchData({page:pageNum})
    },
    editProduct(id){
        this.$router.push('/example/editProduct/'+id);
    },
    handleSelectionChange(selection){
      this.selectList=[];
      selection.forEach((item,index)=>{
        this.selectList[index]=item.id;
      })
    },
    putStatus(){
      if(!this.selectList.length){
         this.$message.error('请选中提交审核内容！');
         return;
      }

      this.$confirm('确定提交审核吗？').then(res=>{
            sendStatus(this.selectList).then(res=>{
                this.$message.success('提交成功！');
                this.fetchData({page:0})
            })
      }).catch(res=>{
        // 取消提交审核
      });
    },
    filterType(item,typeLevel){
      let category=JSON.parse(sessionStorage.getItem("typeList"));  
      if(!category)return;

      let res=category.filter(item2=>{
        if(item2.id==item[typeLevel]){
          return true;
        }else{
          return false;
        }
      })[0];
      
      if(res){
        return res.name;
      }else{
        return '未填'
      }

    }
  }
}
</script>
<style lang="scss">
.handleBtnBox{
  margin-bottom: 20px;
}

.pageBox{
  margin-top:20px;
}

.searchSelect{
  width: 100px;
}

.searchInp{
  width: 130px;
}

</style>

