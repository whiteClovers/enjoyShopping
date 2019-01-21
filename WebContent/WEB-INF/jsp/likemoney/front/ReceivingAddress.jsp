<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
<!-- 		<link rel="stylesheet" type="text/css" href="css/common.css"/> -->
<!-- 		<link rel="stylesheet" type="text/css" href="css/self.css"/> -->
<!-- 		<link rel="stylesheet" type="text/css" href="css/iconfont.css"> -->
<!-- 		<link rel="stylesheet" type="text/css" href="css/lwh.css"> -->
<!-- 		<link rel="stylesheet" type="text/css" href="css/common.css"/> -->
<!-- 		<link rel="stylesheet" type="text/css" href="css/wddd233.css" /> -->
<!-- 		<link rel="stylesheet" type="text/css" href="css/foot.css" /> -->
<!-- 		<link rel="stylesheet" type="text/css" href="css/shouhuodizhi.css"/> -->
		<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
         <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/> 
         <link href="${pageContext.request.contextPath}/css/self.css" rel="stylesheet" type="text/css"/> 
         <link href="${pageContext.request.contextPath}/css/iconfont.css" rel="stylesheet" type="text/css"/> 
         <link href="${pageContext.request.contextPath}/css/lwh.css" rel="stylesheet" type="text/css"/> 
         <link href="${pageContext.request.contextPath}/css/wddd233.css" rel="stylesheet" type="text/css"/> 
         <link href="${pageContext.request.contextPath}/css/foot.css" rel="stylesheet" type="text/css"/> 
         <link href="${pageContext.request.contextPath}/css/shouhuodizhi.css" rel="stylesheet" type="text/css"/> 

	</head>
	<body>
		<div id="top">
			<div class="top_nav clearfix"><!--顶部导航条-->
		    	<ul class="top_ul_left clearfix">
		    		<li id="top_nav_home_id"><i class="top_nav_home">&#xe608;</i><a href="xx" target="_blank">京东首页</a></li>
		    		<li class="top_nav_position" id="top_nav_position_id">北京</li><!--定位-->
		    	</ul>
		    	<ul class="top_ul_right clearfix">
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
					<li class="spacer">|</li><!--导航栏的竖线-->
					
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
					
					<li class="buy"   id="buy_id">
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
					 <div class="wddd_logo1"><a href="home.jd.com/" target="_self">我的京东</div>
					 <div class="wddd_logo2"><a href="www.jd.com/" target="_blank">返回京东首页</a></div>
				</div>
				<div class="wddd_logo3"><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">首页</a></div>
				<div class="wddd_logo3">账户设置</div>
				<div class="wddd_logo3">社区</div>
				<div class="wddd_logo3"><a href="http://joycenter.jd.com/msgCenter/queryMessage.action">信息</a></div>
				<div>
	                <input type="text" style="width: 170px;height: 21px;margin-left: 100px;margin-top: 25px;">
	             </div>
	             <div style="margin-top: 25px;"><button class=" button_width_height"/>搜索</button></div>
				<div style="margin-left: 50px;margin-top: 25px;background-color: #ffffff;">
					<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
					我的购物车
					</a>
				</div>
			</div>
		</div>
		<div class="background2">
			<div  class="div_wrap_1 clearfix" >
				<div class="left_nav" style="float: left;">				
					<div class="m_top30 m_top10">
						<div class="jiacu">设置</div>
						<div><a href="xx">个人信息</a></div>
						<div><a href="xx">账户安全</a></div>
						<div><a href="xx">我的尺码</a></div>
						<div><a href="xx">账号绑定</a></div>
						<div><a href="xx">收货地址</a></div>
						<div><a href="xx">健康档案</a></div>
						<div><a href="xx">分享绑定</a></div>
						<div><a href="xx">邮件订阅</a></div>
						<div><a href="xx">应用授权</a></div>
						<div><a href="xx">快捷支付</a></div>
						<div><a href="xx">增票资质</a></div>
						<div><a href="xx">企业发票</a></div>
						<div><a href="xx">采购需求单</a></div>
					</div>
					<div class="m_top30"><img src="img/黄渤.jpg"/></div>
				</div>
				<!-- 得到地址数量 -->
				<c:forEach items="${listView }" var="list">
						<c:set var="num" value="${fn:length(list.userCustomers)}" scope="page"/>
				</c:forEach>
				<div class="dizhi_color"><!-- 具体的地址信息-->
					<div class="dizhi_main">
						<div class="dizhi_xinzeng"><!--还能添加几个地址-->
							<a class="dizhi_size">新增收货地址</a>
							<span>您已创建<span class="dizhi_span">${num}</span>个收货地址，最多可创建<span class="dizhi_span">20</span>个</span>
						</div>
						<c:forEach items="${listView }" var="list">
						<%-- <c:set var="num" value="${fn:length(list.userCustomers)}" scope="page"/> --%>
						<c:forEach items="${list.userCustomers }" var="listView">
			<!-- 开始 --> <div class="dizhi_div2">
							<div class="clearfix"><!--名称省份-->
								<h3 style="float: left;">
									${listView.addressConsignee}&nbsp;&nbsp;${listView.addressRegion}
									<a href="xx"><i class="iconfont icon-suo" style="font-size: 15px;margin: 0 10px 0 10px;"></i></a>
									<!-- <span><a href="xx"></a></span>是否是默认地址 -->
									<c:if test="${listView.addressDefault=='1' }"><span>默认地址</span></c:if>   
								    <span class="yijiangou">一键购</span>
								</h3>
								<div style="float: right;">
									<a href="xx"><i class="iconfont icon-cuowu" style="font-size: 15px;"></i></a>
								</div>
							</div>
							<div class="float clearfix" style="padding: 10px;">
								<div class="dizhi_left"><!--左边-->
									<div class="clearfix float">
										<span>收货人：</span>
										<div>${listView.addressConsignee}</div>
									</div>
									<div class="clearfix float">
										<span>所在地区：</span>
										<div>${listView.addressRegion}</div>
									</div>
									<div class="clearfix float">
										<span>地址：</span>
										<div>${listView.addressName}</div>
									</div>
									<div class="clearfix float">
										<span>手机：</span>
										<div>${listView.addressPhone}</div>
									</div>
									<div class="clearfix float">
										<span>固定电话：</span>
										<div>${listView.addressPhone}</div>
									</div>
									<div class="clearfix float">
										<span>电子邮件：</span>
										<div>${listView.addressEmail}</div>
									</div>
								</div>
								<div class="dizhi_left" style="margin-left: 60px;"><!--右边-->
									<div class="clearfix float">
										<span>支付方式：</span>
										<div>在线支付</div>
									</div>
									<div class="clearfix float">
										<span>配送方式：</span>
										<div>
											<div>京配区域内由京东快递配送</div>
											<div>京配区域外由第三方快递配送</div>
										</div>
									</div>
									<div class="dizhi_default"><!--设置默认地址-->
										<a href="xx" class="dizhi_a">设为默认</a>
										<a href="xx" class="dizhi_a">编辑</a>
									</div>
								</div>
							</div>
			<!-- 结束 --> </div>
						</c:forEach>
						</c:forEach>
						
						
						<div class="dizhi_xinzeng"><!--还能添加几个地址-->
							<a class="dizhi_size">新增收货地址</a>
							<span>您已创建<span class="dizhi_span">${num}</span> 个收货地址，最多可创建<span class="dizhi_span">20</span>个</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<div id="buttom">
			<div class="dkhs" style="margin: 0;">
				<img src="img/多快好省.jpg" />
			</div>
			<div id="buttom_lianjie">
				<div class="wrap clearfix">
					<dl class="fore1">
						<dt class="fore_dt">购物指南</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-29.html">购物流程</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-151.html">会员介绍</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-297.html">生活旅行/团购</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue.html">常见问题</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-136.html">大家电</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/index.html">联系客服</a></dd>
					</dl>
					<dl class="fore2">		
						<dt class="fore_dt">配送方式</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-81-100.html">上门自提</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-81.html">211限时达</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/103-983.html">配送服务查询</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/109-188.html">配送费收取标准</a></dd>				
						<dd><a target="_blank" href="//help.joybuy.com/help/question-list-201.html">海外配送</a></dd>
					</dl>
					<dl class="fore3">
						<dt class="fore_dt">支付方式</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-172.html">货到付款</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-173.html">在线支付</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-176.html">分期付款</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-174.html">邮局汇款</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-175.html">公司转账</a></dd>
					</dl>
					<dl class="fore4">		
						<dt class="fore_dt">售后服务</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/321-981.html">售后政策</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-132.html">价格保护</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/130-978.html">退款说明</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//myjd.jd.com/repair/repairs.action">返修/退换货</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-50.html">取消订单</a></dd>
					</dl>
					<dl class="fore5">
						<dt class="fore_dt">特色服务</dt>	
						<dd><a target="_blank" href="//help.jd.com/user/issue/list-133.html">夺宝岛</a></dd>
						<dd><a target="_blank" href="//help.jd.com/user/issue/list-134.html">DIY装机</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//fuwu.jd.com/">延保服务</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//o.jd.com/market/index.action">京东E卡</a></dd>				
						<dd><a rel="nofollow" target="_blank" href="//mobile.jd.com/">京东通信</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//s.jd.com/">京东JD+</a></dd>
					</dl>
				</div>
				<div id="footer-2017">
					<div class="w">
						<div class="copyright_links">
							<p>
								<a href="//about.jd.com" target="_blank">关于我们</a><span class="copyright_split">|</span>
								<a href="//about.jd.com/contact/" target="_blank">联系我们</a><span class="copyright_split">|</span>
								<a href="//help.jd.com/user/custom.html" target="_blank">联系客服</a><span class="copyright_split">|</span>
								<a href="//vc.jd.com/cooperation.html" target="_blank">合作招商</a><span class="copyright_split">|</span>
								<a href="//helpcenter.jd.com/venderportal/index.html" target="_blank">商家帮助</a><span class="copyright_split">|</span>
								<a href="//jzt.jd.com" target="_blank">营销中心</a><span class="copyright_split">|</span>
								<a href="//app.jd.com/" target="_blank">手机京东</a><span class="copyright_split">|</span>
								<a href="//club.jd.com/links.aspx" target="_blank">友情链接</a><span class="copyright_split">|</span>
								<a href="//media.jd.com/" target="_blank">销售联盟</a><span class="copyright_split">|</span>
								<a href="//club.jd.com/" target="_blank">京东社区</a><span class="copyright_split">|</span>
								<a href="//sale.jd.com/act/FTrWPesiDhXt5M6.html" target="_blank">风险监测</a><span class="copyright_split">|</span>
								<a href="//about.jd.com/privacy/" target="_blank">隐私政策</a><span class="copyright_split">|</span>
								<a href="//gongyi.jd.com" target="_blank">京东公益</a><span class="copyright_split">|</span>
								<a href="//en.jd.com/" target="_blank">English Site</a><span class="copyright_split">|</span>
								<a href="//corporate.jd.com/" target="_blank">Media & IR</a>
							</p>
						</div>
						<div class="copyright_info">
							<p>
								<a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000088" target="_blank">京公网安备 11000002000088号</a><span class="copyright_split">|</span><span>京ICP证070359号</span><span class="copyright_split">|</span>
								<a
								 href="//img14.360buyimg.com/da/jfs/t256/349/769670066/270505/3b03e0bb/53f16c24N7c04d9e9.jpg" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span></p>
							<p><span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span>
								<a href="//sale.jd.com/act/pQua7zovWdJfcIn.html"
								 target="_blank">出版物经营许可证</a><span class="copyright_split">|</span>
								<a href="//misc.360buyimg.com/wz/wlwhjyxkz.jpg" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span></p>
							<p><span class="copyright_text">Copyright&nbsp;&copy;&nbsp;2004&nbsp;-&nbsp;<em id="copyright_year">2018</em>&nbsp;&nbsp;京东JD.com&nbsp;版权所有</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span>
								<a
								 href="//sale.jd.com/act/7Y0Rp81MwQqc.html" target="_blank" class="copyright_license">经营证照</a><span class="copyright_split">|</span><span>(京)网械平台备字(2018)第00003号</span>
							</p>
							<p class="mod_copyright_inter">
								<a class="mod_copyright_inter_lk" href="//www.joybuy.com/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0501"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_global"></i>Global Site</a><span class="copyright_split">|</span>
								<a
								 class="mod_copyright_inter_lk" href="//www.jd.ru/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0502"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_rissia"></i>Сайт России</a><span class="copyright_split">|</span>
									<a
									 class="mod_copyright_inter_lk" href="//www.jd.id/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0503"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_indonesia"></i>Situs Indonesia</a><span class="copyright_split">|</span>
										<a
										 class="mod_copyright_inter_lk" href="//www.joybuy.es/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0503"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_spain"></i>Sitio de España</a>
							</p>
							<p><span>京东旗下网站：</span>
								<a href="https://www.jdpay.com/" target="_blank">京东钱包</a><span class="copyright_split">|</span>
								<a href="http://www.jcloud.com" target="_blank">京东云</a>
							</p>
						</div>
						<p class="copyright_auth">
							<a class="copyright_auth_ico copyright_auth_ico_1" href="http://www.hd315.gov.cn/beian/view.asp?bianhao=010202007080200026"
							 target="_blank">经营性网站备案中心</a>
							<script type="text/JavaScript">function CNNIC_change(eleId){var str= document.getElementById(eleId).href;var str1 =str.substring(0,(str.length-6));str1+=CNNIC_RndNum(6);
								document.getElementById(eleId).href=str1;}function CNNIC_RndNum(k){var rnd=""; for (var i=0;i
								< k;i++) rnd+=Math.floor(Math.random()*10);
								 return rnd;};(function(){var d=new Date;document.getElementById( "copyright_year").innerHTML=d.getFullYear()})();</script>
									<a id="urlknet" class="copyright_auth_ico copyright_auth_ico_2" onclick="CNNIC_change('urlknet')" oncontextmenu="return false;"
									 name="CNNIC_seal" href="https://ss.knet.cn/verifyseal.dll?sn=2008070300100000031&ct=df&pa=294005" target="_blank">可信网站信用评估</a>
									<a class="copyright_auth_ico copyright_auth_ico_3" href="http://www.cyberpolice.cn/" target="_blank">网络警察提醒你</a>
									<a class="copyright_auth_ico copyright_auth_ico_4" href="https://search.szfw.org/cert/l/CX20120111001803001836"
									 target="_blank">诚信网站</a>
									<a class="copyright_auth_ico copyright_auth_ico_5" href="http://www.12377.cn" target="_blank">中国互联网举报中心</a>
									<a class="copyright_auth_ico copyright_auth_ico_6" href="http://www.12377.cn/node_548446.htm" target="_blank">网络举报APP下载</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
