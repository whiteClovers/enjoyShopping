<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>地址管理</title>

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

			<span>地址管理</span>
		</div>
		<!--第二排-->
		<form action="UserAddressServlet.do" method="post">
		<div class="index_input_body_second">
			<ul class="clearfix">
				<li>
					<form action="">
						<span>地址名：</span> <input type="text" name="addressName" value="${addressName}"  />

					</form>
				</li>
				<li>
					<form action="">
						<span>收货人：</span> <input type="text" name="addressConsignee" value="${addressConsignee} "/>
						<button>
							<i class="icon iconfont icon-fangdajing"></i>
						</button>
					</form>
				</li>
			</ul>
		</div>
		</form>
		<!--第五排-->
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>地址管理</span>
				</div>
				<div class="table_body_first_header_2">
				<a href="UserAddressServlet.do?method=edit">
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
							<th class="width_style5 bgcddd c666 ">地址id</th>
							<th class="width_style5 bgcddd c666 ">地址名称</th>
							<th class="width_style5 bgcddd c666 ">电话</th>
							<th class="width_style5 bgcddd c666 ">签收人</th>
							<th class="width_style5 bgcddd c666 ">email</th>
							<th class="width_style5 bgcddd c666 ">邮编</th>
							<th class="width_style5 bgcddd c666 ">用户·id</th>
							<th class="width_style5 bgcddd c666 ">发源地</th>
							<th class="width_style5 bgcddd c666 ">默认地址</th>



						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUserAddress6}" var="UserAddress">
							<tr>
								<td class="bgc_f9 ">
								<a href="UserAddressServlet.do?method=edit&addressId6=${UserAddress.addressId}">
										<button class="button_style5 button_style8">
											<i class="icon iconfont icon-dui"></i>
										</button>
								</a>
								<a href="UserAddressServlet.do?method=delete&addressId6=${UserAddress.addressId}">
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button></td>
								</a>	
								<td class="bgc_f9 c4a8bc2 ">${UserAddress.addressId}</td>
								<td class="bgc_f9 ">${UserAddress.addressName}</td>
								<td class="bgc_f9 ">${UserAddress.addressPhone}</td>
								<td class="bgc_f9 ">${UserAddress.addressConsignee}</td>
								<td class="bgc_f9 ">${UserAddress.addressEmail}</td>
								<td class="bgc_f9 ">${UserAddress.addressCode}</td>
								<td class="bgc_f9 ">${UserAddress.customerId}</td>
								<td class="bgc_f9 ">${UserAddress.addressRegion}</td>
								<td class="bgc_f9 ">${UserAddress.addressDefault}</td>


							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

	</div>

</body>
</html>