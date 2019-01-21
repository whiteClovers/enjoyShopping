<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车编辑</title>

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

			<span>购物车管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">

				<form action="CartServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>客户名：</span> <input type="text" name="customer_name" value="${customer_name }" /></li>
					<li><span>选中状态：</span> <input type="text" name="car_select" value="${car_select }" /></li>
					<li><span>删除状态：</span> <input type="text" name="car_detect" value="${car_detect }" /></li>
					<button>
						<i class="icon iconfont icon-fangdajing"></i>
					</button>
				</form>
			</ul>
		</div>



		<!--第五排-->
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>订单管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="CartServlet.do?method=edit"> <i
						class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 1440px">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 " style="width: 50px"></th>
							<th class="width_style5 bgcddd c666 " style="width: 150px" >商品Sku编号</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px" >购物车添加日期</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px" >用户</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px" >选中状态</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px" >删除状态</th>
						</tr>
					</thead>
					<tbody>


						<c:forEach items="${listCart6 }" var="CartQueryView">
							<tr>
								<td class="bgc_f9 ">
									<!--<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>-->
									<button class="button_style6">
										<a
											href="CartServlet.do?method=edit&car_id=${CartQueryView.car_id }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="CartServlet.do?method=delete&car_id=${CartQueryView.car_id }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td style="display: none;">${CartQueryView.car_id }</td>
								<td class="bgc_f9 c4a8bc2 ">${CartQueryView.product_sku_code }</td>
								<td class="bgc_f9 ">${CartQueryView.car_date }</td>
								<td class="bgc_f9 ">${CartQueryView.customer_name }</td>
								<td class="bgc_f9  ">${CartQueryView.select_lable }</td>
								<td class="bgc_f9 ">${CartQueryView.delete_lable }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>