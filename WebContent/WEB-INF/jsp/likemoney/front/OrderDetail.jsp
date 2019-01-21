<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wddd233.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ddxq.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/logistics.css" />

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
					<a href="home.jd.com/" target="_self">我的京东 
				</div>
				<div class="wddd_logo2">
					<a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">返回京东首页</a>
				</div>
			</div>
			<div class="wddd_logo3">
				<a href="home.jd.com/" target="_self">首页</a>
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
			<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
					我的购物车
					</a>
		</div>
	</div>
	<div class="container">
		<div class="emph-wrap">
			<div class="top_navigation">
				<div class="emph-tips">
					<span> 安全提醒：为了您的财产安全，<strong>不要点击陌生链接、不要向陌生人转账</strong>或透漏银行卡和验证码信息，<strong>谨防诈骗！</strong>
					</span>
				</div>
			</div>
		</div>
		<div class="top_navigation">
		
		
		
		
		<c:forEach items="${listOrderDetailFront6 }" var="OrderDetailFrontQueryView">
			<div class="mian">

				<div class="breadcrumb">
					<a href="" class="cl">我的京东</a> <span> &nbsp;>&nbsp; <a
						href="" class="cl">订单中心</a> &nbsp;>&nbsp;<strong>${OrderDetailFrontQueryView.order_code}</strong>
					</span>
				</div>

				<div class="state">
					<div class="state-cont">
						<div class="cont-left">
							<div class="cont-left-top">${OrderDetailFrontQueryView.order_code}</div>
							<h3 class="state-text">${OrderDetailFrontQueryView.dataDictonary_detail_label_receive}</h3>
							<div class="state-btn"></div>
						</div>
						<div class="cont-right">
							<div class="cont-right-top">
								<div class="cont-right-tips">
									订单已经完成，感谢您在京东商城购物，欢迎您对本次交易及所购商品进行评价。</div>
							</div>
							<div class="process clearfix">
								<div class="node process-ready">
									<i class="node-icon icon-start"></i>
									<ul>
										<li class="process-text1">&nbsp;</li>
										<li class="process-text2">提交订单</li>
										<li class="process-text3">${OrderDetailFrontQueryView.order_date}
										</li>
									</ul>
								</div>
								<div class="proce">
									<ul>
										<li class="process-text1"></li>
									</ul>
								</div>
								<div class="node process-ready">
									<i class="node-icon icon-pay"></i>
									<ul>
										<li class="process-text1">&nbsp;</li>
										<li class="process-text2">付款成功</li>
										<li class="process-text3">${OrderDetailFrontQueryView.order_paydate}
										</li>
									</ul>
								</div>
								<div class="proce">
									<ul>
										<li class="process-text1"></li>
									</ul>
								</div>
								<div class="node process-ready">
									<i class="node-icon icon-store"></i>
									<ul>
										<li class="process-text1">&nbsp;</li>
										<li class="process-text2">商品出库</li>
										<li class="process-text3">${OrderDetailFrontQueryView.order_detail_outTime}
										</li>
									</ul>
								</div>
								<div class="proce">
									<ul>
										<li class="process-text1"></li>
									</ul>
								</div>
								<div class="node process-ready">
									<i class="node-icon icon-express"></i>
									<ul>
										<li class="process-text1">&nbsp;</li>
										<li class="process-text2">等待收货</li>
										<li class="process-text3">${OrderDetailFrontQueryView.order_detail_logistics_time}
										</li>
									</ul>
								</div>
								<div class="proce">
									<ul>
										<li class="process-text1"></li>
									</ul>
								</div>
								<div class="node process-ready">
									<i class="node-icon icon-finish"></i>
									<ul>
										<li class="process-text1">&nbsp;</li>
										<li class="process-text2">完成</li>
										<li class="process-text3">${OrderDetailFrontQueryView.order_detail_receive_time}
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class=" logistics-wrap">
					<div class="logistics">

						<div class="logistics-left">
							<div class="l-item clearfix">
								<div class="l-item-img">
									<a href=""> <img src="img/5987d65dN4c0a1e3e.jpg" />
									</a>
								</div>

								<div class="l-item-info">
									<ul>
										<li>送货方式：普通快递</li>
										<li>承运人：京东快递</li>
										<li>货运单号：75779866273</li>
									</ul>
								</div>
							</div>
						</div>

						<div class="logistics-right">
							<div class="logistics-info">
								<ul>
									<li class="first"><i class="logistics-icon"></i> <span
										class="date">2018-05-10/周四</span> <span class="time">16:36:48</span>
										<span class="txt">【南昌市】
											您的订单已签收。感谢您在京东购物，欢迎再次光临。参加评价还能赢取京豆哟。</span></li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">14:24:23</span> <span class="txt">【南昌市】
											您的订单正在配送途中，请您准备签收（配送员：刘亚雄，电话：15180180305），感谢您的耐心等待</span></li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">14:18:45</span> <span class="txt">【南昌市】
											您的订单已到达【南昌白水湖站】</span></li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">08:36:25</span> <span class="txt">您的订单在京东【南昌分拨中心】发货完成，准备送往京东【南昌白水湖站】</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">08:35:55</span> <span class="txt">【南昌市】
											您的订单在京东【南昌分拨中心】分拣完成</span></li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">08:29:09</span> <span class="txt">打包成功</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">08:29:09</span> <span class="txt">扫描员已经扫描</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">07:02:05</span> <span class="txt">您的订单已经拣货完成</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">06:56:58</span> <span class="txt">您的订单已经打印完毕</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">06:02:16</span> <span class="txt">您的订单预计5月10日送达您手中</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">06:02:15</span> <span class="txt">您的订单已经进入京东南昌4号库准备出库</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date"></span>
										<span class="time">00:12:22</span> <span class="txt">您的订单由于送货时间未到不能出库</span>
									</li>
									<li><i class="logistics-icon"></i> <span class="date">2018-05-09/周三</span>
										<span class="time">23:53:53</span> <span class="txt">您提交了订单，请等待系统确认</span>
									</li>
								</ul>
							</div>
						</div>

					</div>
				</div>

				<div class="info-wrap">
					<div class="info">
						<div class="info-body clearfix">

							<div class="info-dl">
								<div class="info-dt">
									<h4>收货人信息</h4>
								</div>
								<div class="info-dd">
									<div class="line clearfix">
										<div class="line-left">收货人:</div>
										<div class="line-right">${OrderDetailFrontQueryView.address_consignee }</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">地址：</div>
										<div class="line-right">${OrderDetailFrontQueryView.address_name }</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">手机号码：</div>
										<div class="line-right">${OrderDetailFrontQueryView.address_phone }</div>
									</div>
								</div>
							</div>



							<div class="info-dl">
								<div class="info-dt">
									<h4>配送信息</h4>
								</div>
								<div class="info-dd">
									<div class="line clearfix">
										<div class="line-left">配送方式：</div>
										<div class="line-right">普通快递</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">运费：</div>
										<div class="line-right">¥0.00</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">期望送货日期：</div>
										<div class="line-right">工作日、双休日与假日均可送货</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">期望配送时间：</div>
										<div class="line-right">15:00-19:00</div>
									</div>
								</div>
							</div>



							<div class="info-dl">
								<div class="info-dt">
									<h4>付款信息</h4>
								</div>
								<div class="info-dd">
									<div class="line clearfix">
										<div class="line-left">付款方式：</div>
										<div class="line-right">在线支付</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">付款时间：</div>
										<div class="line-right">${OrderDetailFrontQueryView.order_paydate}</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">商品总额：</div>
										<div class="line-right">${OrderDetailFrontQueryView.order_sum_money}</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">应支付金额：</div>
										<div class="line-right">${OrderDetailFrontQueryView.order_sum_money}</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">支付优惠：</div>
										<div class="line-right">¥0.03</div>
									</div>
								</div>
							</div>



							<div class="info-dl">
								<div class="info-dt">
									<h4>发票信息</h4>
								</div>
								<div class="info-dd">
									<div class="line clearfix">
										<div class="line-left">发票类型：</div>
										<div class="line-right">普通发票</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">发票抬头：</div>
										<div class="line-right">个人</div>
									</div>
									<div class="line clearfix">
										<div class="line-left">发票内容：</div>
										<div class="line-right">商品明细</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="logistics-goods-wrap">
					<div class="l-g-header">
						<span class="goodsshop-name">京东</span>
						<div class="lxkf">
							<a class="lxke-img">联系客服</a>
						</div>
					</div>
					<div class="l-g-info">
					
					
					
					
					
					<c:forEach items="${OrderDetailFrontQueryView.listMyOrder }" var="MyOrderQueryView">
						<div class="g-info-list">
							<table class="tab">
								<thead>
									<tr>
										<th class="grap"></th>
										<th class="w1">商品</th>
										<th>商品编号</th>
										<th>京东价</th>
										<th>商品数量</th>
										<th>京豆</th>
										<th>操作</th>
										<th class="grap"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="grap"></td>
										<td class="w1">
											<div class="p-item clearfix">
												<div class="p-img">
													<a href=""> <img src="${MyOrderQueryView.product_sku_img_small }" />
													</a>
												</div>
												<div class="p-info">
													<div class="p-name">
														<a href="" class="col">${MyOrderQueryView.product_name}</a>
													</div>
													<div class="clr"></div>
													<div class="p-extra">${MyOrderQueryView.color_name}</div>
												</div>
												<div class="p-recycle">
													<a href="">【服务】换新保2年 小数码 101-200</a>
												</div>
											</div>
										</td>
										<td>${MyOrderQueryView.product_sku_code}</td>
										<td>${MyOrderQueryView.product_sku_realPrice}</td>
										<td>${MyOrderQueryView.order_detail_amount}</td>
										<td>16</td>
										<td>
											<div class="p-btn">
												<a href="" class="col p-btn-1">申请售后</a><br /> <a href=""
													class="col p-btn-2">立即购买</a>
											</div>
										</td>
										<td class="grap"></td>
									</tr>
								</tbody>

							</table>
						</div>
						
						
			</c:forEach>
						
						
						
						
						
						
						<div class="clearfix g-info-total">
							<ul class="">
								<li><span class="label">商品总额：</span> <span
									class="total-txt">${OrderDetailFrontQueryView.order_sum_money}</span></li>
								<li><span class="label">返 现：</span> <span class="total-txt">-¥0.00</span>
								</li>
								<li><span class="label">运 费：</span> <span class="total-txt">¥0.00</span>
								</li>
								<li><span class="label label-cl">运 费：</span> <span
									class="total-txt txt-cl">¥${OrderDetailFrontQueryView.order_sum_money}</span></li>
							</ul>
						</div>
					</div>
				</div>

			</div>
			</c:forEach>
		</div>
	</div>
	<div id="GLOBAL_FOOTER">
		<!--service start-->
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
		<!--service end-->
		<!--footer start-->
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
							class="copyright_split">|</span> <a
							href="//img14.360buyimg.com/da/jfs/t256/349/769670066/270505/3b03e0bb/53f16c24N7c04d9e9.jpg"
							target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span
							class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span>
					</p>
					<p>
						<span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span>
						<a href="" target="_blank">出版物经营许可证</a><span
							class="copyright_split">|</span> <a
							href="//misc.360buyimg.com/wz/wlwhjyxkz.jpg" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span
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
		<!--footer end-->
	</div>
</body>
</html>