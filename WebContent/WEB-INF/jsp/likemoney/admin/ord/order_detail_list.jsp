<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单编辑</title>

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

			<span>订单详细管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">

				<form action="OrderDetailServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>订单号：</span> <input type="text" name="order_code" /></li>
					<li><span>商品Sku号：</span> <input type="text"
						name="product_sku_code" /></li>
					<li><span>出库状态：</span> <input type="text"
						name="order_detail_out" /></li>
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
					<i class="icon iconfont icon-santiaogang"></i> <span>订单明细管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="OrderDetailServlet.do?method=edit"><i
						class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i></a> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">商品Sku编号</th>
							<th class="width_style5 bgcddd c666 ">实际价格</th>
							<th class="width_style5 bgcddd c666 ">商品数量</th>
							<th class="width_style5 bgcddd c666 ">发货状态</th>
							<th class="width_style5 bgcddd c666 ">物流状态</th>

							<th class="width_style5 bgcddd c666 ">签收状态</th>
							<th class="width_style5 bgcddd c666 ">评价日期</th>
							<th class="width_style5 bgcddd c666 ">评价状态</th>
							<th class="width_style5 bgcddd c666 ">订单号</th>
							<th class="width_style5 bgcddd c666 ">原价</th>
							<th class="width_style5 bgcddd c666 ">出库状态</th>
							<th class="width_style5 bgcddd c666 ">出库时间</th>
							<th class="width_style5 bgcddd c666 ">物流到达时间</th>
							<th class="width_style5 bgcddd c666 ">签收时间</th>
							<th class="width_style5 bgcddd c666 ">订单详细编号</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOrderDetail6 }" var="OrderDetailQueryView">
							<tr>
								<td class="bgc_f9 ">
									<!--<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>-->
									<button class="button_style6">
										<a
											href="OrderDetailServlet.do?method=edit&order_detail_id=${OrderDetailQueryView.order_detail_id }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="OrderDetailServlet.do?method=delete&order_detail_id=${OrderDetailQueryView.order_detail_id }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td style="display: none">${OrderDetailQueryView.order_detail_id }</td>
								<td class="bgc_f9 c4a8bc2 ">${OrderDetailQueryView.product_sku_code
									}</td>
								<td class="bgc_f9 c4a8bc2 ">${OrderDetailQueryView.product_sku_realPrice
									}</td>

								<td class="bgc_f9 ">${OrderDetailQueryView.order_detail_amount }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.dataDictonary_detail_label_send }</td>
								<td class="bgc_f9  ">${OrderDetailQueryView.dataDictonary_detail_label_logistics }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.dataDictonary_detail_label_receive }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.order_detail_evaluate_time }</td>
								<td class="bgc_f9  ">${OrderDetailQueryView.dataDictonary_detail_label_evaluate}</td>
								<td class="bgc_f9  ">${OrderDetailQueryView.order_code }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.product_sku_price }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.dataDictonary_detail_label_out }</td>
								<td class="bgc_f9  ">${OrderDetailQueryView.order_detail_outTime }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.order_detail_logistics_time }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.order_detail_receive_time }</td>
								<td class="bgc_f9 ">${OrderDetailQueryView.order_detail_code }</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>