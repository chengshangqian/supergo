<template>
 	<!--侧栏面板开始-->
<div class="J-global-toolbar">
	<div class="toolbar-wrap J-wrap">
		<div class="toolbar">
			<div class="toolbar-panels J-panel">
                <!-- <h3 class="tbar-panel-header J-panel-header">
						<a href="" class="title"><i></i><em class="title">购物车</em></a>
						<span class="close-panel J-close" @click="tbar_panel_close('cart');" ></span>
					</h3> -->
				<!-- 购物车 -->
				<div style="visibility: hidden;" class="J-content toolbar-panel tbar-panel-cart toolbar-animate-out">
					<h3 class="tbar-panel-header J-panel-header">
						<a href="" class="title"><i></i><em class="title">购物车</em></a>
						<span class="close-panel J-close" @click="tbar_panel_close('cart');" ></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div id="J-cart-tips" class="tbar-tipbox hide">
								<div class="tip-inner">
									<span class="tip-text">还没有登录，登录后商品将被保存</span>
									<a href="#none" class="tip-btn J-login">登录</a>
								</div>
							</div>
							<div id="J-cart-render">
								<!-- 列表 -->
								<div id="cart-list" class="tbar-cart-list">
								</div>
							</div>
						</div>
					</div>
					<!-- 小计 -->
					<div id="cart-footer" class="tbar-panel-footer J-panel-footer">
						<div class="tbar-checkout">
							<div class="jtc-number"> <strong class="J-count" id="cart-number">0</strong>件商品 </div>
							<div class="jtc-sum"> 共计：<strong class="J-total" id="cart-sum">¥0</strong> </div>
							<a class="jtc-btn J-btn" href="#none" target="_blank">去购物车结算</a>
						</div>
					</div>
				</div>

				<!-- 我的关注 -->
				<div style="visibility: hidden;" data-name="follow" class="J-content toolbar-panel tbar-panel-follow">
					<h3 class="tbar-panel-header J-panel-header">
						<a href="#" target="_blank" class="title"> <i></i> <em class="title">我的关注</em> </a>
						<span class="close-panel J-close" @click="tbar_panel_close('follow');"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div class="tbar-tipbox2">
								<div class="tip-inner"> <i class="i-loading"></i> </div>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer"></div>
				</div>

				<!-- 我的足迹 -->
				<div style="visibility: hidden;" class="J-content toolbar-panel tbar-panel-history toolbar-animate-in">
					<h3 class="tbar-panel-header J-panel-header">
						<a href="#" target="_blank" class="title"> <i></i> <em class="title">我的足迹</em> </a>
						<span class="close-panel J-close" @click="tbar_panel_close('history');"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div class="jt-history-wrap">
								<ul>
									<!--<li class="jth-item">
										<a href="#" class="img-wrap"> <img src=".portal/img/like_03.png" height="100" width="100" /> </a>
										<a class="add-cart-button" href="#" target="_blank">加入购物车</a>
										<a href="#" target="_blank" class="price">￥498.00</a>
									</li>
									<li class="jth-item">
										<a href="#" class="img-wrap"> <img src="portal/img/like_02.png" height="100" width="100" /></a>
										<a class="add-cart-button" href="#" target="_blank">加入购物车</a>
										<a href="#" target="_blank" class="price">￥498.00</a>
									</li>-->
								</ul>
								<a href="#" class="history-bottom-more" target="_blank">查看更多足迹商品 &gt;&gt;</a>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer"></div>
				</div>

			</div>

			<div class="toolbar-header"></div>

			<!-- 侧栏按钮 -->
			<div class="toolbar-tabs J-tab">
				<div @click="tabItemClick('cart')" class="toolbar-tab tbar-tab-cart" data="购物车" tag="cart" >
					<i class="tab-ico"></i>
					<em class="tab-text"></em>
					<span class="tab-sub J-count " id="tab-sub-cart-count">0</span>
				</div>
				<div @click="tabItemClick('follow')" class="toolbar-tab tbar-tab-follow" data="我的关注" tag="follow" >
					<i class="tab-ico"></i>
					<em class="tab-text"></em>
					<span class="tab-sub J-count hide">0</span>
				</div>
				<div @click="tabItemClick('history')" class="toolbar-tab tbar-tab-history" data="我的足迹" tag="history" >
					<i class="tab-ico"></i>
					<em class="tab-text"></em>
					<span class="tab-sub J-count hide">0</span>
				</div>
			</div>

			<div class="toolbar-footer">
				<div class="toolbar-tab tbar-tab-top" > <a href="#"> <i class="tab-ico  "></i> <em class="footer-tab-text">顶部</em> </a> </div>
				<div class="toolbar-tab tbar-tab-feedback" > <a href="#" target="_blank"> <i class="tab-ico"></i> <em class="footer-tab-text ">反馈</em> </a> </div>
			</div>

			<div class="toolbar-mini"></div>

		</div>

		<div id="J-toolbar-load-hook"></div>

	</div>
</div>
</template>

<script>
export default {
  name: "side-panel",
  data() {
    return {
	 cartCellTemplate:'',
	//  showToolbar:false,//是否显示工具栏
     orderData:{
  "totalQuantity":2,
  "totalPrices":8998,
  "orders":[
    {
      "shop":"炫龙官方旗舰店",
      "orderItems":[
        {
          "pid":"10803521657",
          "image":"http://img10.360buyimg.com/cms/s80x80_jfs/t2941/284/2460981288/184644/79d9d20b/57bd9890N73efbc30.jpg",
          "title":"炫龙毁灭者DC 桌面级处理器 GTX950M 4G大显存 15.6英寸游戏笔记本电脑1",
          "color":"黑色",
          "size":"I3-6100/8G/500G+128G",
          "unitPrice":4499,
          "quantity":1,
          "gift":[
            {
              "pid":"10633272618",
              "title":"【炫龙】笔记本电脑专属有线游戏鼠标 龙魂机甲"
            },
            {
              "pid":"10629228032",
              "title":"【炫龙】专属游戏笔记本电脑鼠标垫 黑色加厚加大 轻柔款 黑色"
            }
          ]
        },
        {
          "pid":"10803523232",
          "image":"http://img10.360buyimg.com/cms/s80x80_jfs/t2941/284/2460981288/184644/79d9d20b/57bd9890N73efbc30.jpg",
          "title":"炫龙毁灭者DC 桌面级处理器 GTX950M 4G大显存 15.6英寸游戏笔记本电脑2",
          "color":"黑色",
          "size":"I3-6100/8G/500G+128G",
          "unitPrice":4499,
          "quantity":1,
          "gift":[
            {
              "pid":"10633272618",
              "title":"【炫龙】笔记本电脑专属有线游戏鼠标 龙魂机甲"
            },
            {
              "pid":"10629228032",
              "title":"【炫龙】专属游戏笔记本电脑鼠标垫 黑色加厚加大 轻柔款 黑色"
            }
          ]
        }
      ]
    }
  ]
}
    };
  },
  components: {

  },
  created() {

  },
  mounted(){
     // 初始购物车侧边栏
    this.setup(()=>{
        // 载入购物车列表
        this.fillCart(this.orderData);
    });
  },
  methods: {
	// 初始化
     setup(callback) {

        $('.tbar-cart-item').hover(function (){ $(this).find('.p-del').show(); },function(){ $(this).find('.p-del').hide(); });
        $('.jth-item').hover(function (){ $(this).find('.add-cart-button').show(); },function(){ $(this).find('.add-cart-button').hide(); });

        // 悬浮按钮
        $('.toolbar-tab').hover(function (){
            $(this).find('.tab-text').html($(this).attr("data"));
            $(this).find('.tab-text').addClass("tbar-tab-hover");
            $(this).find('.footer-tab-text').addClass("tbar-tab-footer-hover");
            $(this).addClass("tbar-tab-selected");
        },function(){
            // $(this).find('.tab-text').removeClass("tbar-tab-hover");
            $(this).find('.footer-tab-text').removeClass("tbar-tab-footer-hover");
            $(this).removeClass("tbar-tab-selected");
        });

        this.cartCellTemplate = $("#tbar-cart-item-template").html();

        callback();
    },
    // 侧栏按钮点击
    tabItemClick(typeName) {
// ) {
		// if (this.showToolbar){
        //    this.showToolbar=false;
		// } else{
        //    this.showToolbar=true;
		// }
     if($('.toolbar-wrap').hasClass('toolbar-open')){
            this.tbar_panel_close(typeName);
        }else{
            this.tbar_panel_show(typeName);
        }

	
    },
   // 面板显示
	tbar_panel_show(panelName) {
		console.log("panelName",panelName)
		// 悬浮按钮
		$('.toolbar-tab').removeClass('tbar-tab-click-selected');
        $('.tbar-tab-'+panelName).addClass('tbar-tab-click-selected');
        $('.tbar-tab-'+panelName).find('.tab-text').remove();

		// 面板内容
		$('.toolbar-panel').css('visibility','hidden');
		$('.tbar-panel-'+panelName).css({'visibility':"visible","z-index":"1"});

		// 面板显示
		$('.toolbar-wrap').addClass('toolbar-open'); 
	},
    // 关闭面板
	tbar_panel_close(panelName) {
            //   this.showToolbar=false;
		if($('.tbar-tab-'+panelName).find('.tab-text').length > 0){
			$('.toolbar-tab').each(function(i){
				var tagValue = $(this).attr("tag");
				if((tagValue != panelName)&&(tagValue != undefined)){
					var info = "<em class='tab-text '>"+$(this).attr('data')+"</em>";
					$(this).append(info);
					$(this).removeClass('tbar-tab-click-selected');
					$('.tbar-panel-'+$(this).attr('tag')).css({'visibility':"hidden","z-index":"-1"});
				}
			});
			$('.tbar-tab-'+panelName).addClass('tbar-tab-click-selected');
			$('.tbar-tab-'+panelName).find('.tab-text').remove();
			$('.tbar-panel-'+panelName).css({'visibility':"visible","z-index":"1"});
		}else{
			$('.toolbar-wrap').removeClass('toolbar-open');
			var info = "<em class='tab-text '>"+$('.tbar-tab-'+panelName).attr("data")+"</em>";
			$('.tbar-tab-'+panelName).append(info);
			$('.tbar-tab-'+panelName).removeClass('tbar-tab-click-selected');
			$('.tbar-panel-'+panelName).css({'visibility':"hidden","z-index":"-1"});
		}
	},
     // 填充购物车数据
    fillCart(dataJSON) {
        // 购物车列表
        var rowsHtml = "";
        for(var i = 0; i < dataJSON.orders.length ; i++){
            var shops = dataJSON.orders[i];
            for(var x = 0; x < shops.orderItems.length ; x++){
                var it = shops.orderItems[x];
                rowsHtml += String.format(
                    this.cartCellTemplate,
                    it.pid,
                    it.title,
                    it.image,
                    it.unitPrice*it.quantity,
                    it.quantity
                );
            }
        }
        $("#cart-list").html(rowsHtml);
        // 购物车小计
        $("#cart-number").html(dataJSON.totalQuantity);
        $("#cart-sum").html(String.format("¥{0}",dataJSON.totalPrices));
        // 侧栏 购物件数
        $("#tab-sub-cart-count").html(dataJSON.totalQuantity);
    }



  }
};
</script>

<style scoped>
/* @CHARSET "UTF-8"; */
.J-global-toolbar div a {
	margin: 0;
	padding: 0;
	font: 12px/150% Arial, Verdana, "宋体";
	color: #666
}

.toolbar-wrap {
	position: fixed;
	top: 0;
	right: 0;
	z-index: 9990;
	width: 35px;
	height: 100%
}

.toolbar-wrap a {
	text-decoration: none
}

.toolbar {
	position: absolute;
	right: 0;
	top: 0;
	width: 29px;
	height: 100%;
	border-right: 6px solid #7A6E6E
}

.toolbar-panels {
	position: absolute;
	left: 35px;
	top: 0;
	width: 270px;
	height: 100%;
	z-index: 2;
	background: #ECEAEA none repeat scroll 0 0
}

.toolbar-panel {
	width: 270px;
	height: 100%;
	position: absolute;
	background: #ECEAEA none repeat scroll 0 0
}

.tbar-panel-header {
	position: relative;
	width: 270px;
	height: 40px;
	line-height: 40px;
	background: #ECEAEA none repeat scroll 0 0;
	font-family: "microsoft yahei";
	font-weight: 400;
	margin: 0;
	padding: 0
}

.tbar-panel-header .title {
	display: inline-block;
	height: 40px;
	color: #5E5050;
	font: 16px/40px "微软雅黑"
}

.tbar-panel-cart .tbar-panel-header i {
	width: 20px;
	height: 18px;
	background-position: 0 0;
	margin-top: 11px
}

.tbar-panel-header i {
	margin-right: 4px;
	margin-left: 10px;
	vertical-align: top
}

.tbar-panel-header i,
.tbar-panel-header .close-panel {
	display: inline-block;
	font-style: normal;
	background-image: url(../../../static/img/cartPanelViewIcons.png);
	background-repeat: no-repeat
}

.tbar-panel-header .title em {
	display: inline-block;
	vertical-align: top
}

.tbar-panel-header .close-panel {
	width: 12px;
	height: 12px;
	background-position: 0 -250px;
	position: absolute;
	right: 8px;
	top: 16px;
	cursor: pointer;
	transition: transform .2s ease-out 0s
}

.tbar-panel-main {
	position: relative;
	margin: 0;
	padding: 0;
	font: 12px/150% Arial, Verdana, "宋体";
	color: #666
}

.tbar-tipbox {
	display: block
}

.tbar-panel-content {
	width: 270px;
	overflow-y: auto;
	overflow-x: hidden;
	position: relative
}

.tbar-tipbox .tip-inner {
	padding: 6px 5px;
	border: 1px solid #EDD28B;
	background: #FFFDEE none repeat scroll 0 0;
	text-align: center
}

.tbar-tipbox .tip-text {
	display: inline-block;
	line-height: 20px;
	vertical-align: middle;
	color: #333
}

.tbar-tipbox .tip-btn {
	display: inline-block;
	height: 20px;
	line-height: 20px;
	padding: 0 5px;
	margin-left: 5px;
	color: #FFF;
	vertical-align: middle;
	background: #C81623 none repeat scroll 0 0
}

.tbar-panel-cart .tbar-panel-footer {
	height: 50px;
	background-color: #ECEAEA;
	margin: 0;
	padding: 0
}

.tbar-checkout {
	height: 40px;
	padding: 5px 110px 5px 5px;
	position: relative
}

.tbar-checkout .jtc-number strong {
	font-family: verdana;
	color: #C81623
}

.tbar-checkout .jtc-number {
	line-height: 20px;
	font: 12px/150% Arial, Verdana, "宋体";
	color: #666
}

.tbar-checkout .jtc-sum {
	line-height: 20px;
	font: 12px/150% Arial, Verdana, "宋体";
	color: #666
}

.tbar-checkout .jtc-sum strong {
	font-family: verdana;
	color: #C81623
}

.tbar-checkout .jtc-btn {
	position: absolute;
	right: 5px;
	top: 7px;
	width: 110px;
	height: 35px;
	font: 16px/35px "微软雅黑";
	text-align: center;
	background: #C81623 none repeat scroll 0 0;
	color: #FFF
}

.tbar-cart-list {
	width: 100%;
	margin: 0;
	padding: 0;
	font: 12px/150% Arial, Verdana, "宋体";
	color: #666
}

.tbar-cart-item {
	padding: 0 5px;
	margin-bottom: 10px;
	background: #FFF none repeat scroll 0 0
}

.jtc-item-promo {
	padding: 12px 0 12px 57px;
	border-bottom: 1px dashed #E1E1E1
}

.jtc-item-promo .promo-tag {
	position: relative;
	float: left;
	width: 40px;
	height: 20px;
	margin-top: -1px;
	margin-left: -57px;
	margin-right: 17px;
	text-align: center;
	font: 12px/20px "宋体";
	color: #FFF;
	background-color: #F58813
}

.jtc-item-promo .promo-text {
	height: 18px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	font: 12px/18px verdana
}

.jtc-item-goods {
	padding: 10px 0;
	position: relative;
	overflow: hidden
}

.jtc-item-goods .p-img {
	float: left;
	width: 50px;
	height: 50px;
	border: 1px solid #DDD;
	padding: 0;
	margin-right: 5px
}

.jtc-item-goods .p-img img {
	width: 50px;
	height: 50px
}

img {
	border: 0 none;
	vertical-align: middle
}

.jtc-item-goods .p-name {
	height: 32px;
	line-height: 16px;
	margin-bottom: 4px;
	overflow: hidden
}

.jtc-item-goods .p-name a {
	color: #333
}

.jtc-item-goods .p-price {
	height: 16px;
	padding-right: 65px;
	overflow: hidden;
	font: 12px/16px verdana;
	color: #666
}

.jtc-item-goods .p-price strong {
	color: #C81623;
	font-weight: 400
}

.jtc-item-goods .p-del {
	position: absolute;
	right: 10px;
	top: 46px;
	width: 35px;
	height: 16px;
	line-height: 16px;
	color: #005AA0;
	text-align: right;
	display: none
}

.tbar-panel-history div {
	padding: 0
}

.jt-history-wrap {
	width: 235px;
	margin: 0 auto
}

.tbar-panel-history ul {
	overflow: hidden;
	margin-right: -15px;
	margin-top: 0;
	list-style: outside none none;
	padding: 0
}

.tbar-panel-history .tbar-panel-header i {
	width: 20px;
	height: 17px;
	margin-top: 11px;
	background-position: 0 -100px
}

.tbar-panel-follow .tbar-panel-header i {
	width: 20px;
	height: 17px;
	margin-top: 11px;
	background-position: 0 -50px
}

.tbar-panel-history .jth-item {
	float: left;
	position: relative;
	width: 100px;
	height: 120px;
	margin-right: 15px;
	background: #FFF none repeat scroll 0 0;
	margin-bottom: 15px;
	padding: 5px
}

.tbar-panel-history .jth-item .img-wrap {
	display: block;
	width: 100px;
	height: 100px;
	text-align: center;
	margin-bottom: 5px
}

.tbar-panel-history .jth-item .add-cart-button {
	height: 20px;
	line-height: 20px;
	overflow: hidden;
	text-align: center;
	text-decoration: none;
	display: none;
	position: absolute;
	width: 100px;
	bottom: 25px;
	left: 5px;
	z-index: 3;
	color: #FFF;
	background: rgba(28, 25, 28, .8) none repeat scroll 0 0
}

.tbar-panel-history .jth-item .price {
	color: #C81623
}

.tbar-panel-history .history-bottom-more {
	display: block;
	text-align: center;
	height: 40px;
	line-height: 40px;
	font-family: "宋体";
	color: #666
}

.toolbar-header {
	position: absolute;
	top: 0;
	right: -6px
}

.toolbar-tabs {
	position: absolute;
	top: 50%;
	left: 0;
	width: 35px;
	margin-top: -61px
}

.toolbar-tab {
	position: relative;
	width: 35px;
	height: 35px;
	margin-bottom: 1px;
	cursor: pointer;
	background-color: #7A6E6E;
	border-radius: 3px 0 0 3px;
	font: 12px/150% Arial, Verdana, "宋体";
	color: #666;
	display: inline-block;
	background-image: url(../../../static/img/cartPanelViewIcons.png);
	background-repeat: no-repeat
}

.tbar-tab-cart {
	background-position: -50px 0
}

.tbar-tab-follow {
	background-position: -50px -50px
}

.tbar-tab-history {
	background-position: -50px -100px
}

.tab-ico {
	width: 34px;
	height: 35px;
	margin-left: 1px;
	position: relative;
	z-index: 2;
	background-color: #7A6E6E
}

.tab-text {
	width: 62px;
	height: 35px;
	line-height: 35px;
	color: #FFF;
	text-align: center;
	font-family: "微软雅黑";
	position: absolute;
	z-index: 1;
	left: 35px;
	top: 0;
	background-color: #7A6E6E;
	border-radius: 3px 0 0 3px;
	transition: left .3s ease-in-out .1s;
	font-style: normal;
	margin: 0;
	padding: 0;
	cursor: pointer
}

.tab-sub {
	position: absolute;
	z-index: 3;
	right: 2px;
	top: -5px;
	height: 11px;
	padding: 1px 2px;
	border: 1px solid #B61D1D;
	overflow: hidden;
	color: #FFF;
	font: 11px/11px verdana;
	text-align: center;
	min-width: 11px;
	border-radius: 10px;
	background-color: #CC6060;
	background-image: linear-gradient(to bottom, #CC6060 0, #B61D1D 100%)
}

.hide {
	display: none
}

.toolbar-footer {
	position: absolute;
	bottom: -1px;
	width: 100%;
	margin: 0;
	padding: 0;
	font: 12px/150% Arial, Verdana, "宋体";
	color: #666
}

.tbar-tab-top {
	background-position: -50px -250px
}

.tbar-tab-feedback {
	background-position: -50px -300px
}

.footer-tab-text {
	width: 50px;
	height: 35px;
	line-height: 35px;
	color: #FFF;
	text-align: center;
	font-family: "微软雅黑";
	position: absolute;
	z-index: 1;
	left: 35px;
	top: 0;
	background-color: #7A6E6E;
	border-radius: 3px 0 0 3px;
	transition: left .3s ease-in-out .1s;
	font-style: normal;
	margin: 0;
	padding: 0;
	cursor: pointer
}

.tbar-tab-hover {
	tbar-tab-hoverleft: -60px;
	background-color: #C81623
}

.tbar-tab-footer-hover {
	left: -48px;
	background-color: #C81623
}

.tbar-tab-selected {
	background-color: #C81623
}

.tbar-tab-selected .tab-sub {
	color: #C81623;
	background-color: #FFF;
	background-image: linear-gradient(to bottom, #FFF 0, #FFF 100%);
	box-shadow: 1px 1px 3px rgba(0, 0, 0, .3);
	text-shadow: 1px 0 1px rgba(0, 0, 0, .3)
}

.tbar-tab-click-selected {
	background-color: #C81623
}

.tbar-tab-click-selected .tab-sub {
	color: #C81623;
	background-color: #FFF;
	background-image: linear-gradient(to bottom, #FFF 0, #FFF 100%);
	box-shadow: 1px 1px 3px rgba(0, 0, 0, .3);
	text-shadow: 1px 0 1px rgba(0, 0, 0, .3)
}

.survey-tab-ico {
	display: none
}

.survey-tab-text {
	left: 0;
	width: 35px;
	height: 30px;
	padding: 2px 0 3px;
	line-height: 15px;
	background: #C81623 none repeat scroll 0 0;
	color: #FFF;
	text-align: center;
	font-family: "微软雅黑";
	position: absolute;
	z-index: 1;
	top: 0;
	border-radius: 3px 0 0 3px;
	transition: left .3s ease-in-out .1s;
	font-style: normal;
	margin: 0;
	cursor: pointer
}

.toolbar-open {
	right: 270px
}

.J-close:hover {
	transform: rotate(180deg);
	-webkit-transform: rotate(180deg);
	-moz-transform: rotate(180deg);
	-o-transform: rotate(180deg);
	-ms-transform: rotate(180deg)
}

.tbar-panel-history .jth-item .add-cart-button:hover {
	background: #c81623 none repeat scroll 0 0
}
</style>
