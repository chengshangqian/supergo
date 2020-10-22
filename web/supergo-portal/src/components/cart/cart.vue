<template>
    <div>
        <cartHeader />
    <div class="cart py-container">
        <!--All goods-->
		<div class="allgoods" v-if="shopCart.length>0">
			<h4>全部商品<span>{{payment.count}}</span></h4>
			<div class="cart-main">
				<div class="yui3-g cart-th">
					<!-- <input type="checkbox" name="" id="" value="" /> -->
					<div class="yui3-u-1-4">
						<el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
					</div>
					<div class="yui3-u-1-4">商品</div>
					<div class="yui3-u-1-8">单价（元）</div>
					<div class="yui3-u-1-8">数量</div>
					<div class="yui3-u-1-8">小计（元）</div>
					<div class="yui3-u-1-8">操作</div>
				</div>
				<div class="cart-item-list" v-for="(item,index) in shopCart" :key="index" v-if="item.orderItems.length>0">
					<div class="cart-shop">
						<el-checkbox :v-model="item.option">{{item.shop}}</el-checkbox>
						<!-- <input type="checkbox" name="" id="" value="" />
						<span class="shopname self">{{item.shop}}</span> -->
					</div>
					<div class="cart-body">
						<div class="cart-list" v-for="(items,ind) in item.orderItems" :key="ind">
							<ul class="goods-list yui3-g">
								<li class="yui3-u-1-24">
									<el-checkbox :v-model="items.options"></el-checkbox>
									<!-- <input type="checkbox" name="" id="" value="" /> -->
								</li>
								<li class="yui3-u-11-24">
									<div class="good-item">
										<div class="item-img"><img :src="items.image" /></div>
										<div class="item-msg">{{items.title}}
											尺寸：{{items.size}}</div>
									</div>
								</li>
								
								<li class="yui3-u-1-8"><span class="price">{{items.sell_price}}</span></li>
								<li class="yui3-u-1-8">
									<a href="javascript:void(0)" class="increment mins"  @click="minus(items)">-</a>
									<input autocomplete="off" type="text" v-model.number="items.num" class="itxt" />
									<a href="javascript:void(0)" class="increment plus"  @click="add(items,items.options)">+</a>
								</li>
								<li class="yui3-u-1-8"><span class="sum">8848.00</span></li>
								<li class="yui3-u-1-8">
									<a @click="del(item.orderItems,items)">删除</a><br />
									<a >移到我的关注</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="cart-tool">
				<div class="select-all">
					<el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
				</div>
				<div class="option">
					<a href="#none">删除选中的商品</a>
					<a href="#none">移到我的关注</a>
					<a href="#none">清除下柜商品</a>
				</div>
				<div class="toolbar">
					<div class="chosed">已选择<span>{{payment.count}}</span>件商品</div>
					<div class="sumprice">
						<span><em>总价（不含运费） ：</em><i class="summoney">¥{{payment.total}}</i></span>
						<span><em>已节省：</em><i>-¥20.00</i></span>
					</div>
					<div class="sumbtn">
						<router-link class="sum-btn" to="/getOrderInfo">结算</router-link>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="deled">
				<span>已删除商品，您可以重新购买或加关注：</span>
				<div class="cart-list del">
					<ul class="goods-list yui3-g">
						<li class="yui3-u-1-2">
							<div class="good-item">
								<div class="item-msg">Apple Macbook Air 13.3英寸笔记本电脑 银色（Corei5）处理器/8GB内存</div>
							</div>
						</li>
						<li class="yui3-u-1-6"><span class="price">8848.00</span></li>
						<li class="yui3-u-1-6">
							<span class="number">1</span>
						</li>
						<li class="yui3-u-1-8">
							<a href="#none">重新购买</a>
							<a href="#none">移到我的关注</a>
						</li>
					</ul>
				</div>
			</div>
			
		</div>
		    <div class="cartTips" v-if="shopCart.length==0">
				<h1>购物车为空，请添加商品呦！</h1>
			</div>
			<div class="liked">
                <el-tabs type="border-card">
  <el-tab-pane label="猜你喜欢">
       猜你喜欢
      <!-- <el-carousel trigger="click" height="150px" arrow="always" indicator-position="none">
      <el-carousel-item  v-for="item in 4" :key="item">
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel> -->
      	
  </el-tab-pane>
  <el-tab-pane label="特惠换购">
      特惠换购
      </el-tab-pane>
</el-tabs>
			</div>
        </div>


       <Footer />
    </div>
</template>

<script>
import cartHeader from '../public/cartHeader'
import Footer from '../public/footer'
import GoodsTool from '../../GoodsTool.js'
export default {
  name: "cart",
  data() {
    return {
	   shopCart:[],//购物车数据
	   checkAll:false,//全选
	   isIndeterminate:true,
	   orders:[],//所有订单
    };
  },
  components: {
      cartHeader,
      Footer,
  },
  computed:{ 
	//   计算商品总数及价格
	payment(){
		let total = 0;//总价格
		let count = 0;//总数量
		let orders=[];
		this.shopCart.forEach(item => {
			item.orderItems.forEach(values =>{
				orders.push(values)
			})
		})
		   orders.forEach(shop => {
           
		// 	if(shop.isSelected){
				count+=shop.num;
				total+=shop.num*shop.sell_price;
		// 	}
		});
      return{
		  total,count
	  }
	}
    
  },
  created(){
	//   获取所有购物车商品
	  let goodsList=GoodsTool.getGoodsList();
	//   console.log("goodsList",goodsList)
	let ids =Object.keys(goodsList).join(',');
	// console.log("ids",ids)
	if(ids){
		this.axios.get('../../../static/data/orders.json').then(res=>{
			if(res.status==200){
                this.shopCart=res.data.orders;
		  this.orders=[];
		   this.shopCart.forEach(item => {
			   console.log("item",item)
			item.orderItems.forEach(values =>{
				this.orders.push(values)
			})
		})
		// 增加selected选项
			this.orders.forEach(shop=>{
				this.$set(shop, "options", false)
			})
			}	   
		}).catch(err=>{
			console.log("err",err)
		})
	}
  },
  methods: {
	//   全选
	  handleCheckAllChange(val){
		  
		//   console.log("val",val)
		//    let orders=[];
		//    this.shopCart.forEach(item => {
		// 	   console.log("item",item)
		// 	item.orderItems.forEach(values =>{
		// 		orders.push(values)
		// 	})
		// })
		// 增加selected选项
			// this.orders.forEach(shop=>{
			// 	// shop.options=val;
			// 	// console.log("shop",shop)
			// 	this.$set(shop, "options", val)
			// })
		//  console.log("this.orders",this.orders)
		//  this.orders.forEach(shop=>{
		// 		this.$nextTick(() => {
		// 			shop.options=val;
		// 			})
				
		// 	})
			// this.isIndeterminate = false;
			// console.log("this.orders",this.orders)
		//  this.orders = val ? cityOptions : [];
		
	  },
      // 增加购买数量
	add(shop,option){
		console.log("option",option)
		shop.num++;
		this.$store.dispatch('addShopNumByAction',1)
	},
	// 减少购买数量
	minus(shop){
	  if(shop.num==0){
		  return;
	  }
	   shop.num--;
	   this.$store.dispatch('addShopNumByAction',-1)
	},
	// 删除商品
	del(orderItems,shop){
		console.log("orderItems",orderItems)
		// 删除数组元素
		orderItems.forEach((item,index) => {
			 if(item.pid==shop.pid){
				 orderItems.splice(index,1);       
			   }
		})
		//删除存储的shop
		let num = shop.num;
		GoodsTool.removeGoods(shop.pid);
		this.$store.dispatch('addShopNumByAction',-num);
		console.log("this.shopCart",this.shopCart)
		console.log("this.orders",this.orders)
	}

  }
};
</script>

<style scoped>
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
     background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
     background-color: #d3dce6;
  }


.cart-th {
	background: #f5f5f5;
	border: 1px solid #ddd;
	padding: 10px
}

.cart-shop {
	border-bottom: 2px solid #ddd;
	padding: 10px 9px 5px
}

.cart-tool {
	overflow: hidden;
	border: 1px solid #ddd
}

.cart-shop .self {
	color: #fff;
	background: #c81623;
	padding: 2px
}

.cart-body,
.deled {
	margin: 15px 0
}

.cart-body {
	border: 1px solid #ddd
}

.cart-list ul {
	padding: 10px;
	border-bottom: 1px solid #ddd
}

.cart-list ul li {
	display: inline-block;
	*display: inline;
	*zoom: 1
}

.cartTips{
    height:100px;
}

.cartTips h1{
    text-align: center;
}

.price,
.sum,
.shopname,
.itxt {
	font-family: "微软雅黑"
}

.shopname {
	font-size: 14px
}

.self {
	font-size: 12px
}

.price,
.sum {
	font-size: 16px
}

.good-item .item-msg {
	padding-right: 30px;
}

.item-img {
	float: left;
	width: 100px;
	height: 90px
}

.item-txt {
	width: 200px
}

.goods-list input {
	border: 1px solid #ddd
}

a.increment {
	text-decoration: none;
	width: 6px;
	text-align: center;
	padding: 8px;
	-moz-padding-top: 10px;
	-moz-padding-bottom: 13px;
	-webkit-padding-top: 10px;
	-webkit-padding-bottom: 13px
}

.mins {
	border: 1px solid #ddd;
	border-right: 0;
	float: left
}

.plus {
	border: 1px solid #ddd;
	border-left: 0;
	float: left
}

.itxt {
	width: 40px;
	height: 32px;
	float: left;
	text-align: center;
	font-size: 14px;
	zoom: 1
}

.select-all,
.option {
	padding: 10px;
	overflow: hidden;
	float: left
}

.option a {
	float: left;
	padding: 0 10px
}

.toolbar {
	float: right
}

.chosed,
.sumprice {
	float: left;
	padding: 0 10px
}

.chosed {
	line-height: 26px
}

.sumprice {
	width: 200px;
	line-height: 22px
}

.sumprice em {
	text-align: right
}

.sumbtn {
	float: right
}

.summoney {
	color: #c81623;
	font: 16px "微软雅黑"
}

a.sum-btn {
	display: block;
	position: relative;
	width: 96px;
	height: 52px;
	line-height: 52px;
	color: #fff;
	text-align: center;
	font-size: 18px;
	font-family: "Microsoft YaHei";
	background: #e54346;
	overflow: hidden
}

.del {
	background: #fffdee
}

.del .goods-list {
	display: block;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	margin-top: 15px
}

.sui-nav.nav-tabs {
	background: #f1f1f1;
	padding-left: 0;
	border: 1px solid #ddd;
	overflow: hidden
}

.sui-nav.nav-tabs>li>a {
	border: 0;
	padding: 10px 20px;
	font-family: "微软雅黑"
}

.sui-nav.nav-tabs>.active>a {
	background-color: #c81623;
	color: #fff;
	border-radius: 0;
	border: 0
}

.item ul {
	width: 1000px;
	margin: 0 auto
}

.item ul li {
	list-style-type: none;
	display: inline-block;
	margin-right: -7px;
	border: 1px dashed #ddd;
	padding: 20px;
	*display: inline;
	*zoom: 1;
	position: relative;
	zoom: 1
}

.carousel-control {
	border-radius: 0;
	width: 22px;
	border: 0;
	background: #ddd
}

.intro,
.money,
.incar {
	line-height: 20px
}

.money,
.incar {
	text-align: center
}

.money {
	font: 14px "微软雅黑";
	color: #c81623
}

.incar {
	margin: 10px 0
}

.car {
	width: 20px;
	height: 20px;
	position: absolute;
	/* background: url(../img/icons.png) no-repeat; */
	background-position: -422px -135px
}

.cartxt {
	padding-left: 23px
}
</style>
