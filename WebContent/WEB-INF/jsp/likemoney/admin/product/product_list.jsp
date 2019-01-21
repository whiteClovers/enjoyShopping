<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商品编辑</title>

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

				<span>商品管理</span>
			</div>
			<!--第二排-->
			<div class="index_input_body_second">
				<ul class="clearfix">

				<form action="ProductServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>衣服种类：</span> <input type="text" name="classfiy_small_name"/></li>
					<li><span>品牌：</span> <input type="text" name="brand_name"/></li>
					<li><span>商品编号：</span> <input type="text" name="product_code"/></li>
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
						<span>产品管理</span>
					</div>
					<div class="table_body_first_header_2">
						<a href="ProductServlet.do?method=edit"><i class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i></a>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>
				<div class="table_body_first_body manage_index_new_style table_table4 ">
					<table border="" cellspacing="0">
						<thead>
							<tr>
								<th class="width_style5 bgcddd c666 "></th>
								<th class="width_style5 bgcddd c666 "> 产品名称</th>
								<th class="width_style5 bgcddd c666 "> 商品编号</th>
								<th class="width_style5 bgcddd c666 "> 品牌名</th>
								<th class="width_style5 bgcddd c666 "> 评价数量</th>
								<th class="width_style5 bgcddd c666 "> 店铺名</th>
								<th class="width_style5 bgcddd c666 "> 衣服种类</th>
								<th class="width_style5 bgcddd c666 "> 好评数</th>
								<th class="width_style5 bgcddd c666 "> 差评数</th>
								<th class="width_style5 bgcddd c666 ">中评数</th>
								<th class="width_style5 bgcddd c666 ">上架状态</th>
								<th class="width_style5 bgcddd c666 ">上架时间</th>
								<th class="width_style5 bgcddd c666 ">商品图片</th>
								<th class="width_style5 bgcddd c666 "> 商品介绍</th>
								
								

							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listProduct6 }" var="ProductQueryView">
							<tr>
								<td class="bgc_f9 ">
									<!--<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>-->
									<button class="button_style6">
									<a
											href="ProductServlet.do?method=edit&product_id=${ProductQueryView.product_id }">
										<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
									<a
											href="ProductServlet.do?method=delete&product_id=${ProductQueryView.product_id }">
										<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td style="display: none">${ProductQueryView.product_id }</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductQueryView.product_name }</td>
								<td class="bgc_f9 ">${ProductQueryView.product_code }</td>
								<td class="bgc_f9 ">${ProductQueryView.brand_name }</td>
								<td class="bgc_f9 ">${ProductQueryView.evaluate_amount }</td>
								<td class="bgc_f9 ">${ProductQueryView.store_name }</td>
								<td class="bgc_f9 ">${ProductQueryView.classfiy_small_name }</td>
								<td class="bgc_f9  ">${ProductQueryView.evaluate_good }</td>
								<td class="bgc_f9 ">${ProductQueryView.evaluate_bad }</td>
								<td class="bgc_f9 ">${ProductQueryView.evaluate_common }</td>
								<td class="bgc_f9  ">${ProductQueryView.product_shelf_status }</td>
								<td class="bgc_f9 ">${ProductQueryView.product_shelf_time }</td>
								<td class="bgc_f9 ">${ProductQueryView.product_img }</td>
								<td class="bgc_f9  ">${ProductQueryView.product_introduce }</td>
								

							</tr>
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</body>

</html>