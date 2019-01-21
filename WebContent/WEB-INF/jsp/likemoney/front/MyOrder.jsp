<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wddd233.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css" />
<link href="${pageContext.request.contextPath}/css/evaluate_top.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/evaluate_search.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/order_center_middle.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="top">
		<div class="top_nav clearfix">
			<!--顶部导航条-->
			<ul class="top_ul_left clearfix">
				<li id="top_nav_home_id"><i class="top_nav_home">&#xe608;</i><a
					href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">京东首页</a></li>
				<li class="top_nav_position" id="top_nav_position_id">北京</li>
				<!--定位-->
			</ul>
			<ul class="top_ul_right clearfix">
				<!-- <li class="login" id="login_id"><a href="MyInformServerlet.do">你好，请登录<a>&nbsp;&nbsp;<a
					href="javascript:regist();" class="link-regist style-red">免费注册</a>
				</li> -->
				
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
						<a target="_blank" href="xx">我的京东</a><i class="iconfont">&#xe605;</i>
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
						客户服务<i class="iconfont">&#xe605;</i>
					</div>
					<div class="fuwu_div_2"></div>
				</li>
				<li class="spacer">|</li>

				<li class="daohang" id="daohang_id">
					<div class="daohang_div">
						网站导航<i class="iconfont">&#xe605;</i>
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
	<div class="background">
		<div class="div_wrap clearfix float">
			<div>
				<img src="img/jdlogo233.png">
			</div>
			<div>
				<div class="wddd_logo1">
					<a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_self">我的京东 
				</div>
				<div class="wddd_logo2">
					<a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">返回京东首页</a>
				</div>
			</div>
			<div class="wddd_logo3">
				<a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_self">首页</a>
			</div>
			<div class="wddd_logo3">账户设置</div>
			<div class="wddd_logo3">社区</div>
			<div class="wddd_logo3">
				<a href="http://joycenter.jd.com/msgCenter/queryMessage.action">信息</a>
			</div>
			<div>
				<input type="text"
					style="width: 170px; height: 21px; margin-left: 100px; margin-top: 25px;">
			</div>
			<div style="margin-top: 25px;">
				<button class=" button_width_height" />
				搜索
				</button>
			</div>
			<div style="margin-left: 50px; margin-top: 25px;">
				<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
					我的购物车
					</a>
			
			</div>
		</div>
	</div>
	<div id="container">
		<div class="w">
			<div id="content">
				<div id="sub">
					<!--左侧导航栏-->
					<div id="menu">
						<dl class="fore1">
							<dt id="_MYJD_order">订单中心</dt>
							<dd class="fore1_1 curr" id="_MYJD_ordercenter">
								<a clstag="homepage|keycount|home2013|Homeoder"
									href="${pageContext.request.contextPath}/user/MyOrderServerlet.do?method=list" target="_blank">我的订单</a>
							</dd>
							<dd class="fore1_4" id="_MYJD_yushou">
								<a clstag="homepage|keycount|home2013|Homeys"
									href="//yushou.jd.com/member/qualificationList.action"
									target="_self">我的活动</a>
							</dd>
							<dd class="fore1_5" id="_MYJD_comments">
								<a clstag="homepage|keycount|home2013|Homecomments"
									href="//club.jd.com/mycomments.aspx" target="_self">评价晒单</a>
							</dd>
							<dd class="fore1_7" id="_MYJD_alwaysbuy">
								<a clstag="homepage|keycount|home2013|Homewdcgqd"
									href="//changgou.jd.com/buylist-v2/list?jdHead=true&amp;page=1"
									target="_self">我的常购商品&nbsp;<img width="24" height="11"
									src="img/myjd-new-ico.png"></a>
							</dd>
							<dd class="fore1_8" id="_MYJD_dxd">
								<a clstag="homepage|keycount|home2013|Homedxd"
									href="//skunotify.jd.com/userTouchSub/query.action"
									target="_self">购物助手</a>
							</dd>
						</dl>
						<dl class="fore2">
							<dt id="_MYJD_gz">关注中心</dt>
							<dd class="fore2_1" id="_MYJD_product">
								<a clstag="homepage|keycount|home2013|Homefollow"
									href="//t.jd.com/home/follow" target="_self">关注的商品</a>
							</dd>
							<dd class="fore2_2" id="_MYJD_vender">
								<a clstag="homepage|keycount|home2013|Homefollowv"
									href="//t.jd.com/vender/followVenderList.action" target="_self">关注的店铺</a>
							</dd>
							<dd class="fore2_3" id="_MYJD_followwhat">
								<a clstag="homepage|keycount|home2013|Homewhat"
									href="//what.jd.com/my/follow/index " target="_self">关注的专辑</a>
							</dd>
							<dd class="fore2_4" id="JD_FOLLOW_CONTENT">
								<a clstag="homepage|keycount|home2013|Homettnr"
									href="//tt.jd.com" target="_self">收藏的内容&nbsp;<img
									width="24" height="11" src="img/myjd-new-ico.png"></a>
							</dd>
							<dd class="fore2_6" id="_MYJD_activity">
								<a clstag="homepage|keycount|home2013|Homefollowa"
									href="//t.jd.com/activity/followActivityList.action"
									target="_self">关注的活动</a>
							</dd>
						</dl>
						<dl class="fore3">
							<dt id="_MYJD_zc">资产中心</dt>
							<dd class="fore3_1" id="_MYJD_cashbox">
								<a clstag="homepage|keycount|home2013|Homexjk"
									href="//jinku.jd.com/xjk/income.action" target="_self">小金库</a>
							</dd>
							<dd class="fore3_2" id="_MYJD_credit">
								<a target="_blank" class=""
									clstag="homepage|keycount|home2013|hbt" tag="213"
									href="//baitiao.jd.com">京东白条</a>
							</dd>


							<dd class="fore3_5" id="_MYJD_jdfk">
								<a clstag="homepage|keycount|home2013|Homejdfk"
									href="//mygiftcard.jd.com/giftcard/codeIndex.action"
									target="_self">领货码</a>
							</dd>
							<dd class="fore3_6" id="_MYJD_balance">
								<a clstag="homepage|keycount|home2013|Homemoney"
									href="//mymoney.jd.com/finance/recently.action" target="_self">余额</a>
							</dd>
							<dd class="fore3_7" id="_MYJD_ticket">
								<a clstag="homepage|keycount|home2013|Homequan"
									href="//quan.jd.com/user_quan.action" target="_self">优惠券</a><b>(1)</b>
							</dd>
							<dd class="fore3_8" id="_MYJD_card">
								<a clstag="homepage|keycount|home2013|Homegift"
									href="//mygiftcard.jd.com/giftcard/myGiftCardInit.action"
									target="_self">礼品卡</a>
							</dd>

							<dd class="fore3_10" id="_MYJD_bean">
								<a clstag="homepage|keycount|home2013|Homedou"
									href="//bean.jd.com/myJingBean/list" target="_self">京豆</a>
							</dd>
							<dd class="fore3_11" id="_MYJD_coin">
								<a clstag="homepage|keycount|home2013|Homehgb2"
									href="//coin.jd.com/asset/sc/myassets.html" target="_self">京东钢镚&nbsp;<img
									width="24" height="11" src="img/myjd-new-ico.png"></a>
							</dd>
						</dl>
						<dl class="fore4">
							<dt id="_MYJD_ts">特色业务</dt>
							<dd class="fore4_1" id="_MYJD_tc">
								<a clstag="homepage|keycount|home2013|Homemyyyt"
									href="//le.jd.com/myBusinessHall" target="_self">我的营业厅</a>
							</dd>
							<dd class="fore4_2" id="_MYJD_tx">
								<a clstag="homepage|keycount|home2013|Homemobile"
									href="//mobile.jd.com/yyswt/myjd.do" target="_self">京东通信</a>
							</dd>
							<dd class="fore4_3" id="_MYJD_ding">
								<a clstag="homepage|keycount|home2013|Homeding"
									href="//ding.jd.com/plan/showPlans.action" target="_self">定期购</a>
							</dd>

							<dd class="fore4_5" id="_MYJD_hsd">
								<a clstag="homepage|keycount|home2013|Homewhsd"
									href="//huanwo.jd.com/main/Main_listRecovery.action"
									target="_self">我的回收单</a>
							</dd>
							<dd class="fore4_6" id="_MYJD_jnbt">
								<a clstag="homepage|keycount|home2013|Homejnbt"
									href="//ptrade.jd.com/getNomalToJnActionList.html"
									target="_self">节能补贴</a>
							</dd>
							<dd class="fore4_7" id="_MYJD_yyfw">
								<a clstag="homepage|keycount|home2013|Homeyyfw"
									href="//yiyaorx.jd.com/process_list.action" target="_self">医药服务</a>
							</dd>
							<dd class="fore4_8" id="_MYJD_lljyz">
								<a clstag="homepage|keycount|home2013|Homelljyz"
									href="//datawallet.jd.com/profile.html" target="_self">流量加油站</a>
							</dd>
							<dd class="fore4_9" id="_MYJD_hjtg">
								<a clstag="homepage|keycount|home2013|Homehjtg"
									href="//gold.jd.com/gold/hosting/hostingSingleList.html"
									target="_self">黄金托管</a>
							</dd>
							<dd class="fore4_10" id="_MYJD_edu">
								<a clstag="homepage|keycount|home2013|Homespjydd"
									href="//eduonline.jd.com/orderlist.html" target="_self">视频教育订单</a>
							</dd>
							<dd class="fore4_11" id="_MYJD_hwfc">
								<a clstag="homepage|keycount|home2013|Homehwfcyy"
									href="//abdestate.jd.com/myjd" target="_self">海外房产预约</a>
							</dd>
							<dd class="fore4_12" id="_MYJD_homewdqqg">
								<a clstag="homepage|keycount|home2013|homewdqqg"
									href="https://home.jd.hk" target="_self">我的全球购</a>
							</dd>
							<dd class="fore4_13" id="_MYJD_stagepaymd">
								<a clstag="homepage|keycount|home2013|homezxfw"
									href="//md-helper.jd.com/stagepay/index" target="_self">装修服务</a>
							</dd>
							<dd class="fore4_14" id="_MYJD_paimai">
								<a clstag="pageclick|keycount|home_201804231|1"
									href="//ipaimai.jd.com/home/" target="_self">我的拍卖</a>
							</dd>
							<dd class="fore4_15" id="_MYJD_crt">
								<a clstag="pageclick|keycount|home_201804231|2"
									href="//ctr.jd.com/order-list.html" target="_blank">我的集运</a>
							</dd>
						</dl>
						<dl class="fore5">
							<dt id="_MYJD_fw">客户服务</dt>
							<dd class="fore5_1" id="_MYJD_repair">
								<a clstag="homepage|keycount|home2013|Homerepair"
									href="//myjd.jd.com/afs/indexNew.action?entry=8" target="_self">返修退换货</a>
							</dd>
							<dd class="fore5_2" id="_MYJD_protection">
								<a clstag="homepage|keycount|home2013|Homejb"
									href="//pcsitepp-fm.jd.com" target="_self">价格保护</a>
							</dd>
							<dd class="fore5_3" id="_MYJD_complaint">
								<a clstag="homepage|keycount|home2013|Homeopinion"
									href="//myjd-crm.jd.com/opinion/orderList.action"
									target="_self">意见建议</a>
							</dd>
							<dd class="fore5_4" id="_MYJD_question">
								<a clstag="homepage|keycount|home2013|Homewdwd"
									href="//question.jd.com/myjd/getMyjdQuestionList.action"
									target="_self">我的问答</a>
							</dd>
							<dd class="fore5_5" id="_MYJD_consultation">
								<a clstag="homepage|keycount|home2013|Homeconsu"
									href="//club.jd.com/myjd/userConsultationList_1.html"
									target="_self">购买咨询</a>
							</dd>
							<dd class="fore5_6" id="_MYJD_referee">
								<a clstag="homepage|keycount|home2013|Homemjyjf"
									href="//myjd-crm.jd.com/referee/orderlist.action"
									target="_self">交易纠纷</a>
							</dd>
							<dd class="fore5_7" id="_MYJD_foreign">
								<a clstag="homepage|keycount|home2013|Homemjdwx"
									href="//weixiu.jd.com/mall/repair/foreign" target="_self">京东维修
								</a>
							</dd>
							<dd class="fore5_8" id="_MYJD_smyy">
								<a clstag="homepage|keycount|home2013|Homesmyyfw"
									href="//smyyfw.jd.com/vas/apply/list" target="_self">上门预约服务</a>
							</dd>
							<dd class="fore5_9" id="_MYJD_wdfp">
								<a clstag="homepage|keycount|home2013|Homezzfp"
									href="//myivc.jd.com/fpzz.html" target="_self">我的发票</a>
							</dd>
							<dd class="fore5_10" id="_MYJD_jbzx">
								<a clstag="homepage|keycount|home2013|Homejbzx"
									href="//jubao.jd.com/myjd/list.html" target="_self">举报中心</a>
							</dd>
						</dl>
						<dl class="fore6">
							<dt id="_MYJD_sz">设置</dt>
							<dd class="fore6_1" id="_MYJD_info">
								<a clstag="homepage|keycount|home2013|Homeyser2"
									href="${pageContext.request.contextPath}/user/MyCenterServerlet.do" target="_blank">个人信息</a>
							</dd>
							<dd class="fore6_2" id="_MYJD_add">
								<a clstag="homepage|keycount|home2013|Homeadd2"
									href="${pageContext.request.contextPath}/user/ReceivingAddressServlet.do"
									target="_blank">收货地址</a>
							</dd>
						</dl>
					</div>
					<div id="menu-ads">
						<!--广告全部放这里-->
						<div>
							<a
								href="//c-nfa.jd.com/adclick?keyStr=z5AXFoIimt1jiDK32+w4mZYsU2J35VXuTltSWhYSnymMImvln2Js0HU3q+mnlAr0LpeSNpALCbss46Fg5S8sQYb7iog8VJRd/DurbeYQwISZI7p/OOlX6LABVlykvJwqEKreO71ORAWsytF/0uCxYDFgqtVQIsa4RC8XpQjjHjk+D/mVzAn04NEAtHjPNboqd0FgwJUXGVtlFQqKPtn3bfnye9VHq6RqX2PxQ5QAHtdfZ45WboFYmAv5JPAR/tMbGFFQk7VLNs32CEQYVcHt/3R4BwJzG3j9pildyVaLoDLiRli0RP2gA04xOTTAOy0r&amp;cv=2.0&amp;url=https://wan.jd.com/yeyou/gogame.html"
								target="_blank"><img width="90" height="70" alt=""
								app="image:poster"
								src="//img20.360buyimg.com/da/jfs/t4531/223/4629374646/7516/a018ebec/59126ae3N1b306e2c.jpg"></a>
						</div>
					</div>
				</div>
				<div id="main">
					<div id="chunjie" class="mb10"></div>
					<div class="mod-main mod-comm mod-order" id="order01">
						<div class="mt">
							<h3>我的订单</h3>
							<div class="extra-r"></div>
						</div>
					</div>
					<div class="mod-main mod-comm lefta-box" id="order02">
						<div class="mt">
							<ul class="extra-l">
								<li class="fore1"><a
									href="//order.jd.com/center/list.action" class="txt curr">全部订单</a></li>
								<li><a href="//order.jd.com/center/list.action?s=1"
									id="ordertoPay" clstag="click|keycount|orderinfo|waitPay"
									class="txt">待付款</a></li>
								<li><a href="//order.jd.com/center/list.action?s=128"
									id="ordertoReceive"
									clstag="click|keycount|orderinfo|waitReceive" class="txt">待收货</a></li>
								<li><a href="//club.jd.com/mycomments.aspx"
									id="ordertoComment" target="_blank" class="txt"
									clstag="click|keycount|orderinfo|daipingjia">待评价</a><a
									href="//club.jd.com/mycomments.aspx"><em>2</em></a></li>
								<li class="fore2 "><a
									href="//order.jd.com/center/alwaysbuy.action" id="ordertoBuy"
									clstag="click|keycount|orderinfo|changgoutab"><strong>我的常购商品</strong></a></li>
								<li class="fore2"><a
									href="//order.jd.com/center/tejiaqingcang.action"
									id="ordertoTejia" clstag="click|keycount|orderinfo|tjqc _1"><strong>好货·清仓</strong></a></li>
								<li class="fore2"><a
									href="//order.jd.com/center/recycle.action?d=1"
									clstag="click|keycount|orderlist|dingdanhuishouzhan"
									class="ftx-03" id="ordertoRecycle">订单回收站</a></li>
							</ul>
							<div class="extra-r">
								<div class="search">
									<input id="ip_keyword" type="text" class="itxt"
										value="商品名称/商品编号/订单号" style="color: rgb(204, 204, 204);">
									<a href="javascript:;" class="search-btn"
										clstag="click|keycount|orderinfo|search">搜索<b></b></a> <a
										href="#none" clstag="click|keycount|orderlist|gaoji"
										class="default-btn high-search">高级<b></b></a>
								</div>
							</div>
						</div>
						<div class="mc">
							<table class="td-void order-tb">
								<thead>
									<tr>
										<th><div class="ordertime-cont">
												<div class="time-txt">
													近三个月订单<b></b><span class="blank"></span>
												</div>
												<div class="time-list">
													<ul>
														<li><a href="#none" _val="1&amp;s=4096"
															clstag="click|keycount|orderlist|zuijinsangeyue"><b></b>近三个月订单</a></li>
														<li><a href="#none" _val="2&amp;s=4096"
															clstag="click|keycount|orderlist|jinniannei"><b></b>今年内订单</a></li>
														<li><a href="#none" _val="2017&amp;s=4096"
															clstag="click|keycount|orderlist|2017"><b></b>2017年订单</a></li>
														<li><a href="#none" _val="2016&amp;s=4096"
															clstag="click|keycount|orderlist|2016"><b></b>2016年订单</a></li>
														<li><a href="#none" _val="2015&amp;s=4096"
															clstag="click|keycount|orderlist|2015"><b></b>2015年订单</a></li>
														<li><a href="#none" _val="2014&amp;s=4096"
															clstag="click|keycount|orderlist|2014"><b></b>2014年订单</a></li>
														<li><a href="#none" _val="3&amp;s=4096"
															clstag="click|keycount|orderlist|before_2014"><b></b>2014年以前订单</a></li>
													</ul>
												</div>
											</div>
											<div class="order-detail-txt ac">订单详情</div></th>
										<th style="width: 115px;">收货人</th>
										<th style="width: 110px;">金额</th>
										<th>
											<div class="deal-state-cont" id="orderState">
												<div class="state-txt" style="width: 74px;">
													全部状态<b></b><span class="blank"></span>
												</div>
												<div class="state-list">
													<ul>
														<li value="4096"><a href="#none"
															clstag="click|keycount|orderlist|quanbuzhuangtai"
															class="curr"><b></b>全部状态</a></li>
														<li value="1"><a href="#none"
															clstag="click|keycount|orderlist|dengdaifukuan"><b></b>等待付款</a>
														</li>
														<li value="128"
															clstag="click|keycount|orderlist|dengdaishouhuo"><a
															href="#none"><b></b>等待收货</a></li>
														<li value="1024"><a href="#none"
															clstag="click|keycount|orderlist|yiwancheng"><b></b>已完成</a>
														</li>
														<li value="-1"><a href="#none"
															clstag="click|keycount|orderlist|yiquxiao"><b></b>已取消</a>
														</li>
													</ul>
												</div>
											</div>
										</th>
										<th style="width: 124px;">操作</th>
									</tr>





	<!-- 订单循环 begin-->
	
	<!-- 订单order外层循环 -->
	</thead>
	<c:forEach items="${listMyOrder6 }" var="OrderQueryView">
	<tbody id="tb-77139875356">
		<tr class="sep-row">
			<td colspan="5"></td>
		</tr>
		<tr class="tr-th">
			<td colspan="5"><span class="gap"></span> <span
				class="dealtime" title="${OrderQueryView.order_date }">${OrderQueryView.order_date }</span> <input type="hidden" id="datasubmit-77139875356"
				value="2018-08-06 08:59:47"> <span class="number">
					订单号： <a name="orderIdLinks" id="idUrl77139875356"
					target="_blank"
					href="//details.jd.com/normal/item.action?orderid=77139875356&amp;PassKey=C45D71567A9C37B02838054A3585FE59"
					clstag="click|keycount|orderinfo|order_num">${OrderQueryView.order_code }</a>
			</span>
				<div class="tr-operate">
					<span class="order-shop"> <span class="shop-txt">京东</span>
						<a class="btn-im btn-im-jd" href="#none" title="联系客服"
						clstag="click|keycount|orderlist|ziyingchatim"></a>
					</span> <a href="#none"
						clstag="click|keycount|orderlist|dingdanshanchu"
						class="order-del" _orderid="77139875356"
						_passkey="34B3B5F0DF3C5A51B50C085F0DBD5623" title="删除"
						style="display: none;"></a>
				</div></td>
		</tr>
		
		
		
		<!-- 订单orderDetail内层循环 -->
		<c:forEach items="${OrderQueryView.listMyOrder}" var="MyOrderQueryView">
		
		<tr class="tr-bd" id="track77139875356" oty="0,4,70">
			<td>
				<div class="goods-item p-1759428">
					<div class="p-img">
						<a href="//item.jd.com/1759428.html"
							clstag="click|keycount|orderinfo|order_product"
							target="_blank"> <img class="" src="${MyOrderQueryView.product_sku_img_small }"
							title=""
							data-lazy-img="done" width="60" height="60">
						</a>
					</div>
					<div class="p-msg">
						<div class="p-name" style="width: 240px;">
							<a href="//item.jd.com/1759428.html" class="a-link"
								clstag="click|keycount|orderinfo|order_product"
								target="_blank"
								title="">${MyOrderQueryView.product_name  }</a>
						</div>
						<div class="p-extra">
							<ul class="o-info">
								<li><span class="o-similar J-o-similar"
									data-sku="1759428"><i></i><em>相似商品</em></span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="goods-number">x${MyOrderQueryView.order_detail_amount }</div>
				<div class="goods-repair"></div>
				<div class="clr"></div>
			</td>
			<td rowspan="1">
				<div class="consignee tooltip">
					<span class="txt">${MyOrderQueryView.address_consignee }</span><b></b>
					<div class="prompt-01 prompt-02" style="display: none;">
						<div class="pc">
							<strong>${MyOrderQueryView.address_consignee }</strong>
							<p>福建厦门市集美区杏林镇软件园三期D03公寓楼</p>
							<p>159****9997</p>
						</div>
						<div class="p-arrow p-arrow-left"></div>
					</div>
				</div>
			</td>
			<td rowspan="1">
				<div class="amount">
					<span>总额 ¥${MyOrderQueryView.product_sku_realPrice*MyOrderQueryView.order_detail_amount }</span> <br> <span class="ftx-13">在线支付</span>
				</div>
			</td>
			<td rowspan="1">
				<div class="status">
					<span class="order-status ftx-03"> ${MyOrderQueryView.dataDictonary_detail_label } </span> <br> <a
						href="OrderDetailFrontServlet.do?method=list&&orderDetailId=${MyOrderQueryView.order_detail_id }
						&&orderId=${MyOrderQueryView.order_id }"
						clstag="click|keycount|orderlist|dingdanxiangqing"
						target="_blank">订单详情</a>
				</div>
			</td>
			<td rowspan="1" id="operate77139875356">
				<div class="operate">
					<div id="pay-button-77139875356" _baina="0"></div>
					<a
						href="//cart.jd.com/reBuyForOrderCenter.action?wids=1759428&amp;nums=1&amp;rid=1533886085400"
						class="btn-again btn-again-show" target="_blank"
						clstag="click|keycount|orderlist|buy"><b></b> 立即购买 </a><br>
				</div>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</c:forEach>
	
	
	
	
	
	<!-- 订单详情end -->
	
								
							</table>
						</div>
					</div>
					<div class="mb20" id="shareRecDemo">
						<div id="shareRecSpec">
							<div class="share-rec-main">
								<div class="share-rec-show">
									<div class="share-rec-cont">
										<div class="share-rec-list clearfix share-rec-list-ablm">
											<div class="sr-tit">
												<h3>买什么</h3>
												<a href="//what.jd.com" target="_blank">查看更多商品专辑</a>
											</div>
											<div class="share-rec-item"
												clstag="pageclick|keycount|msn_201707269|1">
												<div class="item-inner" id="507449">
													<div class="ab-name">
														<a
															href="//what.jd.com/album/details?albumId=507449&amp;st=00"
															target="_blank">好用不卡高性价比的手机推荐</a>
													</div>
													<div class="ab-info">
														<a
															href="//what.jd.com/album/details?albumId=507449&amp;st=00"
															target="_blank" class="ab-creator"><em>素闻陌上花开</em></a>
													</div>
													<div class="ab-goods">
														<div class="ab-goods-cover">
															<a target="_blank"
																href="//what.jd.com/album/details?albumId=507449&amp;st=00"
																title=""><img width="155" height="155"
																src="img/5b1f852dNaae9779e.jpg"></a>
														</div>
														<div class="ab-goods-list">
															<div class="ab-goods-ul">
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=507449&amp;st=00"><img
																		width="50" height="50" src="img/5b2b6212N106d8382.png"></a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=507449&amp;st=00"><img
																		width="50" height="50" src="img/5b21f467N4f4ed4d1.png"></a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank"
																		href="//what.jd.com/album/details?albumId=507449&amp;st=00"
																		class="goods-num">98</a>
																</div>
															</div>
														</div>
													</div>
													<div class="ab-operate-info">
														<div class="ab-operate">
															<a href="#none" class="btn-follow"><i class="btnico"></i>关注<em
																class="btntxt">869</em></a>
															<div class="ab-operate-gap"></div>
															<a href="#none" class="btn-like"><i class="btnico"></i>赞<em
																class="btntxt">1148</em></a>
														</div>
													</div>
												</div>
											</div>
											<div class="share-rec-item"
												clstag="pageclick|keycount|msn_201707269|1">
												<div class="item-inner" id="509164">
													<div class="ab-name">
														<a
															href="//what.jd.com/album/details?albumId=509164&amp;st=00"
															target="_blank">厨房小工具</a>
													</div>
													<div class="ab-info">
														<a
															href="//what.jd.com/album/details?albumId=509164&amp;st=00"
															target="_blank" class="ab-creator"><em>大海全都是水啊</em></a>
													</div>
													<div class="ab-goods">
														<div class="ab-goods-cover">
															<a target="_blank"
																href="//what.jd.com/album/details?albumId=509164&amp;st=00"
																title=""> <img width="155" height="155"
																src="img/550161edN596cc322.png"></a>
														</div>
														<div class="ab-goods-list">
															<div class="ab-goods-ul">
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=509164&amp;st=00"><img
																		width="50" height="50" src="img/5a223fc0N09e4bb48.png"></a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=509164&amp;st=00"><img
																		width="50" height="50" src="img/5a0e8c6dNd2955313.png"></a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank"
																		href="//what.jd.com/album/details?albumId=509164&amp;st=00"
																		class="goods-num">100</a>
																</div>
															</div>
														</div>
													</div>
													<div class="ab-operate-info">
														<div class="ab-operate">
															<a href="#none" class="btn-follow"><i class="btnico"></i>关注<em
																class="btntxt">673</em></a>
															<div class="ab-operate-gap"></div>
															<a href="#none" class="btn-like"><i class="btnico"></i>赞<em
																class="btntxt">674</em></a>
														</div>
													</div>
												</div>
											</div>
											<div class="share-rec-item"
												clstag="pageclick|keycount|msn_201707269|1">
												<div class="item-inner" id="555676">
													<div class="ab-name">
														<a
															href="//what.jd.com/album/details?albumId=555676&amp;st=00"
															target="_blank">夏天，需要囤积的降温甜品。</a>
													</div>
													<div class="ab-info">
														<a
															href="//what.jd.com/album/details?albumId=555676&amp;st=00"
															target="_blank" class="ab-creator"><em>不入魔不成仙</em></a>
													</div>
													<div class="ab-goods">
														<div class="ab-goods-cover">
															<a target="_blank"
																href="//what.jd.com/album/details?albumId=555676&amp;st=00"
																title=""> <img width="155" height="155"
																src="img/59a7e9f9Ne45cdb5f.png"></a>
														</div>
														<div class="ab-goods-list">
															<div class="ab-goods-ul">
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=555676&amp;st=00">
																		<img width="50" height="50"
																		src="img/5aa7c484N981cd3c7.png">
																	</a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=555676&amp;st=00">
																		<img width="50" height="50"
																		src="img/5abb3088Na2edfce6.png">
																	</a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank"
																		href="//what.jd.com/album/details?albumId=555676&amp;st=00"
																		class="goods-num">45</a>
																</div>
															</div>
														</div>
													</div>
													<div class="ab-operate-info">
														<div class="ab-operate">
															<a href="#none" class="btn-follow"><i class="btnico"></i>关注<em
																class="btntxt">119</em></a>
															<div class="ab-operate-gap"></div>
															<a href="#none" class="btn-like"><i class="btnico"></i>赞<em
																class="btntxt">137</em></a>
														</div>
													</div>
												</div>
											</div>
											<div class="share-rec-item"
												clstag="pageclick|keycount|msn_201707269|1">
												<div class="item-inner" id="520356">
													<div class="ab-name">
														<a
															href="//what.jd.com/album/details?albumId=520356&amp;st=08"
															target="_blank">如何带着妹子吃鸡</a>
													</div>
													<div class="ab-info">
														<a
															href="//what.jd.com/album/details?albumId=520356&amp;st=08"
															target="_blank" class="ab-creator"><em>素闻陌上花开</em></a>
													</div>
													<div class="ab-goods">
														<div class="ab-goods-cover">
															<a target="_blank"
																href="//what.jd.com/album/details?albumId=520356&amp;st=08"
																title=""> <img width="155" height="155"
																src="img/5b0b7f01N538765c3.png"></a>
														</div>
														<div class="ab-goods-list">
															<div class="ab-goods-ul">
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=520356&amp;st=08"><img
																		width="50" height="50" src="img/5b589a1dN48c2cfce.png"></a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank" title=""
																		href="//what.jd.com/album/details?albumId=520356&amp;st=08">
																		<img width="50" height="50"
																		src="img/5b69c16aN30eb2025.png">
																	</a>
																</div>
																<div class="ab-goods-item">
																	<a target="_blank"
																		href="//what.jd.com/album/details?albumId=520356&amp;st=08"
																		class="goods-num">97</a>
																</div>
															</div>
														</div>
													</div>
													<div class="ab-operate-info">
														<div class="ab-operate">
															<a href="#none" class="btn-follow"><i class="btnico"></i>关注<em
																class="btntxt">342</em></a>
															<div class="ab-operate-gap"></div>
															<a href="#none" class="btn-like"><i class="btnico"></i>赞<em
																class="btntxt">454</em></a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="mod-main">
						<div id="miaozhen10772" style="margin-bottom: 10px;">
							<div>
								<a
									href="//c-nfa.jd.com/adclick?keyStr=z5AXFoIimt1jiDK32+w4mQv4TU5TijzaLZYG38XV9sSSlwdB4HmUAgzG9YlyW+d2xmuN2Yqg0LeqPJ8rxNimOXD6/ILl6bm4cF35xJyaxkhkm3+x2TG8MswgjF5hZkBI9U5XY8j9PvzCHR2NHSeMSX0njotqR1wG3NdXinlSK+qZVo2/i5rDOgiFtUfkNugJbibMh5yC+XiZiRcK3AkGlILWr7X23dmMAsIgRQDtYH7z/pYqcD5JncDEQhYimiAiuGbGHZjcBT1dStWcljQNFpo2VhHqrzj2E/TpshW8wCta6IdJUjTIKRmwwUsyK5FSXBkiAmE1DZB8/5KAXvjI8RausD0bACfw85n5q2vUCAI=&amp;cv=2.0&amp;url=https://sale.jd.com/act/EI0sBulHtDhjd.html?zhongchousc&amp;jdpcshoujiao"
									target="_blank"><img width="1069" height="100" alt=""
									app="image:poster" src="img/5b6a9684Nf7f7d5de.png"></a>
							</div>
						</div>
						<div id="orderAdids">
							<div id="sspid1246"
								style="width: 1069px; overflow: hidden; margin: 0px auto;">
								<img
									src="//im-x.jd.com/dsp/np?log=pcuV1Qf4WRQTDwaWAY3aoBTpSGr2N6fIjFShk6r2e-JBTT7N7CpUsx0gjdg544bIf0MCE4v3D2jHKVDG_3J50PcGdlta5uduF7h6i4IsboPKRA5A0rZuAe4FEQTFHviMCCYGaeBlU1XB4bbXmnDYQRahYIx_I8O0npe-wC3WD4mdO0miBa6j9fkvIVt7zFhaJmTUh5rpIupQBxO3or-e8a3itGjsh6DtLCZvVnoXMxJPaJf32GfEaBLP_nhMBfRsxewfG3lN_Xu1QeNllWCEO_TPy2y7BaxoUHN8alklRBc_IgAybwZrwD5gAJkU0mEiO3Mq3UDI0qiFMe4HqN6-cJKiJlMarJep4WGWL2MiiXY_g8bhfn01eyYKeyvRDsDJaj4tFlKoMtpHjxp9zp-x4Y1oQGcrJFGwJ3WdqpJRU3vJe3APEBsgV9YktF1idQC1bHVImotfl9kaiibxLFrMLXH7GpMe2iMcq758SMox-Qa4sBuO3_rypes1k6etElDt&amp;v=404"
									style="display: none"><a
									href="http://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9zYWxlLmpkLmNvbS9hY3QvemdvcEM2ck53UUJKLmh0bWw&amp;log=pcuV1Qf4WRQTDwaWAY3aoBTpSGr2N6fIjFShk6r2e-JBTT7N7CpUsx0gjdg544bIf0MCE4v3D2jHKVDG_3J50PcGdlta5uduF7h6i4IsboPKRA5A0rZuAe4FEQTFHviMCCYGaeBlU1XB4bbXmnDYQRahYIx_I8O0npe-wC3WD4mdO0miBa6j9fkvIVt7zFhaJmTUh5rpIupQBxO3or-e8Ybh_vkFWPc-2u6aU6Jr6GFV3d3w0Bci8KK13m1nW6I6g1L89rKqMbPp0KgXDFa21gDjlvke4Al4h7ywMD4XXNfV9zHK5GubbT_bi0y-ojyp6jtIRk4NWIJj-6_heQU-FjIGJFwq7qGArb7SGUUfcCO1YOrCPyHXbCctGlpJ7Lge-xRYnJJP5Ou3ScoBB4Fd7f27l4tP9NWhIYj9CAPkpL3CQVx5H1Z_sQO5F9XrJRAk&amp;v=404"
									target="_blank"><img src="img/5b6a9684Nf7f7d5df.png"
									width="1069" height="100"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>