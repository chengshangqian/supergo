<template>
  <div class="app-container">
    <h3>填写商品信息</h3>
    <el-main class="tabBox">
      <el-row class="rows">
        <el-col :span="4"><div class="grid-content grid-tit">选择产品</div></el-col>
        <el-col :span="20"><div class="grid-content">
            <el-input v-model="goodsName" placeholder="请选择商品" class="goodsNameInp"></el-input>
            <el-button @click="showProduct">选择产品</el-button>
        </div></el-col>
      </el-row>
      <el-row class="rows" v-for="(key,val) in chooseList" :key="val" >
        <el-col :span="4"><div class="grid-content grid-tit">{{val}}</div></el-col>
        <el-col :span="20"><div class="grid-content">
          <el-checkbox-group v-model="configure[val]" size="mini">
            <el-checkbox-button @change="changeConfig" v-for="val in key" :label="val.optionName" :key="val.id">{{val.optionName}}</el-checkbox-button>
          </el-checkbox-group>
        </div></el-col>
      </el-row>
      
      <el-row class="btnRow">
         <el-button type="primary" @click="saveFn">保存</el-button>
         <el-button @click="back">返回</el-button>
      </el-row>
    </el-main>


    <!-- 2019-7-3 -->
    <el-dialog title="选择产品" :visible.sync="choiceGoodsBool">
      <el-row>
        <el-input v-model="searchName" placeholder="搜索产品名称，未通过审核的不显示" class="choiceGoodsSearch"></el-input>
        <el-button icon="el-icon-search" @click="searchFn">查询</el-button>
      </el-row>
      <el-table :data="goodsList">
        <el-table-column property="id" label="ID" width="150"></el-table-column>
        <el-table-column property="goodsName" label="名称" width="200"></el-table-column>
        <el-table-column property="category1Id" label="一级"></el-table-column>
        <el-table-column property="category2Id" label="二级"></el-table-column>
        <el-table-column property="category3Id" label="三级"></el-table-column>
        <el-table-column label="操作">
            <el-button type="primary" slot-scope="scope"  @click="choseTemplate(scope.row.typeTemplateId,scope.row.goodsName,scope.row)">选择</el-button>
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
    </el-dialog>

  </div>
</template>

<script>

import { getList,getProName,chooseTemplate,savePost } from '@/api/table2'


export default {
  data() {
    return {
      goodsName:'',
      choiceGoodsBool:false,
      goodsList:[],
      total:0,
      searchName:'',
      chooseList:'',
      configure:{},
      goodsId:''
    }
  },
  mounted() {
  },
  methods: {
    back(){
      this.$router.go(-1);
    },
    getProductTab(params){
      getList(params).then(res => {
        this.goodsList=res.data.rows;
        this.total=res.data.total;
        
        this.category=JSON.parse(window.sessionStorage.getItem('typeList'));
        if(this.category){
          this.goodsList.forEach(item=>{
            item.category1Id=this.filterType(item,'category1Id');
            item.category2Id=this.filterType(item,'category2Id');
            item.category3Id=this.filterType(item,'category3Id');
          })
        }

      });
    },
    changePage(val){
        this.getProductTab({page:val});
    },
    showProduct(){
      this.getProductTab({page:0});
      this.choiceGoodsBool=true;
    },
    choseTemplate(id,name,row){
      chooseTemplate(id).then(res=>{
          this.choiceGoodsBool=false;
          this.chooseList = res.data;
          this.goodsName=name;
          this.row=row;

          for(let obj in this.chooseList){
            console.log(obj)
            this.configure[obj]=[];
          }

      })
    },
    searchFn(){
        this.getProductTab({page:0,name:this.searchName})
    },
    saveFn(){
        savePost({
          goodsId:this.row.id,
          title:this.goodsName,
          price:0,
          num:0,
          spec:{

          }
          
        }).then(res=>{
          console.log(res,888)
        })
    },
    changeConfig(){
      console.log(this.configure)
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
  },

}
</script>
<style lang="scss">
   .grid-content{
     height: 60px;
     border: 1px solid #CCC;
     border-bottom:none;
     border-right:none;
     line-height: 60px;
     padding: 0 20px;
   }
   .grid-tit{
     background: #EEE;
     text-align: center;
   }

  .grid-content:nth-last-child(1){
    border-right: 1px solid #CCC;
  }

   .rows:nth-last-child(1) .grid-content{
     border-bottom: 1px solid #CCC;
   }

   .editorRow .grid-content{
     height: 330px;
   }

   .btnRow{
     margin:20px 0;
   }


  // 2019-7-3
   .goodsNameInp{
     width: 300px;
   }

   .choiceGoodsSearch{
     width:400px;
   }

   .pageBox{
     margin: 10px 0;   
  }
</style>

