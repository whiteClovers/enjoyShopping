<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/index_input.css" />

		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/WdatePicker.js"></script>
		<title>入库编辑</title>
	</head>

	<body>
		<div class="index_input_all">
			<!--第一排-->
		
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

				<div class="index_input_body_third_body">

					<form action="StockInServlet.do" method="post">
					<input type="hidden" name="method" value="save" />
					<input type="hidden" name="stockInId" value="${stockIn.stockInId}" />	
						<div class="index_input_body_third_body_all clearfix">
							<div class="index_input_body_third_body_1 clearfix" style="display:none">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库id:</div>

								<div>
									<input class="index_input_style1" type="text" name="stockInId" 
									value="${stockIn.stockInId}" />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库编号:</div>

								<div>
									<input class="index_input_style1"  name="stockInCode" value="${stockIn.stockInCode}"/>
								</div>
							</div>
							<div class="index_input_body_third_body_1 index_input_select2 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库时间:</div>
								<div>
									<input class="index_input_style1" onclick="WdatePicker({dateFmt:'yy-MM-dd HH:mm:ss'})"  name="stockInTime" value="${stockIn.stockInTime}"/>
								</div>
							</div>
							
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">入库金额:</div>

								<div>
									<input class="index_input_style1" type="text"  name="stockInPay" value="${stockIn.stockInPay}" />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">员工名称:</div>
								<%-- <div>
									<input class="index_input_style1" type="text"  name="employeeId" value="${stockIn.employeeId}"/>
								</div> --%>
								<select name="employeeId">
									<c:forEach items="${empList }" var="e">	
												<option value="${e.employeeId}">${e.employeeName }</option>
									</c:forEach>
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
					</form>
				</div>

			</div>
		</div>
	</body>

</html>