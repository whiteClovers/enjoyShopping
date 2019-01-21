<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>员工管理</title>

<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/index_input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/manage_table.css" />
</head>
<body>

	<div class="manage_table_all">

		<!--第一排-->
		<div class="index_input_body_first fsz28">

			<span>员工管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
		<form action="UserCustomerServlet.do" method="post">
		<input type="hidden" name="method" value="list" >
		<span>用户id：</span> <input type="text" name="customerId" value="${ customerId}" />
		<span>用户名：</span> <input type="text" name="customerName" value="${ customerName}"/>
		<span>性别：</span> <input type="text" name="customerSex" value="${ customerSex}"/>
		<input type="submit" value="提交" >
		</form>
		</div>
		<%-- 
			<ul class="clearfix">

				<li>
					
						<span>用户id：</span> <input type="text" name="customerId" value="${ customerId}" />

					
				</li>
				<li>
					
						<span>用户名：</span> <input type="text" name="customerName" value="${ customerName}"/>

					
				</li>
				<li>
					
						<span>性别：</span> <input type="text" name="customerSex" value="${ customerSex}"/>
						<input type="submit" value="提交" >
							<i class="icon iconfont icon-fangdajing"></i>
						</input>
					
				</li>
			</ul>
		</div> --%>
		
		
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>员工管理</span>
				</div>
				<div class="table_body_first_header_2">
				<a href="UserCustomerServlet.do?method=edit">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> 
				</a>
					<iclass="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">用户id</th>
							<th class="width_style5 bgcddd c666 ">教育程度</th>
							<th class="width_style5 bgcddd c666 ">用户名</th>
							<th class="width_style5 bgcddd c666 ">登录密码</th>
							<th class="width_style5 bgcddd c666 ">支付密码</th>
							<th class="width_style5 bgcddd c666 ">手机号码</th>
							<th class="width_style5 bgcddd c666 ">email</th>
							<th class="width_style5 bgcddd c666 ">性别</th>
							<th class="width_style5 bgcddd c666 ">会员</th>
							<th class="width_style5 bgcddd c666 ">生日</th>
							<th class="width_style5 bgcddd c666 ">爱好</th>
							<th class="width_style5 bgcddd c666 ">昵称</th>
							<th class="width_style5 bgcddd c666 ">头像</th>
							<th class="width_style5 bgcddd c666 ">余额</th>
							<th class="width_style5 bgcddd c666 ">月收入</th>
							<th class="width_style5 bgcddd c666 ">身份证号</th>
							<th class="width_style5 bgcddd c666 ">婚姻状态</th>
							<th class="width_style5 bgcddd c666 ">可用状态</th>



						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUserCustomer6}" var="UserCustomer">
							<tr>
								<td class="bgc_f9 ">
								<a href="UserCustomerServlet.do?method=edit&customerId6=${UserCustomer.customerId}">
										<button class="button_style5 button_style8">
											<i class="icon iconfont icon-dui"></i>
										</button>
								</a>
								<a href="UserCustomerServlet.do?method=delete&customerId6=${UserCustomer.customerId}">
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button></td>
								</a>	
								<td class="bgc_f9 c4a8bc2 ">${UserCustomer.customerId}</td>
								<td class="bgc_f9 ">${UserCustomer.customerEd}</td>
								<td class="bgc_f9 ">${UserCustomer.customerName}</td>
								<td class="bgc_f9 ">${UserCustomer.customerPwd}</td>
								<td class="bgc_f9 ">${UserCustomer.customerPayPwd}</td>
								<td class="bgc_f9 ">${UserCustomer.customerPhone}</td>
								<td class="bgc_f9 ">${UserCustomer.customerEmail}</td>
								<td class="bgc_f9 ">${UserCustomer.customerSex}</td>
								<td class="bgc_f9 ">${UserCustomer.customerVip}</td>
								<td class="bgc_f9 ">${UserCustomer.customerBirthday}</td>
								<td class="bgc_f9 ">${UserCustomer.customerHobby}</td>
								<td class="bgc_f9 ">${UserCustomer.customerNickName}</td>
								<td class="bgc_f9 ">${UserCustomer.customerImg}</td>
								<td class="bgc_f9 ">${UserCustomer.customerBalance}</td>
								<td class="bgc_f9 ">${UserCustomer.customerIncome}</td>
								<td class="bgc_f9 ">${UserCustomer.customerIdCard}</td>
								<td class="bgc_f9 ">${UserCustomer.customerMaritalStatus}</td>
								<td class="bgc_f9 ">${UserCustomer.customerAvailableStatus}</td>


							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

	</div>

</body>
</html>