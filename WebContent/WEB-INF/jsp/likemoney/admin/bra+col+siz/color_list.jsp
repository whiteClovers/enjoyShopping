<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>颜色编辑</title>

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

			<span>颜色管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">

				<form action="ProductColorServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>颜色名：</span> <input type="text" name="color_name" /></li>


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
					<i class="icon iconfont icon-santiaogang"></i> <span>颜色管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="ProductColorServlet.do?method=edit"> <i
						class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 800px;">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">颜色</th>
							<!-- 								<th class="width_style5 bgcddd c666 "> 类型</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 "> 种类</th> -->


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listProductColor6 }" var="ProductColor">
							<tr>
								<td class="bgc_f9 "><a
									href="ProductColorServlet.do?method=edit&color_id=${ProductColor.color_id }">
										<button class="button_style6">
											<i class="icon iconfont icon-bi"></i>
										</button>
								</a> <a
									href="ProductColorServlet.do?method=delete&color_id=${ProductColor.color_id }">
										<button class="button_style7">
											<i class="icon iconfont icon-shanchu"></i>
										</button>
								</a></td>
								<td style="display: none">${ProductColor.color_id }</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductColor.color_name }</td>



							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>