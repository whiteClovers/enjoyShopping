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
		<title>财务管理</title>
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

            <form action="BankServlet.do"method="post">
               <input type="hidden" name="method" value="save" />
				<input type="hidden" name="bankId" value="${userAddress4.addressId}" />
				<div class="index_input_body_third_body">
					
						<div class="index_input_body_third_body_all clearfix">
							

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">地址id：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userAddress4.addressName}"  />
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">地址名称：</div>

								<div>
									<input class="index_input_style1" type="text" name="bank_num" value="${userAddress4.addressPhone}"/>
								</div>
							</div>
<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">用户id：</div> -->

<!-- 								<div> -->
<%-- 									<input class="index_input_style1" type="text" name="customer_id" value="${bank4.bankType}" /> --%>
<!-- 							</div> -->
<!-- 							</div> -->
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">电话：</div>

								<div>
									<input class="index_input_style1" type="text" name="bank_type" value="${userAddress4.addressConsignee}"  />
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">签收人：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userAddress4.addressName}"  />
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">email：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userAddress4.addressName}"  />
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">邮编：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userAddress4.addressName}"  />
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
								<div class="c888 fsz14 index_input_body_third_body_style1">发源地：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userAddress4.addressName}"  />
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">默认地址：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userAddress4.addressName}"  />
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