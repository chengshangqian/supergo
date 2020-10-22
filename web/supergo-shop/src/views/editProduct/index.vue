<template>
  <div class="app-container">
    <h3>修改产品基本信息</h3>
    <el-main class="tabBox">
      <el-row class="rows">
        <el-col :span="4"><div class="grid-content grid-tit">产品分类</div></el-col>
        <el-col :span="20"><div class="grid-content">
            <el-select v-model="value" placeholder="请选择" @change="changeFirst">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value" 
                >
              </el-option>
            </el-select>

            <el-select v-model="value2" placeholder="请选择"  @change="changeSecond">
              <el-option
                v-for="item in options2"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>


            <el-select v-model="value3" placeholder="请选择" @change="changeThird">
              <el-option
                v-for="item in options3"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
        </div></el-col>
      </el-row>
      <el-row class="rows">
        <el-col :span="4"><div class="grid-content grid-tit">产品名称</div></el-col>
        <el-col :span="20"><div class="grid-content">
          <el-input v-model="productName" placeholder="产品名称"></el-input>
        </div></el-col>
      </el-row>
      <el-row class="rows">
        <el-col :span="4"><div class="grid-content grid-tit">品牌</div></el-col>
        <el-col :span="20"><div class="grid-content">
          <el-select v-model="brandName" placeholder="请选择品牌" >
              <el-option
                v-for="item in brands"
                :key="item.value"
                :label="item.label"
                :value="item.value" 
                >
              </el-option>
            </el-select>
        </div></el-col>
      </el-row>
      <el-row class="rows">
        <el-col :span="4"><div class="grid-content grid-tit">副标题</div></el-col>
        <el-col :span="20"><div class="grid-content">
          <el-input v-model="subProductName" placeholder="副标题"></el-input>
        </div></el-col>
      </el-row>
      <el-row class="rows editorRow">
        <el-col :span="4"><div class="grid-content grid-tit">产品介绍</div></el-col>
        <el-col :span="20"><div class="grid-content">
          <editor  v-model="content" :init="editorInit"></editor>
        </div></el-col>
      </el-row>
      <el-row class="rows">
        <el-col :span="4"><div class="grid-content grid-tit">包装列表</div></el-col>
        <el-col :span="20"><div class="grid-content">
           <el-input type="textarea" v-model="packingList"></el-input>
        </div></el-col>
      </el-row>
      <el-row class="rows">
        <el-col :span="4"><div class="grid-content grid-tit">售后服务</div></el-col>
        <el-col :span="20"><div class="grid-content">
           <el-input type="textarea" v-model="afterSaleService"></el-input>
        </div></el-col>
      </el-row>
      <el-row class="btnRow">
         <el-button type="primary" @click="saveEditFn">保存</el-button>
         <el-button @click="back">返回</el-button>
      </el-row>
    </el-main>
  </div>
</template>

<script>
//富文本
import tinymce from 'tinymce/tinymce'
import 'tinymce/themes/silver/theme'
import Editor from '@tinymce/tinymce-vue'

import { getList,getProName,getList2,saveEdit } from '@/api/editProduct'


export default {
  components:{
    Editor
  },
  data() {
    return {
      options: [],
      options2: [],
      options3: [],
      value: '1',
      value2: '2',
      value3: '3',
      brandName:'',
      brands:[],
      productName:'',
      subProductName:'',
      content:'',
      packingList:'',
      afterSaleService:'',
      editorInit:{
        language_url: '/tinymce/zh_CN.js',
        language: 'zh_CN',
        skin_url: '/tinymce/skins/ui/oxide/',
        height: 300
      },
      productId:0
    }
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      //获取修改原始值
     this.productId=this.$route.params.id;

      getList(this.productId).then(res => {
        this.category1Id=res.data.category1Id;
        this.category2Id=res.data.category2Id;
        this.category3Id=res.data.category3Id;
        this.value=this.showTypeName(res.data.category1Id);
        this.value2=this.showTypeName(res.data.category2Id);
        this.value3=this.showTypeName(res.data.category3Id);
        this.productName=res.data.goodsName;
        this.brandName=res.data.brandId;
        this.subProductName=res.data.caption;
        this.content=res.data.goodsDesc.introduction;
        this.packingList=res.data.goodsDesc.packageList;
        this.afterSaleService=res.data.goodsDesc.saleService;
      })

       //获取分类
      getList2(0).then(res => {
        let _this=this;
        res.data.forEach((item,index)=>{
          let obj={};
          obj.label=item.name;
          obj.value=item.id;
          _this.options.push(obj);
        })
      })


      // 获取品牌
      getProName().then(res => {
        let _this=this;
        res.data.forEach((item,index)=>{
          let obj={};
          obj.label=item.name;
          obj.value=item.id;
          _this.brands.push(obj);
        })
      })
    },
    changeFirst(val){

      this.value2=this.value3='';
      this.options3=[];

      this.category1Id=val;

      getList2(val).then(res=>{
        let _this=this;
        this.options2=[];
        res.data.forEach((item,index)=>{
          let obj={};
          obj.label=item.name;
          obj.value=item.id;
          _this.options2.push(obj);
        })
      })
    },
    changeSecond(val){

      this.category2Id=val;

      this.value3='';

      getList2(val).then(res=>{
        let _this=this;
        this.options3=[];
        res.data.forEach((item,index)=>{
          let obj={};
          obj.label=item.name;
          obj.value=item.id;
          _this.options3.push(obj);
        })
      })
    },
    changeThird(val){
      this.category3Id=val;
    },
    saveEditFn(){
        // console.log(this.productId,this.category1Id,this.category2Id,this.category3Id,this.productName,this.brandName,this.subProductName,this.content,this.packingList,this.afterSaleService)

        if(!this.category3Id) {this.$message.error('请选择分类！'); return;}
        if(!this.brandName) {this.$message.error('请选择品牌！'); return;}

        saveEdit({
            id:this.productId,
            category1Id:this.category1Id,
            category2Id:this.category2Id,
            category3Id:this.category3Id,
            goodsName:this.productName,
            brandId:this.brandName,
            caption:this.subProductName,
            goodsDesc:{
               itemImages:"[{'color':'红色','url':'http://192.168.25.133/group1/M00/00/01/wKgZhVmHINKADo__AAjlKdWCzvg874.jpg'}]",
               introduction:this.content,
               goodsId:this.productId,
               packageList:this.packingList,
               saleService:this.afterSaleService,
            },
            sellerId:"yijia",
            price:0
        }).then(res=>{
          if(res.code==200){
             this.$message.success('修改成功！');
             this.$router.push('/example/tree/');
          }
        })
    },
    back(){
      this.$router.go(-1);
    },
    showTypeName(typeId){
      let typeList=JSON.parse(sessionStorage.getItem('typeList'));

      let res=typeList.filter(item=>{
        if(item.id==typeId)
        {
          return true;
        }else{
          return false;
        }
      })[0];

      if(res){
        return res.name;
      }else{
        return '请选择'
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
</style>

