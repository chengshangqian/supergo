<!--product-info-->
			<div class="product-info">
                   <div class="fl preview-wrap">
					<!--放大镜效果-->
					<div class="zoom">
						<!--默认第一个预览-->
						<div id="preview" class="spec-preview">
							<span class="jqzoom"><img :jqimg="firstBigImg" :src="firstSmallImg" /></span>
						</div>
						<!--下方的缩略图-->
						<div class="spec-scroll">
							<a class="prev" @click="prevImg">&lt;</a>
							<!--左右按钮-->
							<div class="items">
								<ul>
									<li v-for="(item,index) in detailsData.images" :key="index"><img :src="item.imgSmall" :bimg="item.imgBig" @mouseover="preview($event)" /></li>
								</ul>
							</div>
							<a class="next" @click="nextImg">&gt;</a>
						</div>
					</div>
				</div>
				<div class="fr itemInfo-wrap">
					<div class="sku-name">
						<h4>{{detailsData.title}}</h4>
					</div>
					<div class="news"><span>{{detailsData.promotion}}</span></div>
					<div class="summary">
						<div class="summary-wrap">
							<div class="fl title">
								<i>价　　格</i>
							</div>
							<div class="fl price">
								<i>¥</i>
								<em>{{detailsData.price}}</em>
								<span>降价通知</span>
							</div>
							<div class="fr remark">
								<i>累计评价</i><em>612188</em>
							</div>
						</div>
						<div class="summary-wrap">
							<div class="fl title">
								<i>促　　销</i>
							</div>
							<div class="fl fix-width">
								<i class="red-bg">加价购</i>
								<em class="t-gray">{{detailsData.salesDeclarer}}</em>
							</div>
						</div>
					</div>
					<div class="support">
						<div class="summary-wrap">
							<div class="fl title">
								<i>支　　持</i>
							</div>
							<div class="fl fix-width">
								<em class="t-gray">以旧换新，闲置手机回收  4G套餐超值抢  礼品购</em>
							</div>
						</div>
						<div class="summary-wrap">
							<div class="fl title">
								<i>配 送 至</i>
							</div>
							<div class="fl fix-width">
								<em class="t-gray">满999.00另加20.00元，或满1999.00另加30.00元，或满2999.00另加40.00元，即可在购物车换购热销商品</em>
							</div>
						</div>
					</div>
					<div class="clearfix choose">
						<div id="specification" class="summary-wrap clearfix">
							<dl v-for="(item, index) in detailsData.sellingStyles" :key="index">
								<dt>
									<div class="fl title">
									<i>{{item.style}}</i>
								</div>
								</dt>
								<dd  v-for="(value, ind) in item.items" :key="ind" class="sel" :class="{'selected':ind==0}" @click="selcolor(ind)">{{value.title}}<span title="点击取消选择">&nbsp;</span></dd>
							</dl>
						</div>
						
						
						<div class="summary-wrap">
							<div class="fl title">
								<div class="control-group">
									<div class="controls">
										<input type="text" v-model.number="num" class="itxt" />
										<a href="javascript:void(0)" class="increment plus" @click="add">+</a>
										<a href="javascript:void(0)" class="increment mins" @click="minus">-</a>
									</div>
								</div>
							</div>
							<div class="fl">
								<ul class="btn-choose unstyled">
									<li>
										<a class="sui-btn  btn-danger addshopcar" @click="addCart">加入购物车</a>
										<!-- <router-link class="sui-btn  btn-danger addshopcar" to="/cart" @click="addCart">加入购物车</router-link> -->
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>