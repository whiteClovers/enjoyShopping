<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/index_input.css" />

		<link href="${pageContext.request.contextPath}/img/login_logo.png" rel="SHORTCUT ICON" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/WdatePicker.js"></script>
		<title>订单管理</title>
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
						<i class="icon iconfont icon-santiaogang"></i>
						<span>用户编辑</span>
					</div>
					<div class="index_input_body_third_header_2">
						<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>

            <form action="TransferAccountServlet.do"method="post">
               <input type="hidden" name="method" value="save" />
				<input type="hidden" name="transferAccountsId" value="${transferAccount4.transferAccountsId}" />
				<div class="index_input_body_third_body">
					
						<div class="index_input_body_third_body_all clearfix">
							

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">转账人id：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${transferAccount4.transferAccountsId}"  />
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">用户id：</div>
								<select name="customer_id">
								<c:forEach items="${listUserCustomer }" var="UserCustomer">
									<option value="${UserCustomer.customerId}">${UserCustomer.customerName}</option>
								</c:forEach>
							    </select>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">订单id：</div>
								<select name="order_id">
								<c:forEach items="${listOrder }" var="order">
									<option value="${order.order_id}">${order.order_code}</option>
								</c:forEach>
							</select>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">收款人id：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${transferAccount4.receivablesId}"  />
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">收款人姓名：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${transferAccount4.receivablesName}"  />
								</div>
							</div>
							
							

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">转账金额：</div>

								<div>
									<input class="index_input_style1" type="text" name="bank_num" value="${transferAccount4.orderSumMoney}"/>
								</div>
							
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">订单支付日期：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" 
									onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									value="${transferAccount4.orderPaydate}"  />
								</div>
							</div>
<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">用户id：</div> -->

<!-- 								<div> -->
<%-- 									<input class="index_input_style1" type="text" name="customer_id" value="${bank4.bankType}" /> --%>
<!-- 							</div> -->
<!-- 							</div> -->
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">转账时间：</div>

								<div>
									<input class="index_input_style1" type="text" name="bank_type" value="${transferAccount4.orderPaydate}"  />
								</div>
							</div>
							
								</select>

							</div>
						</div>
				

					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
						   
							<button class="index_input_body_third_body_foot_btn1">
							提交
							</button>
					
							<button class="index_input_body_third_body_foot_btn2">
							取消
							</button>

						</div>

					</div>
				</div>
</form>
			</div>
		</div>
  	
</body>
</html>