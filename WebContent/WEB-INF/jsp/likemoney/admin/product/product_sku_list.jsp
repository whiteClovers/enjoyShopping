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

				<form action="ProductSkuServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>评价数量：</span> <input type="text" name="evaluate_amount"/></li>
<!-- 					<li><span>品牌：</span> <input type="text" name="brand_name"/></li> -->
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
						<span>商品管理</span>
					</div>
					<div class="table_body_first_header_2">
						<a href="ProductSkuServlet.do?method=edit"><i class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i></a>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>
				<div class="table_body_first_body manage_index_new_style table_table4 ">
					<table border="" cellspacing="0">
						<thead>
							<tr>
								<th class="width_style5 bgcddd c666 "></th>
								<th class="width_style5 bgcddd c666 "> 商品编号</th>
								<th class="width_style5 bgcddd c666 "> 颜色</th>
								<th class="width_style5 bgcddd c666 "> 尺寸</th>
								<th class="width_style5 bgcddd c666 "> 库存数量</th>
								<th class="width_style5 bgcddd c666 "> 原价</th>
								<th class="width_style5 bgcddd c666 "> 原始图片</th>
								<th class="width_style5 bgcddd c666 "> 库存状态</th>
								<th class="width_style5 bgcddd c666 "> 上架状态</th>
								<th class="width_style5 bgcddd c666 "> 实际价格</th>
								<th class="width_style5 bgcddd c666 ">大图</th>
								<th class="width_style5 bgcddd c666 ">小图</th>
								<th class="width_style5 bgcddd c666 ">中图</th>
								<th class="width_style5 bgcddd c666 ">最大库存</th>
								<th class="width_style5 bgcddd c666 "> 最小库存</th>
								<th class="width_style5 bgcddd c666 "> 评价数量</th>
								<th class="width_style5 bgcddd c666 "> Sku编号</th>
								

							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listProductSku6 }" var="ProductSkuQueryView">
							<tr>
								<td class="bgc_f9 ">
									<!--<button class="button_style5 button_style8">
										<i class="icon iconfont icon-dui"></i>
									</button>-->
									<button class="button_style6">
									
										<a href="ProductSkuServlet.do?method=edit&product_sku_id=${ProductSkuQueryView.product_sku_id }">
										<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
									
										<a href="ProductSkuServlet.do?method=delete&product_sku_id=${ProductSkuQueryView.product_sku_id }">
										<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td style="display: none">${ProductSkuQueryView.product_sku_id}</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductSkuQueryView.product_code }</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductSkuQueryView.color_name }</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductSkuQueryView.size_name }</td>
								<td class="bgc_f9 c4a8bc2 ">${ProductSkuQueryView.product_sku_amount }</td>
								<td class="bgc_f9 ">${ProductSkuQueryView.product_sku_price }</td>
								<td class="bgc_f9 ">${ProductSkuQueryView.product_sku_img }</td>
								
								<td class="bgc_f9  ">${ProductSkuQueryView.product_sku_stock_label }</td>
								<td class="bgc_f9  ">${ProductSkuQueryView.product_shelf_status_label }</td>
								
								<td class="bgc_f9 ">${ProductSkuQueryView.product_sku_realPrice }</td>
								<td class="bgc_f9 ">${ProductSkuQueryView.product_sku_img_big }</td>
								<td class="bgc_f9  ">${ProductSkuQueryView.product_sku_img_small }</td>
								<td class="bgc_f9 ">${ProductSkuQueryView.product_sku_img_mid }</td>
								<td class="bgc_f9 ">${ProductSkuQueryView.product_stock_max }</td>
								<td class="bgc_f9  ">${ProductSkuQueryView.product_stock_min }</td>
								
								<td class="bgc_f9  ">${ProductSkuQueryView.evaluate_amount }</td>
								<td class="bgc_f9  ">${ProductSkuQueryView.product_sku_code }</td>
							

							</tr>
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</body>

</html>