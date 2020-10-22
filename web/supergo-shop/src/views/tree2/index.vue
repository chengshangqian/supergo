<template>
  <div class="app-container">

    <el-row>
      <el-col :span="12">
        <el-button-group class="handleBtnBox">
          <el-button @click="addNew">新建</el-button>
          <el-button @click="deleteP">删除</el-button>
          <el-button @click="goUpFn">上架</el-button>
          <el-button @click="goDownFn">下架</el-button>
          <el-button >库存管理</el-button>
          <el-button >价格调整</el-button>
          <el-button @click="$router.go(0)">刷新</el-button>
        </el-button-group>
      </el-col>

       <!-- 暂时砍掉
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

          商品名称：
          <el-input v-model="seachName" placeholder="请输入商品名称" class="searchInp"></el-input>
          <el-button icon="el-icon-search" circle @click="searchFn"></el-button>
       </el-col> -->
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
      <el-table-column align="center" label="商品ID" width="100">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="产品ID" width="100">
        <template slot-scope="scope">
          {{ scope.row.goodsId }}
        </template>
      </el-table-column>
      <el-table-column label="商品名称">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>
      <el-table-column label="商品售价" width="150" align="center">
        <template slot-scope="scope">
          <span>{{scope.row.price}}</span>
        </template>
      </el-table-column>
      <el-table-column label="商品供价" width="150" align="center">
        <template slot-scope="scope">
          {{ scope.row.marketPrice }}
        </template>
      </el-table-column>
      <el-table-column label="库存" width="150" align="center">
        <template slot-scope="scope">
          {{ scope.row.num }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="状态" width="200" align="center">
        <template slot-scope="scope">
          <!-- <el-tag :type="scope.row.auditStatus | statusFilter">{{ scope.row.auditStatus }}</el-tag> -->

          <div class="tag-group">
            <el-tag
              v-for="item in scope.row.statusList"
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
          <el-button type="primary" 
            @click="editProduct({
              id:scope.row.id,
              name:scope.row.title,
              price:scope.row.price,
              marketPrice:scope.row.marketPrice,
              num:scope.row.num,
              status:scope.row.status
              })">修改</el-button>
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


    <!-- 修改 -->
    <el-dialog title="商品信息修改" :visible.sync="changeDialog" width="600px">
      <h3>{{editObj.name}}</h3>
      <el-form>
        <el-form-item label="产品售价">
          <el-input v-model="editObj.price" placeholder="请输入内容" class="change-price"></el-input>
        </el-form-item>
        <el-form-item label="产品供价">
          <el-input v-model="editObj.marketPrice" placeholder="请输入内容" class="change-price"></el-input>
        </el-form-item>
        <el-form-item label="产品库存">
          <el-input v-model="editObj.num" placeholder="请输入内容" class="change-price"></el-input>
        </el-form-item>
        <el-form-item label="产品状态">
          <el-select v-model="editObj.status"  placeholder="请选择状态">
            <el-option label="上架" value="1"></el-option>
            <el-option label="下架" value="2"></el-option>
            <el-option label="已删除" value="3"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="changeDialog = false">取 消</el-button>
        <el-button type="primary" @click="changeDialog = false">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { getList,getcategoryName,sendDelete,goUp,goDown } from '@/api/tree2'

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
      pageNow:0,
      category:[],
      selectList:[],
      searchSelect:'',
      searchStatusList:[
        { value: '', label: '全部' },
        { value: 1, label: '上架' },
        { value: 2, label: '下架' },
        { value: 3, label: '已删除' },
      ],
      seachName:'',
      changeDialog:false,
      editObj:{}
    }
  },
  created() {
    this.fetchData({page:0})
  },
  methods: {
    fetchData(params) {
      this.listLoading = true
      getList(params).then(response => {

        console.log(response)

        this.total=response.data.total
        this.list = response.data.rows

        this.list.forEach(item=>{
          // 显示状态
          item.statusList=[
            { type: 'info', label: '上架' },
            { type: 'info', label: '下架' },
            { type: 'info', label: '已删除' },
          ]

          item.statusList[item.status-1].type='';

      })
       
        this.listLoading = false
      })

    },
    addNew(){
      this.$router.push('/example/table2')
    },
    goUpFn(){
      if(!this.selectList.length){
         this.$message.error('请选中需要上架的商品');
         return;
      }

      goUp(this.selectList).then(res=>{
        this.$message.success('上架成功！');
        this.fetchData({page:this.pageNow})
      })
    },
    goDownFn(){
      if(!this.selectList.length){
         this.$message.error('请选中需要下架的商品');
         return;
      }

      goDown(this.selectList).then(res=>{
        this.$message.success('下架成功！');
        this.fetchData({page:this.pageNow})
      })
    },
    deleteP(){

      if(!this.selectList.length){
         this.$message.error('请选中需要删除的产品列表');
         return;
      }

      this.$confirm('确定删除？').then(res=>{

            sendDelete(this.selectList).then(res=>{
                this.$message.success('删除成功！');
                this.fetchData({page:this.pageNow})
            })

      }).catch(res=>{
        // 取消删除
      });

       
    },
    searchFn(){
        this.fetchData({page:0,name:this.seachName,status:this.searchSelect})
    },
    changePage(pageNum){
      this.pageNow=pageNum;
      this.fetchData({page:pageNum})
    },
    editProduct(params){
        console.log(params)
        this.editObj=params;
        this.changeDialog=true;
    },
    handleSelectionChange(selection){
      this.selectList=[];
      selection.forEach((item,index)=>{
        this.selectList[index]=item.id;
      })
    },
    filterType(item,typeLevel){
      let res=this.category.filter(item2=>{
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

.change-price{
  width: 200px;
}

</style>

