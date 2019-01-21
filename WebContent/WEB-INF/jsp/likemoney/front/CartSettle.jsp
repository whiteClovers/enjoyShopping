<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
		<title>京东女装购物车</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lwh.css" />
</head>
<body class="body">
		<div id="top">
			<div class="top_nav clearfix"><!--顶部导航条-->
		    	<ul class="top_ul_left clearfix">
		    		<li id="top_nav_home_id"><i class="top_nav_home">&#xe608;</i><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">京东首页</a></li>
		    		<li class="top_nav_position" id="top_nav_position_id">北京</li><!--定位-->
		    	</ul>
		    	<ul class="top_ul_right clearfix">
					<li class="login" id="login_id">
						<!-- <a href="MyInformServerlet.do">你好，请登录<a>&nbsp;&nbsp;<a href="javascript:regist();" class="link-regist style-red">免费注册</a> -->
					
						<a href="${pageContext.request.contextPath}/LoginServlet.do" >
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

		<div class="all">

			<div class="logo clearfix"><!--京东logo行-->
				<div class="logo_image">
					<a href="xx"><img src="img/京东logo.jpg"></a>
					<a href="xx"><img class="cart" src="img/购物车.jpg"></a>
				</div>
				<div class="logo_input">
						<input class="input_shuru" value="自营">
						<input type="button" class="input_sousuo" value="搜索">
				</div>
			</div>

			<div class="allproduct clearfix"><!--显示全部商品/京东大药房/配送地址-->
				<div class="allproduct_1">
					<a href="xx">
						<span class="allproduct_n">全部商品</span>
						<span id="shuliang">n</span>
					</a>
				</div>
				<div class="allproduct_2">
					<a href="xx">
						<span id="yaofang">京东大药房</span>
					</a>
				</div>
				<div class="allproduct_3">
					<span>配送至：</span>
					<select>
						<option>北京</option>
						<option>上海</option>
						<option>深圳</option>
						<option>杭州</option>
						<option>天津</option>
					</select>
				</div>
			</div>
	
	
	
	
	
			<!-- form表单提交到结算 -->
		<form action="SettlementServerlet.do" method="post" target="_blank">
		<input type="hidden" name="listMyCart" value="${listMyCart6 }" />
		
			<div class="jiliang"><!--显示商品的计量单位-->
				<ul class="jiliang_ui clearfix">
				
				<!-- 全选按钮 -->
					<li class="ji_1">
						<input class="jiliang_input" type="checkbox">全选
					</li>
					<li class="ji_2">商品</li>
					<li class="ji_3">单价</li>
					<li class="ji_4">数量</li>
					<li class="ji_5">小计</li>
					<li class="ji_6">操作</li>
				</ul>
			</div>

			<div class="gouwuquan"><!--显示购物车商品详情-->
				<div id="ziying"><!--京东自营-->
	
					<div class="xiangqing clearfix"><!--详情-->
						<c:forEach items="${listMyCart6 }" var="MyCartQueryView">
						
						<%-- <input type="hidden" name="carId"  value="${MyCartQueryView.car_id }" /> --%>
						
						
						
						
						<!-- 单选按钮 -->
				<div class="xiangqing_xuanzhong"><!--是否选中-->
		<input type="checkbox" checked="${MyCartQueryView.car_select }" name="carId" value="${MyCartQueryView.car_id }" />
							
					<span>${MyCartQueryView.store_name }</span><!--店铺名 -->
				</div>
						
						
						
						
						<div class="xiangqing_shangpin clearfix" style="width:1000px;"><!--商品-->
						
							<div class="xiangqing_shangpin_img"><!--商品图片显示-->
								<a href="${pageContext.request.contextPath}/user/ProductDetailServlet.do" target="_blank">
									<img src="${MyCartQueryView.product_sku_img_small }"></a>
							</div>
							<div class="xiangqing_shangpin_all"><!--商品名称及包邮条件等-->
							
								<div class="xiangqing_shangpin_mingcheng"><!--名称-->
									
								${MyCartQueryView.product_name }
									
								</div>
								<div><!--包邮条件-->
									<a href="xx"><img src="img/7天无理由.jpg">不支持7天无理由退货</a>
									<a href="xx"><img src="img/选礼物.jpg">选包装</a>
								</div>
							</div>
							<div>
								<div class="xiangqing_color"style="margin-left:28px;text-align:left;"><!--颜色，尺寸-->
									  颜色：${MyCartQueryView.color_name }
									
								</div>
								<div class="xiangqing_size"style="width:130px;padding-left:28px;">
								              尺码：${MyCartQueryView.size_name }
								</div>
							</div>
							<div class="xiangqing_danjia"><!-- 单价 -->
								<span class="xiangqing_jiage">$</span>
								${MyCartQueryView.product_sku_realPrice }
							</div>
							<div class="xiangqing_shuliang">
								<div class="xiangqing_shuliang_div clearfix">
									<input type="button" id="jian" value="-"/>
									
									<!--数量-->
									<input type="text" id="shuliang" value="${MyCartQueryView.sku_amount }"/>
									
									<input type="button" id="jia" value="+"/>
								</div>
							</div>
							<div class="xiangqing_xiaoji"><!--小计-->
							<span class="xiangqing_zongjia"><strong>${MyCartQueryView.product_sku_realPrice }</strong></span>
							</div>
							<div class="xiangqing_caozuo"><!--操作-->
								<div>
<div><a href="${pageContext.request.contextPath}/user/CartSettle.do?method=deleteByCarId&carId=${MyCartQueryView.car_id }" target="_self">
										删除</a></div>
									
									<div><a href="xx">移到我的关注</a></div>
									<div><a href="xx">加到我的关注</a></div>
								</div>
							</div>
							
						</div>
						</c:forEach>
						
					</div>
					
					</div>
				</div>
				
				 
				<div class="jiesuan clearfix"><!--结算栏-->
					<input class="jiesuan_input js" type="checkbox"><span class="jiesuan_1 js">全选</span>
					<span class="js"><a href="xx">删除所中的商品</a></span>
					<span class="js"><a href="xx">移到我的关注</a></span>
					<span class="js"><a href="xx"><strong>清空购物车</strong></a></span>
					<span class="jiesuan_2 js">已选择商品数<select class="js">
						<option>n</option>
					</select></span>
					<span class="jiesuan_3">总计<input type="text" class="jiesuan_zongji js"></span>
					<span>
					
					<button id="qujiesuan" >去结算</button>
					<%-- <a href="${pageContext.request.contextPath}/SettlementServerlet.do?">去结算</a> --%>
					</span>
				</div>
					
				</form>	
					
				
				
				
				
				
				<div class="ad"><!--广告栏-->
					<div class="ad_kind clearfix">
						<ul class="ad_kind_ul1 clearfix">
							<li>猜你喜欢</li>
							<li>随手购</li>
							<li>我的关注</li>
						</ul>
						<ul class="ad_kind_ul2 clearfix">
							<li><a href="xx">上一页</a></li>
							<li><a href="xx">下一页</a></li>
						</ul>
					</div>
					<div>
						<ul class="ad_ul clearfix">
							<li>
								<div><!--第一条广告-->
									<div class="ad_li_div1"><!--图片-->
										<img class="ad_img1" src="img/益达.jpg"/>
									</div>
									<div class="ad_li_div">
										<a href="xx">益达（Extra）木糖醇无糖口香糖混合味70粒98g单瓶装（新旧包装随机发）</a>
									</div>
									<div class="ad_li_div2"><!--价格-->
										$5.00
									</div>
								</div>
								<div class="ad_li_div2">
									<input type="button" value="加入购物车" class="ad_li_button"/>
								</div>
							</li>
							<li>
								<div><!--第一条广告-->
									<div class="ad_li_div1"><!--图片-->
										<a href="xx"><img class="ad_img1" src="img/无糖口香糖.jpg"></a>
									</div>
									<div class="ad_li_div"><!--文字-->
										<a href="xx">曼妥思清劲无糖口香糖清新薄荷味瓶装56克薄荷糖 休闲零食</a>
									</div>
									<div class="ad_li_div2"><!--价格-->
										$6.00
									</div>
								</div>
								<div class="ad_li_div2">
									<input type="button" value="加入购物车" class="ad_li_button"/>
								</div>
							</li>
							<li>
								<div><!--第一条广告-->
									<div class="ad_li_div1"><!--图片-->
										<a href="xx"><img class="ad_img1" src="img/绿箭.jpg"></a>
									</div>
									<div class="ad_li_div"><!--文字-->
										<a href="xx">绿箭无糖薄荷糖原味薄荷味35粒23.8g单盒金属装（新旧包装随机发）
											绿箭无糖薄荷糖原味薄荷味35粒23.8g单盒金属装（新旧包装随机发）
										</a>
									</div>
									<div class="ad_li_div2"><!--价格-->
										$7.00
									</div>
								</div>
								<div class="ad_li_div2">
									<input type="button" value="加入购物车" class="ad_li_button"/>
								</div>
							</li>
							<li>
								<div><!--第一条广告-->
									<div class="ad_li_div1"><!--图片-->
										<a href="xx"><img class="ad_img1" src="img/巧克力.jpg"></a>
									</div>
									<div class="ad_li_div"><!--文字-->
										<a href="xx">好时之吻Kisses牛奶巧克力82g休闲零食糖果分享（新老包装随机发货）</a>
									</div>
									<div class="ad_li_div2"><!--价格-->
										$8.00
									</div>
								</div>
								<div class="ad_li_div2">
									<input type="button" value="加入购物车" class="ad_li_button"/>
								</div>
							</li>
						</ul>
					</div>
				</div>	
			</div>
		</div>
		<div id="buttom">
			<div class="dkhs">
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