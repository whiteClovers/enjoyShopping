<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<!-- 		<link rel="stylesheet" href="css/style.css" /> -->
<!-- 		<link rel="stylesheet" href="css/foot.css" /> -->
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/foot.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!--第1行-->
	<div id="shortcut">
		<div class="w">
			<div class="top_nav clearfix">
				<!--顶部导航条-->
				<ul class="top_ul_left clearfix">
					<li id="top_nav_home_id"><i class="top_nav_home"></i><a
						href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">京东首页</a></li>
					<li class="top_nav_position" id="top_nav_position_id">北京</li>
					<!--定位-->
				</ul>
				<ul class="top_ul_right clearfix">
					<%-- <li class="login" id="login_id"><a href="${pageContext.request.contextPath}/user/MyInformServerlet.do">
						${sessionScope.session_customer.customerName }
						<a>&nbsp;&nbsp;<a href="javascript:regist();" class="link-regist style-red">
						<a href="${pageContext.request.contextPath}/user/MyInformServerlet.do">
							你好，${sessionScope.session_customer.customerNickName }
							</a>&nbsp;&nbsp;
							<c:if test="${sessionScope.session_customer.customerNickName==null }">
							<a>免费注册</a>
							</c:if>
						</a>
					</li> --%>
					
					<li class="topright">
						<a href="${pageContext.request.contextPath}/LoginServlet.do">
							你好，${sessionScope.session_customer.customerNickName }
						</a>&nbsp;&nbsp;
							
						<c:if test="${sessionScope.session_customer.customerNickName==null }">
							<a>免费注册</a>
						</c:if>
						<c:if test="${sessionScope.session_customer.customerNickName!=null }">
							<a href="${pageContext.request.contextPath}/LogoutServlet.do" >注销</a>
						</c:if>
					</li>
					
					
					<li class="spacer">|</li>
					<!--导航栏的竖线-->

					<li class="dingdan">
						<div class="dingdan_div">
							<a target="_blank" href="${pageContext.request.contextPath}/user/MyOrderServerlet.do?method=list">我的订单</a>
						</div>
					</li>
					<li class="spacer">|</li>

					<li class="ower" id="ower_id">
						<div class="ower_div">
							<!-- <i class="ci-right"><s>◇</s></i> -->
							<a target="_blank" href="xx">我的京东</a><i class="iconfont"></i>
						</div>
						<div class="ower_div_2"></div>
					</li>
					<li class="spacer">|</li>

					<li class="vip" id="vip_id">
						<div class="vip_div">
							<a target="_blank" href="xx">京东会员</a>
						</div>
					</li>
					<li class="spacer">|</li>

					<li class="buy" id="buy_id">
						<div class="buy_div">
							<a target="_blank" href="xx">企业采购</a>
						</div>
					</li>
					<li class="spacer">|</li>

					<li class="fuwu" id="fuwu_id">
						<div class="fuwu_div">
							客户服务<i class="iconfont"></i>
						</div>
						<div class="fuwu_div_2"></div>
					</li>
					<li class="spacer">|</li>

					<li class="daohang" id="daohang_id">
						<div class="daohang_div">
							网站导航<i class="iconfont"></i>
						</div>
						<div class="daohang_div_2"></div>
					</li>
					<li class="spacer">|</li>

					<li class="phone" id="phone_id">
						<div class="phone_div">
							<a target="_blank" href="//app.jd.com/">手机京东</a>
						</div>
					</li>
				</ul>
				<span class="clr"></span>
			</div>
		</div>
	</div>
	<!--第2行-->
	<div style="height: 100px;" class="w">
		<div style="float: left;">
			<!--1l-->
			<div id="logo" style="float: left;">
				<a href="" class="logo">京东</a>
			</div>
			<div style="float: left;"></div>
			<div style=""></div>
		</div>
		<div style="float: left;">
			<!--2l-->
			<div>
				<ul id="shelper" class="hide" style="display: none;"></ul>
				<div class="form">
					<input type="text" autocomplete="off" id="key" accesskey="s"
						class="text" style="height: 25px;">
					<button class="button cw-icon">搜全站</button>
					<button type="button" class="button button01">搜本店</button>
				</div>
			</div>
			<div>
				<div id="hotwords">
					<a target="_blank" href="">女巫和骑士</a> <a target="_blank" href="">jdx联名款</a>
					<a target="_blank" href="">张帅羽绒服</a> <a target="_blank" href="">设计师首饰</a>
					<a target="_blank" href="">时尚大师</a>
				</div>
			</div>
		</div>
		<div class="gwc">
			<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
					我的购物车
					</a>
		</div>
		<div style=""></div>
	</div>

	<div style="border: solid 1px #ff0ess; height: 110px;">
		<!--第3行-->
		<div class="sh-brand-wrap" style="height: 110px;">
			<div class="" style="float: left;">
				<a href="" class="shop-logo-link" target="_blank"> <img
					src="img/njr.jpg" data-id="xxx">
				</a>
			</div>
			<div class="shop-name-box">
				<span class="shop-name">南极人梅子屋专卖店</span>
			</div>
		</div>
		<div style=""></div>
	</div>
	<div style="height: 40px;">
		<!--第4行-->
	</div>
	<div class="crumb-wrap" style="height: 40px;">
		<!--第5行-->
		<div class="w">
			<div class="crumb fl clearfix">
				<div class="item first">
					<a href="">服饰内衣</a>
				</div>
				<div class="item sep">&gt;</div>
				<div class="item">
					<a href="">女装</a>
				</div>
				<div class="item sep">&gt;</div>
				<div class="item">
					<a href="">T恤</a>
				</div>
				<div class="item sep">&gt;</div>
				<div class="item">
					<a href="">南极人</a>
				</div>
				<div class="item sep">&gt;</div>
				<div class="item ellipsis"
					title="南极人白色t恤女韩版2018夏装新款宽松露肩字母上衣夏季时尚半袖体恤胖MM 白色 M(88-108斤)">南极人白色t恤女韩版2018夏装新款宽松露肩字母上衣夏季时尚半袖体恤胖MM
					白色 M(88-108斤)</div>
			</div>
		</div>

	</div>
	<div class="w">
		<div class="product-intro clearfix">
		
		<c:forEach items="${listProductSku }" var="ProductSkuQueryView">
		
			<div class="preview-wrap">
				<div class="preview" id="preview">
					<div id="spec-n1" class=" main-img" data-big="1">
						<img id="spec-img" width="350"
							alt="${ProductSkuQueryView.product_name} }"
							src="${ProductSkuQueryView.product_sku_img_big} ">
					</div>

					<div class="spec-list">
						<div id="spec-list" class="spec-items"
							style="margin: 0 20px; position: relative; width: 290px; height: 68px; overflow: hidden;">
							<ul class="lh"
								style="position: absolute; width: 348px; height: 68px; top: 0px; left: 0px;">
								<li class="img"><img src="${pageContext.request.contextPath}/img/d1.jpg" width="50"
									height="64"></li>
								<li class="img"><img src="${pageContext.request.contextPath}/img/d2.jpg" width="50"
									height="64"></li>
								<li class="img"><img src="${pageContext.request.contextPath}/img/d3.jpg" width="50"
									height="64"></li>
								<li class="img"><img src="${pageContext.request.contextPath}/img/d4.jpg" width="50"
									height="64"></li>
								<li class="img"><img src="${pageContext.request.contextPath}/img/d5.jpg" width="50"
									height="64"></li>
								<li class="img"><img src="${pageContext.request.contextPath}/img/d6.jpg" width="50"
									height="64"></li>
							</ul>
						</div>
					</div>
					<div class="preview-info clearfix">
						<div style="float: left;">
							<a class="follow J-follow" data-id="28137694529"
								href="https://item.jd.com/28137694529.html#none"
								clstag="shangpin|keycount|product|guanzhushangpin_2"> <i
								class="sprite-follow-sku"></i><em>关注</em>
							</a> <a class="share J-share"
								href="https://item.jd.com/28137694529.html#none"
								clstag="shangpin|keycount|product|share_2"> <i
								class="sprite-share"></i><em>分享</em>
							</a>
						</div>
						<div style="float: right;">
							<a class="report-btn"
								href="https://jubao.jd.com/index.html?skuId=28137694529"
								target="_blank" clstag="shangpin|keycount|product|jubao">举报</a>
						</div>
					</div>

				</div>
			</div>
			
			
			
			<div class="itemInfo-wrap">
				<div class="sku-name" name="product_name">${ProductSkuQueryView.product_name}</div>
				<div class="summary summary-first">
					<div class="summary-price-wrap clearfix">
						<div class="summary-price ">
							<div class="dt">京 东 价</div>
							<div class="dd">
								<span class="p-price"> 
								<span>￥</span> <span class="price J-p-11629979307">${ProductSkuQueryView.product_sku_price}</span>
								</span> <a class="notice " data-type="1" data-sku="11629979307"
									href="#none">降价通知</a>
							</div>
							<div class="summary-info J-summary-info clearfix">
								<div id="comment-count" class="comment-count item fr">
									<p class="comment">累计评价</p>
<%-- 									<a href="#none">${ProductSkuQueryView.product_name}</a> --%>
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				<div class="summary p-choose-wrap">
					<div style="width: 590; height: 30px;" class="1">
						<div class="dt">配 送 至</div>
						<div class="dd" style="height: 20px;">
							<div class="store clearfix" style="height: 20px;">
								<div class="stock-address">
									<div class="fl" title="北京朝阳区">北京朝阳区</div>

									<div class="fl">
										<div style="margin: 0 5px;">
											<strong>有货</strong>
										</div>

									</div>
									<div class="fl">
										<div class="title fl">支持</div>
										<div class="icon-list fl">
											<div class="line1 clearfix">
												<a>货到付款</a> <a>送运费险</a>
											</div>
										</div>
									</div>
									<div class=" fl">货到付款运费10元,在线支付运费10元</div>
								</div>
							</div>
						</div>
					</div>
					<div style="width: 590px; height: 32px; margin-left: 60px;"
						class="2">
						<div class="dd">
							<div>由南极人梅子屋专卖店从 湖南株洲市 发货, 并提供售后服务.</div>
						</div>
					</div>
					<div class="summary-line"></div>
					<div class="3" style="width: 590px; height: 82px;">
						<div class="dt">选择颜色</div>
						<div class="dd">
							<img data-img="1" src="img/ls.jpg" width="60" height="76"
								alt="绿色"> <img data-img="1" src="img/hs.jpg" width="60"
								height="76" alt="绿色"> <img data-img="1"
								src="img/black.jpg" width="60" height="76" alt="绿色">
						</div>
					</div>
					<div class="4" style="width: 590px; height: 38px;">
						<div class="dt">选择尺码</div>
						<div class="dd clearfix">
							<div class="item" data-sku="11629979308" data-value="S/26"
								title="S/26">
								<b></b> <a href="#none"
									clstag="shangpin|keycount|product|yanse-S/26"> S/26 </a>
							</div>
							<div class="item" data-sku="11629979308" data-value="S/26"
								title="S/26">
								<b></b> <a href="#none"
									clstag="shangpin|keycount|product|yanse-S/26"> M/27 </a>
							</div>
							<div class="item  selected" data-sku="11629979307"
								data-value="L/28" title="L/28">
								<b></b> <a href="#none"
									clstag="shangpin|keycount|product|yanse-L/28"> L/28 </a>
							</div>
							<div class="item" data-sku="11629979320" data-value="XL/29"
								title="XL/29">
								<b></b> <a href="#none"
									clstag="shangpin|keycount|product|yanse-XL/29"> XL/29 </a>
							</div>
							<div class="item" data-sku="12247802645" data-value="2XL/30"
								title="2XL/30">
								<b></b> <a href="#none"
									clstag="shangpin|keycount|product|yanse-2XL/30"> 2XL/30 </a>
							</div>
							<div class="item" data-sku="12247802629" data-value="3XL/31"
								title="3XL/31">
								<b></b> <a href="#none"
									clstag="shangpin|keycount|product|yanse-3XL/31"> 3XL/31 </a>
							</div>
							<div class="item" data-sku="28348201941" data-value="4XL/32"
								title="4XL/32">
								<b></b> <a href="#none"
									clstag="shangpin|keycount|product|yanse-4XL/32"> 4XL/32 </a>
							</div>
						</div>
					</div>
					<div class="summary-line"></div>
					<div class="5" style="width: 590px; height: 46px;">
						<div class="wrap-input">
							<input class=" buy-num" id="buy-num" value="1" data-max="200"
								style='width: 47px; height: 48px;&gt;
				                        <a class="btn-reduce disabled"  href="#none" >-</a>
				                        &lt;a class="btn-add"  href="#none" \'>+</a>
				                        
<a href="${pageContext.request.contextPath}/user/AddtoCart.do?method=addToCart&productSkuId=${productSkuId }" id="InitCartUrl" class="btn-special1 btn-lg"
								
								
								clstag="shangpin|keycount|product|加入购物车_2">加入购物车
								
							</a>
						</div>
						<!-- href="AddtoCart.do?method=addToCart&productSkuId=${productSkuId } -->
					</div>
				</div>
			</div>
			

			<div class="track">
				<div class="extra">
					<div class="track-tit">
						<h3>看了又看</h3>
					</div>
					<div
						style="position: relative; width: 150px; height: 188px; overflow: hidden; margin: 0 auto;">
						<a target="_blank" href=""> <img
							style="width: 150px; height: 150px;" alt="南极人短裤女夏"
							src="img/qfk.jpg" />
							<div>南极人短裤女夏2018新款韩版百搭宽松阔腿裤显瘦半身裙高腰a字chic裙裤 黑色 M</div>
						</a>
					</div>
					<div class="track-con" data-rid="902029"
						style="position: relative; width: 150px; height: 188px; overflow: hidden; margin: 0 auto;">
						<a target="_blank" href=""> <img height="150" width="150"
							alt="南极人短裤女夏" src="img/dk.jpg">
							<div>南极人短裤女夏2018新款韩版百搭宽松阔腿裤显瘦半身裙高腰a字chic裙裤 黑色 M</div>
							<p class="J-p-27684478592">￥</p>
						</a>
					</div>
					<div class="track-con" data-rid="902029"
						style="position: relative; width: 150px; height: 188px; overflow: hidden; margin: 0 auto;">
						<a target="_blank" href=""> <img height="150" width="150"
							alt="南极人短裤女夏" src="img/jsk.jpg">
							<div>南极人短裤女夏2018新款韩版百搭宽松阔腿裤显瘦半身裙高腰a字chic裙裤 黑色 M</div>
							<p class="J-p-27684478592">￥</p>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="w">
		<div class="ETab clearfix">
			<div class="fbj">
				<div class="tab-main large">
					<ul>
						<li data-tab="trigger"
							class="J-shopRec-trigger shopRec-trigger current"
							data-name="店长推荐">店长推荐</li>
					</ul>
				</div>
			</div>
			<div class="tab-con clearfix">
				<ul>
					<c:forEach items="${listProductSku1 }" var="ProductSkuQueryView" begin="1" end="6">
					<li class="fore">
					
					
					
						<div class="p-img">
							<a href="" target="_blank"> <img class="dimg"
								src="${ProductSkuQueryView.product_sku_img_mid }">
							</a>
						</div>
						<div class="p-price">
							<span>￥</span>
							<span class="price J-p-11629979307">${ProductSkuQueryView.product_sku_price}</span>
						</div>
					</li>
					
					</c:forEach>
				</ul>
			</div>
		</div>

	</div>

	<div class="w">
		<div class="clearfix">
			<div class="aside">
				<div class="m">
					<div class="mt">
						<h3>
							<a href="//nanjirenmzw.jd.com" target="_blank" title="南极人梅子屋专卖店">南极人梅子屋专卖店</a>
						</h3>
					</div>
					<div class="mc">
						<div class="m1 clearfix">
							<div class="score-sum">
								<span class="number">9.47</span>
							</div>
							<div class="score-parts">
								<div class="score-part">
									<span class="score-desc">商品评价</span> <span class="score-detail">9.48</span>
								</div>
								<div class="score-part">
									<span class="score-desc">服务态度</span> <span class="score-detail">9.51</span>
								</div>
								<div class="score-part">
									<span class="score-desc">物流速度</span> <span class="score-detail">9.50</span>
								</div>
							</div>
						</div>
						<div class="btns">
							<a href="" target="_blank"> <span
								style="margin: 0 5px;">进店逛逛</span>
							</a> <a href="#none"> <i class="sprite-follow"> </i> <span
								style="margin: 0 5px;">关注店铺</span>
							</a>
						</div>
					</div>

				</div>
				<div class="m-aside">
					<div class="mt">
						<h3>店内搜索</h3>
					</div>
					<div class="mc">
						<p class="sp-form-item1">
							<label for="sp-keyword">关键字：</label> <span> <input
								type="text" id="sp-keyword" style="width: 118px;">
							</span>
						</p>
						<p class="sp-form-item2" style="margin-top: 5px;">
							<label for="sp-price">价 格：</label> <span> <input
								type="text" id="sp-price" style="width: 46px;"> 到 <input
								type="text" id="sp-price1" style="width: 46px;">
							</span>
						</p>
						<p class="sp-form-item3" style="margin-top: 5px;">
							<label for="" style="margin-left: 12px;"> </label> <span>
								<input type="submit" value="搜索" id="btnShopSearch"
								style="width: 50px; height: 25px;">
							</span>
						</p>
					</div>
				</div>
				<div class="sp-category">
					<div class="mt">
						<h3>店内分类</h3>
					</div>
					<div class="mc no-padding">
						<dl class=" sp-single">
							<dt class="open">
								<a href="#" target="_blank">2018春装上新</a>
							</dt>
						</dl>
						

					</div>
				</div>
				<div class="mc no-padding">
					<div class="ETab">
						<div class="tab-main large">
							<ul>
								<li class="current">店铺热销</li>
								<li class="" style="">热门关注</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="detail">
				<div class="ETab">
					<div class="tab-main large ">
						<ul style="width: 990px;">
							<li class="">商品介绍</li>
							<li class="">规格与包装</li>
							<li style="display: none">质检报告</li>
							<li class="">售后保障</li>
							<li class="">商品评价<s>(1500+)</s></li>
							<li class="current">本店好评商品</li>
						</ul>
						<div style="float: right;">
							<a id="InitCartUrl-mini" class="btn-primary" href="">加入购物车</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="w">
		<div class="ETab clearfix">
			<div class="fbj">
				<div class="tab-main large">
					<ul>
						<li>猜你喜欢</li>
					</ul>
				</div>
			</div>
			<div class="tab-con clearfix">
				<div>
					<ul>
						<c:forEach items="${listProductSku1 }" var="ProductSkuQueryView" begin="1" end="6">
					<li class="fore">
					
					
					
						<div class="p-img">
							<a href="" target="_blank"> <img class="dimg"
								src="${ProductSkuQueryView.product_sku_img_mid }">
							</a>
						</div>
						<div class="p-price">
							<span>￥</span>
							<span class="price J-p-11629979307">${ProductSkuQueryView.product_sku_price}</span>
						</div>
					</li>
					
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>

	</div>
	<div id="GLOBAL_FOOTER">
		<div id="service-2017">
			<div class="w">
				<ol class="slogen">
					<li class="item fore1"><i>多</i>品类齐全，轻松购物</li>
					<li class="item fore2"><i>快</i>多仓直发，极速配送</li>
					<li class="item fore3"><i>好</i>正品行货，精致服务</li>
					<li class="item fore4"><i>省</i>天天低价，畅选无忧</li>
				</ol>
			</div>
			<div class="jd-help">
				<div class="w">
					<div class="wrap">
						<dl class="fore1">
							<dt>购物指南</dt>
							<dd>
								<a rel="nofollow" target="_blank" href="">购物流程</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">会员介绍</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">生活旅行/团购</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">常见问题</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">大家电</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">联系客服</a>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>配送方式</dt>
							<dd>
								<a rel="nofollow" target="_blank" href="">上门自提</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">211限时达</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">配送服务查询</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">配送费收取标准</a>
							</dd>
							<dd>
								<a target="_blank" href="">海外配送</a>
							</dd>
						</dl>
						<dl class="fore3">
							<dt>支付方式</dt>
							<dd>
								<a rel="nofollow" target="_blank" href="">货到付款</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">在线支付</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">分期付款</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">邮局汇款</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">公司转账</a>
							</dd>
						</dl>
						<dl class="fore4">
							<dt>售后服务</dt>
							<dd>
								<a rel="nofollow" target="_blank" href="">售后政策</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">价格保护</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">退款说明</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="n">返修/退换货</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="l">取消订单</a>
							</dd>
						</dl>
						<dl class="fore5">
							<dt>特色服务</dt>
							<dd>
								<a target="_blank" href="">夺宝岛</a>
							</dd>
							<dd>
								<a target="_blank" href="">DIY装机</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">延保服务</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">京东E卡</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">京东通信</a>
							</dd>
							<dd>
								<a rel="nofollow" target="_blank" href="">京东JD+</a>
							</dd>
						</dl>
						<span class="clr"></span>
					</div>
				</div>
			</div>
		</div>
		<div id="footer-2017">
			<div class="w">
				<div class="copyright_links">
					<p>
						<a href="" target="_blank">关于我们</a><span class="copyright_split">|</span>
						<a href="" target="_blank">联系我们</a><span class="copyright_split">|</span>
						<a href="" target="_blank">联系客服</a><span class="copyright_split">|</span>
						<a href="" target="_blank">合作招商</a><span class="copyright_split">|</span>
						<a href="" target="_blank">商家帮助</a><span class="copyright_split">|</span>
						<a href="">营销中心</a><span class="copyright_split">|</span> <a
							href="">手机京东</a><span class="copyright_split">|</span> <a href=""
							target="_blank">友情链接</a><span class="copyright_split">|</span> <a
							href="" target="_blank">销售联盟</a><span class="copyright_split">|</span>
						<a href="" target="_blank">京东社区</a><span class="copyright_split">|</span>
						<a href="" target="_blank">风险监测</a><span class="copyright_split">|</span>
						<a href="" target="_blank">隐私政策</a><span class="copyright_split">|</span>
						<a href="" target="_blank">京东公益</a><span class="copyright_split">|</span>
						<a href="" target="_blank">English Site</a><span
							class="copyright_split">|</span> <a href="" target="_blank">Media
							&amp; IR</a>
					</p>
				</div>
				<div class="copyright_info">
					<p>
						<a href="" target="_blank">京公网安备 11000002000088号</a><span
							class="copyright_split">|</span><span>京ICP证070359号</span><span
							class="copyright_split">|</span> <a href="" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span
							class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span>
					</p>
					<p>
						<span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span>
						<a href="" target="_blank">出版物经营许可证</a><span
							class="copyright_split">|</span> <a href="" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span
							class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span>
					</p>
					<p>
						<span class="copyright_text">Copyright&nbsp;©&nbsp;2004&nbsp;-&nbsp;<em
							id="copyright_year">2018</em>&nbsp;&nbsp;京东JD.com&nbsp;版权所有
						</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span>
						<a href="" target="_blank" class="copyright_license">经营证照</a><span
							class="copyright_split">|</span><span>(京)网械平台备字(2018)第00003号</span>
					</p>
					<p class="mod_copyright_inter">
						<a class="mod_copyright_inter_lk" href="" target="_blank"><i
							class="mod_copyright_inter_ico mod_copyright_inter_ico_global"></i>Global
							Site</a><span class="copyright_split">|</span> <a
							class="mod_copyright_inter_lk" href="" target="_blank"><i
							class="mod_copyright_inter_ico mod_copyright_inter_ico_rissia"></i>Сайт
							России</a><span class="copyright_split">|</span> <a
							class="mod_copyright_inter_lk" href="" target="_blank"><i
							class="mod_copyright_inter_ico mod_copyright_inter_ico_indonesia"></i>Situs
							Indonesia</a><span class="copyright_split">|</span> <a
							class="mod_copyright_inter_lk" href="" target="_blank"><i
							class="mod_copyright_inter_ico mod_copyright_inter_ico_spain"></i>Sitio
							de Espa?a</a>
					</p>
					<p>
						<span>京东旗下网站：</span> <a href="https:" target="_blank">京东钱包</a><span
							class="copyright_split">|</span> <a href="" target="_blank">京东云</a>
					</p>
				</div>
				<p class="copyright_auth">
					<a class="copyright_auth_ico copyright_auth_ico_1" href=""
						target="_blank">经营性网站备案中心</a> <a id="urlknet"
						class="copyright_auth_ico copyright_auth_ico_2"
						oncontextmenu="return false;" name="CNNIC_seal" href=""
						target="_blank">可信网站信用评估</a> <a
						class="copyright_auth_ico copyright_auth_ico_3" href=""
						target="_blank"><i></i>网络警察提醒你</a> <a
						class="copyright_auth_ico copyright_auth_ico_4" href=""
						target="_blank">诚信网站</a> <a
						class="copyright_auth_ico copyright_auth_ico_5" href=""
						target="_blank">中国互联网举报中心</a> <a
						class="copyright_auth_ico copyright_auth_ico_6" href=""
						target="_blank">网络举报APP下载</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>