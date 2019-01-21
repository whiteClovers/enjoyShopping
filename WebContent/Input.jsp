<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>导航页</title>
	</head>
	<body>
		<a href="AddToCarServlet.do" target="_blank">添加购物车</a>
		<a href="CartSettleServerlet.do" target="_blank">购物车详情</a>
		<a href="EvaluateCenterServlet.do" target="_blank">评价中心</a>
		<a href="${pageContext.request.contextPath}/HomepageServlet.do" target="_blank">主页</a>
		<a href="LoginServlet.do" target="_blank">登录</a>
		<a href="MyCenterServerlet.do" target="_blank">我的中心</a>
		<a href="MyInformServerlet.do" target="_blank">我的详情</a>
		<a href="MyOrderServerlet.do" target="_blank">我的订单</a>
		<a href="OrderDetailServlet.do" target="_blank">订单明细</a>
		<a href="PayServerlet.do" target="_blank">支付页面</a>
		<a href="ProductDetailServlet.do" target="_blank">产品详情</a>
		<a href="ReceivingAddressServlet.do" target="_blank">收货地址</a>
		<a href="RegisterServlet.do" target="_blank">注册</a>
		<a href="SearchServerlet.do" target="_blank">搜索页</a>
		<a href="SettlementServerlet.do" target="_blank">结算页</a>
	</body>
</html>