<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺信息</title>

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

			<span>店铺信息管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">

				<form action="ProductStoreServlet.do" method="post">
				<input type="hidden" name="method" value="list" /> 
					<li><span>店铺名称：</span> <input type="text" name="storeName" value="${storeName}"/></li>
					<li><span>店铺信息：</span> <input type="text" name="storeMessage" value="${storeMessage}"/></li>
					<li><span>店主姓名：</span> <input type="text" name="customerName" value="${customerName}"/>
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
					<i class="icon iconfont icon-santiaogang"></i> <span>店铺管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="ProductStoreServlet.do?method=edit"> <i
						class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 1500px;">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">店铺id</th>
							<th class="width_style5 bgcddd c666 ">店铺名称</th>
							<th class="width_style5 bgcddd c666 ">店铺信息</th>
							<th class="width_style5 bgcddd c666 ">店主姓名</th>



						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listProductStore }" var="ProductStoreQueryView">
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<a
											href="ProductStoreServlet.do?method=edit&storeId=${ProductStoreQueryView.storeId }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="ProductStoreServlet.do?method=delete&storeId=${ProductStoreQueryView.storeId }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductStoreQueryView.storeId }</td>
								<td class="bgc_f9 ">${ProductStoreQueryView.storeName}</td>
								<td class="bgc_f9 ">${ProductStoreQueryView.storeMessage}</td>
								<td class="bgc_f9 ">${ProductStoreQueryView.customerName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>