<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/login.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/index_input.css" />

<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
<title>产品SKU增改</title>
</head>

<body>
	<div class="index_input_all">
		<!--第一排-->
		<!--<div class="index_input_body_first fsz28">

				<span>用户编辑</span>
			</div>-->
		<!--第二排-->

		<!--第三排-->
		<div class="index_input_body_third">
			<div class="index_input_body_third_header clearfix">
				<div class="index_input_body_third_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>产品SKU编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="ProductSkuServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="product_sku_id"
						value="${ProductSku4.product_sku_id}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">产品id</div>

							<div>
								<input class="index_input_style1" type="text"
									name="product_sku_id" id="product_sku_id" disabled="disabled"
									value="${ProductSku4.product_sku_id}" />

							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">商品编号</div>

								<select name="product_id">
								<c:forEach items="${listProduct6 }" var="ProductQueryView">
									<option value="${ProductQueryView.product_id}">${ProductQueryView.product_code}</option>
								</c:forEach>
							</select>
							
					
					</div>
					<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">颜色</div>

								<select name="color_id">
								<c:forEach items="${listProductColor6 }" var="ProductColor">
									<option value="${ProductColor.color_id}">${ProductColor.color_name}</option>
								</c:forEach>
							</select>
							
					
					</div>
					<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">尺寸</div>

								<select name="size_id">
								<c:forEach items="${listProductSize6 }" var="ProductSize">
									<option value="${ProductSize.size_id}">${ProductSize.size_name}</option>
								</c:forEach>
							</select>
							
					
					</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">库存数量</div>

								<div>
									<input class="index_input_style1" type="text"  name="product_sku_amount"
									id="product_sku_amount"/>
								</div>
							
					
					</div>

					<div class="index_input_body_third_body_1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">原价：</div>

						<div>
							<input class="index_input_style1" type="text"
								name="product_sku_price" id="product_sku_price" />
						</div>
					</div>

					<div class="index_input_body_third_body_1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">原始图片：</div>

						<div>
							<input class="index_input_style1" type="text"
								name="product_sku_img" id="product_sku_img" />
						</div>
					</div>
					<!-- 中文字段 -->
					<div class="index_input_body_third_body_1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">库存状态：</div>

						<div>
							<!-- <input class="index_input_style1" type="text"
								name="product_sku_stock" id="product_sku_stock" /> -->
									<select name="product_sku_stock" var="">
										<c:forEach items="${findBySkuStock }" var="list">
											<%-- <c:if test="${product_sku_stock==good in stock}" /> --%>
											<option value="${list.code }">${list.label }</option>
										</c:forEach>
									</select>
						</div>
					</div>
					
					<div class="index_input_body_third_body_1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">上架状态：</div>

						<div>
							<!-- <input class="index_input_style1" type="text"
								name="product_sku_stock" id="product_sku_stock" /> -->
									<select name="product_sku_stock" var="">
										<c:forEach items="${findByShelfStatus }" var="list">
											<%-- <c:if test="${product_shelf_status==on}" />  --%>
											<option value="${list.code }">${list.label }</option>
										</c:forEach>
									</select>
						</div>
					</div>
					
					<div class="index_input_body_third_body_1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">实际价格：</div>

						<div>
							<input class="index_input_style1" type="text"
								name="product_sku_realPrice" id="product_sku_realPrice" />
						</div>
					</div>
					<div
						class="index_input_body_third_body_1 index_input_select1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">大图：</div>
						<div>
							<input class="index_input_style1" type="text"
								name="product_sku_img_big" id="product_sku_img_big" />
						</div>

					</div>
					<div
						class="index_input_body_third_body_1 index_input_select2 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">小图：</div>
						<div>
							<input class="index_input_style1" type="text"
								name="product_sku_img_small" id="product_sku_img_small" />
						</div>
					</div>


					<div class="index_input_body_third_body_1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">中图：</div>

						<div class="index_input_body_third_body_1_style1 clearfix">

							<div>
								<input style="width: 220px"
									class="index_input_style4 index_input_style3" type="text"
									name="product_sku_img_mid" id="product_sku_img_mid" />
							</div>

						</div>
					</div>




					<div
						class="index_input_body_third_body_1 index_input_select1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">最大库存：</div>
						<div>
							<input style="width: 220px"
								class="index_input_style4 index_input_style3" type="text"
								name="product_stock_max" id="product_stock_max" />
						</div>

					</div>
					<div
						class="index_input_body_third_body_1 index_input_select1 clearfix">
						<div class="c888 fsz14 index_input_body_third_body_style1">最小库存：</div>
						<div>
							<input style="width: 220px"
								class="index_input_style4 index_input_style3" type="text"
								name="product_stock_min" id="product_stock_min" />
						</div>

					</div>
					
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价数量</div>

							<select name="evaluate_id">
								<c:forEach items="${listOrderEvaluate6 }" var="OrderEvaluateQueryView">
									<option value="${OrderEvaluateQueryView.evaluate_id}">${OrderEvaluateQueryView.evaluate_amount}</option>
								</c:forEach>
							</select>
							<%-- <select name="evaluate_id">
								<c:forEach items="${listProductSku6 }" var="ProductSkuQueryView">
									<option value="${ProductSkuQueryView.evaluate_id}">${ProductSkuQueryView.evaluate_amount}</option>
								</c:forEach>
							</select> --%>
							
					
					</div>
					<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">Sku编号：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="product_sku_code" id="product_sku_code" />
							</div>

						</div>
			</div>


			<div class="index_input_body_third_body_foot">
				<div class="index_input_body_third_body_foot_btnall">
					<button class="index_input_body_third_body_foot_btn1">提交</button>
					<button class="index_input_body_third_body_foot_btn2">取消</button>

				</div>

			</div>
		</div>
		</form>
	</div>
	</div>
</body>

</html>