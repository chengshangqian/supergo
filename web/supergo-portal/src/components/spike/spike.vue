<template>
  <div>
      <Header />
      <div class="py-container index">
		<!--banner-->
		<div class="banner">
			<img src="https://img12.360buyimg.com/cms/jfs/t5671/1/365678428/17311/c49dd58c/591ee12fNb3943292.png" class="img-responsive" alt="">
			<img src="https://img12.360buyimg.com/cms/jfs/t5671/1/365678428/17311/c49dd58c/591ee12fNb3943292.png" class="img-responsive" alt="">
		</div>
		<!--秒杀时间-->
		<div class="sectime">
			<div class="item-time active">
				<div class="time-clock">12:00</div>
				<div class="time-state-on">
					<span class="on-text">快抢中</span>
					<span class="on-over">距离结束：01:02:34</span>
				</div>
			</div>
			<div class="item-time">
				<div class="time-clock">14:00</div>
				<div class="time-state-will">
					<span>即将开始</span>
				</div>
			</div>
			<div class="item-time">
				<div class="time-clock">16:00</div>
				<div class="time-state-will">
					<span>即将开始</span>
				</div>
			</div>
			<div class="item-time">
				<div class="time-clock">18:00</div>
				<div class="time-state-will">
					<span>即将开始</span>
				</div>
			</div>
			<div class="item-time">
				<div class="time-clock">20:00</div>
				<div class="time-state-will">
					<span>即将开始</span>
				</div>
			</div>
		</div>
		<!--商品列表-->
		<div class="goods-list">
			<ul class="seckill" id="seckill">
				<li class="seckill-item" @mouseover="addBorder($event)" @mouseout="removeBorder($event)">
                    <router-link to="/item">
					<div class="pic">
						<img src="https://img10.360buyimg.com/mobilecms/s500x500_jfs/t30790/323/145983886/88485/d023bb70/5be92c32N1e03fa18.jpg" alt=''>
					</div>
					<div class="intro"><span>联想ThinkPad E485（08CD）14英寸笔记本电脑（锐龙5-2500U 8G 512GSSD FHD Win10）黑色</span></div>
					<div class='price'><b class='sec-price'>￥4988</b><b class='ever-price'>￥5999</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 80%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>70</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
                    </router-link>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img11.360buyimg.com/mobilecms/s500x500_jfs/t23131/54/1346507459/233648/178a183a/5b5af8d3N0fed8584.jpg" alt=''>
					</div>
					<div class="intro"><span>【无线充套装】小辣椒 红辣椒R15 全面屏双摄拍照手机 6+128GB 黑色 全网通4G 双卡双待 </span></div>
					<div class='price'><b class='sec-price'>￥1469</b><b class='ever-price'>￥1569</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 90%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>23</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img12.360buyimg.com/mobilecms/s500x500_jfs/t30193/262/1062178765/79554/e1d09744/5c05fec0N8128ed78.jpg" alt=''>
					</div>
					<div class="intro"><span>联想小新Air13 高色域窄边框2018新款13.3英寸超轻薄商务办公超极本笔记本电脑酷睿八代增强版 轻奢灰 i5-8265U/8G/256G固态/核显 指纹识别 背光键盘 win10</span></div>
					<div class='price'><b class='sec-price'>￥4799</b><b class='ever-price'>￥5499</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 60%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>115</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img13.360buyimg.com/mobilecms/s500x500_jfs/t1/15806/27/1020/174374/5c0e381eEd5b9c92d/784def93c5eeaba3.jpg" alt=''>
					</div>
					<div class="intro"><span>【3D彩屏心率智能表】心率智能手环运动计步卡路里手表睡眠检测遥控拍照电子表 支持苹果安卓 运动版黑圈黑带</span></div>
					<div class='price'><b class='sec-price'>￥258</b><b class='ever-price'>￥788</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 80%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>60</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img14.360buyimg.com/mobilecms/s500x500_jfs/t22531/292/1261360982/200804/7df9fe83/5b596705Na1e240b7.jpg!q70.jpg" alt=''>
					</div>
					<div class="intro"><span>三只松鼠坚果炒货休闲零食花生米多味花生205g/袋</span></div>
					<div class='price'><b class='sec-price'>￥15.9</b><b class='ever-price'>￥15.9</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 90%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>30</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img10.360buyimg.com/mobilecms/s500x500_jfs/t1/22825/24/1196/362764/5c0fb5f5E4a6566e5/a2d81fcb71310727.jpg" alt=''>
					</div>
					<div class="intro"><span>【超值限量8件套 急速疯抢】【美妆节特惠 买3免1】玻尿酸多效保湿亮肤修护精华原液礼盒新款护肤套装 玻尿酸精华原液多效护肤8件套</span></div>
					<div class='price'><b class='sec-price'>￥39.90</b><b class='ever-price'>￥598</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 65%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>22</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img10.360buyimg.com/mobilecms/s500x500_jfs/t25369/275/2229485560/868281/f84a7b09/5bc5feebN5596a9c9.png" alt=''>
					</div>
					<div class="intro"><span>华为（HUAWEI） 华为mate20手机 亮黑色 6GB+128GB 全网通+1年碎屏险套餐</span></div>
					<div class='price'><b class='sec-price'>￥4549</b><b class='ever-price'>￥4799</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 95%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>35</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img13.360buyimg.com/mobilecms/s500x500_jfs/t1/23935/33/275/186196/5c08a825E4b8ca63f/91c6ad0774c44b4d.jpg" alt=''>
					</div>
					<div class="intro"><span>沙芬SAVINELLI 电子烟套装 便携一次性 蒸汽烟戒烟器 仿真烟 大烟雾 星空1支装(蓝莓薄荷)</span></div>
					<div class='price'><b class='sec-price'>￥49</b><b class='ever-price'>￥159</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 75%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>200</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img10.360buyimg.com/mobilecms/s500x500_jfs/t3664/2/455941377/50024/6af917c2/580acd95N24aaaee4.jpg" alt=''>
					</div>
					<div class="intro"><span>珂兰 PT950钻石吊坠/项链项坠 30分白色/不分级 六爪显钻闪耀 永恒爱恋 送银链 KLPW019753</span></div>
					<div class='price'><b class='sec-price'>￥1999</b><b class='ever-price'>￥4999</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 80%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>160</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img12.360buyimg.com/mobilecms/s500x500_jfs/t1/23975/11/172/135064/5c078ba3Eb6cffba1/4b5456c4e09e54cf.jpg" alt=''>
					</div>
					<div class="intro"><span>悦目清心 紫砂壶 宜兴紫砂纯全手工茶壶 功夫茶具泡茶壶 清水泥天际</span></div>
					<div class='price'><b class='sec-price'>￥199</b><b class='ever-price'>￥580</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 75%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>190</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img13.360buyimg.com/mobilecms/s500x500_jfs/t3067/187/815707784/259898/40a7c47a/57bf0328N42a7c0ef.jpg" alt=''>
					</div>
					<div class="intro"><span>富安娜家纺 床上用品 纯棉印花冬厚被子 清雅汐颜 1.8米床适用（230*229cm）粉色</span></div>
					<div class='price'><b class='sec-price'>￥299</b><b class='ever-price'>￥758</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 60%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>310</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>
				<li class="seckill-item">
					<div class="pic">
						<img src="https://img14.360buyimg.com/mobilecms/s500x500_jfs/t5161/85/1636276207/239014/cff84f42/59128639Nd5f2f79a.jpg!q70.jpg" alt=''>
					</div>
					<div class="intro"><span>酷派（Coolpad）S588老人手机 铂光金 移动联通2G双卡双待</span></div>
					<div class='price'><b class='sec-price'>￥99</b><b class='ever-price'>￥118</b></div>
					<div class='num'>
						<div>已售87%</div>
						<div class='progress'>
							<div class='sui-progress progress-danger'><span style='width: 30%;' class='bar'></span></div>
						</div>
						<div>剩余<b class='owned'>600</b>件</div>
					</div>
					<a class='sui-btn btn-block btn-buy' href='seckill-item.html' target='_blank'>立即抢购</a>
				</li>


			</ul>
		</div>
		<div class="cd-top">
			<div class="top">
				<img src="../../../static/img/_/gotop.png" />
				<b>TOP</b>
			</div>
			<div class="code" id="code">
				<span><img src="../../../static/img/_/code.png"/></span>
			</div>
			<div class="erweima">
				<img src="../../../static/img/_/erweima.jpg" alt="">
				<s></s>
			</div>
		</div>
	</div>
       <Footer />
  </div>
</template>

<script>
import Header from '../public/header'
import Footer from '../public/footer'
export default {
  name: "spike",
  data() {
    return {


    };
  },
  components: {
     Header,
	 Footer,
  },
  mounted() {

  },
  methods: {
	//   鼠标划入添加边框
    addBorder(e){
		// console.log("e",e)
		console.log("e.currentTarget",e.currentTarget)
		// console.log("1231")
		e.currentTarget.style.border='solid 1px #f00'
	},
	// 鼠标划出移除边框
	removeBorder(e){
		// console.log("e",e)
		console.log("e.currentTarget",e.currentTarget)
		// console.log("1231")
		e.currentTarget.style.border='solid 1px #f00'
	}



  }
};
</script>

<style scoped>
.row-405 {
	width: 405px
}

.row-225 {
	width: 225px
}

.row-165 {
	width: 165px
}

.row-330 {
	width: 330px
}

.row-220 {
	width: 220px
}

.row-218 {
	width: 218px
}

.index .sectime {}

.index .sectime .item-time {
	float: left;
	vertical-align: middle;
	margin-left: 2.5px;
	padding: 10px 0;
	width: 238px;
	height: 40px;
	line-height: 40px;
	*line-height: 42px;
	_line-height: 42px;
	color: #fff;
	background-color: #4e4e4e
}

.index .sectime .item-time.active {
	line-height: 21px;
	background: #b1191a
}

.index .sectime .item-time:first-child {
	margin-left: 0
}

.index .sectime .item-time div {
	overflow: hidden;
	*float: left;
	vertical-align: middle
}

.index .sectime .item-time.active .time-clock {
	*padding-top: 10px;
	_padding-top: 10px;
	*line-height: 20px;
	_line-height: 20px
}

.index .sectime .item-time .time-clock {
	float: left;
	padding-left: 25px;
	padding-right: 10px;
	line-height: 40px;
	font-size: 18px;
	font-weight: 700
}

.index .sectime .item-time .time-state-on span {
	display: block
}

.index .sectime .item-time .time-state-on .on-text {
	font-size: 14px
}

.index .sectime .item-time .time-state-on .on-over {
	font-size: 12px
}

.index .sectime .item-time .time-state-will span {
	padding: 4px 10px;
	*padding-top: 0;
	_padding-top: 0;
	border: 1px solid #9e9e9e;
	border-radius: 10px;
	color: #9e9e9e
}

.goods-list {
	margin-bottom: 30px
}

.goods-list ul.seckill {
	margin-left: -10px
}

.goods-list ul li {
	display: inline-block;
	margin-left: 10px;
	margin-top: 10px;
	width: 287px;
	line-height: 26px;
	list-style-type: none;
	cursor: pointer;
	border: 1px solid transparent
}

.border {
	border-color: #555
}

.goods-list ul li.border {
	border: 1px solid #b1191a
}

.goods-list .seckill-item .intro {
	padding: 0 10px;
	font-size: 14px;
	color: #666
}

.goods-list .seckill-item .price {
	padding: 0 10px
}

.goods-list .seckill-item .price .sec-price {
	font-size: 22px;
	color: #e60012
}

.goods-list .seckill-item .price .ever-price {
	font-size: 14px;
	color: #a4a4a4;
	text-decoration: line-through
}

.goods-list .seckill-item .num {
	padding: 0 10px
}

.goods-list .seckill-item .num div {
	display: inline-block
}

.goods-list .seckill-item .num .progress {
	width: 55%;
	margin: 0 5px
}

.goods-list .seckill-item .num .sui-progress {
	margin-bottom: 0;
	width: 100%;
	height: 12px
}

.progress-danger .bar {
	background-color: #ed282e
}

.goods-list .seckill-item .num .owned {
	font-size: 16px;
	color: #e12228
}

.goods-list li.seckill-item .btn-buy {
	padding: 15px 0;
	margin-top: 10px;
	font-size: 20px;
	border: 0;
	border-radius: 0;
	background-color: #b1191a;
	color: #fff
}

.cd-top {
	position: fixed;
	right: 13%;
	bottom: 25%;
	z-index: 100;
	text-align: center;
	color: #fff;
	background-color: #B1191A
}

.cd-top .top {
	padding: 5px;
	background-color: #B1191A;
	cursor: pointer
}

.top b {
	display: block;
	margin-top: -5px;
	color: #fff;
	font-size: 16px;
	line-height: 26px
}

.cd-top .code {
	border-top: 1px solid #fff;
	padding: 10px 20px;
	cursor: pointer
}

.cd-top .erweima {
	display: none;
	position: fixed;
	right: 17.5%;
	z-index: 200;
	bottom: 19%;
	border: 2px solid #b1191a
}

.cd-top .erweima s {
	position: absolute;
	right: -15px;
	top: 39%;
	border-width: 7px;
	border-style: solid;
	border-color: transparent transparent transparent #B1191A;
	z-index: 4
}
</style>
