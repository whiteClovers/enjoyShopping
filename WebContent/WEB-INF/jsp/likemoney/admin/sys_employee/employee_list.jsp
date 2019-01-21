<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@taglib uri="java.util.ArrayList;"%> --%>
<%-- <%@taglib uri="com.ckwl.likemoney.system.entity.SystemEmployee;"%> --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>

<link href="${pageContext.request.contextPath}/img/login_logo.png" rel="SHORTCUT ICON" />
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
			<ul class="clearfix">

				<form action="SystemEmployeeServlet.do" method="post">
				<input type="hidden" name="method" value="list" /> 
					<li><span>员工名：</span> <input type="text" name="employeeName" value="${employeeName}"/></li>
					<li><span>在职状态：</span> <input type="text" name="employeeStatus" value="${employeeStatus}"/></li>
					<li><span>员工资料：</span> <input type="text" name="employeeInformation" value="${employeeInformation}"/>
						<button>
							<i class="icon iconfont icon-fangdajing"></i>
						</button></li>
				</form>
			</ul>
		</div>

		<!--第五排-->
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>员工管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="SystemEmployeeServlet.do?method=edit"> <i
						class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">员工_id</th>
							<th class="width_style5 bgcddd c666 ">员工名</th>
							<th class="width_style5 bgcddd c666 ">登录密码</th>
							<th class="width_style5 bgcddd c666 ">手机</th>
							<th class="width_style5 bgcddd c666 ">性别</th>
							<th class="width_style5 bgcddd c666 ">在职状态</th>
							<th class="width_style5 bgcddd c666 ">出生日期</th>
							<th class="width_style5 bgcddd c666 ">员工资料</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listSystemEmployee }" var="SystemEmployeeQueryView">
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<a
											href="SystemEmployeeServlet.do?method=edit&employeeId=${SystemEmployeeQueryView.employeeId }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="SystemEmployeeServlet.do?method=delete&employeeId=${SystemEmployeeQueryView.employeeId }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">${SystemEmployeeQueryView.employeeId }</td>
								<td class="bgc_f9 ">${SystemEmployeeQueryView.employeeName}</td>
								<td class="bgc_f9 ">${SystemEmployeeQueryView.employeePwd }</td>
								<td class="bgc_f9 ">${SystemEmployeeQueryView.employeePhone}</td>
								<td class="bgc_f9 ">${SystemEmployeeQueryView.employeeSex }</td>
								<td class="bgc_f9 ">${SystemEmployeeQueryView.dataDictonaryDetailLabel}</td>
								<td class="bgc_f9 ">${SystemEmployeeQueryView.employeeBirthday }</td>
								<td class="bgc_f9 ">${SystemEmployeeQueryView.employeeInformation}</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>