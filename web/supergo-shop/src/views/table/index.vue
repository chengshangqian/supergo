<template>
  <div class="app-container">
    <h3>填写产品基本信息</h3>
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
         <el-button type="primary" @click="pushAdd">保存</el-button>
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

import { getList,getProName,saveAdd } from '@/api/addProduct'


export default {
  components:{
    Editor
  },
  data() {
    return {
      options: [],
      options2: [],
      options3: [],
      value: '选择一级分类',
      value2: '选择二级分类',
      value3: '选择三级分类',
      category3Id:'',
      category1Id:'',
      category2Id:'',
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
      }
    }
  },
  mounted() {
    this.fetchData();
    
  },
  methods: {
    fetchData() {
      //获取分类
      getList(0).then(res => {
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

      getList(val).then(res=>{
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

      this.value3='';

      this.category2Id=val;

      getList(val).then(res=>{
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
    back(){
      this.$router.go(-1);
    },
    pushAdd(){
         console.log(this.category1Id,this.category2Id,this.category3Id,this.productName,this.brandName,this.subProductName,this.content,this.packingList,this.afterSaleService)

        if(!this.category3Id) {this.$message.error('请选择分类！'); return;}
        if(!this.productName) {this.$message.error('请填写产品名称！'); return;}
        if(!this.brandName) {this.$message.error('请选择品牌！'); return;}
        if(!this.subProductName) {this.$message.error('请输入副标题！'); return;}

        saveAdd({
          category1Id:this.category1Id,
          category2Id:this.category2Id,
          category3Id:this.category3Id,
          goodsName:this.productName,
          brandId:this.brandName,
          caption:this.subProductName,
          goodsDesc:{
              itemImages:"[{'color':'红色','url':'http://192.168.25.133/group1/M00/00/01/wKgZhVmHINKADo__AAjlKdWCzvg874.jpg'}]",
              introduction:this.content,
              packageList:this.packingList,
              saleService:this.afterSaleService,
          },
          sellerId:"yijia",
          price:0
        }).then(res=>{
          console.log(res,1111)
        });
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

