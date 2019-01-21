<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>菜单详情</title>
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

				<span>菜单管理</span>
			</div>
			<!--第二排-->
			<div class="index_input_body_second">
				<ul class="clearfix">

					<!-- <li>
						<form action="">
							<span>菜单ID：</span>
							<input type="text" />

						</form>
					</li> -->
					<li>
						<form action="SystemMenuServlet.do?method=edit"  method="post">
							<span>菜单名：</span>
							<input type="text" name="menuName" value="${menuName}" />
							<button>
								<i class="icon iconfont icon-fangdajing"></i>
							</button>
						</form>
					</li>
					<!-- <li>
						<form action="">
							<span>模块ID：</span>
							<input type="text" />
							<button>
								<i class="icon iconfont icon-fangdajing"></i>
							</button>
						</form>
					</li> -->
				</ul>
			</div>
			
			<div class="table_body_first table_style2 border_style5">
				<div class="table_body_first_header bgc_f37b53  clearfix">
					<div class="table_body_first_header_1">
						<i class="icon iconfont icon-santiaogang"></i>
						<span>菜单管理</span>
					</div>
					<div class="table_body_first_header_1">
						<a href="SystemMenuServlet.do?method=edit"><!-- 修改 -->
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
						<!-- 修改  -->		<a href="SystemMenuServlet.do?method=edit"><!-- 修改 -->
											新增<!-- <i class="icon iconfont icon-bi"></i> -->
										</a>
									</button>
								</th>
								<th class="width_style5 bgcddd c666 "> 菜单ID</th>
								<th class="width_style5 bgcddd c666 "> 菜单名</th>
								<th class="width_style5 bgcddd c666 "> 模块名</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="ms"><!-- 修改  -->
								<tr>
									<td class="bgc_f9 ">
										<button class="button_style6"><!-- 修改  -->
								<!-- 修改  -->	<a href="SystemMenuServlet.do?method=edit&menuId=${ms.menuId }">
												<i class="icon iconfont icon-bi"></i><!-- 修改  -->
											</a>
										</button>
										<button class="button_style7"><!-- 修改  -->
											<a href="SystemMenuServlet.do?method=delete&menuId=${ms.menuId}">
												<i class="icon iconfont icon-shanchu"></i><!-- 修改  -->
											</a>
										</button>
	
									</td>
									<td class="bgc_f9 c4a8bc2 ">${ms.menuId }</td><!-- 修改  -->
									<td class="bgc_f9 ">${ms.menuName }</td><!-- 修改  -->
									<td class="bgc_f9 ">${ms.moduleName }</td><!-- 修改  -->
								</tr>
							</c:forEach>
						</tbody>
						
					</table>
					
				</div>
			</div>

		</div>
	</body>
</html>