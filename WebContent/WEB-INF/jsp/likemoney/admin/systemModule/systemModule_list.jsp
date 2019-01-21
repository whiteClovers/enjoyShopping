<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>模块详情</title>
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

				<span>模块管理</span>
			</div>
			<!--第二排-->
			<div class="index_input_body_second">
				<ul class="clearfix">

					<!-- <li>
						<form action="">
							<span>模块ID：</span>
							<input type="text" />

						</form>
					</li> -->
					<li>
						<form action="SystemModuleServlet.do?method=list"  method="post">
							<span>模块名：</span>
								<input type="text" name="moduleName" value="${moduleName}"/>
							<button class="button_style6">
								<i class="icon iconfont icon-fangdajing"></i>
							</button>
						</form>
					</li>
				</ul>
			</div>
			
			<div class="table_body_first table_style2 border_style5">
				<div class="table_body_first_header bgc_f37b53  clearfix">
					<div class="table_body_first_header_1">
						<i class="icon iconfont icon-santiaogang"></i>
						<span>模块管理</span>
					</div>
					<div class="table_body_first_header_1">
						<a href="SystemModuleServlet.do?method=edit"><!-- 新增	-->
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
										<a href="SystemModuleServlet.do?method=edit"><!-- 新增	-->
											新增<!-- <i class="icon iconfont icon-bi"></i> -->
										</a>
									</button>
								</th>
								<th class="width_style5 bgcddd c666 "> 模块ID</th>
								<th class="width_style5 bgcddd c666 "> 模块名</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="sm"><!-- 修改  -->
								<tr>
									<td class="bgc_f9 ">
										<button class="button_style6">
											<a href="SystemModuleServlet.do?method=edit&moduleId=${sm.moduleId }"><!-- 修改  -->
												<i class="icon iconfont icon-bi"></i>
											</a>
										</button>
										<button class="button_style7"><!-- 修改  -->
							<!-- 修改  -->		<a href="SystemModuleServlet.do?method=delete&moduleId=${sm.moduleId }">										
												<i class="icon iconfont icon-shanchu"></i>
											</a>
										</button>
	
									</td>
									<td class="bgc_f9 c4a8bc2 ">${sm.moduleId }</td><!-- 修改  -->
									<td class="bgc_f9 ">${sm.moduleName }</td><!-- 修改  -->
								</tr>
							</c:forEach>
						</tbody>
						
						
					</table>
					
				</div>
			</div>

		</div>
	</body>
</html>