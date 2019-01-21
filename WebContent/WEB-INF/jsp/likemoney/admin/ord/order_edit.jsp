<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



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
					<i class="icon iconfont icon-santiaogang"></i> <span>订单编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="OrderServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="order_id" value="${Order4.order_id}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">id</div>

							<div>
								<input class="index_input_style1" type="text" name="order_id"
									id="order_id" disabled="disabled" value="${Order4.order_id}" />

							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">订单编号:</div>

							<div>
								<input class="index_input_style1" type="text" id="order_code"
									name="order_code" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">收货地址：</div>
							<select name="address_id">
								<c:forEach items="${listUserAddress6 }" var="UserAddressQueryView">
									<option value="${UserAddressQueryView.addressId}">${UserAddressQueryView.addressName}</option>
								</c:forEach>
							</select>
							<!-- 							<div> -->
							<!-- 								<input class="index_input_style1" type="text" id="address_id" -->
							<!-- 									name="address_id" /> -->
							<!-- 							</div> -->
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">用户：</div>
							<select name="customer_id">
								<c:forEach items="${listUserCustomer6 }" var="UserCustomer">
									<option value="${UserCustomer.customerId}">${UserCustomer.customerName}</option>
								</c:forEach>
							</select>
							<!-- 							<div> -->
							<!-- 								<input class="index_input_style1" type="text" id="customer_id" -->
							<!-- 									name="customer_id" /> -->
							<!-- 							</div> -->
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">提交订单时间：</div>

							<div>
								<input class="index_input_style1" type="text" id="order_date" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									name="order_date" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">订单状态：</div>

							<select name="order_status">
								<c:forEach items="${listDictionariesDetail6 }" var="DictionariesDetailQueryView">
									<option value="${DictionariesDetailQueryView.code}">${DictionariesDetailQueryView.label}</option>
								</c:forEach>
							</select>
						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">订单金额：</div>
							<!-- 								<select name=""> -->
							<!-- 									<option value="">是</option> -->
							<!-- 									<option value="">否</option> -->
							<!-- 								</select> -->
							<div>
								<div>
									<input class="index_input_style1" type="text"
										id="order_sum_money" name="order_sum_money" />
								</div>

							</div>
						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">订单支付时间：</div>
						
							<div>
								<input class="index_input_style1" type="text" id="order_paydate" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									name="order_paydate" />
							</div>

						</div>


						<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
						<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">物流状态：</div> -->

						<!-- 								<div class="index_input_body_third_body_1_style1 clearfix"> -->

						<!-- 									<div> -->
						<!-- 										<input style="width: 220px" class="index_input_style4 index_input_style3" type="text" /> -->
						<!-- 									</div> -->

						<!-- 								</div> -->
						<!-- 							</div> -->




						<!-- 							<div class="index_input_body_third_body_1 index_input_select1 clearfix"> -->
						<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">订单评价：</div> -->
						<!-- 								<select name=""> -->
						<!-- 									<option value="">已评</option> -->
						<!-- 									<option value="">未评</option> -->
						<!-- 								</select> -->

						<!-- 							</div> -->
						<!-- 							<div class="index_input_body_third_body_1 index_input_select1 clearfix"> -->
						<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">出库状态：</div> -->
						<!-- 								<select name=""> -->
						<!-- 									<option value="">已出库</option> -->
						<!-- 									<option value="">包装中</option> -->
						<!-- 									<option value="">待处理</option> -->
						<!-- 								</select> -->

						<!-- 							</div> -->


						<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
						<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">出库时间：</div> -->

						<!-- 								<div> -->
						<!-- 									<input class="index_input_style1" type="text" /> -->
						<!-- 								</div> -->
						<!-- 							</div> -->

						<!-- 							<div class="index_input_body_third_body_1 index_input_select1 clearfix"> -->
						<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">是否收货：</div> -->
						<!-- 								<select name=""> -->
						<!-- 									<option value="">是</option> -->
						<!-- 									<option value="">否</option> -->

						<!-- 								</select> -->

						<!-- 							</div> -->
					</div>


					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
							<button class="index_input_body_third_body_foot_btn1">
								提交</button>
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