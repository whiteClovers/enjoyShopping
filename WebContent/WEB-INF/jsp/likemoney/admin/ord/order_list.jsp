<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




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

			<span>订单管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">
				<form action="OrderServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>订单号：</span> <input type="text" name="order_code"/></li>
					<li><span>客户名：</span> <input type="text" name="customer_name"/></li>
					<li><span>订单状态：</span> <input type="text" name="order_status"/></li>
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
					<i class="icon iconfont icon-santiaogang"></i> <span>订单管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="OrderServlet.do?method=edit"> <i
						class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">订单号</th>
							<th class="width_style5 bgcddd c666 ">收货地址名称</th>
							<th class="width_style5 bgcddd c666 ">用户名称</th>
							<th class="width_style5 bgcddd c666 ">提交订单时间</th>
							<th class="width_style5 bgcddd c666 ">订单状态</th>
							<th class="width_style5 bgcddd c666 ">订单金额</th>
							<th class="width_style5 bgcddd c666 ">订单支付时间</th>
							<!-- 								<th class="width_style5 bgcddd c666 ">付款金额</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 ">是否发货</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 "> 物流状态</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 ">订单提交时间</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 ">订单评价</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 ">出库状态</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 ">出库时间</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 ">物流更新时间</th> -->
							<!-- 								<th class="width_style5 bgcddd c666 ">是否收货</th> -->

						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listOrder6 }" var="OrderQueryView">
							<tr>
								<td class="bgc_f9 ">
									<!--<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>-->
									<button class="button_style6">
										<a
											href="OrderServlet.do?method=edit&order_id=${OrderQueryView.order_id }&order_code=${OrderQueryView.order_code }&address_id=${OrderQueryView.address_id }&customer_id=${OrderQueryView.customer_id }&order_date=${OrderQueryView.order_date }&order_status=${OrderQueryView.order_status }&order_sum_money=${OrderQueryView.order_sum_money }&order_paydate=${OrderQueryView.order_paydate }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="OrderServlet.do?method=delete&order_id=${OrderQueryView.order_id }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td style="display: none">${OrderQueryView.order_id }</td>
								<td class="bgc_f9 c4a8bc2 ">${OrderQueryView.order_code }</td>
								<td class="bgc_f9 ">${OrderQueryView.address_name }</td>
								<td class="bgc_f9 ">${OrderQueryView.customer_name }</td>
								<td class="bgc_f9  ">${OrderQueryView.order_date }</td>
								<td class="bgc_f9 ">${OrderQueryView.dataDictonary_detail_label }</td>
								<td class="bgc_f9 ">${OrderQueryView.order_sum_money }</td>
								<td class="bgc_f9  ">${OrderQueryView.order_paydate }</td>
								<!-- 								<td class="bgc_f9 ">998.00</td> -->
								<!-- 								<td class="bgc_f9 ">已发货</td> -->
								<!-- 								<td class="bgc_f9  ">客户已签收</td> -->
								<!-- 								<td class="bgc_f9 ">2018-08-18</td> -->
								<!-- 								<td class="bgc_f9 ">未评价</td> -->
								<!-- 								<td class="bgc_f9  ">已出库</td> -->
								<!-- 								<td class="bgc_f9 ">2018-08-18</td> -->
								<!-- 								<td class="bgc_f9 ">2018-08-18</td> -->
								<!-- 								<td class="bgc_f9 ">是</td> -->

							</tr>
						</c:forEach>
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!-- 						<tr> -->
						<!-- 							<td class="bgc_f9 "> -->
						<!-- 								<button class="button_style5 button_style8">
<!-- 										<i class="icon iconfont icon-dui"></i> -->
						<!-- 									</button>-->
						-->
						<!-- 								<button class="button_style6"> -->
						<!-- 									<i class="icon iconfont icon-bi"></i> -->
						<!-- 								</button> -->
						<!-- 								<button class="button_style7"> -->
						<!-- 									<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 								</button> -->

						<!-- 							</td> -->
						<!-- 							<td class="bgc_f9 c4a8bc2 ">351465498112</td> -->
						<!-- 							<td class="bgc_f9 ">11644152</td> -->
						<!-- 							<td class="bgc_f9 ">98.00</td> -->
						<!-- 							<td class="bgc_f9  ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">3</td> -->
						<!-- 							<td class="bgc_f9 ">已付款</td> -->
						<!-- 							<td class="bgc_f9  ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">998.00</td> -->
						<!-- 							<td class="bgc_f9 ">已发货</td> -->
						<!-- 							<td class="bgc_f9  ">客户已签收</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">未评价</td> -->
						<!-- 							<td class="bgc_f9  ">已出库</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">2018-08-18</td> -->
						<!-- 							<td class="bgc_f9 ">是</td> -->

						<!-- 						</tr> -->
						<!--<tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr><tr>
								<td class="bgc_f9 ">
									<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">32212</td>
								<td class="bgc_f9 ">阮康</td>
								<td class="bgc_f9 ">1345114715</td>
								<td class="bgc_f9  ">13131313</td>
								<td class="bgc_f9 ">132311</td>
								<td class="bgc_f9 ">帅康</td>
								<td class="bgc_f9  ">男</td>
								<td class="bgc_f9 ">19950806</td>
								<td class="bgc_f9 ">1345114715@去qq.com</td>
								<td class="bgc_f9  ">15797816373</td>
								<td class="bgc_f9 ">...</td>
								<td class="bgc_f9 ">已婚</td>
								<td class="bgc_f9  ">本科</td>
								<td class="bgc_f9 ">99999999</td>
								<td class="bgc_f9 ">36xxxxxxxxxxxxxx32</td>
								<td class="bgc_f9 ">是</td>

							</tr>-->
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>