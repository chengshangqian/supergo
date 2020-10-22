<template>
        <div class="yui3-u-1-6 list">

                    <div class="person-info">
                        <div class="person-photo"><img src="img/_/photo.png" alt=""></div>
                        <div class="person-account">
                            <span class="name">Michelle</span>
                            <span class="safe">账户安全</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="list-items">
                        <dl>
							<dt><i>·</i> 订单中心</dt>
							<dd ><router-link class="list-active" to="/account/order">我的订单</router-link></dd>
							<dd><router-link to="/account/order">待付款</router-link></dd>
							<dd><router-link to="/account/order">待发货</router-link></dd>
							<dd><router-link to="/account/order">待收货</router-link></dd>
							<dd><router-link to="/account/order">待评价</router-link></dd>
						</dl>
						<dl>
							<dt><i>·</i> 我的中心</dt>
							<dd><router-link to="/account/personCollect">我的收藏</router-link></dd>
							<dd><router-link to="/account/personCollect">我的足迹</router-link></dd>
						</dl>
						<dl>
							<dt><i>·</i> 物流消息</dt>
						</dl>
						<dl>
							<dt><i>·</i> 设置</dt>
							<dd><router-link to="/account/settingInfo">个人信息</router-link></dd>
							<dd><router-link to="/account/settingAddress">地址管理</router-link></dd>
							<dd><router-link to="/account/settingSafe">安全管理</router-link></dd>
						</dl>
                    </div>
                </div>
</template>

<script>
export default {
  name: "myself_account",
  data() {
    return {
     
    };
  },
  components: {

  },
  mounted() {},
  methods: {
    



  }
};
</script>

<style scoped>
.home {
	padding: 10px;
	color: #333
}

.list a {
	text-decoration: none
}

.list .list-items dd a.list-active {
	color: #e4393c
}

.list .list-items {
	margin-top: 10px;
	background: #F1F1F1
}

.list dl {
	margin: 0
}

.list dl a {
	color: #000
}

.list dt,
dd {
	line-height: 28px
}

.list dt {
	font-weight: 700;
	padding: 5px
}

.list dt i {
	color: red
}

.list dd {
	margin: 0 0 6px;
	border-bottom: 1px solid #ededed;
	text-align: center
}

.list .list-items dd a {
	color: #555
}

.list .list-items dd a:hover {
	color: #e4393c
}

.person-info {
	padding: 10px;
	background: #F1F1F1
}

.person-info .person-photo {
	float: left
}

.person-info .person-account {
	float: left;
	margin-left: 10px;
	margin-top: -3px;
	font-size: 14px
}

.person-info .person-account span {
	display: block;
	line-height: 26px
}
</style>
