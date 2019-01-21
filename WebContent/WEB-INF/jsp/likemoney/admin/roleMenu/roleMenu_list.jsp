<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>角色菜单详情</title>

		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_comman.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_input.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manage_table.css" />
	</head>
	
	<body>
		<div class="manage_table_all">

			<!--第一排-->
			<div class="index_input_body_first fsz28">

				<span>角色菜单管理</span>
			</div>
			<!--第二排-->
			<div class="index_input_body_second">
				<ul class="clearfix">

					<!-- <li>
						<form action="">
							<span>角色菜单ID：</span>
							<input type="text" />

						</form>
					</li> -->
						<form action="SystemRoleMenuServlet.do?method=list" method="post">
								<li>
										<span>角色名称：</span>
										<input type="text" name="roleName" value="${roleName }"/>
			
								</li>
								<li>
										<span>菜单名称：</span>
										<input type="text" name="menuName" value="${menuName }"/>
										<button>
											<i class="icon iconfont icon-fangdajing"></i>
										</button>
								</li>
						</form>
				</ul>
			</div>
			
			<div class="table_body_first table_style2 border_style5">
				<div class="table_body_first_header bgc_f37b53  clearfix">
					<div class="table_body_first_header_1">
						<i class="icon iconfont icon-santiaogang"></i>
						<span>角色菜单管理</span>
					</div>
					<div class="table_body_first_header_1">
						<a href="SystemRoleMenuServlet.do?method=edit"><!-- 进行里修改 -->
							>>>新增
						</a>
					</div>
					<div class="table_body_first_header_2">
						<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>
				<div class="table_body_first_body manage_index_new_style table_table4 ">
					<table border="" cellspacing="0" style="width: 1610px;">
						<thead>
							<tr>
								<th class="width_style5 bgcddd c666 ">
									<button class="button_style6">
										<a href="SystemRoleMenuServlet.do?method=edit"><!-- 进行里修改 -->
											新增<!-- <i class="icon iconfont icon-bi"></i> -->
										</a>
									</button>
								</th>
								<th class="width_style5 bgcddd c666 "> 角色菜单ID</th>
								<th class="width_style5 bgcddd c666 "> 角色名称</th>
								<th class="width_style5 bgcddd c666 "> 菜单名称</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="rm">
								<tr>
									<td class="bgc_f9 ">
										<button class="button_style6">
											<a href="SystemRoleMenuServlet.do?method=edit&roleMenuId=${rm.roleMenuId }">
												<i class="icon iconfont icon-bi"></i>
											</a>
										</button>
										<button class="button_style7">
											<a href="SystemRoleMenuServlet.do?method=delete&roleMenuId=${rm.roleMenuId }">
												<i class="icon iconfont icon-shanchu"></i>
											</a>
										</button>
	
									</td>
									<td class="bgc_f9 c4a8bc2 ">${rm.roleMenuId }</td>
									<td class="bgc_f9 ">${rm.roleName }</td>
									<td class="bgc_f9 ">${rm.menuName }</td>
								</tr>
								<tr>
							</c:forEach>
						</tbody>
						
					</table>
					
				</div>
			</div>

		</div>
	</body>
</html>