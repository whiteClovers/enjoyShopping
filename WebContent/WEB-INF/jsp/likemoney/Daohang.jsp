<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/LoginServlet.do?method=list" target="_blank">登录</a>
<a href="${pageContext.request.contextPath}/RegisterServlet.do?method=list" target="_blank">注册</a>

<a href="${pageContext.request.contextPath}/user/HomepageServlet.do?method=list" target="_blank">首页</a>
<a href="${pageContext.request.contextPath}/user/SearchServerlet.do?method=list" target="_blank">搜索页</a>
<a href="${pageContext.request.contextPath}/user/ProductDetailServlet.do?" target="_blank">商品详情</a>
<a href="${pageContext.request.contextPath}/user/AddtoCart.do?method=list" target="_blank">加入购物车</a>
<a href="${pageContext.request.contextPath}/user/CartSettle.do?method=list" target="_blank">购物车</a>

<!-- 以下页面用户未登录不能进入 -->
<a href="${pageContext.request.contextPath}/user/SettlementServerlet.do?method=list" target="_blank">结算页</a>
<a href="${pageContext.request.contextPath}/user/PayServlet.do?method=list" target="_blank">支付页</a>

<a href="${pageContext.request.contextPath}/user/MyOrderServerlet.do?method=list" target="_blank">我的订单</a>
<a href="${pageContext.request.contextPath}/user/OrderDetailFrontServlet.do?method=list" target="_blank">订单详情</a>

<a href="${pageContext.request.contextPath}/user/MyCenterServerlet.do?method=list" target="_blank">个人中心</a>
<a href="${pageContext.request.contextPath}/user/MyInformServerlet.do?method=list" target="_blank">个人信息设置</a>
<a href="${pageContext.request.contextPath}/user/EvaluateCenterServlet.do?method=list" target="_blank">评价中心</a>
<a href="${pageContext.request.contextPath}/user/ReceivingAddressServlet.do?method=list" target="_blank">收货地址</a>

<br>
<br>
<br>
<br>
<br>
<a href="BankServlet.do?method=list" target="_blank">银行卡</a>
<a href="ClassfiyBigServlet.do?method=list"target="_blank">大类别</a>
<a href="ClassfiySmallServlet.do?method=list"target="_blank">小类别</a>
<a href="DictionariesServlet.do?method=list"target="_blank">字典</a>
<a href="DictionariesServletDetail.do?method=list"target="_blank">字典详细</a>
<a href="CartSettleServerlett.do?method=list"target="_blank">购物车</a>
<a href="OrderEvaluateServlet.do?method=list"target="_blank">订单评价</a>
<a href="OrderServlet.do?method=list"target="_blank">订单</a>
<a href="OrderDetailServlet.do?method=list"target="_blank">订单明细</a>
<a href="TransferAccountServlet.do?method=list"target="_blank">转账</a>
<a href="ProductBrandServlet.do?method=list"target="_blank">品牌</a>
<a href="ProductColorServlet.do?method=list"target="_blank">颜色</a>
<a href="ProductServlet.do?method=list"target="_blank">产品</a>
<a href="ProductSkuServlet.do?method=list"target="_blank">产品SKu</a>
<a href="ProductSizeServlet.do?method=list"target="_blank">尺寸</a>
<a href="ProductStoreServlet.do?method=list"target="_blank">店铺</a>
<a href="StockInServlet.do?method=list"target="_blank">库存</a>
<a href="StockInDetailServlet.do?method=list"target="_blank">库存明细</a>
<a href="SystemEmployeeServlet.do?method=list"target="_blank">员工</a>
<a href="SystemEmployeeRoleServlet.do?method=list"target="_blank">员工角色</a>
<a href="SystemMenuServlet.do?method=list"target="_blank">菜单</a>
<a href="SystemModuleServlet.do?method=list"target="_blank">模块</a>
<a href="SystemRoleServlet.do?method=list"target="_blank">角色</a>
<a href="SystemRoleMenuServlet.do?method=list"target="_blank">角色菜单</a>
<a href="UserAddressServlet.do?method=list"target="_blank">用户地址</a>
<a href="UserAttentionServlet.do?method=list"target="_blank">用户关注</a>
<a href="UserCustomerServlet.do?method=list"target="_blank">用户</a>

</body>
</html>