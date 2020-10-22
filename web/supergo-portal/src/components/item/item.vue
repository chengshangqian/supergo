<template>
  <div>
    <Header/>
    <div class="py-container">
      <div id="item">
        <div class="crumb-wrap">
          <ul class="sui-breadcrumb">
            <li>
              <a href="#">手机、数码、通讯</a>
            </li>
            <li>
              <a href="#">手机</a>
            </li>
            <li>
              <a href="#">Apple苹果</a>
            </li>
            <li class="active">iphone 6S系类</li>
          </ul>
        </div>

        <!--product-info-->
        <div class="product-info">
          <div class="fl preview-wrap">
            <!--放大镜效果-->
            <div class="zoom">
              <!--默认第一个预览-->
              <div id="preview" class="spec-preview">
                <pic-zoom :url="bigPicUrl" :scale="3"></pic-zoom>
              </div>
              <!--下方的缩略图-->
              <div class="spec-scroll">
                <a class="prev" @click="prevImg">&lt;</a>
                <!--左右按钮-->
                <div class="items">
                  <ul>
                    <li v-for="(item,index) in detailsData.images" :key="index">
                      <img :src="item.imgSmall" @mouseover="bigPicUrl=item.imgBig">
                    </li>
                  </ul>
                </div>
                <a class="next" @click="nextImg">&gt;</a>
              </div>
            </div>
          </div>
          <div class="fr itemInfo-wrap">
            <div class="sku-name">
              <h4>{{detailsData.title}}</h4>
            </div>
            <div class="news">
              <span>{{detailsData.promotion}}</span>
            </div>
            <div class="summary">
              <div class="summary-wrap">
                <div class="fl title">
                  <i>价 格</i>
                </div>
                <div class="fl price">
                  <i>¥</i>
                  <em>{{detailsData.price}}</em>
                  <span>降价通知</span>
                </div>
                <div class="fr remark">
                  <i>累计评价</i>
                  <em>612188</em>
                </div>
              </div>
              <div class="summary-wrap">
                <div class="fl title">
                  <i>促 销</i>
                </div>
                <div class="fl fix-width">
                  <i class="red-bg">加价购</i>
                  <em class="t-gray">{{detailsData.salesDeclarer}}</em>
                </div>
              </div>
            </div>
            <div class="support">
              <div class="summary-wrap">
                <div class="fl title">
                  <i>支 持</i>
                </div>
                <div class="fl fix-width">
                  <em class="t-gray">以旧换新，闲置手机回收 4G套餐超值抢 礼品购</em>
                </div>
              </div>
              <div class="summary-wrap">
                <div class="fl title">
                  <i>配 送 至</i>
                </div>
                <div class="fl fix-width">
                  <em
                    class="t-gray"
                  >满999.00另加20.00元，或满1999.00另加30.00元，或满2999.00另加40.00元，即可在购物车换购热销商品</em>
                </div>
              </div>
            </div>
            <div class="clearfix choose">
              <div id="specification" class="summary-wrap clearfix">
                <dl v-for="(item, index) in detailsData.sellingStyles" :key="index">
                  <dt>
                    <div class="fl title">
                      <i>{{item.style}}</i>
                    </div>
                  </dt>
                  <dd
                    v-for="(value, ind) in item.items"
                    :key="ind"
                    class="sel"
                    :class="{'selected':ind==0}"
                    @click="selcolor(ind)"
                  >
                    {{value.title}}
                    <span title="点击取消选择">&nbsp;</span>
                  </dd>
                </dl>
              </div>

              <div class="summary-wrap">
                <div class="fl title">
                  <div class="control-group">
                    <div class="controls">
                      <input type="text" v-model.number="num" class="itxt">
                      <a href="javascript:void(0)" class="increment plus" @click="add">+</a>
                      <a href="javascript:void(0)" class="increment mins" @click="minus">-</a>
                    </div>
                  </div>
                </div>
                <div class="fl">
                  <ul class="btn-choose unstyled">
                    <li>
                      <a class="sui-btn btn-danger addshopcar" @click="addCart">加入购物车</a>
                      <!-- <router-link class="sui-btn  btn-danger addshopcar" to="/cart" @click="addCart">加入购物车</router-link> -->
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--product-detail-->
        <div class="clearfix product-detail">
          <div class="fl aside">
            <el-tabs type="border-card">
              <el-tab-pane label="相关分类">
                <ul class="part-list unstyled">
                  <li>手机</li>
                  <li>手机壳</li>
                  <li>内存卡</li>
                  <li>Iphone配件</li>
                  <li>贴膜</li>
                  <li>手机耳机</li>
                  <li>移动电源</li>
                  <li>平板电脑</li>
                </ul>
                <ul class="goods-list unstyled">
                  <li>
                    <div class="list-wrap">
                      <div class="p-img">
                        <img src="img/_/part01.png">
                      </div>
                      <div class="attr">
                        <em>Apple苹果iPhone 6s (A1699)</em>
                      </div>
                      <div class="price">
                        <strong>
                          <em>¥</em>
                          <i>6088.00</i>
                        </strong>
                      </div>
                      <div class="operate">
                        <router-link class="sui-btn btn-bordered" to="/cart">加入购物车</router-link>
                      </div>
                    </div>
                  </li>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="推荐品牌">推荐品牌</el-tab-pane>
            </el-tabs>
          </div>
          <div class="fr detail">
            <div class="clearfix fitting">
              <h4 class="kt">选择搭配</h4>
              <div class="good-suits">
                <div class="fl master">
                  <div class="list-wrap">
                    <div class="p-img">
                      <img src="img/_/l-m01.png">
                    </div>
                    <em>￥5299</em>
                    <i>+</i>
                  </div>
                </div>
                <div class="fl suits">
                  <ul class="suit-list">
                    <li class v-for="(item,index) in choiceData" :key="index">
                      <div id>
                        <img :src="item.img">
                      </div>
                      <i>{{item.title}}</i>
                      <div>
                        <el-checkbox v-model="item.option">{{item.price}}</el-checkbox>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="fr result">
                  <div class="num">已选购0件商品</div>
                  <div class="price-tit">
                    <strong>套餐价</strong>
                  </div>
                  <div class="price">￥5299</div>
                  <router-link class="sui-btn btn-danger addshopcar" to="/cart">加入购物车</router-link>
                </div>
              </div>
            </div>
            <div class="tab-main intro">
              <el-tabs type="border-card">
                <el-tab-pane label="商品介绍">
                  <ul
                    class="goods-intro unstyled"
                    v-for="(item,index) in detailsData.standard"
                    :key="index"
                  >
                    <li v-for="(value,ind) in item.items" :key="ind">{{value.key}}:{{value.val}}:</li>
                  </ul>
                  <div class="intro-detail">
                    <img src="../../../static/img/intro01.png">
                    <img src="../../../static/img/intro02.png">
                    <img src="../../../static/img/intro03.png">
                    <!-- {{detailsData.introduction}} -->
                  </div>
                </el-tab-pane>
                <el-tab-pane label="规格与包装">规格与包装</el-tab-pane>
                <el-tab-pane label="售后保障">售后保障</el-tab-pane>
                <el-tab-pane label="商品评价">商品评价</el-tab-pane>
                <el-tab-pane label="手机社区">手机社区</el-tab-pane>
              </el-tabs>
            </div>
          </div>
        </div>
        <!--like-->
        <div class="clearfix"></div>
        <div class="like">
          <h4 class="kt">猜你喜欢</h4>
          <div class="like-list">
            <ul class="yui3-g">
              <li class="yui3-u-1-6" v-for="(item,index) in likeData" :key="index">
                <div class="list-wrap">
                  <div class="p-img">
                    <img :src="item.img">
                  </div>
                  <div class="attr">
                    <em>{{item.title}}}</em>
                  </div>
                  <div class="price">
                    <strong>
                      <em>¥</em>
                      <i>{{item.price}}</i>
                    </strong>
                  </div>
                  <div class="commit">
                    <i class="command">已有6人评价</i>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
// import {getItem} from '@/api'
import Header from "../public/header";
import Footer from "../public/footer";
// vue放大插件引用
import PicZoom from "vue-piczoom";
import GoodsTool from "../../GoodsTool.js";

export default {
  name: "item",
  data() {
    return {
      tempLength: 0, //临时变量,当前移动的长度
      viewNum: 5, //设置每次显示图片的个数量
      moveNum: 2, //每次移动的数量
      moveTime: 300, //移动速度,毫秒
      num: 1, //购买商品数量
      detailsData: [], //产品信息数据
      likeData: [], //猜你喜欢
      choiceData: [], //选择搭配
      checked: false,
      bigPicUrl: "" //放大图片路径
    };
  },
  components: {
    Header,
    Footer,
    PicZoom
  },
 async  created() {
    // 获取详情页数据
    const url = 'http://192.168.84.211:9994/item/page/getDynamicPage?goodsId=149187842867938'
    const res = await this.$axios.get(url)
    console.log(res)
    // const res = await this.$axios.get(`http://192.168.84.211:9994/item/page/getDynamicPage?goodsId=${149187842867938}`)
    // console.log(res)
    //选择搭配
    // this.axios
    //   .get("../../../static/data/productRelationship.json")
    //   .then(res => {
    //     if (res.status == 200) {
    //       this.choiceData = res.data.items;
    //       this.choiceData.forEach(item => {
    //         this.$set(item, "option", false);
    //       });
    //     }
    //     console.log("res111", res);
    //   })
    //   .catch(err => {
    //     console.log("err", err);
    //   });

    //获取猜你喜欢
    // this.axios
    //   .get("../../../static/data/productGuess.json")
    //   .then(res => {
    //     if (res.status == 200) {
    //       this.likeData = res.data.items;
    //     }
    //     console.log("res111", res);
    //   })
    //   .catch(err => {
    //     console.log("err", err);
    //   });
    // 获取产品信息数据
    // this.axios
    //   .get("../../../static/data/productInfo.json")
    //   .then(res => {
    //     if (res.status == 200) {
    //       this.detailsData = res.data;
    //       // 获取页面加载时的首张放大图片
    //       this.bigPicUrl = res.data.images[0].imgBig;
    //     }

    //     console.log("this.detailsData", this.detailsData);
    //   })
    //   .catch(err => {
    //     console.log("err", err);
    //   });
  },
  mounted() {
    // this.preview()
  },
  methods: {
    //  上一张
    prevImg() {
      var scrollItems = $(".spec-scroll .items ul li"); //移动容器里的集合
      var moveLength = scrollItems.eq(0).width() * this.moveNum; //计算每次移动的长度
      if (this.tempLength > 0) {
        if (this.tempLength > moveLength) {
          $(".spec-scroll .items ul").animate(
            { left: "+=" + moveLength + "px" },
            this.moveTime
          );
          this.tempLength -= moveLength;
        } else {
          $(".spec-scroll .items ul").animate(
            { left: "+=" + this.tempLength + "px" },
            this.moveTime
          );
          this.tempLength = 0;
        }
      }
    },
    //下一张
    nextImg() {
      var scrollItems = $(".spec-scroll .items ul li"); //移动容器里的集合
      var moveLength = scrollItems.eq(0).width() * this.moveNum; //计算每次移动的长度
      var countLength =
        (scrollItems.length - this.viewNum) * scrollItems.eq(0).width(); //计算总长度,总个数*单个长度
      if (this.tempLength < countLength) {
        if (countLength - this.tempLength > moveLength) {
          $(".spec-scroll .items ul").animate(
            { left: "-=" + moveLength + "px" },
            this.moveTime
          );
          this.tempLength += moveLength;
        } else {
          $(".spec-scroll .items ul").animate(
            { left: "-=" + (countLength - this.tempLength) + "px" },
            this.moveTime
          );
          this.tempLength += countLength - this.tempLength;
        }
      }
    },

    //    选中商品类型
    selcolor(index) {
      $(".sel")
        .eq(index)
        .addClass("selected")
        .siblings()
        .removeClass("selected");
    },
    //加入购物车
    addCart() {
      this.$router.push({ path: "/cart" });
      this.$store.dispatch("addShopNumByAction", this.num);
      //将添加到购物车的数据保存到本地存储中
      GoodsTool.addGoods({
        id: this.detailsData.pid,
        num: this.$store.getters.getShopNum
      });
    },
    // 增加购买数量
    add() {
      this.num++;
    },
    // 减少购买数量
    minus() {
      this.num--;
      if (this.num <= 1) {
        this.num = 1;
      }
    }
  }
};
</script>

<style scoped>
/* @import '../../../static/css/pages-item.css'; */
@import "../../../static/css/pages-zoom.css";
.btn-danger {
  border-radius: 0;
}

#item {
  margin: 15px 0;
  font-family: "微软雅黑";
}

.preview-wrap {
  width: 400px;
}

.itemInfo-wrap {
  width: 700px;
}

.aside {
  width: 210px;
}

.detail {
  width: 980px;
}

em {
  font-style: normal;
}

.sui-breadcrumb {
  padding: 9px 15px 0 0;
  margin: 0 0 9px;
}

.product-info {
  overflow: hidden;
  margin: 5px 0 15px;
}

.itemInfo-wrap {
  font-family: "宋体";
}

.summary-wrap .price {
  color: #c81623;
}

.summary-wrap .price em {
  font-size: 24px;
  font-weight: 700;
}

.summary-wrap .price i {
  font-size: 16px;
}

.summary-wrap .price span {
  font-size: 12px;
}

.product-detail {
  margin: 30px 0;
}

.red-bg {
  background: #b61d1d;
  padding: 3px;
  color: #fff;
}

.sku-name h4 {
  font-weight: 700;
}

.news {
  color: #e12228;
}

.summary {
  background: #fee9eb;
  padding: 7px;
  margin: 13px 0;
}

.support {
  border-bottom: 1px solid #ededed;
  padding-bottom: 5px;
}

.summary-wrap {
  overflow: hidden;
  line-height: 28px;
  margin-top: 10px;
}

.summary-wrap dl {
  overflow: hidden;
}

.summary-wrap dl dd {
  color: #666;
  line-height: 24px;
  padding: 2px 14px;
  margin: 0 5px 0;
  display: block;
  float: left;
  position: relative;
  outline: 0;
  border-top: 1px solid #eee;
  border-right: 1px solid #bbb;
  border-bottom: 1px solid #bbb;
  border-left: 1px solid #eee;
  background-color: #fff;
  text-decoration: none;
  cursor: pointer;
}

.summary-wrap .selected {
  border: 1px solid #c81623;
}

.summary-wrap .locked {
  color: #d6d6d6;
  cursor: not-allowed;
  border-color: #bbb;
  border-style: dotted;
}

.summary-wrap dd span {
  width: 100%;
  height: 100%;
  display: none;
  position: absolute;
  right: 0;
  _right: -1px;
  bottom: 0;
  _bottom: -1px;
  overflow: hidden;
}

.summary-wrap .selected span {
  display: block;
}

.title {
  width: 60px;
  margin-top: 0px;
  margin-right: 10px;
}

.controls {
  width: 48px;
  position: relative;
}

.controls a {
  text-decoration: none;
}

.controls .itxt {
  display: block;
  width: 38px;
  height: 34px;
  line-height: 42px;
  border: 1px solid #ddd;
  text-align: center;
  color: #555;
  float: left;
  border-right: 0;
}

.controls .plus {
  display: block;
  width: 15px;
  text-align: center;
  height: 17px;
  line-height: 17px;
  overflow: hidden;
  background: #f1f1f1;
  color: #666;
  position: absolute;
  right: -8px;
  border: 1px solid #ccc;
}

.controls .mins {
  display: block;
  width: 15px;
  text-align: center;
  height: 17px;
  line-height: 17px;
  overflow: hidden;
  background: #f1f1f1;
  color: #666;
  position: absolute;
  right: -8px;
  border: 1px solid #ccc;
  top: 19px;
  border-top: 0;
}

.red-bg {
  background: #c81623;
  color: #fff;
  padding: 3px;
}

.fix-width {
  width: 520px;
}

.t-gray {
  color: #999;
}

ul.btn-choose li {
  float: left;
  margin: 0 10px 0 0;
}

ul.btn-choose li .btn-xlarge .addshopcar {
  font-size: 16px;
}

.addshopcar {
  padding: 10px 25px;
  background: #c81623;
  font-size: 16px;
  font-family: 微软雅黑;
}

ul.btn-choose li .btn-xlarge {
  font-size: 12px;
  border-radius: 0;
}

.sui-btn:active,
.sui-btn.active {
  background-color: #c81623;
  color: #fff;
}

ul.part-list {
  overflow: hidden;
}

ul.part-list li {
  line-height: 18px;
  width: 50%;
  float: left;
  border-bottom: 1px dashed #ededed;
  line-height: 28px;
}

.sui-nav.nav-tabs.tab-wraped > li {
  width: 50%;
}

.sui-nav.nav-tabs.tab-wraped > li > a {
  padding: 11px;
  text-align: center;
}

.sui-nav.nav-tabs.tab-wraped > li.active > a {
  padding-top: 9px;
}

.intro .sui-nav.nav-tabs.tab-wraped > li.active > a {
  font-weight: 400;
  border: 0;
  padding-top: 12px;
  background: #c81623;
  color: #fff;
}

.tab-content.tab-wraped {
  padding: 10px;
}

.summary-price-wrap {
  overflow: hidden;
}

.goods-list .operate {
  margin: 5px 40px;
}

ul.goods-list li {
  margin: 5px 0 15px;
  border-bottom: 1px solid #ededed;
  padding-bottom: 5px;
}

ul.goods-intro li {
  line-height: 26px;
}

.p-img img {
  padding-left: 20px;
}

.suits .list-wrap {
  float: left;
  margin: 0 10px;
}

.good-suits {
  overflow: hidden;
}

.master,
.suits,
.result {
  height: 140px;
  padding: 10px;
}

.master .list-wrap {
  position: relative;
  text-align: center;
}

.master .list-wrap i {
  position: absolute;
  top: 48px;
  right: -25px;
  font-size: 16px;
}

.master .list-wrap em {
  color: #c81623;
  font-size: 16px;
  font-weight: 700;
}

.suits ul li {
  float: left;
  list-style-type: none;
  padding: 0 20px;
}

.result {
  line-height: 26px;
  border-left: 1px solid #ddd;
  padding: 20px;
}

.result .price {
  color: #b1191a;
  font-size: 16px;
}

.fitting,
.like {
  border: 1px solid #ddd;
  margin-bottom: 15px;
}

.intro .sui-nav.nav-tabs.tab-wraped {
  background: #ededed;
}

.intro .sui-nav.nav-tabs.tab-wraped > li {
  width: auto;
}

.intro .tab-content.tab-wraped {
  border: 0;
}

.kt {
  border-bottom: 1px solid #ddd;
  background: #f1f1f1;
  color: #333;
  margin: 0;
  padding: 5px 0 5px 15px;
}

.like .like-list {
  padding: 15px;
}

.like-list ul li .attr,
.like-list ul li .price,
.like-list ul li .commit {
  padding-left: 15px;
  font-family: "微软雅黑";
}

.list-wrap .price {
  font-size: 16px;
  color: #c81623;
}

.like-list ul li .price {
  margin-bottom: 20px;
}

.like-list ul li .list-wrap {
  line-height: 22px;
}
</style>

