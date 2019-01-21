<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_comman.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manage_table.css" />
<title>入库详情编辑</title>
</head>
<body>
	<div class="manage_table_all">

		<!--第一排-->
		<div class="index_input_body_first fsz28">

			<span>入库明细管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<form action="StockInDetailServlet.do?method=list" method="post">
				<span>产品sku编号：</span> <input type="text" style="width: 150px" name="skuCode" value="${skuCode }" />
				<span style="margin-left:25px">入库价格：</span> 
						<input type="text" style="width: 100px;" name="minPrice" value="${minPrice }" />
				<span>~</span> 
						<input type="text" style="width: 100px;" name="maxPrice" value="${maxPrice }" />		
				<span style="margin-left:25px">入库编号：</span> 
						<input type="text" style="width:150px" name="inCode" value="${inCode }" />
						
				<input type="submit" value="查询" style="width: 100px;float:right;height:35px"  />
			</form>
		</div>
		
		<!-- 
		<div class="index_input_body_second">
			<form action="StockInDetailServlet.do?method=list" method="post">
			
				<ul class="clearfix">
					<li>
						<span>产品sku编号：</span> 
						<input type="text" style="width: 150px" name="skuCode" value="${skuCode }" />
					</li>
					<li>
						<span>入库价格：</span> 
						<input type="text" style="width: 100px" name="minPrice" value="${minPrice }" />
						<span>~</span> 
						<input type="text" style="width: 100px" name="maxPrice" value="${maxPrice }" />
					</li>
					<li>
						<span>入库编号：</span> 
						<input type="text" style="width: 150px" name="inCode" value="${inCode }" />
						<button>
							<i class="icon iconfont icon-fangdajing"></i>
						</button>
					</li>
				</ul>
			</form>
		</div>
		 -->
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>入库明细管理</span>
					<a href="StockInDetailServlet.do?method=edit"> >>>新增 </a>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 1450px">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 " style="width: 70px">
								<button class="button_style6">
									<a href="StockInDetailServlet.do?method=edit"> 新增 </a>
								</button>
							</th>
							<th class="width_style5 bgcddd c666 ">入库明细id</th>
							<th class="width_style5 bgcddd c666 ">产品skuCode</th>
							<th class="width_style5 bgcddd c666 ">入库明细数量</th>
							<th class="width_style5 bgcddd c666 ">入库明细价格</th>
							<th class="width_style5 bgcddd c666 ">入库Code</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listStockInDetail}" var="stockInDetail">
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<a
											href="StockInDetailServlet.do?method=edit&stockIn_detail_id=${stockInDetail.stockIn_detail_id}">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="StockInDetailServlet.do?method=delete&stockIn_detail_id=${stockInDetail.stockIn_detail_id}">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>
								</td>
								<td class="bgc_f9 c4a8bc2 ">${stockInDetail.stockIn_detail_id}</td>
								<td class="bgc_f9 ">${stockInDetail.productSkuCode}</td>
								<td class="bgc_f9 ">${stockInDetail.stockIn_detail_amount}</td>
								<td class="bgc_f9  ">${stockInDetail.stockIn_detail_price}</td>
								<td class="bgc_f9 ">${stockInDetail.stockInCode}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>