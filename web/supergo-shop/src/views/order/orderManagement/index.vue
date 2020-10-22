<template>
  <div class="app-container">

    <el-row>
      <el-col :span="8">
        <el-button-group class="handleBtnBox">
          <el-button @click="$router.go(0)">刷新</el-button>
        </el-button-group>
      </el-col>

       <el-col :span="16" :offset="0">
          订单状态：
           <el-select v-model="searchSelect" placeholder="请选择" class="searchSelect">
            <el-option
              v-for="item in statusList"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>

          订单号：
          <el-input v-model="seachName" placeholder="请输入订单号" class="searchInp"></el-input>
          下单人：
          <el-input v-model="seachName" placeholder="请输入订单号" class="searchInp"></el-input>
          下单时间：
          <el-date-picker
            v-model="date"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
          </el-date-picker>
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
      <el-table-column align="center" label="订单号" width="200">
        <template slot-scope="scope">
          {{ scope.row.orderId }}
        </template>
      </el-table-column>
      <el-table-column label="收货地址" width="200" align="center">
        <template slot-scope="scope">
          <span>{{scope.row.receiverAreaName}}</span>
        </template>
      </el-table-column>
      <el-table-column label="收货人" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.receiver }}
        </template>
      </el-table-column>
      <el-table-column label="联系方式" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.receiverMobile }}
        </template>
      </el-table-column>
      <el-table-column label="结算金额" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.payment }}
        </template>
      </el-table-column>
      <el-table-column label="下单人" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.buyerNick }}
        </template>
      </el-table-column>
      <el-table-column label="下单时间" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.createTime }}
        </template>
      </el-table-column>
      <el-table-column label="订单状态"  align="center">
        <template slot-scope="scope">
          {{ statusList[scope.row.status].label }}
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
import { getList } from '@/api/orderManagement'

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
      date:'',
      list: null,
      listLoading: true,
      //2019-7-5 17:26:46
      
      total:0,
      category:[],
      selectList:[],
      searchSelect:'',
      statusList:[
        { value: '', label: '未知' },
        { value: 1, label: '未付款' },
        { value: 2, label: '已付款' },
        { value: 3, label: '未发货' },
        { value: 4, label: '已发货' },
        { value: 5, label: '交易成功' },
        { value: 6, label: '交易关闭' },
        { value: 7, label: '待评价' },
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

