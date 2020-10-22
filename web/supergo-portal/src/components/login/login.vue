<template>
  <div>
		<div class="py-container logoArea">

      <!--head-->
      <div class="logoArea">
        <a href="" class="logo"></a>
      </div>

		  <!--loginArea-->
      <div class="loginArea login">
        <div class="loginform">
          <el-tabs type="border-card" v-model="activeName">
            <el-tab-pane label="扫描登录" name="code">
              <p>二维码登录，暂为官网二维码</p>
              <img src="../../../static/img/wx_cz.jpg" />
            </el-tab-pane>
            <el-tab-pane label="账户登录" name="account">
              <form class="sui-form">
                <div class="input-prepend">
                  <span class="add-on loginname"></span>
                  <input id="user" type="text" placeholder="邮箱/用户名/手机号" class="span2 input-xfat" v-model="user">
                </div>
                <div class="input-prepend">
                  <span class="add-on loginpwd"></span>
                  <input id="password" type="password" placeholder="请输入密码" class="span2 input-xfat" v-model="password">
                </div>
                <div class="setting">
                  <label class="checkbox inline">
                    <input name="m1" type="checkbox" value="2" checked="" />&nbsp;自动登录
                  </label>
                  <span class="forget">忘记密码？</span>
                </div>
                <div class="logined">
                  <a class="sui-btn btn-block btn-xlarge btn-danger" @click="login(user, password)">登&nbsp;&nbsp;录</a>
                </div>
              </form>

              <div class="otherlogin">
                <div class="types">
                  <ul>
                    <li><img src="../../../static/img/qq.png" width="35px" height="35px" /></li>
                    <li><img src="../../../static/img/sina.png" /></li>
                    <li><img src="../../../static/img/ali.png" /></li>
                    <li><img src="../../../static/img/weixin.png" /></li>
                  </ul>
                </div>
                <span class="register"><router-link to="/register">立即注册</router-link></span>
              </div>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>

      <!--foot-->
      <div class="py-container copyright">
        <ul>
          <li>关于我们</li>
          <li>联系我们</li>
          <li>联系客服</li>
          <li>商家入驻</li>
          <li>营销中心</li>
          <li>手机超级购</li>
          <li>销售联盟</li>
          <li>超级购社区</li>
        </ul>
        <div class="address">地址：北航致真大厦D座21F 邮编：102539  电话：010-25339 传真：010-121502</div>
        <div class="beian">京ICP备08001421号京公网安备110108007702</div>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      activeName: "account"
    };
  },
  components: {},
  mounted() {},
  methods: {
    //   登录
    login(user, password) {
      if (user && password) {
        this.$router.push({ path: "/index"});
      } else {
        this.$message({
          message: '用户名和密码不得为空!',
          type: 'warning'
        });
      }
    },
  }
};
</script>

<style scoped>
.logoArea {
	height: 78px;
	border-bottom: 2px solid #c81523
}

.copyright {
  text-align: center;
  line-height: 24px;
}

.logo {
	background: url(../../../static/img/icons.png) no-repeat;
	width: 182px;
	height: 78px;
	position: absolute;
	background-position: -367px 0
}

.login {
  height: 480px;
}

.loginform {
  width: 380px;
  background: #fff;
  float: right;
  top: 45px;
  position: relative;
  padding: 20px;
}

img {
  display: block;
  margin: 0 auto;
}

.sui-form {
  margin-top: 15px;
}

span.loginname {
  background-image: url(../../../static/img/icons.png);
  background-position: -10px -201px;
}

.sui-form .input-prepend {
  margin-bottom: 16px;
}

.sui-nav.nav-tabs.tab-wraped > li {
  width: 50%;
}

.sui-nav.nav-tabs.tab-wraped > li.active > a {
  padding-top: 0;
  border-top: 1px solid #28a3ef;
}

.sui-nav.nav-tabs.tab-wraped > li > a {
  padding: 0;
}

.sui-nav.nav-tabs.tab-wraped > li.active h3 {
  color: #c8111a;
}

.sui-form .input-prepend .add-on {
  padding: 6px 5px;
  background-color: #cfcdcd;
  width: 25px;
  height: 23px;
  *float: left;
}

.sui-form input[type="text"],
.sui-form input[type="password"] {
  height: 23px;
}

.sui-form input.span2 {
  width: 284px;
  *float: left;
}

.loginpwd {
  background-image: url(../../../static/img/icons.png);
  background-position: -72px -201px;
  display: block;
  width: 25px;
  height: 23px;
}

.setting {
  position: relative;
  margin: 0 0 25px;
}

.setting .forget {
  position: absolute;
  right: 0;
}

.btn-danger {
  background-color: #c81623;
  padding: 6px;
  border-radius: 0;
  font-size: 16px;
  font-family: 微软雅黑;
  word-spacing: 4px;
}

.otherlogin {
  position: relative;
  margin-top: 30px;
}

.otherlogin .register {
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 15px;
}

.types ul li {
  list-style-type: none;
  display: inline-block;
  *display: inline;
  *zoom: 1;
  width: 40px;
  height: 55px;
}

.copyright ul li {
  list-style-type: none;
  display: inline-block;
  *display: inline;
  *zoom: 1;
  border-right: 1px solid #e4e4e4;
  padding: 0 20px;
  margin: 15px 0;
}

.copyright ul li:last-child {
  border-right: 0;
}
</style>
