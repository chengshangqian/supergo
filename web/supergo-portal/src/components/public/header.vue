<template>
  <div>
    <div class="top">
      <div class="py-container">
        <div class="shortcut">
          <ul class="fl">
            <li class="f-item">超级购商城欢迎您！</li>
            <li class="f-item">
              请
              <router-link to="/login">登录</router-link>
              <span>
                <router-link to="/side">消息</router-link>
              </span>
              <span>
                <router-link to="/register">免费注册</router-link>
              </span>
              <span>
                <router-link to="/item">商品详情</router-link>
              </span>
              <span>
                <router-link to="/cart">购物车</router-link>
              </span>
              <span>
                <router-link to="/getOrderInfo">订单</router-link>
              </span>
              <span>
                <router-link to="/home">个人中心</router-link>
              </span>
            </li>
          </ul>
          <ul class="fr">
            <li class="f-item">我的订单</li>
            <li class="f-item space"></li>
            <li class="f-item">
              <a href="home.html" target="_blank">我的超级购商城</a>
            </li>
            <li class="f-item space"></li>
            <li class="f-item">超级购商城会员</li>
            <li class="f-item space"></li>
            <li class="f-item">企业采购</li>
            <li class="f-item space"></li>
            <li class="f-item">关注超级购商城</li>
            <li class="f-item space"></li>
            <li class="f-item" id="service">
              <span>客户服务</span>
              <ul class="service">
                <li>
                  <a href="//business.supergo.com/shopregiste.html" target="_blank">商家入驻</a>
                </li>
                <li>
                  <a href="//business.supergo.com" target="_blank">商家后台</a>
                </li>
              </ul>
            </li>
            <li class="f-item space"></li>
            <li class="f-item">网站导航</li>
          </ul>
        </div>
      </div>
    </div>

    <div class="header">
      <div class="py-container">
        <div class="yui3-g Logo">
          <div class="yui3-u Left logoArea">
            <a class="logo-bd" title="超级狂欢购">
              <img src="/static/img/logo.png" alt />
            </a>
          </div>
          <div class="yui3-u Center searchArea">
            <div class="search">
              <form action class="sui-form form-inline">
                <div class="input-append">
                   <!-- @blur="isShowHint=false" -->
                  <input
                    type="text"
                    v-model="keywords"
                    class="input-error input-xxlarge"
                    @input="searchInp"
                    @focus="searchFocus"
                  />
                  <button class="sui-btn btn-xlarge btn-danger" type="button" @click="goSearch">搜索</button>
                </div>
              </form>

              <!-- 搜索下拉列表：绑定hintList对象 -->
              <ul class="search-hint" v-show="isShowHint && hintList.length > 0" >
                <li v-for="item in hintList" :key="item" @click="addKeywords(item)">{{item}}</li>
                <li @click="isShowHint=false">
                  <p>关闭</p>
                </li>
              </ul>

            </div>
            <div class="hotwords">
              <ul>
                <li class="f-item">超级购商城首发</li>
                <li class="f-item">亿元优惠</li>
                <li class="f-item">9.9元团购</li>
                <li class="f-item">每满99减30</li>
                <li class="f-item">亿元优惠</li>
                <li class="f-item">9.9元团购</li>
                <li class="f-item">办公用品</li>
              </ul>
            </div>
          </div>
          <div class="yui3-u Right shopArea">
            <div class="fr shopcar">
              <div class="show-shopcar" id="shopcar">
                <span class="car"></span>
                <router-link class="sui-btn btn-default btn-xlarge" to="/cart">
                  <span>我的购物车</span>
                  <i class="shopnum">{{pickNum}}</i>
                </router-link>
              </div>
            </div>
          </div>
        </div>

        <div class="yui3-g NavList">
          <div class="yui3-u Left all-sort">
            <h4>全部商品分类</h4>
          </div>
          <div class="yui3-u Center navArea">
            <ul class="nav">
              <li class="f-item">服装城</li>
              <li class="f-item">美妆馆</li>
              <li class="f-item">全球购</li>
              <li class="f-item">闪购</li>
              <li class="f-item">团购</li>
              <li class="f-item">有趣</li>
              <li class="f-item">
                <router-link to="/spike">秒杀</router-link>
              </li>
            </ul>
          </div>
          <div class="yui3-u Right"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// 导入搜索api
import { search, searchList } from "@/api";

export default {
  name: "head",
  data() {
    return {
      keywords: "", //搜索商品
      hintList: [], //搜索联想词
      isShowHint: true //搜索提示显示隐藏
    };
  },
  computed: {
    pickNum() {
      return this.$store.getters.getShopNum;
    }
  },
  mounted() {},
  methods: {
    // 根据输入的搜索关键字获取相关商品列表
    async searchInp() {
      // 调用查询API从ES获取相关商品列表
      const {
        status,
        data: { data }
      } = await searchList(this.keywords);

      // 打印
      console.log(data);

      // 如果状态OK，将获取的商品列表绑定VUE的变量然后展示在前端页面
      if (status === 200) {
        this.hintList = data;
        this.isShowHint = true;
      }
    },

    searchFocus() {
      if (this.hintList.length > 0) {
        this.isShowHint = true;
      }
    },

    addKeywords(keywords) {
      console.log(keywords)
      if (keywords) {
        this.keywords = keywords;
        this.isShowHint = false;
      }
    },

    // 跳转到搜索页
    goSearch() {
      // console.log(132132131)
      // localStorage.setItem('keywords',this.keywords)
      this.$router.push({
        path: "seachGoods",
        query: { keywords: this.keywords }
      });
    },

    debounce(func, wait, flag) {
      var timeout;
      var self = this;
      return function() {
        clearTimeout(timeout);
        if (flag) {
          //开始边界  就去就是做
          var callnow = !timeout; //callnow:当前状态
          timeout = setTimeout(function() {
            timeout = null;
          }, wait);
          if (callnow) {
            func.apply(self);
          }
        } else {
          timeout = setTimeout(function() {
            func.apply(self); //为啥this没有代表 <div id="container"></div>？
          }, wait);
        }
      };
    }
    // 防抖
    //    debounce(fn,wait,time){
    //     var previous = null; //记录上一次运行的时间
    //     var timer = null;

    //     return function(){
    //         var now = +new Date();
    //         if(!previous) previous = now;
    //         //当上一次执行的时间与当前的时间差大于设置的执行间隔时长的话，就主动执行一次
    //         if(now - previous > time){
    //             clearTimeout(timer);
    //             fn();
    //             previous = now;// 执行函数后，马上记录当前时间
    //         }else{
    //             clearTimeout(timer);
    //             timer = setTimeout(function(){
    //                 fn();
    //             },wait);
    //         }
    //     }
    // }
  }
};
</script>

<style scoped>
/* 搜索提示 */
.search-hint {
  width: 570px;
  min-height: 30px;
  position: absolute;
  left: 0;
  top: 30px;
  background: #fff;
  border: solid 1px #ccc;
  z-index: 99;
}

.search-hint li {
  width: 100%;
  height: 20px;
  line-height: 20px;
  /* padding: 0 2px; */
  list-style: none;
}

.search-hint li:hover {
  background: lightblue;
}

.search-hint li:last-child {
  float: right;
  border-top: solid 1px #ccc;
  cursor: pointer;
}
.search-hint li:last-child p {
  float: right;
  height: 20px;
  line-height: 20px;
}
</style>
