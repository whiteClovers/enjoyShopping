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
<script type="text/javascript" src="${pageContext.request.contextPath }/WdatePicker.js"></script>
<title>订单增改</title>
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
					<i class="icon iconfont icon-santiaogang"></i> <span>订单详细编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="OrderDetailServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="order_detail_id"
						value="${OrderDetail4.order_detail_id}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">订单详细id</div>

							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_id" id="order_detail_id" disabled="disabled"
									value="${OrderDetail4.order_detail_id}" />

							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix" >
							<div class="c888 fsz14 index_input_body_third_body_style1">商品Sku编号</div>

							<select name="product_sku_id">
								<c:forEach items="${listProductSku6 }" var="ProductSkuQueryView">
									<option value="${ProductSkuQueryView.product_sku_id}">${ProductSkuQueryView.product_sku_code}</option>
								</c:forEach>
							</select>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">商品实际价格：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="product_sku_realPrice" id="product_sku_realPrice" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">商品数量：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_amount" id="order_detail_amount" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">发货状态：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_send" id="order_detail_send" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">物流状态：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_logistics" id="order_detail_logistics" />
							</div>
						</div>
						

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">签收状态：</div>

							<div class="index_input_body_third_body_1_style1 clearfix">

								<div>
									<input style="width: 220px"
										class="index_input_style4 index_input_style3" type="text"
										name="order_detail_receive" id="order_detail_receive" />
								</div>

							</div>
						</div>




						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价日期：</div>
							<div>
								<input class="index_input_style1" type="text" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									name="order_detail_evaluate_time"
									id="order_detail_evaluate_time" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价状态：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_evaluate" id="order_detail_evaluate" />
							</div>

						</div>

						
						<div class="index_input_body_third_body_1 clearfix" >
							<div class="c888 fsz14 index_input_body_third_body_style1" >订单编号：</div>

							<select name="order_id">
								<c:forEach items="${listOrder6 }" var="OrderQueryView">
									<option value="${OrderQueryView.order_id}">${OrderQueryView.order_code}</option>
								</c:forEach>
							</select>
						</div>

						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">原价：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="product_sku_price" id="product_sku_price" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">出库时间：</div>
							<div>
								<input class="index_input_style1" type="text" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									name="order_detail_outTime" id="order_detail_outTime" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">出货状态：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_out" id="order_detail_out" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">物流到达时间：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_logistics_time" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									id="order_detail_logistics_time" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">签收时间：</div>
							<div>
								<input class="index_input_style1" type="text" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									name="order_detail_receive_time" id="order_detail_receive_time" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">订单详细编号：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="order_detail_code" id="order_detail_code" />
							</div>

						</div>
					</div>


					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
							<button class="index_input_body_third_body_foot_btn1" >
								提交</button>
							<button class="index_input_body_third_body_foot_btn2">
								取消</button>

						</div>

					</div>
			</div>
			</form>
		</div>
	</div>
</body>

</html>