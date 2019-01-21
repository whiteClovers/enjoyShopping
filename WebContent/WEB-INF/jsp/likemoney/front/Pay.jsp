<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 		<link rel="stylesheet" href="css/syt.css" /> -->
		<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
         <link href="${pageContext.request.contextPath}//css/syt.css" rel="stylesheet" type="text/css"/> 
<%--          <link href="${path}/css/uploadify.css" rel="stylesheet" type="text/css"/>  --%>
		<title></title>
	</head>
	<body>
		<div class="shortcut">
			<div class="w">
				<a class="s-logo" href="" target="_blank" psa="PCashier_jd">
					<img width="170" height="28" alt="京东 收银台" src="${pageContext.request.contextPath}/img/jd-logo.png">
				</a>
				<ul class="s-right">
					<li class="s-item fore1">
						<!-- <a href="#" target="_blank" class="link-user">xxxxxxxx</a> -->
							<li class="topright">
								<a href="${pageContext.request.contextPath}/LoginServlet.do">
								你好，${sessionScope.session_customer.customerNickName }
								</a>&nbsp;&nbsp;
							</li>
					</li>
					<li class="s-div">|</li>
					<li class="s-item fore2" psa="PCashier_myOrder">
						<a class="op-i-ext" href="${pageContext.request.contextPath}/user/MyOrderServerlet.do" target="_blank">我的订单</a>
					</li>
					<li class="s-div">|</li>
					<li class="s-item fore3" psa="PCashier_help">
						<a class="op-i-ext" target="_blank" href="">支付帮助</a>
					</li>
					<span class="clr"></span>
				</ul>
			</div>
		</div>
		<div class="main main-bg">
			<div class="w">
				<div class="order clearfix">
					<div class="o-qrcode o-qrcode-enhance">
						<a class="oq-img" >
							<img src="img/getQrCodeImage.jpg" alt="">
							<i></i>
						</a>
					</div>
					<div id="qrCouponTips" class="o-couponTips hide"><p></p></div>
						
					<!-- 订单信息 -->
					<div class="o-left">
						<h3 class="o-title">订单提交成功，请尽快付款！订单号：xxxxxxxx</h3>
						<p class="o-tips">
							<span class="o-tips-qrcode">
								推荐使用
								<a href="" class="o-tips-app-jd" ></a>
								<a href="" class="o-tips-app-jdjr"></a>
								扫码支付
                			</span>
		                	<span class="o-tips-div">|</span>
		                	<span class="o-tips-time" >
		                		    请您在<span class="font-red">24小时</span>内完成支付，否则订单会被自动取消(库存紧俏订单请参见详情页时限)
		 
		                	</span>
						</p>
					</div>
						
					<!-- 订单信息 end --><!-- 订单金额 -->
					<div class="o-right">
						<div class="o-price">
							<em>应付金额</em>
							<strong>${sessionScope.priceSumS }</strong><em>元</em>
						</div>
						<div class="o-detail">
						<a href="${pageContext.request.contextPath}/user/OrderDetailFrontServlet.do">订单详情<i></i></a>
						</div>
					</div>
						
					<!-- 订单金额 end -->
					<div class="o-list j_orderList" id="listPayOrderInfo">
						
					<!-- 单笔订单 --><!-- 多笔订单 end -->
					</div>
				</div>
				<div class="payment pay-load" id="payChannelListId">
					
				<!--京东支付图标-->
				<div class="jp-logo-wrap"><span class="jp-logo"></span></div>
					
				<!--京东支付图标 end-->
					
				<!--收银台公告-->
				<div class="jp-notice" style="background:none;">
					<div class="jn-wrap"><ul class="jn-list"></ul></div>
					<div class="jp-tips"><img src="img/ddlj.png"></div>
				</div>
					
				<!--收银台公告 end-->
					
				<!-- 收银台加载loading -->
				<div id="payChanel" class="pay-channel animate-enter animate-enter-active" avalon-events="">
					<div class="paybox paybox-baitiao paybox-selected" change-class="paybox-selected">
						<div class="p-wrap">
							<i class="p-border"></i>
							<div class="p-key">
								
							<!-- 支付方式选择 -->
							<span class="p-k-check ui-checkbox-wrap" psa="PCashier_bt" change-class="" avalon-events="click:eclick_0_64checkToggle">
								<i class="ui-checkbox-L"><em change-class="selected" class="selected"></em></i>
								<i class="p-k-icon"><img src="img/BAITIAO_2.0.png"></i>
								<strong>打白条</strong>
							</span>
							</div>
							<div class="p-value">
								
							<!--if-->
								
							<!--if-->
							<div class="p-v-line baitiao-balance">
								
							<!-- 普通可用额度 -->可用额度&nbsp;&nbsp;2700.00元<!-- 普通可用额度 end -->
							<span class="p-div">|</span>白条还款日&nbsp;2018-08-12
							<span class="p-div">|</span>
							<span class="bb-coupo" >
								<i class="bb-coupo-icon">优惠</i>
								<em class="bb-coupo-text"><b>立减7元</b><i>&gt;</i></em>
							</span>
							</div>
								
							<!-- 白条分期选择区 new -->
							<div class="baitiao-choose" style="">
								<div class="payment-list">
									<ul class="pl-wrap">
										<li class="pl-item"  change-class="pl-item  " >
											<span class="pl-i-text">不分期</span>
											<span class="pl-i-fenqi">0服务费</span>
										</li>
										<li class="pl-item"  change-class="pl-item  " >
											<span class="pl-i-text">3期</span>
											<span class="pl-i-fenqi">xxx元/期</span>
											
										</li>
										<li class="pl-item"  change-class="pl-item  " >
											<span class="pl-i-text">6期</span>
											<span class="pl-i-fenqi">xxx元/期</span>
											<i class="pl-i-selected"></i>
										</li>
										<li class="pl-item"  change-class="pl-item" >
											<span class="pl-i-text">12期</span>
											<span class="pl-i-fenqi">xxx/期</span>
											<i class="pl-i-selected">
												
											</i>
										</li>
										<li class="pl-item selected"  change-class="pl-item  selected" >
											<span class="pl-i-text">24期</span>
											<span class="pl-i-fenqi">xxx元/期</span>
											<i class="pl-i-selected"></i>
										</li>
									</ul>
								</div>
								<div class="bc-detail">
									<div class="bc-d-content hide"></div>
										
									<!-- 不分期 end -->
										
									<!-- 3期 -->
									<div class="bc-d-content">
										<span>已选择分<b>24期</b></span>
										<span class="p-div">|</span>
										<span>应还总额<em class="font-red">xxxx</em>元</span>
										<span class="p-div">|</span>
										<span>每期还款xxx元<em class="font-red">（含分期服务费xxxx元)</em></span>
										<span class="p-div">|</span>
										<span>费率1%</span>
									</div>
								</div>
							</div>
								
							<!-- 白条分期选择区 new end -->
							</div>
								
							<!-- 支付金额 -->
							<div class="p-amount">
								<em>支付</em><strong>${sessionScope.priceSumS }</strong><em>元</em>
								<div class="pre-val">已减0.00元</div>
							</div>
								
							<!-- 支付金额 end -->
						</div>
					</div>
					<div class="paybox paybox-xjk" change-class=" ">
						<div class="p-wrap">
							<i class="p-border"></i>
							<div class="p-key">
								
							<!-- 支付方式选择 -->
							<span class="p-k-check ui-checkbox-wrap ui-check-disable"  change-class="ui-check-disable" >
								<i class="ui-checkbox-L"><em change-class=""></em></i>
								<i class="p-k-icon"><img src="img/XJKCONSUME.png"></i>
								<strong>京东小金库</strong>
							</span>
								
							<!-- 支付方式选择 end -->
							</div>
							<div class="p-value">
								<div class="p-v-line xjk-balance">
									<span class="font-gray">未开通小金库</span>
								</div>
									
								<!--if-->
							</div>
							<div class="p-amount">
								<em>支付</em><strong>0</strong><em>元</em>
									
								<!--if-->
							</div>
						</div>
					</div>
					<div class="paybox paybox-bankCard" change-class=" ">
						<div class="p-wrap">
							<i class="p-border"></i>
							<div class="p-key">
								
							<!-- 支付方式选择 -->
							<span class="p-k-check ui-checkbox-wrap"  change-class="" >
								<i class="ui-checkbox-L"><em change-class=""></em></i>
								<i class="p-k-icon"><img src="img/CCB.png"></i>
								<strong>建设银行</strong>
							</span>
								
							<!-- 支付方式选择 end -->
							</div>
							<div class="p-value">
								<div class="p-v-line xjk-balance">
									<span>储蓄卡 (2821)</span>
									<span class="p-div">​</span>
										
									<!--if-->
									<span class="bb-coupo">
										<i class="bb-coupo-icon">优惠</i>
										<em class="bb-coupo-text"><b>单单减最高99元</b><i>&gt;</i></em>
									</span>
								</div>
									
								<!--if-->
							</div>
							<div class="p-amount">
								<em>支付</em><strong>0</strong><em>元</em>
									
								<!--if-->
							</div>
						</div>
					</div>
				</div>
					
				<!-- paybox 添加新卡网银支付 -->
				<div class="paybox-newcard animate-enter animate-enter-active" avalon-events="">
					<a class="pn-more"  style="display: none;">更多付款方式<i></i></a>
					<a class="pn-new"  >添加新卡&nbsp;/&nbsp;网银支付<i></i></a>
				</div>
					
				<!-- paybox 添加新卡网银支付 end -->
					
				<!-- pay-verify 支付验证提交 type-credit type-credit-verify-code -->
				<div class="pay-verify animate-enter animate-enter-active" avalon-events="">
					
				<!--if--><!--if-->
				<div class="pv-line pv-line-shortPwd">
					<div class="pl-s-title">请输入6位数字支付密码</div>
						
					<!-- 需要错误提示 添加 ui-input-error -->
					<span class="ui-shortPwd" avalon-events="keyup:ekeyup_0_64typeEnter">
						<input type="password" class="ui-shortPwd-input"  maxlength="1" ">
						<input type="password" class="ui-shortPwd-input"  maxlength="1" ">
						<input type="password" class="ui-shortPwd-input"  maxlength="1" ">
						<input type="password" class="ui-shortPwd-input"  maxlength="1" ">
						<input type="password" class="ui-shortPwd-input"  maxlength="1" ">
						<input type="password" class="ui-shortPwd-input"  maxlength="1" ">
					</span>
						<a href="" class="ml10" target="_blank" >忘记支付密码？</a>
				</div>
					
				<!-- 支付信息提示 -->
					
				<!--if-->
					
				<!-- 支付信息提示 end -->
					
				<!-- 支付加载 -->
				<div class="pv-button" style="display: none;">
					<input class="ui-button ui-button-XL ui-button-XL-loading" type="submit" value="加载中">
				</div>
				<div class="pv-button">
				<a class="ui-button ui-button-XL"  change-class="ui-button ui-button-XL "
	 					href="${pageContext.request.contextPath}/user/PayServlet.do?method=orderSubmit" target="_blank">
						立即支付
						</a>
					<span class="font-red ml10"></span>
				</div>

				</div>
					
				<!-- pay-verify 支付验证提交 end -->
					
				<!-- 新用户引导 old --><!--if-->
					
				<!-- 新用户引导 old end -->
					
				<!-- 新用户引导 new 营销 -->
					
				<!--if--><!-- 新用户引导 new 营销 end -->
				</div>
			<div class="payment payment-new mt25" id="payMallPlatVm">
				<div class="payment-change">
					<div class="pc-wrap clearfix animate-enter animate-enter-active" avalon-events="">
						<div class="pc-w-left">
							<div class="pay-wrap" id="unionpay"  >
								<a>
									<i class="icon"><img src="img/PAY-UNION.png"></i>
				                                中国银联          
								</a>
							</div>
							<span>|</span>
							<div class="pay-wrap" id="weixin" >
								<a><i class="icon">
									<img src="img/PAY-WEIXIN.png"></i>
				                                微信支付
								</a>
							</div>
							<span>|</span>
							<div class="pay-wrap" id="DAIFU" >
								<a><i class="icon"><img src="img/PAY-DAIFU.png"></i>
				                                找人代付
				                            
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="payPlats"></div>
		</div>
		</div>
		<div class="p-footer">
			<div class="pf-wrap w">
				<div class="pf-line">
					<span class="pf-l-copyright">Copyright © 2004-2018  京东JD.com 版权所有</span>
					<img width="185" height="20" src="img/footer-auth.png">
					<span class="ml40">由网银在线（北京）科技有限公司提供技术支持</span>
				</div>
			</div>
		</div>	
	</body>
</html>