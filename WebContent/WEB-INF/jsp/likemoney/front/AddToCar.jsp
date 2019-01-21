<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加购页</title>
 <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta charset=utf-8>
  
  <link href="${pageContext.request.contextPath}/css/a.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/c.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css"/>
</head>
<body>
   
   
	
	 <div class="shouye";style="position:relative;border:solid #0FF000;top:0px;">
		<div class="c";>
			<div style="float:left;">
			<a href="${pageContext.request.contextPath}/user/HomepageServlet.do">
					京东首页
					</a>
			
			</div>
			<div style="float:left;margin-left: 22px;">北京
			</div>
				<div style="float:left;margin-left:540px;">
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
				</div>
			</div>
				
				<div style="float:left;">｜
				</div>
				<div style="float:left;">
					<a href="${pageContext.request.contextPath}/user/MyOrderServerlet.do" target="_blank" >我的订单</a>
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">我的京东	
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">京东会员
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">企业采购
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">客户服务
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">网站导航
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">手机京东
				</div>
				<div style="clear:both;">
				</div>
			</div> <!--第一行-->
		

	<div class="ww">
		<div >
		    <div style="float:left; ">
		        <img src="img/1.png" alt="logo" title="logo"/>
		    </div>
			<div  class="s" style="float:left;">
			    
			    <input class="search"type="text" name="搜索" value="" > 
			   
                <input class="shousuo" type="button" name="button" value="搜索" style="width:65px; ">
			</div>
			<div class="shoppingcar" style="border:1px solid #DFDFDF;float:left;">
			<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
					我的购物车
					</a>
			</div>
			<div style="clear:both;"></div> <!--第二行-->
        </div>

		
           <div id="fenlei">
				<div  id="categroys">全部商品分类</div>
				<div  id="colthes">京东服饰</div>
				<div  id="beauty">美妆馆</div>
				<div  id="supermarket">超市</div>
				<div  id="shengxian">生鲜</div>
				<div  id="wshop">全球购</div>
				<div  id="fshop">闪购</div>
				<div  id="sort">拍卖</div>
				<div id="jinrong">金融</div>
				<div style="clear:both;"></div> <!--第四行-->
			</div>
		</div>
			
			<div class="line"></div>
		
		<div class="ddd">
			<div class="qt">
				<div style="float:left;margin-top: 20px;"><img src="${ProductSku.product_sku_img_big }" alt="logo" title="1"/></div>
				<div  id="sf"style="float:left;">商品已成功加入购物车！</div>
				<div style="clear:both;"></div>
				<div style="margin-top: 10px;">
					<div style="float:left;"><img src="${ProductSku.product_sku_img_small}" alt="logo" title="1"/></div>
					<div style="float:left;margin-left: 10px;">
						<div id="f1">${ProductSku.product_name }</div>
						<div>
							颜色：${ProductSku.color_name }
							种类：吊带裙+披肩尺码：
							均码/：${ProductSku.size_name }
							数量：1
						
						</div>
					</div>
					<div id="e3"style="float:left;">查看商品详情</div>
<div id="e4"style="float:left;"><a href="${pageContext.request.contextPath}/user/CartSettle.do" target="_Blank">去购物车结算</a></div>
					<div style="clear:both;"></div>
				</div>
			</div>
		</div>
		
		<div class="s1">
			<div id="q2">购买了该商品的用户还购买了</div>
			
			
			<div class="r1"style="float:left;">
				<div style="float:left;"><img src="img/a5.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
			
			<div class="r1"style="float:left;margin-left: 45px;">
				<div style="float:left;"><img src="img/q1.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;">
				<div style="float:left;"><img src="img/q2.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;">
				<div style="float:left;"><img src="img/q3.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
			<div class="r1"style="float:left;margin-top: 30px;">
				<div style="float:left;"><img src="img/q4.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
			
			<div class="r1"style="float:left;margin-left: 45px;margin-top: 30px;">
				<div style="float:left;"><img src="img/q5.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;margin-top: 30px;">
				<div style="float:left;"><img src="img/q6.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;margin-top: 30px;">
				<div style="float:left;"><img src="img/q7.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			<div style="clear:both;"></div>
			<div style="margin-top: 22px;">
				<div style="float:left;"><input class="a1"type="button"value="1"></div>
				<div style="float:left;"><input class="a2"type="button"value="2"></div>
				<div style="float:left;"><input class="a3"type="button"value="3"></div>
				<div style="float:left;"><input class="a4"type="button"value="4"></div>
			</div>
		</div>
		<div style="clear:both;"></div>
		
			<div class="s1">
			<div id="qq">您可能还需要</div>
			
			
			<div class="r1"style="float:left;">
				<div style="float:left;"><img src="img/b1.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
			
			<div class="r1"style="float:left;margin-left: 45px;">
				<div style="float:left;"><img src="img/b3.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;">
				<div style="float:left;"><img src="img/b4.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;">
				<div style="float:left;"><img src="img/b5.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
			<div class="r1"style="float:left;margin-top: 30px;">
				<div style="float:left;"><img src="img/b6.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
			
			<div class="r1"style="float:left;margin-left: 45px;margin-top: 30px;">
				<div style="float:left;"><img src="img/b7.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;margin-top: 30px;">
				<div style="float:left;"><img src="img/b8.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			
				<div class="r1"style="float:left;margin-left: 45px;margin-top: 30px;">
				<div style="float:left;"><img src="img/b9.jpg" alt="logo" title="1"/></div>
				<div style="float:left;">
					<div class="t4">子牧棉麻2018夏季新款 女新款原创百搭森女简约女式短裤</div>
					<div class="d1">￥69.00</div>
					<div class="w1">加入购物车</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			<div style="clear:both;"></div>
			<div style="margin-top: 22px;">
				<div style="float:left;"><input class="a1"type="button"value="1"></div>
				<div style="float:left;"><input class="a2"type="button"value="2"></div>
				<div style="float:left;"><input class="a3"type="button"value="3"></div>
				<div style="float:left;"><input class="a4"type="button"value="4"></div>
			</div>
			<div style="clear:both;"></div>
			<div>
				<div style="float:left;font-weight:bold ;">买什么</div>
				<div style="float:left;font-size:10px;margin-left:1082px;">查看更多商品专辑</div>
				<div style="clear:both;"></div>
				
				<div class="c2"style="float:left;">
					<div id="v1">微胖女孩的夏季穿衣指南</div>
					<div id="v2">素闻陌上花开</div>
					<div>
						<div style="float:left;margin-left: 42px;"><img src="img/e1.jpg" alt="logo" title="1"/></div>
						<div style="float:left;">
							<div id="m1"><img src="img/e2.jpg"/></div>
							<div id="m2"><img src="img/e3.jpg"/></div>
							<div id="m3"><img src="img/e2.jpg"/></div>
						</div>
						<div style="clear:both;"></div>
					</div>
					<div>
						<div style="float:left;margin-left: 85px;">关注 87</div>
						<div style="float:left;">｜</div>
						<div style="float:left;">赞 45</div>
						<div style="clear:both;"></div>
					</div>
				</div>
				
				
				<div class="c2"style="float:left;margin-left: 22px;">
					<div id="v1">微胖女孩的夏季穿衣指南</div>
					<div id="v2">素闻陌上花开</div>
					<div>
						<div style="float:left;margin-left: 42px;"><img src="img/e1.jpg" alt="logo" title="1"/></div>
						<div style="float:left;">
							<div id="m1"><img src="img/e2.jpg"/></div>
							<div id="m2"><img src="img/e3.jpg"/></div>
							<div id="m3"><img src="img/e2.jpg"/></div>
						</div>
						<div style="clear:both;"></div>
					</div>
					<div>
						<div style="float:left;margin-left: 85px;">关注 87</div>
						<div style="float:left;">｜</div>
						<div style="float:left;">赞 45</div>
						<div style="clear:both;"></div>
					</div>
				</div>
				
				<div class="c2"style="float:left;margin-left: 22px;">
					<div id="v1">微胖女孩的夏季穿衣指南</div>
					<div id="v2">素闻陌上花开</div>
					<div>
						<div style="float:left;margin-left: 42px;"><img src="img/e1.jpg" alt="logo" title="1"/></div>
						<div style="float:left;">
							<div id="m1"><img src="img/e2.jpg"/></div>
							<div id="m2"><img src="img/e3.jpg"/></div>
							<div id="m3"><img src="img/e2.jpg"/></div>
						</div>
						<div style="clear:both;"></div>
					</div>
					<div>
						<div style="float:left;margin-left: 85px;">关注 87</div>
						<div style="float:left;">｜</div>
						<div style="float:left;">赞 45</div>
						<div style="clear:both;"></div>
					</div>
				</div>
				<div class="c2"style="float:left;margin-left: 22px;">
					<div id="v1">微胖女孩的夏季穿衣指南</div>
					<div id="v2">素闻陌上花开</div>
					<div>
						<div style="float:left;margin-left: 42px;"><img src="img/e1.jpg" alt="logo" title="1"/></div>
						<div style="float:left;">
							<div id="m1"><img src="img/e2.jpg"/></div>
							<div id="m2"><img src="img/e3.jpg"/></div>
							<div id="m3"><img src="img/e2.jpg"/></div>
						</div>
						<div style="clear:both;"></div>
					</div>
					<div>
						<div style="float:left;margin-left: 85px;">关注 87</div>
						<div style="float:left;">｜</div>
						<div style="float:left;">赞 45</div>
						<div style="clear:both;"></div>
					</div>
				</div>
				<div style="clear:both;"></div>
			</div>
		</div>
		
	
	
	
			<div id="GLOBAL_FOOTER" style="margin-top: 42px;">        <!--service start-->
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
		
   
</body>
</html>