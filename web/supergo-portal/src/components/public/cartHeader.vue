<template>
    <div>
     <!--head-->
	<div class="top">
		<div class="py-container">
			<div class="shortcut">
				<ul class="fl">
					<li class="f-item">超级购欢迎您！</li>
					<li class="f-item">请登录　<span><a href="#">免费注册</a></span></li>
				</ul>
				<ul class="fr">
					<li class="f-item">我的订单</li>
					<li class="f-item space"></li>
					<li class="f-item">我的超级购</li>
					<li class="f-item space"></li>
					<li class="f-item">超级购会员</li>
					<li class="f-item space"></li>
					<li class="f-item">企业采购</li>
					<li class="f-item space"></li>
					<li class="f-item">关注超级购</li>
					<li class="f-item space"></li>
					<li class="f-item">客户服务</li>
					<li class="f-item space"></li>
					<li class="f-item">网站导航</li>
				</ul>
			</div>
		</div>
	</div>

  <!--logoArea-->
		<div class="py-container logoArea">
			<div class="fl logo"><span class="title">购物车</span></div>
			<div class="fr search">
				<form class="sui-form form-inline">
					<div class="input-append">
						<input type="text" class="input-error input-xxlarge" placeholder="品优购自营" />
						<button class="sui-btn btn-xlarge btn-danger" type="button">搜索</button>
					</div>
				</form>
			</div>
		</div>
    </div>
</template>

<script>
export default {
  name: "cartHeader",
  data() {
    return {

    };
  },
  components: {},
  mounted() {},
  methods: {




  }
};
</script>

<style scoped>
.top {
	background-color: #f1f1f1
}

.logoArea {
	overflow: hidden;
	position: relative
}

.logo {
	/* background: url(../img/icons.png) no-repeat; */
	background-position: -370px 0;
	width: 177px;
	height: 75px
}

.logo .title {
	font: 19px "微软雅黑";
	position: absolute;
	top: 24px;
	left: 190px
}

.search {
	position: absolute;
	right: 0;
	top: 22px;
	font-size: 16px
}

.search .btn-danger {
	font-size: 16px
}
</style>
