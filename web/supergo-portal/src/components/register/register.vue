<template>
  <div>
    <div class="register py-container ">
      <!--head-->
      <div class="logoArea">
        <a href="" class="logo"></a>
      </div>

      <!--register-->
      <div class="registerArea">
        <h3>注册新用户<span class="go">我有账号，去<router-link to="/login">登录</router-link></span></h3>
        <div class="info">
          <form class="sui-form form-horizontal">
            <div class="control-group">
              <label for="username" class="control-label">用户名：</label>
              <div class="controls">
                <input type="text" id="username" name="username" placeholder="请输入你的用户名" class="input-xfat input-xlarge">
              </div>
            </div>
            <div class="control-group">
              <label for="password" class="control-label">登录密码：</label>
              <div class="controls">
                <input type="password" id="password" name="password" placeholder="设置登录密码" class="input-xfat input-xlarge">
              </div>
            </div>
            <div class="control-group">
              <label for="inputPassword" class="control-label">确认密码：</label>
              <div class="controls">
                <input type="password" id="inputPassword" name="inputPassword" placeholder="再次确认密码" class="input-xfat input-xlarge">
              </div>
            </div>

            <div class="control-group">
              <label for="phone" class="control-label">手机号：</label>
              <div class="controls">
                <input type="text" id="phone" name="phone" placeholder="请输入你的手机号" class="input-xfat input-xlarge">
              </div>
            </div>
            <div class="control-group">
              <label for="verifyCode" class="control-label">短信验证码：</label>
              <div class="controls">
                <input type="text" id="verifyCode" name="verifyCode" placeholder="短信验证码" class="input-xfat input-xlarge">  <a href="#">获取短信验证码</a>
              </div>
            </div>

            <div class="control-group">
              <label for="agree" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
              <div class="controls">
                <input id="agree" name="agree" type="checkbox" value="2" checked=""><span>&nbsp;同意协议并注册《超级购用户协议》</span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"></label>
              <div class="controls btn-reg">
                <a class="sui-btn btn-block btn-xlarge btn-danger" href="home.html" target="_blank">完成注册</a>
              </div>
            </div>
          </form>
          <div class="clearfix"></div>
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
    name:"register",
    data () {
        return {

        }
    },
    components: {

    },
    mounted(){

    }
}
</script>

<style scoped>
.logoArea {
	height: 78px;
	border-bottom: 2px solid #c81523
}

.logo {
	background: url(../../../static/img/icons.png) no-repeat;
	width: 182px;
	height: 78px;
	position: absolute;
	background-position: -367px 0
}

.registerArea {
	margin: 15px 0;
	border: 1px solid #dfdfdf;
	font-family: "微软雅黑"
}

.registerArea h3 {
	background: #ececec;
	margin: 0;
	padding: 6px 15px;
	color: #333;
	border-bottom: 1px solid #dfdfdf
}

h3 .go {
	font-size: 14px;
	float: right
}

.btn-reg {
	width: 270px
}

.info {
	width: 600px;
	margin: 40px auto
}

.control-label {
	font-size: 14px
}

.sui-form input[type=text].input-xfat.input-xlarge,
.sui-form input[type=password].input-xfat.input-xlarge {
	width: 250px;
	border-radius: 0;
	border: 1px solid #999;
	height: 24px
}

.sui-form .control-group label {
	*display: inline;
	*zoom: 1;
	*float: left
}

#submit {
	padding: 5px 80px;
	font-family: "微软雅黑";
	background-color: #c81523
}

.reg {
	width: 221px
}

.zhuce {
	*width: 221px;
	float: right
}

.btn-danger {
	background-color: #c81623;
	padding: 6px;
	border-radius: 0;
	font-size: 16px;
	font-family: 微软雅黑;
	word-spacing: 4px
}

.copyright {
	text-align: center;
	line-height: 24px
}

.copyright ul li {
	list-style-type: none;
	display: inline-block;
	*display: inline;
	*zoom: 1;
	border-right: 1px solid #e4e4e4;
	padding: 0 20px;
	margin: 15px 0
}

.copyright ul li:last-child {
	border-right: 0
}
</style>
