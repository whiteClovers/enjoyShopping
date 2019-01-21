<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/index_input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/manage_table.css" />
<title>角色管理</title>
</head>
<body>
	<div class="manage_table_all">

		<!--第一排-->
		<div class="index_input_body_first fsz28">

			<span>角色管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">
				<form action="SystemEmployeeRoleServlet.do" method="post">
				<input type="hidden" name="method" value="list" /> 
				
					<li><span>员工名：</span> <input type="text" name="emPloyeeName" value="${emPloyeeName}"/></li>
					<li><span> 角色名：</span> <input type="text" name="roleName" value="${roleName}"/>
						<button>
							<i class="icon iconfont icon-fangdajing"></i></li>
				</form>
			</ul>
		</div>
		<!--第五排-->
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>角色管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="SystemEmployeeRoleServlet.do?method=edit"> <i
						class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 800px;">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">员工角色id</th>
							<th class="width_style5 bgcddd c666 ">员工Name</th>
							<th class="width_style5 bgcddd c666 ">角色Name</th>



						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listSystemEmployeeRole }"
							var="SystemEmployeeRoleQueryView">
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<a
											href="SystemEmployeeRoleServlet.do?method=edit&emPloyeeRoleId=${SystemEmployeeRoleQueryView.emPloyeeRoleId }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="SystemEmployeeRoleServlet.do?method=delete&emPloyeeRoleId=${SystemEmployeeRoleQueryView.emPloyeeRoleId }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">${SystemEmployeeRoleQueryView.emPloyeeRoleId }</td>
								<td class="bgc_f9 ">${SystemEmployeeRoleQueryView.emPloyeeName}</td>
								<td class="bgc_f9 ">${SystemEmployeeRoleQueryView.roleName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>