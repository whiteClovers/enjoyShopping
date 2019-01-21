<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>数据字典详情</title>
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

				<span>数据字典管理</span>
			</div>
			<!--第二排-->
			<div class="index_input_body_second">
				<ul class="clearfix">

					<!-- <li>
						<form action="">
							<span>数据字典ID：</span>
							<input type="text" />

						</form>
					</li>-->
						<form action="DictionariesServlet.do?method=list" method="post">
							<li> 
									<span>英文：</span>
									<input type="text" name="code" value="${code }" />
		
							</li>
							<li>
									<span>中文：</span>
									<input type="text" name="label" value="${label}" />
									<button>
										<i class="icon iconfont icon-fangdajing"></i>
									</button>
							</li>
						</form>
				</ul>
			</div>
			
			<div class="table_body_first table_style2 border_style5">
				<div class="table_body_first_header bgc_f37b53  clearfix">
					<div class="table_body_first_header_1">
						<i class="icon iconfont icon-santiaogang"></i>
						<span>数据字典管理</span>
					</div>
					<div class="table_body_first_header_1">
						<a href="DictionariesServlet.action?method=edit">
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
										<a href="DictionariesServlet.action?method=edit">
											新增<!-- <i class="icon iconfont icon-bi"></i> -->
										</a>
									</button>
								</th>
								<th class="width_style5 bgcddd c666 "> 数据字典ID</th>
								<th class="width_style5 bgcddd c666 "> 英文</th>
								<th class="width_style5 bgcddd c666 "> 中文</th>
							</tr>
						</thead>
						
						<tbody>
						<c:forEach items="${list}" var="dic">
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<a href="DictionariesServlet.action?method=edit&id=${dic.id }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a href="DictionariesServlet.action?method=delete&id=${dic.id }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">${dic.id }</td>
								<td class="bgc_f9 ">${dic.dictCode }</td>
								<td class="bgc_f9 ">${dic.dictLabel }</td>
							</tr>
							</c:forEach>
						</tbody>
						
						<!-- <tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">2</td>
								<td class="bgc_f9 ">product_sku_stock</td>
								<td class="bgc_f9 ">库存状态</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">3</td>
								<td class="bgc_f9 ">customer_edu</td>
								<td class="bgc_f9 ">教育程度</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">4</td>
								<td class="bgc_f9 ">customer_vip</td>
								<td class="bgc_f9 ">会员等级</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">5</td>
								<td class="bgc_f9 ">customer_sex</td>
								<td class="bgc_f9 ">性别</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">6</td>
								<td class="bgc_f9 ">customer_marital_status</td>
								<td class="bgc_f9 ">婚姻状况</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">7</td>
								<td class="bgc_f9 ">customer_available_status</td>
								<td class="bgc_f9 ">可用状态</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">8</td>
								<td class="bgc_f9 ">address_default</td>
								<td class="bgc_f9 ">默认地址</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">9</td>
								<td class="bgc_f9 ">order_status</td>
								<td class="bgc_f9 ">订单付款状态</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">10</td>
								<td class="bgc_f9 ">order_detail_send</td>
								<td class="bgc_f9 ">是否发货</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">11</td>
								<td class="bgc_f9 ">order_detail_logistics</td>
								<td class="bgc_f9 ">物流状况</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">12</td>
								<td class="bgc_f9 ">order_detail_receive</td>
								<td class="bgc_f9 ">是否签收</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">13</td>
								<td class="bgc_f9 ">order_detail_evaluate</td>
								<td class="bgc_f9 ">是否进行评价</td>
							</tr>
							<tr>
						</tbody>
						<tbody>
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<i class="icon iconfont icon-bi"></i>
									</button>
									<button class="button_style7">
										<i class="icon iconfont icon-shanchu"></i>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">14</td>
								<td class="bgc_f9 ">order_detail_out</td>
								<td class="bgc_f9 ">是否出库</td>
							</tr>
							<tr>
						</tbody> -->
						
					</table>
					
				</div>
			</div>

		</div>
	</body>
</html>