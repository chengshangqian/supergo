<template>
  <div>
    <div class="sort">
      <div class="py-container">
        <div class="yui3-g SortList">
          <div class="yui3-u Left all-sort-list">
            <div class="all-sort-list2">
              <!-- @mousemove="openLeftMenu($event)" @mouseout="closeLeftMenu($event)" -->
              <div
                class="item"
                v-for="leftOne in leftMenu"
                :key="leftOne.name"
                @mousemove="openLeftMenu"
                @mouseout="closeLeftMenu"
              >
                <h3>
                  <a>{{leftOne.name}}</a>
                </h3>
                <div class="item-list clearfix">
                  <div class="subitem">
                    <dl class="fore1" v-for="leftTwo in leftOne.children" :key="leftTwo.name">
                      <dt>
                        <a>{{leftTwo.name}}</a>
                      </dt>
                      <dd>
                        <em v-for="leftThree in leftTwo.children" :key="leftThree.name">
                          <a @click="toSeachList(leftThree.id)">{{leftThree.name}}</a>
                        </em>
                      </dd>
                    </dl>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- banner轮播 -->
          <div class="yui3-u Center banerArea">
            <el-carousel trigger="click" height="460px">
              <el-carousel-item v-for="item in bannerImg" :key="item">
                <h3>
                  <img :src="item" />
                </h3>
              </el-carousel-item>
            </el-carousel>
          </div>

          <div class="yui3-u Right">
            <div class="news">
              <h4>
                <em class="fl">超级购商城快报</em>
                <span class="fr tip">更多 ></span>
              </h4>
              <div class="clearix"></div>
              <ul class="news-list unstyled">
                <li>
                  <span class="bold">[特惠]</span>备战开学季 全民半价购数码
                </li>
                <li>
                  <span class="bold">[公告]</span>备战开学季 全民半价购数码
                </li>
                <li>
                  <span class="bold">[特惠]</span>备战开学季 全民半价购数码
                </li>
                <li>
                  <span class="bold">[公告]</span>备战开学季 全民半价购数码
                </li>
                <li>
                  <span class="bold">[特惠]</span>备战开学季 全民半价购数码
                </li>
              </ul>
            </div>
            <ul class="yui3-g Lifeservice">
              <li class="yui3-u-1-4 life-item tab-item">
                <i class="list-item list-item-1"></i>
                <span class="service-intro">话费</span>
              </li>
              <li class="yui3-u-1-4 life-item tab-item">
                <i class="list-item list-item-2"></i>
                <span class="service-intro">机票</span>
              </li>
              <li class="yui3-u-1-4 life-item tab-item">
                <i class="list-item list-item-3"></i>
                <span class="service-intro">电影票</span>
              </li>
              <li class="yui3-u-1-4 life-item tab-item">
                <i class="list-item list-item-4"></i>
                <span class="service-intro">游戏</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-5"></i>
                <span class="service-intro">彩票</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-6"></i>
                <span class="service-intro">加油站</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-7"></i>
                <span class="service-intro">酒店</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-8"></i>
                <span class="service-intro">火车票</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-9"></i>
                <span class="service-intro">众筹</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-10"></i>
                <span class="service-intro">理财</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-11"></i>
                <span class="service-intro">礼品卡</span>
              </li>
              <li class="yui3-u-1-4 life-item notab-item">
                <i class="list-item list-item-12"></i>
                <span class="service-intro">白条</span>
              </li>
            </ul>
            <div class="life-item-content">
              <div class="life-detail">
                <i class="close">关闭</i>
                <p>话费充值</p>
                <form action class="sui-form form-horizontal">
                  号码：
                  <input type="text" id="inputphoneNumber" placeholder="输入你的号码" />
                </form>
                <button class="sui-btn btn-danger">快速充值</button>
              </div>
              <div class="life-detail">
                <i class="close">关闭</i> 机票
              </div>
              <div class="life-detail">
                <i class="close">关闭</i> 电影票
              </div>
              <div class="life-detail">
                <i class="close">关闭</i> 游戏
              </div>
            </div>
            <div class="ads">
              <img src="/static/img/ad1.png" />
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 今日推荐 -->
    <div class="show">
      <div class="py-container">
        <ul class="yui3-g Recommend">
          <li class="yui3-u-1-6 clock">
            <div class="time">
              <img src="/static/img/clock.png" />
              <h3>今日推荐</h3>
            </div>
          </li>
          <li class="yui3-u-5-24">
            <a href="//search.supergo.com/search.html?cid=3" target="_blank">
              <img src="/static/img/today01.png" />
            </a>
          </li>
          <li class="yui3-u-5-24">
            <a href="//search.supergo.com/search.html?cid=3" target="_blank">
              <img src="/static/img/today02.png" />
            </a>
          </li>
          <li class="yui3-u-5-24">
            <a href="//search.supergo.com/search.html?cid=3" target="_blank">
              <img src="/static/img/today03.png" />
            </a>
          </li>
          <li class="yui3-u-5-24">
            <a href="//search.supergo.com/search.html?cid=3" target="_blank">
              <img src="/static/img/today04.png" />
            </a>
          </li>
        </ul>
      </div>
    </div>

    <!-- 猜你喜欢 -->
    <div class="like">
      <div class="py-container">
        <div class="title">
          <h3 class="fl">猜你喜欢</h3>
          <b class="border"></b>
          <a href="javascript:;" class="fr tip changeBnt" id="xxlChg">
            <i></i>换一换
          </a>
        </div>
        <div class="bd">
          <ul class="clearfix yui3-g Favourate picLB" id="picLBxxl">
            <li class="yui3-u-1-6" v-for="(item,index) in likeData" :key="index">
              <dl class="picDl huozhe">
                <dd>
                  <a href="//search.supergo.com/search.html?cid=3" class="pic">
                    <img :src="item.img" alt />
                  </a>
                  <div class="like-text">
                    <p>{{item.title}}</p>
                    <h3>¥{{item.price}}</h3>
                  </div>
                </dd>
              </dl>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <!-- 有趣区 -->
    <div class="fun">
      <div class="py-container">
        <div class="title">
          <h3 class="fl">超级购商城.有趣区</h3>
        </div>
        <div class="clearfix yui3-g Interest">
          <span class="x-line"></span>
          <div class="yui3-u row-405 Interest-conver">
            <img src="/static/img/interest01.png" />
          </div>
          <div class="yui3-u row-225 Interest-conver-split">
            <h5>好东西</h5>
            <img src="/static/img/interest02.png" />
            <img src="/static/img/interest03.png" />
          </div>
          <div class="yui3-u row-405 Interest-conver-split blockgary">
            <h5>品牌街</h5>
            <div class="split-bt">
              <img src="/static/img/interest04.png" />
            </div>
            <div class="x-img fl">
              <img src="/static/img/interest05.png" />
            </div>
            <div class="x-img fl">
              <img src="/static/img/interest06.png" />
            </div>
          </div>
          <div class="yui3-u row-165 brandArea">
            <span class="brand-yline"></span>
            <ul class="yui3-g brand-list">
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand01.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand02.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand03.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand04.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand05.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand06.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand07.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand08.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand09.png" />
              </li>
              <li class="yui3-u-1-2 brand-pit">
                <img src="/static/img/brand10.png" />
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <!-- 家有电器 -->
    <div id="floor-1" class="floor">
      <div class="py-container">
        <div class="title floors">
          <h3 class="fl">家用电器</h3>
          <div class="fr">
            <ul class="sui-nav nav-tabs">
              <li v-for="(item,index) in tabTitle1" :key="index" @click="tab1(index)">
                <a>{{item}}</a>
              </li>
            </ul>
          </div>
        </div>
        <div class="clearfix tab-content floor-content">
          <div id="tab1" class="tab-pane active">
            <div class="yui3-g Floor-1">
              <div class="yui3-u Left blockgary">
                <ul class="jd-list">
                  <li>节能补贴</li>
                  <li>4K电视</li>
                  <li>空气净化器</li>
                  <li>IH电饭煲</li>
                  <li>滚筒洗衣机</li>
                  <li>电热水器</li>
                </ul>
                <img src="/static/img/floor-1-1.png" />
              </div>
              <div class="yui3-u row-330 floorBanner">
                <!-- 1321651651 -->
                <el-carousel trigger="click" height="360px">
                  <el-carousel-item v-for="item in goodsImg" :key="item">
                    <h3>
                      <img :src="item" />
                    </h3>
                  </el-carousel-item>
                </el-carousel>
              </div>
              <div class="yui3-u row-220 split">
                <span class="floor-x-line"></span>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-2.png" />
                </div>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-3.png" />
                </div>
              </div>
              <div class="yui3-u row-218 split">
                <img src="/static/img/floor-1-4.png" />
              </div>
              <div class="yui3-u row-220 split">
                <span class="floor-x-line"></span>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-5.png" />
                </div>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-6.png" />
                </div>
              </div>
            </div>
          </div>
          <!-- <div id="tab2" class="tab-pane">
					<p>第二个</p>
				</div>
				<div id="tab3" class="tab-pane">
					<p>第三个</p>
				</div>
				<div id="tab4" class="tab-pane">
					<p>第4个</p>
				</div>
				<div id="tab5" class="tab-pane">
					<p>第5个</p>
				</div>
				<div id="tab6" class="tab-pane">
					<p>第6个</p>
				</div>
				<div id="tab7" class="tab-pane">
					<p>第7个</p>
          </div>-->
        </div>
      </div>
    </div>

    <!-- 手机通讯 -->
    <div id="floor-2" class="floor">
      <div class="py-container">
        <div class="title floors">
          <h3 class="fl">手机通讯</h3>
          <div class="fr">
            <ul class="sui-nav nav-tabs">
              <li v-for="(item,index) in tabTitle2" :key="index" @click="tab2(index)">
                <a>{{item}}</a>
              </li>
            </ul>
          </div>
        </div>
        <div class="clearfix tab-content floor-content">
          <div id="tab8" class="tab-pane active">
            <div class="yui3-g Floor-1">
              <div class="yui3-u Left blockgary">
                <ul class="jd-list">
                  <li>节能补贴</li>
                  <li>4K电视</li>
                  <li>空气净化器</li>
                  <li>IH电饭煲</li>
                  <li>滚筒洗衣机</li>
                  <li>电热水器</li>
                </ul>
                <img src="/static/img/floor-1-1.png" />
              </div>
              <div class="yui3-u row-330 floorBanner">
                <el-carousel trigger="click" height="360px">
                  <el-carousel-item v-for="item in goodsImg" :key="item">
                    <h3>
                      <img :src="item" />
                    </h3>
                  </el-carousel-item>
                </el-carousel>
              </div>
              <div class="yui3-u row-220 split">
                <span class="floor-x-line"></span>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-2.png" />
                </div>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-3.png" />
                </div>
              </div>
              <div class="yui3-u row-218 split">
                <img src="/static/img/floor-1-4.png" />
              </div>
              <div class="yui3-u row-220 split">
                <span class="floor-x-line"></span>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-5.png" />
                </div>
                <div class="floor-conver-pit">
                  <img src="/static/img/floor-1-6.png" />
                </div>
              </div>
            </div>
          </div>
          <div id="tab2" class="tab-pane">
            <p>第二个</p>
          </div>
          <div id="tab9" class="tab-pane">
            <p>第三个</p>
          </div>
          <div id="tab10" class="tab-pane">
            <p>第4个</p>
          </div>
          <div id="tab11" class="tab-pane">
            <p>第5个</p>
          </div>
          <div id="tab12" class="tab-pane">
            <p>第6个</p>
          </div>
          <div id="tab13" class="tab-pane">
            <p>第7个</p>
          </div>
          <div id="tab14" class="tab-pane">
            <p>第8个</p>
          </div>
        </div>
      </div>
    </div>

    <!-- 品牌 -->
    <div class="brand">
      <div class="py-container">
        <ul class="Brand-list blockgary">
          <li class="Brand-item">
            <img src="/static/img/brand_21.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_03.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_05.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_07.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_09.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_11.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_13.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_15.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_17.png" />
          </li>
          <li class="Brand-item">
            <img src="/static/img/brand_19.png" />
          </li>
        </ul>
      </div>
    </div>

    <!-- 楼层导航 -->
    <div id="floor-index" class="floor-index" v-show="showFloor">
      <ul>
        <li>
          <a class="num" href="javascript:;" style="display: none;">1F</a>
          <a class="word" href="javascript;;" style="display: block;">家用电器</a>
        </li>
        <li>
          <a class="num" href="javascript:;" style="display: none;">2F</a>
          <a class="word" href="javascript;;" style="display: block;">手机通讯</a>
        </li>
        <li>
          <a class="num" href="javascript:;" style="display: none;">3F</a>
          <a class="word" href="javascript;;" style="display: block;">电脑办公</a>
        </li>
        <li>
          <a class="num" href="javascript:;" style="display: none;">4F</a>
          <a class="word" href="javascript;;" style="display: block;">家居家具</a>
        </li>
        <li>
          <a class="num" href="javascript:;" style="display: none;">5F</a>
          <a class="word" href="javascript;;" style="display: block;">运动户外</a>
        </li>
      </ul>
    </div>
    <!-- <sidePanel/> -->
  </div>
</template>

<script>
import { leftMenu, search } from "@/api";
// import sidePanel from "../public/side-panel";
export default {
  name: "homePage",
  data() {
    return {
      // showLeftMenu:false,
      bannerImg: [
        "/static/img/banner1.jpg",
        "/static/img/banner2.jpg",
        "/static/img/banner3.jpg",
        "/static/img/banner4.jpg"
      ],
      goodsImg: [
        "/static/img/floor-1-b01.png",
        "/static/img/floor-1-b02.png",
        "/static/img/floor-1-b03.png"
      ],
      tabTitle1: [
        "热门",
        "大家电",
        "生活电器",
        "厨房电器",
        "应季电器",
        "空气/净水",
        "高端电器"
      ],
      tabTitle2: [
        "热门",
        "品质优选",
        "新机尝鲜",
        "高性价比",
        "合约机",
        "手机卡",
        "手机配件"
      ],
      likeData: [], //猜你喜欢数据
      showFloor: false, //是否显示楼层导航
      leftMenu: []
    };
  },
  components: {
    // sidePanel
  },
  async created() {
    // 获取菜单
    const {
      status,
      data: { data }
    } = await leftMenu();
    if (status === 200) {
      this.leftMenu = data.slice(0, 15);
    }
  },
  mounted() {
    this.handleScroll();
    //  给window添加滚动事件
    window.addEventListener("scroll", this.handleScroll);

    function resizeFloorView() {
      if ($(document.body).width() > 1200) {
        ele_width = $(document.body).width() - 1200;
        ele_width = ele_width / 2 - 65;
        $("#floor-index").css("left", ele_width + "px");
      } else {
        $("#floor-index").css("left", "6px");
      }
    }
    $(function() {
      resizeFloorView();
      $(window).resize(function() {
        resizeFloorView();
      });
    });

    /*商品分类*/
    // $(function() {
    //   $(".all-sort-list2 > .item").hover(
    //     function() {
    //       console.log($(this))
    //       //父类分类列表容器的高度
    //       $(this).addClass("hover");
    //       $(this)
    //         .children(".item-list")
    //         .css("display", "block");
    //     },
    //     function() {
    //       $(this).removeClass("hover");
    //       $(this)
    //         .children(".item-list")
    //         .css("display", "none");
    //     }
    //   );

    //   $(".item > .item-list > .close").click(function() {
    //     $(this)
    //       .parent()
    //       .parent()
    //       .removeClass("hover");
    //     $(this)
    //       .parent()
    //       .hide();
    //   });
    // });
  },
  destroyed() {
    // 移除window滚动事件
    window.removeEventListener("scroll", this.handleScroll);
  },
  methods: {
    // 跳转到列表页
    async toSeachList(id){
      this.$router.push({path:"seachGoods",query:{seachId:id}})
    },
    openLeftMenu(e) {
      $(e.currentTarget).addClass("hover");
      $(e.currentTarget)
        .children(".item-list")
        .css("display", "block");
    },
    closeLeftMenu(e) {
      $(e.currentTarget).removeClass("hover");
      $(e.currentTarget)
        .children(".item-list")
        .css("display", "none");
    },

    /*楼层导航*/
    handleScroll() {
      const scrollTop =
        window.pageYOffset ||
        document.documentElement.scrollTop ||
        document.body.scrollTop;
      if (scrollTop > 1200) {
        this.showFloor = true; //如果滚动的距离大于1200，滚动框显示出来
      }
      if (1200 < scrollTop && scrollTop < 1600) {
        //第一层的数字隐藏，文字显示，其他兄弟元素的li数字显示，文字隐藏
        $("#floor-index ul li")
          .eq(0)
          .find(".num")
          .hide()
          .siblings(".word")
          .css("display", "block");
        $("#floor-index ul li")
          .eq(0)
          .siblings("li")
          .find(".num")
          .css("display", "block")
          .siblings(".word")
          .hide();
      } else if (scrollTop < 1800) {
        $("#floor-index ul li")
          .eq(1)
          .find(".num")
          .hide()
          .siblings(".word")
          .css("display", "block");
        $("#floor-index ul li")
          .eq(1)
          .siblings("li")
          .find(".num")
          .css("display", "block")
          .siblings(".word")
          .hide();
      }
      if (scrollTop > 2500 || scrollTop < 1200) {
        this.showFloor = false;
      }
    },
    //    tab切换1
    tab1(index) {
      //    this.axios.get('').then(res=>{
      //        console.log("res",res)
      //    }).catch(err=>{
      //        console.log("err",err)
      //    })
    },
    //    tab切换2
    tab2(index) {
      //    this.axios.get('').then(res=>{
      //        console.log("res",res)
      //    }).catch(err=>{
      //        console.log("err",err)
      //    })
    }
  }
};
</script>

<style scoped>
/* banner样式 */
/* .el-carousel__item h3 {
    margin: auto;
  } */
</style>
