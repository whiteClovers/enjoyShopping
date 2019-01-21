<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/index_input.css" />

		<link href="${pageContext.request.contextPath}/img/login_logo.png" rel="SHORTCUT ICON" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/WdatePicker.js"></script>
		<title>关注管理</title>
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
						<i class="icon iconfont icon-santiaogang"></i>
						<span>用户编辑</span>
					</div>
					<div class="index_input_body_third_header_2">
						<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>

            <form action="UserAttentionServlet.do"method="post">
               <input type="hidden" name="method" value="save" />
				<input type="hidden" name="attentionId" value="${userAttention4.attentionId}" />
				<div class="index_input_body_third_body">
					
						<div class="index_input_body_third_body_all clearfix">
							

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">关注id：</div>

								<div>
									<input class="index_input_style1" type="text" name="bankName" value="${userAttention4.attentionId}"  />
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">商铺名：</div>

								<select name="store_id">
								<c:forEach items="${listProductStoreQueryView }" var="store">
									<option value="${store.storeId}">${store.storeName}</option>
								</c:forEach>
							    </select>
							
							</div>
<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">用户id：</div> -->

<!-- 								<div> -->
<%-- 									<input class="index_input_style1" type="text" name="customer_id" value="${bank4.bankType}" /> --%>
<!-- 							</div> -->
<!-- 							</div> -->
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">产品名：</div>
								<select name="product_id">
								<c:forEach items="${listProductQueryView }" var="product">
									<option value="${product.product_id}">${product.product_name}</option>
								</c:forEach>
							    </select>
							</div>
							
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">用户id：</div>
								<select name="customer_id">
								<c:forEach items="${listUserCustomer }" var="UserCustomer">
									<option value="${UserCustomer.customerId}">${UserCustomer.customerName}</option>
								</c:forEach>
							    </select>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">关注日期：</div>

								<div>
									<input class="index_input_style1" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"
									 type="text" name="bankName" value="${userAttention4.attentionDate}"  />
								</div>
							</div>
								</select>

							</div>
						</div>
				

					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
						   
							<button class="index_input_body_third_body_foot_btn1">
							提交
							</button>
					
							<button class="index_input_body_third_body_foot_btn2">
							取消
							</button>

						</div>

					</div>
				</div>
</form>
			</div>
		</div>
  	
</body>
</html>