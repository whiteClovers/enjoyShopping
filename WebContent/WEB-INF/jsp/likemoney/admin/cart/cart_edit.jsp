<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/login.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/index_input.css" />

<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />

<script type="text/javascript" src="${pageContext.request.contextPath}/WdatePicker.js" ></script>

<title>购物车增改</title>
</head>

<body>
	<div class="index_input_all">
		<!--第一排-->
		<!--<div class="index_input_body_first fsz28">

				<span>用户编辑</span>
			</div>-->
		<!--第二排-->

		<!--第三排-->
		<div class="index_input_body_third">
			<div class="index_input_body_third_header clearfix">
				<div class="index_input_body_third_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>购物车编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="CartServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="car_id" value="${Cart4.car_id}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">id</div>

							<div>
								<input class="index_input_style1" type="text" name="car_id"
									id="car_id" disabled="disabled" value="${Cart4.car_id}" />

							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">商品Sku编号：</div>

							<select name="product_sku_id">
								<c:forEach items="${listProductSku6 }" var="ProductSkuQueryView">
									<option value="${ProductSkuQueryView.product_sku_id}">${ProductSkuQueryView.product_sku_code}</option>
								</c:forEach>
							</select>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1" style="font-size: 12px;">
								添加购物车日期：
								</div>

							<div>
								<input class="index_input_style1 Wdate" type="text" id="car_date" 
								onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})" 
								style="width: 172px;"	name="car_date" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">用户名：</div>

							<select name="customer_id">
								<c:forEach items="${listUserCustomer6 }" var="UserCustomer">
									<option value="${UserCustomer.customerId}">${UserCustomer.customerName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">选中状态：</div>

							<div>
								<!-- <input class="index_input_style1" type="text" id="car_select"
									name="car_select" /> -->
		<select name="car_select" >
			<c:forEach items="${selectQueryViews}" var="select">
				<option value="${select.code }" <c:if test="${select.code==car_select}">selected="selected"</c:if> >${select.label }</option>
			</c:forEach>
		</select>
							</div>
						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">删除状态：</div>
							<div>
								<!-- <input class="index_input_style1" type="text" id="car_detect"
									name="car_detect" /> -->
								<select name="car_detect"   style="width: 172px;">
									<c:forEach items="${deleteQueryViews}" var="delete">
										<option value="${delete.code }" <c:if test="${delete.code==car_delete}">selected="selected"</c:if> >${delete.label }</option>
									</c:forEach>
								</select>
							</div>

						</div>

					</div>


					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
							<button class="index_input_body_third_body_foot_btn1">提交
							</button>
							<button class="index_input_body_third_body_foot_btn2">取消
							</button>

						</div>

					</div>
			</div>
			</form>
		</div>
	</div>
</body>

</html>