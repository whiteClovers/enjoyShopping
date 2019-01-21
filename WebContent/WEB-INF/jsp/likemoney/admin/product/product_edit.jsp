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
<script type="text/javascript" src="${pageContext.request.contextPath }/WdatePicker.js"></script>
<title>产品增改</title>
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
					<i class="icon iconfont icon-santiaogang"></i> <span>产品编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="ProductServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="product_id" value="${Product4.product_id}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">产品id</div>

							<div>
								<input class="index_input_style1" type="text" name="product_id"
									id="product_id" disabled="disabled"
									value="${Product4.product_id}" />

							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">产品名称</div>

							<div>
								<input class="index_input_style1" type="text"
									name="product_name" id="product_name" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">产品编号：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="product_code" id="product_code" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">品牌：</div>

							<select name="brand_id">
								<c:forEach items="${listProductBrand6 }" var="ProductBrand">
									<option value="${ProductBrand.brand_id}">${ProductBrand.brand_name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">评价数量：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_amount" id="evaluate_amount" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">店铺：</div>

							<select name="store_id">
								<c:forEach items="${listProductStore6 }" var="ProductStoreQueryView">
									<option value="${ProductStoreQueryView.storeId}">${ProductStoreQueryView.storeName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">服装种类：</div>

							<select name="classfiy_small_id">
								<c:forEach items="${listClassfiySmall6 }" var="ClassfiySmallQueryView">
									<option value="${ClassfiySmallQueryView.classfiySmallId}">${ClassfiySmallQueryView.classfiySmallName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">好评数：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_good" id="evaluate_good" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">差评数：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_bad" id="evaluate_bad" />
							</div>
						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">中评数：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="evaluate_common" id="evaluate_common" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select2 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">上架状态：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="product_shelf_status" id="product_shelf_status" />
							</div>
						</div>


						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">上架时间：</div>

							<div class="index_input_body_third_body_1_style1 clearfix">

								<div>
									<input style="width: 220px"
										class="index_input_style4 index_input_style3" type="text" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
										name="product_shelf_time" id="product_shelf_time" />
								</div>

							</div>
						</div>




						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">商品图片：</div>
							<div>
								<input class="index_input_style1" type="text" name="product_img"
									id="product_img" />
							</div>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">商品介绍：</div>
							<div>
								<input class="index_input_style1" type="text"
									name="product_introduce" id="product_introduce" />
							</div>

						</div>



					</div>


					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
							<button class="index_input_body_third_body_foot_btn1">
								提交</button>
							<button class="index_input_body_third_body_foot_btn2">
								取消</button>

						</div>

					</div>
			</div>
			</form>
		</div>
	</div>
</body>

</html>