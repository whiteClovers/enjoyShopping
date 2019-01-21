<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>入库详情编辑</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_comman.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index_input.css" />
		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
	</head>

	<body>
		<div class="index_input_all">
			<div class="index_input_body_third">
				<div class="index_input_body_third_header clearfix">
					<div class="index_input_body_third_header_1">
						<i class="icon iconfont icon-santiaogang"></i>
						<span>用户编辑</span>
					</div>
					<div class="index_input_body_third_header_2">
						<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>

				<div class="index_input_body_third_body">

					<form action="StockInDetailServlet.do" method="post">
						<input type="hidden" name="method" value="save" />
						<input type="hidden" name="stockIn_detail_id" value="${stockInDetail.stockIn_detail_id}" />
						<div class="index_input_body_third_body_all clearfix">
							<div class="index_input_body_third_body_1 clearfix" style="display:none">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库明细id:</div>
								<div>
									<input class="index_input_style1" type="text" id="stockIn_detail_id" name="stockIn_detail_id" value="${stockInDetail.stockIn_detail_id}" />
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">产品skuCode:</div>

								<div>
									<%-- <input class="index_input_style1" type="text" name="product_sku_id" value="${stockInDetail.product_sku_id}" /> --%>
									<select name="product_sku_id">
										<c:forEach items="${proList }" var="pro">
											<option value="${pro.product_sku_id }">${pro.product_sku_code }</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库明细数量:</div>
								<div>
									<input class="index_input_style1" type="text" name="stockIn_detail_amount" value="${stockInDetail.stockIn_detail_amount}" />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库明细价格：</div>
								<div>
									<input class="index_input_style1" type="text" name="stockIn_detail_price" value="${stockInDetail.stockIn_detail_price}" />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库Code：</div>
								<div>
									<%-- <input class="index_input_style1" type="text" name="stockIn_id" value="${stockInDetail.stockIn_id}" /> --%>
									<select name="stockIn_id">
										<c:forEach items="${stoList }" var="sto">
											<option value="${sto.stockInId }">${sto.stockInCode }</option>
										</c:forEach>
									</select>
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
		</div>
	</body>

</html>