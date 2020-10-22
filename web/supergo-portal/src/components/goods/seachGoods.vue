<template>
  <div>
    <Header @setKeyword="getKeyword" />
    <div class="main">
      <div class="py-container">
        <div class="clearfix selector">
          <div class="type-wrap"></div>
          <div class="type-wrap">
            <div class="fl key">品牌</div>
            <div class="fl value">
              <ul class="type-list">
                <li
                  v-for="item in conditionData.brands"
                  :key="item.id"
                  @click="brandFilter(item.id)"
                >{{item.name}}</li>
              </ul>
            </div>
          </div>

          <div class="type-wrap" v-for="(item,index) in conditionData.attrs" :key="index">
            <div class="fl key">{{item.attributeName}}</div>
            <div class="fl value">
              <ul class="type-list">
                <li
                  v-for="items in item.optionNames"
                  :key="items"
                  @click="attrsFilter(item.attributeName,items)"
                >{{items}}</li>
              </ul>
            </div>
          </div>

          <div class="type-wrap" v-for="(item,index) in conditionData.specs" :key="index">
            <div class="fl key">{{index}}</div>
            <div class="fl value">
              <ul class="type-list">
                <li
                  v-for="items in item"
                  :key="items"
                  @click="specsFilter(index,items.optionName)"
                >{{items.optionName}}</li>
              </ul>
            </div>
          </div>

          <!-- <div class="type-wrap" v-for="(item, index) in conditionData" :key="index">
					<div class="fl key">网络制式</div>
					<div class="fl value">
						<ul class="type-list">
							<li v-for="(items, ind) in item" :key="ind" @click="brandFilter(items.type)">{{items.type}}</li>
						</ul>
					</div>
          </div>-->

          <div class="details">
            <div class="sui-navbar">
              <div class="navbar-inner filter">
                <ul class="sui-nav">
                  <!-- class="active" -->
                  <li v-for="(item, index) in sortList" :key="index" @click="sort(index)">
                    <!-- <a href="#">{{item}}</a> -->
                    {{item}}
                  </li>
                </ul>
              </div>
            </div>

            <!-- goods-list -->
            <div class="goods-list">
              <ul class="yui3-g">
                <li
                  class="yui3-u-1-5"
                  v-for="item in valueList"
                  :key="item.itemId"
                  @click="toItem(item.goodsId)"
                >
                  <div class="list-wrap">
                    <div class="p-img">
                      <img :src="item.imgPath" />
                    </div>
                    <div class="price">
                      <strong>
                        <em>¥</em>
                        <i>{{item.price}}</i>
                      </strong>
                    </div>
                    <div class="attr">
                      <em>{{item.goodsName}}</em>
                    </div>
                    <div class="cu">
                      <em>
                        <span>促</span>满一件可参加超值换购
                      </em>
                    </div>
                    <div class="commit">
                      <i class="command">已有2000人评价</i>
                    </div>
                    <div class="operate">
                      <a
                        href="success-cart.html"
                        target="_blank"
                        class="sui-btn btn-bordered btn-danger"
                      >加入购物车</a>
                      <a href="javascript:void(0);" class="sui-btn btn-bordered">对比</a>
                      <a href="javascript:void(0);" class="sui-btn btn-bordered">关注</a>
                    </div>
                  </div>
                </li>
              </ul>
            </div>

            <!-- 分页 -->
            <!-- <div class="fr page">
						   <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="currentPage3"
      :page-size="100"
      layout="prev, pager, next, jumper"
      :total="1000">
    </el-pagination>
            </div>-->
          </div>
        </div>

        <!--hotsale-->
        <div class="clearfix hot-sale">
          <h4 class="title">热卖商品--这里是广告栏</h4>
          <div class="hot-list">
            <ul class="yui3-g">
              <li class="yui3-u-1-4">
                <div class="list-wrap">
                  <div class="p-img">
                    <img src="/static/img/like_01.png" />
                  </div>
                  <div class="attr">
                    <em>Apple苹果iPhone 6s (A1699)</em>
                  </div>
                  <div class="price">
                    <strong>
                      <em>¥</em>
                      <i>4088.00</i>
                    </strong>
                  </div>
                  <div class="commit">
                    <i class="command">已有700人评价</i>
                  </div>
                </div>
              </li>
              <li class="yui3-u-1-4">
                <div class="list-wrap">
                  <div class="p-img">
                    <img src="/static/img/like_03.png" />
                  </div>
                  <div class="attr">
                    <em>金属A面，360°翻转，APP下单省300！</em>
                  </div>
                  <div class="price">
                    <strong>
                      <em>¥</em>
                      <i>4088.00</i>
                    </strong>
                  </div>
                  <div class="commit">
                    <i class="command">已有700人评价</i>
                  </div>
                </div>
              </li>
              <li class="yui3-u-1-4">
                <div class="list-wrap">
                  <div class="p-img">
                    <img src="/static/img/like_04.png" />
                  </div>
                  <div class="attr">
                    <em>256SSD商务大咖，完爆职场，APP下单立减200</em>
                  </div>
                  <div class="price">
                    <strong>
                      <em>¥</em>
                      <i>4068.00</i>
                    </strong>
                  </div>
                  <div class="commit">
                    <i class="command">已有20人评价</i>
                  </div>
                </div>
              </li>
              <li class="yui3-u-1-4">
                <div class="list-wrap">
                  <div class="p-img">
                    <img src="/static/img/like_02.png" />
                  </div>
                  <div class="attr">
                    <em>Apple苹果iPhone 6s (A1699)</em>
                  </div>
                  <div class="price">
                    <strong>
                      <em>¥</em>
                      <i>4088.00</i>
                    </strong>
                  </div>
                  <div class="commit">
                    <i class="command">已有700人评价</i>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <Footer />
  </div>
</template>

<script>
import { search } from "@/api";
import Header from "../public/header";
import Footer from "../public/footer";
export default {
  name: "seachGoods",
  // props:[],
  data() {
    return {
      conditionData: [], //条件筛选
      valueList: [], //搜索列表
      typeCountList: [],
      sortList: ["综合", "销量", "新品", "评价", "价格"],
      seachKeyWord: localStorage.seachKeyWord, //搜索商品
      priceFlage: "asc" //价格升降序
    };
  },
  components: {
    Header,
    Footer
  },
  async created() {
    //  获取搜索数据
    const seachId = this.$route.query.seachId;
    const keywords = this.$route.query.keywords;
    console.log(seachId);
    console.log(String(seachId));
    if (keywords) {
      const {
        status,
        data: {
          data: {
            conditionData,
            listData: { valueList }
          }
        }
      } = await search({ keywords: keywords });
      if (status === 200) {
        console.log("22222", conditionData);
        this.conditionData = conditionData;
        this.valueList = valueList;
      }
    } else if (seachId) {
      const {
        status,
        data: {
          data: {
            conditionData,
            listData: { valueList }
          }
        }
      } = await search({ classify: String(seachId) });
      if (status === 200) {
        this.conditionData = conditionData;
        this.valueList = valueList;
      }
    }
  },
  mounted() {},
  methods: {
    //   跳转商品详情页
    toItem(id) {
      console.log(id);
      window.open(`http://39.107.94.159/${id}.html`);
    },
    getKeyword(data) {
      //   this.seachKeyWord = data;
      //   	console.log("this.seachKeyWord",this.seachKeyWord)
    },
    // 品牌过滤
    async brandFilter(id) {
      const {
        status,
        data: {
          data: {
            conditionData,
            listData: { valueList }
          }
        }
      } = await search({
        classify: String(this.$route.query.seachId),
        brand: id
      });
      if (status === 200) {
        console.log("22222", conditionData);
        this.conditionData = conditionData;
        this.valueList = valueList;
      }
	},
	async attrsFilter(attributeName, items) {
      console.log(attributeName, items);
      let params;
      if (attributeName == "版本类型") {
        params = "network";
      } else if (attributeName == "内存") {
        params = "rom";
      }
      const {
        status,
        data: {
          data: {
            conditionData,
            listData: { valueList }
          }
        }
      } = await search({
        classify: String(this.$route.query.seachId),
        [params]: items
      });
      if (status === 200) {
        this.conditionData = conditionData;
        this.valueList = valueList;
      }
    },
	// specs过滤
    async specsFilter(index, optionName) {
      console.log(index, optionName);
      let params;
      if (index == "网络") {
        params = "network";
      } else if (index == "机身内存") {
        params = "rom";
      }
      const {
        status,
        data: {
          data: {
            conditionData,
            listData: { valueList }
          }
        }
      } = await search({
        classify: String(this.$route.query.seachId),
        [params]: optionName
      });
      if (status === 200) {
        this.conditionData = conditionData;
        this.valueList = valueList;
      }
    },
    //    价格排序
    sort(index) {
      if (index == 4 && this.priceFlage == "asc") {
        this.priceFlage = "desc";
      } else if (index == 4 && this.priceFlage == "desc") {
        this.priceFlage = "asc";
      }
      console.log("this.priceFlage", this.priceFlage);
      this.axios
        .post("http://192.168.10.204:8183/itemsearch/search", {
          keywords: localStorage.seachKeyWord,
          //   brand: id,
          order: "sell_price:" + this.priceFlage
        })
        .then(res => {
          if (res.status == 200) {
            this.goodsList = res.data.goodsList;
            this.typeCountList = res.data.typeCountList;
          }
        })
        .catch(err => {
          console.log("err", err);
        });
    }
  }
};
</script>

<style scoped>
.main {
  margin: 10px 0;
}

em,
i {
  font-style: normal;
}

.bread,
.selector,
.type-wrap,
.value {
  overflow: hidden;
}

.bread,
.selector,
.details,
.hot-sale {
  margin: 0;
}

.hot-sale,
.selector,
.filter {
  border: 1px solid #ddd;
}

.key {
  padding: 10px 10px 0 15px;
}

.type-wrap ul li {
  float: left;
  list-style-type: none;
}

.sui-btn {
  border-radius: 0;
}

.bread .sui-breadcrumb {
  padding: 3px 5px 3px 15px;
  margin: 0;
}
.sui-breadcrumb > li + li:after {
  content: "/\00a0";
  padding: 0 5px;
  color: #ccc;
}
.tags-choose {
  list-style: none;
  padding: 3px 5px;
  overflow: hidden;
  float: left;
}
.tags-choose .tag {
  float: left;
  color: #555;
  border: 1px solid #ccc;
  padding: 0px 5px 1px;
  margin-right: 5px;
}
.tags-choose .tag .icon-tb-close {
  padding-left: 4px;
  color: #8c8c8c;
  cursor: pointer;
}
.bread .sui-form {
  margin: 2px 10px 10px 0;
}
.type-wrap {
  margin: 0;
  position: relative;
  border-top: 1px solid #ddd;
}

.type-wrap:first-child {
  border-top: 0;
}

.type-wrap .key {
  width: 100px;
  background: #f1f1f1;
  line-height: 26px;
  text-align: right;
}

.logo .brand {
  padding-bottom: 87px;
}

.type-wrap .value {
  padding: 10px 0 0 15px;
  color: #333;
}

.type-wrap .logos {
  margin-left: 120px;
  padding-right: 90px;
}

.type-wrap .ext {
  position: absolute;
  top: 10px;
  right: 10px;
}

.ext .sui-btn {
  padding: 0 10px;
  background: #fff;
}

.ext a {
  color: #666;
}

ul.type-list li {
  display: block;
  margin-right: 30px;
  line-height: 26px;
  cursor: pointer;
}

ul.type-list li a {
  cursor: pointer;
  color: #555;
  padding: 2px;
  text-decoration: none;
}

ul.type-list li a.redhover {
  background: #c81623;
  color: #fff;
  padding: 2px;
  text-decoration: none;
}

ul.type-list li a.grayhover {
  color: #555;
}

ul.logo-list li {
  border: 1px solid #e4e4e4;
  margin: -1px -1px 0 0;
  width: 105px;
}

.filter {
  background: #f1f1f1;
}

.sui-navbar {
  margin-bottom: 0;
}

.sui-navbar .navbar-inner {
  padding-left: 0;
  border-radius: 0;
}

.sui-navbar .sui-nav > .active > a {
  background: #c81623;
  color: #fff;
}

.sui-navbar .sui-nav li {
  padding: 11px 15px;
  cursor: pointer;
}

.goods-list {
  margin: 20px 0;
}

.goods-list ul li {
  margin-top: 10px;
  line-height: 28px;
}

.goods-list ul li:hover {
  box-shadow: 0 0 10px 2px #ededed;
}

.goods-list .p-img {
  width: 215px;
  height: 255px;
}

.p-img,
.price,
.attr,
.cu,
.commit,
.operate {
  padding-left: 15px;
}

.attr,
.cu,
.commit {
  height: 22px;
}

.price {
  font-size: 18px;
  color: #c81623;
}

.price i {
  margin-left: -5px;
}

.cu span {
  background: #c81623;
  color: #fff;
  padding: 3px;
  margin-right: 3px;
}

.operate {
  padding: 12px 15px;
}

.page {
  width: 733px;
  height: 66px;
  overflow: hidden;
}

.sui-pagination div {
  float: right;
  width: 241px;
}

.sui-pagination ul {
  display: inline-block;
  *display: inline;
  *zoom: 1;
  width: 490px;
  float: left;
}

.sui-pagination ul > .active > a {
  background-color: #fff;
  color: #c81623;
  border-color: #fff;
  cursor: default;
}

.sui-pagination ul > .active > a:hover {
  background: #ccc;
  border: 1px solid #ddd;
}

.sui-pagination ul > li {
  display: inline-block;
  *display: inline;
  *zoom: 1;
}

.pagination-large ul > li > a,
.pagination-large ul > li > span {
  padding: 9px 18px;
  color: #333;
}

.sui-pagination ul > li > a:hover {
  background: #ccc;
  border: 1px solid #ddd;
}

.sui-pagination ul > .dotted > span,
.sui-pagination ul > .dotted > a {
  border: 0;
}

.pagination-large div .page-num {
  padding: 9px 18px;
}

.pagination-large div .page-num + .page-confirm {
  padding: 7px 16px;
  color: #666;
  background-color: #f6f6f6;
  border: 1px solid #ddd;
}

.sui-pagination div {
  display: inline-block;
  *display: inline;
  *zoom: 1;
}

.hot-sale .hot-list {
  padding: 15px;
}

.hot-sale .title {
  border-bottom: 1px solid #ddd;
  background: #f1f1f1;
  color: #333;
  margin: 0;
  padding: 5px 0 5px 15px;
}
</style>