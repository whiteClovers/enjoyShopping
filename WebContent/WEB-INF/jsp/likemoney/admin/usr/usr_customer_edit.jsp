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
		<title>员工管理</title>
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

            <form action="UserCustomerServlet.do"method="post">
               <input type="hidden" name="method" value="save" />
				<input type="hidden" name="bankId" value="${userCustomer4.customerId}" />
				<div class="index_input_body_third_body">
					
						<div class="index_input_body_third_body_all clearfix">
							

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">教育程度：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerEd}"  />
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">用户名：</div>

								<div>
									<input class="index_input_style1" type="text" name="bank_num" value="${userCustomer4.customerName}"/>
								</div>
							
							</div>
<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">用户id：</div> -->

<!-- 								<div> -->
<%-- 									<input class="index_input_style1" type="text" name="customer_id" value="${bank4.bankType}" /> --%>
<!-- 							</div> -->
<!-- 							</div> -->
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">登录密码：</div>

								<div>
									<input class="index_input_style1" type="password" name="bank_type" value="${userCustomer4.customerPwd}"  />
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">支付密码：</div>

								<div>
									<input class="index_input_style1" type="password" name="bankName" value="${userCustomer4.customerPayPwd}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">电话：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerPhone}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">email：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerEmail}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">性别：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerSex}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">会员：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerVip}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">生日：</div>

								<div>
									<input class="index_input_style1" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									type="text" name="bankName" value="${userCustomer4.customerBirthday}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">爱好：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerHobby}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">昵称：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerNickName}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">昵称：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerImg}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">头像：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerImg}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">收入：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerIncome}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">省份证：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerIdCard}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">婚姻状态：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerMaritalStatus}"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">可用状态：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userCustomer4.customerAvailableStatus}"  />
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