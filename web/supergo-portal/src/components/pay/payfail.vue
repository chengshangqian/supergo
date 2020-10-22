<template>
    <div>
       <Top />
       <div class="cart py-container">
			<!--logoArea-->
			<div class="logoArea">
				<div class="fl logo"><span class="title">支付页</span></div>
			</div>
			<!--主内容-->
			<div class="payfail">
				<div class="fail">
					<h3><img src="img/_/fail.png" width="48" height="48">　支付失败，请稍后再试</h3>
					<div class="fail-text">
					<p>失败原因：不能使用金币购买！</p>
					<p>您可以先去　<a href="index.html" target="_blank">品优购首页</a>　逛逛</p>
					<p class="button"><a href="" class="sui-btn btn-xlarge btn-danger">重新支付</a></p>
				    </div>
				</div>
				
			</div>
		</div>
      <Footer />
    </div>
</template>

<script>
import Top from '../public/top'
import Footer from '../public/footer'
export default {
  name: "payfail",
  data() {
    return {
     
    };
  },
  components: {
      Top,
      Footer
  },
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

.payfail {
	padding: 25px;
	margin: 20px 0;
	overflow: hidden;
	border: 1px solid #ddd;
	font-family: "微软雅黑"
}

.payfail .fail {
	width: 500px;
	margin: 0 auto
}

.fail h3 {
	font-weight: 700
}

.fail .fail-text {
	float: left;
	margin-left: 66px;
	line-height: 26px;
	font-size: 15px
}

.fail-text .button {
	margin: 16px 0
}
</style>
