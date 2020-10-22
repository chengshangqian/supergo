<template>
    <div>
        <Top />
        <div class="cart py-container">
			<!--logoArea-->
			<div class="logoArea">
				<div class="fl logo"><span class="title">支付页</span></div>
			</div>
			<!--主内容-->
			<div class="paysuccess">
				<div class="success">
					<h3><img src="img/_/right.png" width="48" height="48">　恭喜您，支付成功啦！</h3>
					<div class="paydetail">
					<p>支付方式：支付宝</p>
					<p>支付金额：￥1006.00元</p>
					<p class="button"><a href="myOrder.html" class="sui-btn btn-xlarge btn-danger">查看订单</a>&nbsp;&nbsp;&nbsp;&nbsp;<router-link class="sui-btn btn-xlarge" to="/index">继续购物</router-link></p>
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
  name: "item",
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

.paysuccess {
	padding: 25px;
	margin: 20px 0;
	border: 1px solid #ddd;
	font-family: "微软雅黑"
}

.paysuccess .success {
	width: 500px;
	margin: 0 auto
}

.success h3 {
	margin: 20px 0;
	font-weight: 700;
	font-size: 20px
}

.success .paydetail {
	margin-left: 66px;
	font-size: 15px
}

.paydetail p {
	line-height: 26px
}

p.button {
	margin: 30px 0
}

.paydetail .sui-btn.btn-xlarge {
	font-size: 18px
}
</style>
