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

			<span>用户管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">

				<form action="OrderEvaluateServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>订单号：</span> <input type="text" name="order_code" /></li>
					<li><span>用户：</span> <input type="text" name="customer_name" /></li>
<!-- 					<li><span>出库状态：</span> <input type="text" -->
<!-- 						name="order_detail_out" /></li> -->
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
					<i class="icon iconfont icon-santiaogang"></i> <span>订单评价管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="OrderEvaluateServlet.do?method=edit"><i
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
							<th class="width_style5 bgcddd c666 ">评价日期</th>
							<th class="width_style5 bgcddd c666 ">评价内容</th>
							<th class="width_style5 bgcddd c666 ">图片地址</th>
							<th class="width_style5 bgcddd c666 ">服务态度</th>
							<th class="width_style5 bgcddd c666 ">评价数量</th>
							<th class="width_style5 bgcddd c666 ">差评数量</th>
							<th class="width_style5 bgcddd c666 ">好评数量</th>
							<th class="width_style5 bgcddd c666 ">中评数量</th>
							<th class="width_style5 bgcddd c666 ">订单详细编号</th>
							<th class="width_style5 bgcddd c666 ">物流速度</th>
							<th class="width_style5 bgcddd c666 ">商家描述</th>
							<th class="width_style5 bgcddd c666 ">用户</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOrderEvaluate6 }" var="OrderEvaluateQueryView">
							<tr>
								<td class="bgc_f9 ">
									<!--<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>-->
									<button class="button_style6">
									<a
											href="OrderEvaluateServlet.do?method=edit&evaluate_id=${OrderEvaluateQueryView.evaluate_id }">
										<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="OrderEvaluateServlet.do?method=delete&evaluate_id=${OrderEvaluateQueryView.evaluate_id }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td style="display: none">${OrderEvaluateQueryView.evaluate_id }</td>
								<td class="bgc_f9 c4a8bc2 ">${OrderEvaluateQueryView.evaluate_time }</td>
								<td class="bgc_f9 ">${OrderEvaluateQueryView.evaluate_message }</td>
								<td class="bgc_f9 ">${OrderEvaluateQueryView.evaluate_img }</td>
								<td class="bgc_f9  ">${OrderEvaluateQueryView.evaluate_service }</td>
								<td class="bgc_f9 ">${OrderEvaluateQueryView.evaluate_amount }</td>
								<td class="bgc_f9 ">${OrderEvaluateQueryView.evaluate_bad }</td>
								<td class="bgc_f9  ">${OrderEvaluateQueryView.evaluate_good }</td>
								<td class="bgc_f9 ">${OrderEvaluateQueryView.evaluate_common }</td>
								<td class="bgc_f9 ">${OrderEvaluateQueryView.order_detail_code }</td>
								<td class="bgc_f9 ">${OrderEvaluateQueryView.evaluate_speed }</td>
								<td class="bgc_f9  ">${OrderEvaluateQueryView.evaluate_describe }</td>
								<td class="bgc_f9  ">${OrderEvaluateQueryView.customer_name }</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>