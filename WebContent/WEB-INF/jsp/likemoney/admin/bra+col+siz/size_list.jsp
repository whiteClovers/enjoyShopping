<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>尺码编辑</title>

		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/login.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/index_input.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/manage_table.css" />
	</head>

	<body>
		<div class="manage_table_all">

			<!--第一排-->
			<div class="index_input_body_first fsz28">

				<span>尺码管理</span>
			</div>
			<!--第二排-->
			<div class="index_input_body_second">
				<ul class="clearfix">

				<form action="ProductSizeServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>尺寸名：</span> <input type="text" name="size_name" /></li>
					
					
					<button>
						<i class="icon iconfont icon-fangdajing"></i>
					</button>
				</form>
				</ul>
			</div>
			<!--			
			<!--第三排
			
			
				-->
			<!--第五排-->
			<div class="table_body_first table_style2 border_style5">
				<div class="table_body_first_header bgc_f37b53  clearfix">
					<div class="table_body_first_header_1">
						<i class="icon iconfont icon-santiaogang"></i>
						<span>用户管理</span>
					</div>
					<div class="table_body_first_header_2">
					<a href="ProductSizeServlet.do?method=edit">
						<i class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i>
						</a>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>
				<div class="table_body_first_body manage_index_new_style table_table4 ">
					<table border="" cellspacing="0" style="width:800px;">
						<thead>
							<tr>
								<th class="width_style5 bgcddd c666 "></th>
								<th class="width_style5 bgcddd c666 "> 尺码</th>
<!-- 								<th class="width_style5 bgcddd c666 "> 类型</th> -->
<!-- 								<th class="width_style5 bgcddd c666 "> 种类</th> -->


							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listProductSize6 }" var="ProductSize">
							<tr>
								<td class="bgc_f9 ">
									<a href="ProductSizeServlet.do?method=edit&size_id=${ProductSize.size_id }">
										<button class="button_style6">
											<i class="icon iconfont icon-bi"></i>
										</button>
									</a>
									<a href="ProductSizeServlet.do?method=delete&size_id=${ProductSize.size_id }">
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>
									</a>
								</td>
								<td style="display:none">${ProductSize.size_id }</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductSize.size_name }</td>
							

							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</body>

</html>