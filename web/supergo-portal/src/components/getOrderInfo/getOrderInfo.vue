<template>
    <div>
			<cartHeader />
            <el-dialog title="添加收货地址" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
                <el-form :model="form" size="mini">
    <el-form-item label="收货人:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="详细地址:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="联系电话:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="邮箱:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="地址别名:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
      <p>建议填写常用地址:<el-button>家里</el-button><el-button>父母家</el-button><el-button>公司</el-button></p>
    </el-form-item>
  </el-form>
  
  <div slot="footer" class="dialog-footer">
    <el-button size="mini" @click="dialogFormVisible = false">取 消</el-button>
    <el-button size="mini" type="primary" @click="dialogFormVisible = false">确 定</el-button>
  </div>
</el-dialog>
<!-- <newAddress :title="tit"/> -->
       	<div class="cart py-container">
		<!--主内容-->
		<div class="checkout py-container">
			<div class="checkout-tit">
				<h4 class="tit-txt">填写并核对订单信息</h4>
			</div>
			<div class="checkout-steps">
				<!--收件人信息-->
				<div class="step-tit">
					<h5>收件人信息<span><a class="newadd" @click="dialogFormVisible = true">新增收货地址</a></span></h5>
				</div>
				<div class="step-cont">
					<div class="addressInfo">
						<ul class="addr-detail">
							<li class="addr-item">
							
							  <div>
								<div class="con name selected"><a href="javascript:;" >张默<span title="点击取消选择"></span>&nbsp;</a></div>
								<div class="con address">张默 北京市海淀区三环内 中关村软件园9号楼 <span>159****3201</span>
									<span class="base">默认地址</span>
									<span class="edittext"><a data-toggle="modal" data-target=".edit" data-keyboard="false" >编辑</a>&nbsp;&nbsp;<a href="javascript:;">删除</a></span>
								</div>
								<div class="clearfix"></div>
							  </div>
							  <div>
								<div class="con name"><a href="javascript:;">李煜<span title="点击取消选择"></span>&nbsp;</a></div>
								<div class="con address">李煜 北京市海淀区三环内 中关村软件园8号楼 <span>187****4201</span>
								<span class="edittext"><a data-toggle="modal" data-target=".edit" data-keyboard="false" >编辑</a>&nbsp;&nbsp;<a href="javascript:;">删除</a></span>
								</div>
								<div class="clearfix"></div>
							  </div>
							  
							  <div>
								<div class="con name"><a href="javascript:;">王希<span title="点击取消选择"></span>&nbsp;</a></div>
								<div class="con address">王希 北京市海淀区三环内 中关村软件园6号楼  <span>156****5681</span>
								<span class="edittext"><a data-toggle="modal" data-target=".edit" data-keyboard="false" >编辑</a>&nbsp;&nbsp;<a href="javascript:;">删除</a></span>
								</div>
								<div class="clearfix"></div>
							  </div>
							</li>
							
							
						</ul>
						<!--添加地址-->
                          <div  tabindex="-1" role="dialog" data-hasfoot="false" class="sui-modal hide fade edit">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" data-dismiss="modal" aria-hidden="true" class="sui-close">×</button>
						        <h4 id="myModalLabel" class="modal-title">添加收货地址</h4>
						      </div>
						      <div class="modal-body">
						      	<form action="" class="sui-form form-horizontal">
						      		 <div class="control-group">
									    <label class="control-label">收货人：</label>
									    <div class="controls">
									      <input type="text" class="input-medium">
									    </div>
									  </div>
									   
									   <div class="control-group">
									    <label class="control-label">详细地址：</label>
									    <div class="controls">
									      <input type="text" class="input-large">
									    </div>
									  </div>
									   <div class="control-group">
									    <label class="control-label">联系电话：</label>
									    <div class="controls">
									      <input type="text" class="input-medium">
									    </div>
									  </div>
									   <div class="control-group">
									    <label class="control-label">邮箱：</label>
									    <div class="controls">
									      <input type="text" class="input-medium">
									    </div>
									  </div>
									   <div class="control-group">
									    <label class="control-label">地址别名：</label>
									    <div class="controls">
									      <input type="text" class="input-medium">
									    </div>
									    <div class="othername">
									    	建议填写常用地址：<a href="#" class="sui-btn btn-default">家里</a>　<a href="#" class="sui-btn btn-default">父母家</a>　<a href="#" class="sui-btn btn-default">公司</a>
									    </div>
									  </div>
									  
						      	</form>
						      	
						      	
						      </div>
						      <div class="modal-footer">
						        <button type="button" data-ok="modal" class="sui-btn btn-primary btn-large">确定</button>
						        <button type="button" data-dismiss="modal" class="sui-btn btn-default btn-large">取消</button>
						      </div>
						    </div>
						  </div>
						</div>
						 <!--确认地址-->
					</div>
					<div class="hr"></div>
					
				</div>
				<div class="hr"></div>
				<!--支付和送货-->
				<div class="payshipInfo">
					<div class="step-tit">
						<h5>支付方式</h5>
					</div>
					<div class="step-cont">
						<ul class="payType">
							<li class="selected">微信付款<span title="点击取消选择"></span></li>
							<li>货到付款<span title="点击取消选择"></span></li>
						</ul>
					</div>
					<div class="hr"></div>
					<div class="step-tit">
						<h5>送货清单</h5>
					</div>
					<div class="step-cont">
						<ul class="send-detail">
							<li>
								
								<div class="sendGoods">
									
									<ul class="yui3-g">
										<li class="yui3-u-1-6">
											<span><img src="img/goods.png"/></span>
										</li>
										<li class="yui3-u-7-12">
											<div class="desc">Apple iPhone 6s (A1700) 64G 玫瑰金色 移动联通电信4G手机硅胶透明防摔软壳 本色系列</div>
											<div class="seven">7天无理由退货</div>
										</li>
										<li class="yui3-u-1-12">
											<div class="price">￥5399.00</div>
										</li>
										<li class="yui3-u-1-12">
											<div class="num">X1</div>
										</li>
										<li class="yui3-u-1-12">
											<div class="exit">有货</div>
										</li>
									</ul>
								</div>
							</li>
							<li></li>
							<li></li>
						</ul>
					</div>
					<div class="hr"></div>
				</div>
				<div class="linkInfo">
					<div class="step-tit">
						<h5>发票信息</h5>
					</div>
					<div class="step-cont">
						<span>普通发票（电子）</span>
						<span>个人</span>
						<span>明细</span>
					</div>
				</div>
				<div class="cardInfo">
					<div class="step-tit">
						<h5>使用优惠/抵用</h5>
					</div>
				</div>
			</div>
		</div>
		<div class="order-summary">
			<div class="static fr">
				<div class="list">
					<span><i class="number">1</i>件商品，总商品金额</span>
					<em class="allprice">¥5399.00</em>
				</div>
				<div class="list">
					<span>返现：</span>
					<em class="money">0.00</em>
				</div>
				<div class="list">
					<span>运费：</span>
					<em class="transport">0.00</em>
				</div>
			</div>
		</div>
		<div class="clearfix trade">
			<div class="fc-price">应付金额:　<span class="price">¥5399.00</span></div>
			<div class="fc-receiverInfo">寄送至:北京市海淀区三环内 中关村软件园9号楼 收货人：某某某 159****3201</div>
		</div>
		<div class="submit">
			<router-link class="sui-btn btn-danger btn-xlarge" to="/pay">提交订单</router-link>
		</div>
        
	</div>
       <Footer />
    </div>
</template>

<script>
import cartHeader from '../public/cartHeader'
import Footer from '../public/footer'
// import newAddress from '../public/newAddress'
export default {
  name: "getOrderInfo",
  data() {
    return {
       dialogFormVisible: false,//新增收货地址dialog
     form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
		formLabelWidth: '120px',
    };
  },
  components: {
      cartHeader,
	  Footer,
	//   newAddress
  },
  mounted() {},
  methods: {
		

  }
};
</script>

<style scoped>
.el-input {
  width: 300px;
}
.checkout h5 {
	font-weight: 700;
	margin: 0
}

.hr {
	height: 1px;
	background-color: #ddd
}

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

.checkout {
	margin: 20px 0
}

.checkout-steps {
	border: 1px solid #ddd;
	padding: 25px;
	font-family: "微软雅黑"
}

.step-tit {
	line-height: 36px;
	margin: 15px 0
}

.step-cont {
	margin: 0 10px 10px 20px
}

.step-cont ul li {
	list-style-type: none;
	overflow: hidden
}

.step-cont .con {
	float: left;
	padding: 0;
	margin: 5px 0
}

.seven {
	color: #c81623;
	margin-top: 20px
}

.price {
	font: 14px "微软雅黑";
	font-weight: 700;
	color: #e12228
}

ul.addr-detail li {
	width: 99%;
	margin: 10px 0
}

.recommendAddr {
	margin-top: 10PX
}

ul.payType li {
	position: relative;
	display: inline-block;
	padding: 5px 20px;
	border: 1px solid #ddd;
	*display: inline;
	_zoom: 1;
	*margin: 5px 10px;
	cursor: pointer
}

.step-cont li.selected {
	border: 1px solid #c81623
}

.step-cont li.selected span {
	width: 13px;
	height: 13px;
	display: none;
	position: absolute;
	right: 0;
	_right: -1px;
	bottom: 0;
	_bottom: -1px;
	overflow: hidden;
	/* background: url(../img/choosed.png) no-repeat */
}

.step-cont li.selected span {
	display: block
}

.addr-item .name {
	text-align: center;
	border: 1px solid #ddd
}

.addressInfo .sui-modal {
	width: 565px
}

.addr-item .name a {
	display: block;
	padding: 5px 38px;
	position: relative;
	outline: 0;
	text-decoration: none;
	color: inherit
}

.addr-item .name.selected {
	border: 1px solid #c81623
}

.addr-item .name a span {
	width: 13px;
	height: 13px;
	display: none;
	position: absolute;
	right: 0;
	_right: -1px;
	bottom: 0;
	_bottom: -1px;
	overflow: hidden;
	/* background: url(../img/choosed.png) no-repeat */
}

.addr-item .name.selected span {
	display: block
}

.addr-item .address {
	line-height: 30px;
	margin-left: 10px;
	padding-left: 5px;
	width: 55%
}

.addr-item .address:hover {
	cursor: pointer
}

.addr-item .address .edittext {
	padding-left: 15px;
	visibility: hidden
}

.address-hover {
	background-color: #ddd
}

.address-hover .edittext {
	visibility: visible!important
}

.addr-item .address .base {
	padding: 4px;
	margin-left: 10px;
	background-color: #878787;
	color: #fff
}

.payshipInfo span {
	font-weight: 700
}

ul.send-detail li {
	margin-top: 10px;
	line-height: 30px
}

.sendType .express {
	border: 1px solid #ddd;
	width: 120px;
	text-align: center;
	margin-right: 10px
}

.sendType,
.sendGoods {
	padding: 15px
}

.sendType {
	background: #f4f4f4;
	margin-bottom: 2px
}

.sendGoods {
	background: #feedef
}

.num,
.exit {
	text-align: center
}

.order-summary {
	overflow: hidden;
	padding-right: 20px
}

.list,
.trade {
	line-height: 26px
}

.list span {
	float: left;
	width: 160px
}

.list em {
	font-family: "微软雅黑"
}

.trade {
	padding: 10px;
	margin: 10px 0;
	text-align: right;
	background-color: #f4f4f4;
	border: 1px solid #ddd
}

.trade .fc-receiverInfo {
	color: #999
}

.sui-btn {}

.submit .btn-xlarge {
	padding: 15px 45px;
	float: right;
	margin: 0 0 10px;
	font: 18px "微软雅黑";
	font-weight: 700;
	border-radius: 0
}

.number {
	color: red
}

.step-tit h5 span {
	float: right
}

.step-tit h5 span a {
	color: #555;
	cursor: pointer;
	text-decoration: none
}

.step-tit h5 span a:hover {
	color: red
}
</style>
