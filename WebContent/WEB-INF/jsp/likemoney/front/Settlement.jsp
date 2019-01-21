<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/zfjs.css" />
		<title></title>
	</head>
	<body>
		<div id="shortcut">
				<div class="w">
			    	<div class="top_nav clearfix"><!--顶部导航条-->
				    	<ul class="top_ul_left clearfix">
			<li id="top_nav_home_id"><i class="top_nav_home"></i><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">京东首页</a></li>
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
									<a target="_blank" href="${pageContext.request.contextPath}/user/MyOrderServerlet.do">我的订单</a>
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
		<div class="w w1 header clearfix">
		            <div id="logo-2014">
		            <a href="" class="logo" target="_blank"></a>
		            <a href="#none" class="link2"><b></b>"结算页"</a>
		        </div>
		    
		    <div class="stepflex" id="#sflex03">
		        <dl class="first done">
		            <dt class="s-num">1</dt>
		            <dd class="s-text">1.我的购物车<s></s><b></b></dd>
		        </dl>
		        <dl class="normal doing">
		            <dt class="s-num">2</dt>
		            <dd class="s-text">2.填写核对订单信息<s></s><b></b></dd>
		        </dl>
		        <dl class="normal last">
		            <dt class="s-num">3</dt>
		            <dd class="s-text">3.成功提交订单<s></s><b></b></dd>
		        </dl>
		    </div>
		</div>
		<div id="container">
			<div id="container" class="w">
				<div class="checkout-tit">
		            <span class="tit-txt">填写并核对订单信息</span>                         
				</div>
				
				<div class="body_middle">
					<!--收货人信息-->
					<div class="body_middle_people">
						<div class="clearfix">
							<span class="body_middle_people_span1 bold">收货人信息</span>
							<span class="body_middle_people_span2">新增收货地址</span>
						</div>
						<div class="body_middle_people_all mar20 clearfix">
							<div class="body_middle_people_address clearfix">
								<div class="body_middle_people_address_01 c102">xx xx</div>
								<div class="body_middle_people_address_02 c102">&nbsp;&nbsp;xx&nbsp;&nbsp;&nbsp;&nbsp;xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xxxxxxxxxxxxxxx</div>
								<div class="body_middle_people_address_03 ">默认地址</div>
							</div>
							<div class="body_middle_people_address_more c102">更多地址</div>
							<div class="body_middle_people_all_self">
								<button>京东自提</button>
								<span>抱歉，存在不支持自提的商品或该地址下没有可用的自提点 </span>
								<span style="color:#005EA7;">&nbsp;&nbsp;&nbsp;详情</span>
							</div>
						</div>
	
					</div>
					<!--边线-->
					<div class="body_line  mar-left20 mar-right20">
	
					</div>
					<!--支付方式-->
					<div>
						<div class="body_middle_payway_header mar20 mar-bottom10 bold fsz14">支付方式</div>
						<div class="body_middle_payway_body clearfix">
							<div class="body_middle_payway_body_1 c102 fsz12 mar-left40">
								货到付款
							</div>
							<div class="body_middle_payway_body_1 c102 fsz12 mar-left10">
								在线支付
							</div>
							<div class="body_middle_payway_body_3 mar-left10 c102 ">
								更多
							</div>
						</div>
					</div>
					<!--边线-->
					<div class="body_line mar-left20 mar-right20">
	
					</div>
					
					
					
					<!--送货清单-->
					
					
					
					
					
			<form action="PayServlet.do" method="post" target="_blank" >
					
					
				<c:forEach items="${listCarts }" var="listCart">
					<c:forEach items="${listCart }" var="list">
					<div>
						<div class="body_middle_list_header mar20 mar-bottom10 clearfix">
							<div class="body_middle_people_span1">
								送货清单
							</div>
							<div class="body_middle_people_span2">
								价格说明&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;返回修改购物车
							</div>
						</div>
						<div class="body_middle_list_body clearfix">
							<div class="body_middle_list_body_left mar-left20">
	
								<div class="body_middle_list_body_left_01">配送方式</div>
								<div class="body_middle_people_address_01 c102" style="margin: 10px 0px;float: none;">
									快递运输
								</div>
								<div class="body_middle_list_body_left_03 mar-right20 c102 fsz12"><span class="c153">配送时间：</span>工作日、双休日与节假日均可送货</div>
								<div class="body_middle_list_body_left_04">
									<div style="color: #7884BD;font-size: 13px;">&amp;运费险</div>
									<div class="body_middle_list_body_left_04_1 c102 fsz12 pad-left20">${list.store_name }7天内退货，15天内换货，可享1次运费赔付到小金库</div>
								</div>
							</div>
							<div class="body_middle_list_body_right mar-bottom20" style="float: right;">
								<div class="body_middle_list_body_left_01 fsz12 c102 bold">
									<!-- 商家：南极人梅子屋专卖店 -->
									${list.store_name }
								</div>
								<div class="clearfix">
									<div class="body_middle_list_body_left_01" style="margin-top: 12px;float: left;">活动商品已购满1件，已减0.00现金</div>
									<div class="body_middle_list_body_right_second_02 mar-left20"> 返现：￥6.9</div>
								</div>
								<div class="body_middle_list_body_left_03 mar-right20 c102 fsz12 clearfix">
									<div><img class="body_middle_list_body_left_03_1" src="${list.product_sku_img_small }"></div>
									<div class="body_middle_list_body_left_03_2 mar-left10">
										<!-- 南极人棉麻七分裤女夏2018薄款小脚哈伦裤中裤松紧腰五分裤大码休闲女裤 黑色 L/28 -->
										${list.product_name }
									</div>
									<div class="body_middle_list_body_left_03_3 c228-57-60 bold ">
										<!-- ￥ 69.00 -->
										${list.product_sku_realPrice }
										
									</div>
									<div class="body_middle_list_body_left_03_4">
										x${list.sku_amount }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有货
									</div>
								</div>
								<div class="body_middle_list_body_right_04 mar-top30 mar-bottom10 clearfix" >
									<div class="body_middle_list_body_right_04_1 fsz12 c102">
										商家备注：
									</div>
									<div>
										<input type="text" value="（定制类商品，请将购买需求在备注上做详细说明）请勿填写与支付、收货、发票有关信息">
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--边线-->
					<div class="body_line mar-left20 mar-right20">
	
					</div>
					<!--发票信息-->
					<div class="body_middle_fapiao_wrap">
						<div class="body_middle_fapiao bold clearfix">
							<div>发票信息</div>
							<span><i class="icon iconfont icon-bulbdengpao"></i>开企业抬头发票须填写纳税人识别号，以免影响报销</span>
						</div>
						<div class="body_middle_fapiao_2 fsz12 c102">
							<span>不开发票</span>
							<span style="color: #005EA7;">修改</span>
						</div>
					</div>
					<!--边线-->
					<div class="body_line mar-left20 mar-right20">
					
					
					</c:forEach>
				</c:forEach>
					
					
	
					</div>
					<!--优惠信息-->
					<div class="body_middle_chip mar20 mar-bottom10 bold">使用优惠/礼品卡/抵用</div>
				</div>
				<div class="body_youhui mar20">
					<div class="clearfix">
						<span class="body_youhui_span1">${priceSum }</span>
						<span>${skuSum } 件商品，总商品金额：</span>
	
					</div>
					<div class="clearfix">
	
						<span class="body_youhui_span1">-￥0.00</span>
						<span>返现：</span>
					</div>
					<div class="clearfix">
						<span class="body_youhui_span1"> ￥0.00</span>
						<span>运费：</span>
					</div>
					<div class="clearfix">
						<span class="body_youhui_span1">￥0.00</span>
						<span>服务费：</span>
					</div>
					<div class="clearfix">
						<span class="body_youhui_span1">￥0.00</span>
						<span>退换无忧：</span>
					</div>
				</div>
				<div class="body_rmb">
					<div class="body_rmb_first clearfix">
						<span class="body_youhui_span3 mar-right20 fsz20 c228-57-60 bold">${priceSumS }</span>
						<span>应付总额：</span>
					</div>
					<div class="body_rmb_second clearfix">
						<span class="body_youhui_span2 mar-right20 c153" >
							收货人：<span >${sessionScope.customerId } </span>
						</span>
						<span class="c153">寄送至：江西省抚州市临川区：</span>
					</div>
				</div>
				
				
				<div class="body_tijiao clearfix">
					<button>提交订单</button>
					
					<!-- <input type="submit" value="提交订单" /> -->
				</div> 
				
				
				
				
			</form>
			
			
			
			
				</div>
		</div>
		<div id="GLOBAL_FOOTER" >        <!--service start-->
			<div id="service-2017">
				<div class="w">
					<ol class="slogen">
						<li class="item fore1">
							<i>多</i>品类齐全，轻松购物
						</li>
						<li class="item fore2">
							<i>快</i>多仓直发，极速配送
						</li>
						<li class="item fore3">
							<i>好</i>正品行货，精致服务
						</li>
						<li class="item fore4">
							<i>省</i>天天低价，畅选无忧
						</li>
					</ol>
				</div>
				<div class="jd-help">
					<div class="w">
						<div class="wrap">
							<dl class="fore1">
								<dt>购物指南</dt>
								<dd><a rel="nofollow" target="_blank" href="">购物流程</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">会员介绍</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">生活旅行/团购</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">常见问题</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">大家电</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">联系客服</a></dd>
							</dl>
							<dl class="fore2">		
								<dt>配送方式</dt>
								<dd><a rel="nofollow" target="_blank" href="">上门自提</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">211限时达</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">配送服务查询</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">配送费收取标准</a></dd>				
								<dd><a target="_blank" href="">海外配送</a></dd>
							</dl>
							<dl class="fore3">
								<dt>支付方式</dt>
								<dd><a rel="nofollow" target="_blank" href="">货到付款</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">在线支付</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">分期付款</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">邮局汇款</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">公司转账</a></dd>
							</dl>
							<dl class="fore4">		
								<dt>售后服务</dt>
								<dd><a rel="nofollow" target="_blank" href="">售后政策</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">价格保护</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">退款说明</a></dd>
								<dd><a rel="nofollow" target="_blank" href="n">返修/退换货</a></dd>
								<dd><a rel="nofollow" target="_blank" href="l">取消订单</a></dd>
							</dl>
							<dl class="fore5">
								<dt>特色服务</dt>	
								<dd><a target="_blank" href="">夺宝岛</a></dd>
								<dd><a target="_blank" href="">DIY装机</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">延保服务</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">京东E卡</a></dd>				
								<dd><a rel="nofollow" target="_blank" href="">京东通信</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">京东JD+</a></dd>
							</dl>
							<span class="clr"></span>
						</div>
					</div>
				</div>
			</div>
			<!--service end-->        <!--footer start-->
			<div id="footer-2017">
				<div class="w">
					<div class="copyright_links">
						<p>
							<a href="" target="_blank">关于我们</a><span class="copyright_split">|</span>
							<a href="" target="_blank">联系我们</a><span class="copyright_split">|</span>
							<a href="" target="_blank">联系客服</a><span class="copyright_split">|</span>
							<a href="" target="_blank">合作招商</a><span class="copyright_split">|</span>
							<a href="" target="_blank">商家帮助</a><span class="copyright_split">|</span>
							<a href="">营销中心</a><span class="copyright_split">|</span>
							<a href="">手机京东</a><span class="copyright_split">|</span>
							<a href="" target="_blank">友情链接</a><span class="copyright_split">|</span>
							<a href="" target="_blank">销售联盟</a><span class="copyright_split">|</span>
							<a href="" target="_blank">京东社区</a><span class="copyright_split">|</span>
							<a href="" target="_blank">风险监测</a><span class="copyright_split">|</span>
							<a href="" target="_blank">隐私政策</a><span class="copyright_split">|</span>
							<a href="" target="_blank">京东公益</a><span class="copyright_split">|</span>
							<a href="" target="_blank">English Site</a><span class="copyright_split">|</span>
							<a href="" target="_blank">Media &amp; IR</a>
						</p>
					</div>
					<div class="copyright_info">
						<p>
							<a href="" target="_blank">京公网安备 11000002000088号</a><span class="copyright_split">|</span><span>京ICP证070359号</span><span class="copyright_split">|</span>
							<a href="//img14.360buyimg.com/da/jfs/t256/349/769670066/270505/3b03e0bb/53f16c24N7c04d9e9.jpg" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span></p>
						<p><span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span>
							<a href="" target="_blank">出版物经营许可证</a><span class="copyright_split">|</span>
							<a href="//misc.360buyimg.com/wz/wlwhjyxkz.jpg" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span></p>
						<p><span class="copyright_text">Copyright&nbsp;©&nbsp;2004&nbsp;-&nbsp;<em id="copyright_year">2018</em>&nbsp;&nbsp;京东JD.com&nbsp;版权所有</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span>
							<a href="" target="_blank" class="copyright_license">经营证照</a><span class="copyright_split">|</span><span>(京)网械平台备字(2018)第00003号</span>
						</p>
						<p class="mod_copyright_inter">
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_global"></i>Global Site</a><span class="copyright_split">|</span>
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_rissia"></i>Сайт России</a><span class="copyright_split">|</span>
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_indonesia"></i>Situs Indonesia</a><span class="copyright_split">|</span>
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_spain"></i>Sitio de Espa?a</a>
						</p>
						<p><span>京东旗下网站：</span>
							<a href="https:" target="_blank">京东钱包</a><span class="copyright_split">|</span>
							<a href="" target="_blank">京东云</a>
						</p>
					</div>
					<p class="copyright_auth">
						<a class="copyright_auth_ico copyright_auth_ico_1" href="" target="_blank">经营性网站备案中心</a>
						
								<a id="urlknet" class="copyright_auth_ico copyright_auth_ico_2"  oncontextmenu="return false;" name="CNNIC_seal" href="" target="_blank">可信网站信用评估</a>
								<a class="copyright_auth_ico copyright_auth_ico_3" href="" target="_blank"><i ></i>网络警察提醒你</a>
								<a class="copyright_auth_ico copyright_auth_ico_4" href="" target="_blank">诚信网站</a>
								<a class="copyright_auth_ico copyright_auth_ico_5" href="" target="_blank">中国互联网举报中心</a>
								<a class="copyright_auth_ico copyright_auth_ico_6" href="" target="_blank">网络举报APP下载</a>
					</p>
				</div>
			</div>
			<!--footer end-->
		</div>
	</body>
</html>