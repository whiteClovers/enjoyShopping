<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>我的信息</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/self.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/iconfont.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lwh.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wddd233.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shouhuodizhi.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/myDetail.css"/>
	</head>
	
	<body>
		<div id="top">
			<div class="top_nav clearfix"><!--顶部导航条-->
		    	<ul class="top_ul_left clearfix">
		    		<li id="top_nav_home_id"><i class="top_nav_home">&#xe608;</i><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">京东首页</a></li>
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
					 <div class="wddd_logo1"><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_self">我的京东</div>
					 <div class="wddd_logo2"><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">返回京东首页</a></div>
				</div>
				<div class="wddd_logo3"><a href="home.jd.com/" target="_self">首页</a></div>
				<div class="wddd_logo3">账户设置</div>
				<div class="wddd_logo3">社区</div>
				<div class="wddd_logo3"><a href="http://joycenter.jd.com/msgCenter/queryMessage.action">信息</a></div>
				<div>
	                <input type="text" style="width: 170px;height: 21px;margin-left: 100px;margin-top: 25px;">
	             </div>
	             <div style="margin-top: 25px;"><button class=" button_width_height"/>搜索</button></div>
				<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
					我的购物车
					</a>
			</div>
		</div>
		<div class="background2">
			<div  class="div_wrap_1 clearfix" >
				<div class="left_nav">				
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
				</div>
				<div class="info"><!--基本信息-->
					<div class="info_color">
						<div class="info_1 clearfix">
							<ul class="clearfix">
								<li><a href="xx" class="info_a1">基本信息</a></li>
								<li><a href="xx">头像照片</a></li>
								<li><a href="xx">更多个人信息</a></li>
							</ul>
						</div>
						<div class="clearfix"><!--第二行-->
							<div class="info_div1 info_from"><!--个人信息-->
								<div class="clearfix info_item">
									<span>用户名：</span>
									<div>
										<strong>${user.customerName }</strong>
									</div>
								</div>
								<div class="clearfix info_item">
									<span><em>*</em>登录名：</span>
									<div>
										<strong>${user.customerName }</strong>
										<a href="xx" class="info_a2">修改</a>
										<div style="display: inline;">可用于登录，请牢记哦~</div>
									</div>
								</div>
								<div class="clearfix info_item">
									<span><em>*</em>昵称：</span>
									<div>
										<input type="text" class="info_itxt" value="${user.customerNickName }" name="customerName"/>
									</div>
								</div>
								<div class="clearfix info_item">
									<span>性别：</span>
									<div>
										<input type="radio" name="sex" id="" value="0" <c:if test="${'0'== user.customerSex}">checked="checked"</c:if> />
										<label class="info_label">男</label>
										<input type="radio" name="sex" id="" value="1" <c:if test="${'1'== user.customerSex}">checked="checked"</c:if> />
										<label class="info_label">女</label>
										<input type="radio" name="sex" id="" value="2" <c:if test="${'2'== user.customerSex}">checked="checked"</c:if> />
										<label class="info_label">保密</label>
									</div>
								</div>
								<div class="clearfix info_item">
									<span>生日：</span>
									<div>
										<select name="year" class="info_selt info_selt1" id="birthdayYear">
											<c:forEach var="year" begin="1940" end="2100" step="1"  >
												<option value="${year}" <c:if test="${year==years}">selected="selected"</c:if> >${year}</option>
											</c:forEach>
										</select>
										<label class="info_label">年</label>
										<select name="month" class="info_selt info_selt1" id="birthdayMonth">
											<c:forEach var="month" begin="1" end="12" step="1" >
												<option value="${month}" <c:if test="${month==months}">selected="selected"</c:if>>${month}</option>
											</c:forEach>
										</select>
										<label class="info_label">月</label>
										<select name="date" class="info_selt info_selt1" id="birthdayDay">
											<c:forEach var="date" begin="1" end="31" step="1" >
												<option value="${date}"  <c:if test="${date==dates}">selected="selected"</c:if> >${date}</option>
											</c:forEach>
										</select>
										<label class="info_label">日</label>
										<div style="display: inline;">填生日有惊喜哦~</div>
									</div>
								</div>
								<div class="clearfix info_item">
									<span>兴趣爱好：</span>
									<div class="info_div3">
										<i>请选择您感兴趣的分类，给您最精准的推荐</i>
                                        <ul class="hobul clearfix" clstag="homepage|keycount|home2013|infoInterest">
                                            <li name="hobbyType" class="i-li" value="1">
                                                <div class="li-item">图书音像/电子书刊<s></s></div>
                                            </li>
                                            <li name="hobbyType" class="i-li" value="2">
                                            	<div class="li-item">家用电器<s></s></div>
                                            </li>
                                            <li name="hobbyType" class="i-li" value="3"><div class="li-item">手机/数码<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="4"><div class="li-item">电脑/办公<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="5"><div class="li-item">家居/家具/家装/厨具<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="6"><div class="li-item">服饰内衣/珠宝首饰<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="7"><div class="li-item">个护化妆<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="8"><div class="li-item">鞋靴/箱包/钟表/奢侈品<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="9"><div class="li-item">运动健康<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="10"><div class="li-item">汽车用品<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="11"><div class="li-item">母婴/玩具乐器<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="12"><div class="li-item">食品饮料/保健食品<s></s></div></li>
                                            <li name="hobbyType" class="i-li" value="13"><div class="li-item">彩票/旅行/充值/票务<s></s></div></li>
                                        </ul>
									</div>
								</div>
								<div class="clearfix info_item">
									<span>邮箱：</span>
									<div>
										<a href="xx" class="info_a2">立即验证</a>
									</div>
								</div>
								<div class="info_item clearfix">
									<span>&nbsp;</span>
									<div><input type="button" value="提交" class="info_size"></div>
								</div>
							</div>
							<div class="info_div2"><!--头像-->
								<div id="user_info" class="clearfix">
									<div class="user_info_img"><!--图片-->
										<img src="img/geren.jpg" class="user_info_img1" />
									</div>
									<div class="user_info_div"><!--信用-->
										<div>
											<b>用户名：${user.customerName }</b>
										</div>
										<div style="color: red;">
											<i class="iconfont icon-lianjie"></i>
											<a href="xx">京享值552</a>
										</div>
										<div>
											<span>小白信用:<i class="info_a2">71.7</i></span>
										</div>
										<div>
											<span>会员类型：个人用户</span>
										</div>
									</div>
								</div>
							</div>
							
							<div class="info_zhuyi">
								<span>注：修改手机和邮箱请到</span><a href="xx" class="info_a2">账号安全</a>
							</div>
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