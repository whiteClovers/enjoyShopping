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
					<i class="icon iconfont icon-santiaogang"></i> <span>订单评价编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="OrderEvaluateServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="evaluate_id"
						value="${OrderEvaluate4.evaluate_id}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价id</div>

							<div>
								<input class="index_input_style1" type="text" name="evaluate_id"
									id="evaluate_id" disabled="disabled"
									value="${OrderEvaluate4.evaluate_id}" />

							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价日期</div>

							<div>
								<input class="index_input_style1" type="text" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									name="evaluate_time" id="evaluate_time" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价内容：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_message" id="evaluate_message" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">图片地址：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_img" id="evaluate_img" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">服务态度评分：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_service" id="evaluate_service" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价数量：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_amount" id="evaluate_amount" />
							</div>
						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">差评数量：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_bad" id="evaluate_bad" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select2 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">好评数量：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_good" id="evaluate_good" />
							</div>
						</div>


						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">中评数量：</div>

							<div class="index_input_body_third_body_1_style1 clearfix">

								<div>
									<input style="width: 220px"
										class="index_input_style4 index_input_style3" type="text"
										name="evaluate_common" id="evaluate_common" />
								</div>

							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">订单详细编号：</div>

							<div class="index_input_body_third_body_1_style1 clearfix">

								<select name="order_detail_id">
									<c:forEach items="${listOrderDetail6 }" var="OrderDetailQueryView">

											<option value="${OrderDetailQueryView.order_detail_id}">${OrderDetailQueryView.order_detail_code}</option>

									</c:forEach>
								</select>

							</div>
						</div>


						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">物流速度：</div>
							<div>
								<input style="width: 220px"
									class="index_input_style4 index_input_style3" type="text"
									name="evaluate_speed" id="evaluate_speed" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">商家描述：</div>
							<div>
								<input style="width: 220px"
									class="index_input_style4 index_input_style3" type="text"
									name="evaluate_describe" id="evaluate_describe" />
							</div>

						</div>

						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">用户：</div>
							<select name="customer_id">
								<c:forEach items="${listUserCustomer6 }" var="UserCustomer">
									<option value="${UserCustomer.customerId}">${UserCustomer.customerName}</option>
								</c:forEach>
							</select>

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