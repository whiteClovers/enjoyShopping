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

<link href="${pageContext.request.contextPath}/img/login_logo.png" rel="SHORTCUT ICON" />
<script type="text/javascript" src="${pageContext.request.contextPath }/WdatePicker.js"></script>
<title>员工添加</title>
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
					<i class="icon iconfont icon-santiaogang"></i> <span>用户编辑</span>
				</div>
				<div class="index_input_body_third_header_2">

					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="SystemEmployeeServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> 
					<input type="hidden" name="employeeId" value="${systemEmployee.employeeId}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">员工id：</div>

							<div>
								<input class="index_input_style1" type="text"
									disabled="disabled" name="employeeId"
									value="${systemEmployee.employeeId }" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">员工名称：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="employeeName" value="${systemEmployee.employeeName }" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">登录密码：</div>

							<div>
								<input class="index_input_style1" type="text" name="employeePwd"
									value="${systemEmployee.employeePwd }" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">手机：</div>

							<div class="index_input_body_third_body_1_style1 clearfix">

								<div>
									<input style="width: 220px"
										class="index_input_style4 index_input_style3 " type="text"
										name="employeePhone" value="${systemEmployee.employeePhone}" />
									<i class="icon iconfont icon-shouji"></i>
								</div>

							</div>
						</div>
						<div
							class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">性别：</div>
							<div>
								<input class="index_input_style1" type="text" name="employeeSex"
									value="${systemEmployee.employeeSex}" />
							</div>

						</div>
						<div class="index_input_body_third_body_1 index_input_select1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">在职状态：</div>
							
								<select name="employeeStatus">
									<c:forEach items="${listDictionariesDetail }" var="DictionariesDetailQueryView">
										<option value="${DictionariesDetailQueryView.code}">${DictionariesDetailQueryView.label}</option>
									</c:forEach>
								</select>

						</div>
						<div
							class="index_input_body_third_body_1 index_input_select2 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">出生日期：</div>
							<div>
								<input class="index_input_style1" type="text"
									id="employeeBirthday" name="employeeBirthday" onclick="WdatePicker()"
									value="${systemEmployee.employeeBirthday}" />
							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">员工资料：</div>

							<div>
								<input class="index_input_style1" type="text"
									id="employeeInformation" name="employeeInformation"
									value="${systemEmployee.employeeInformation}" />
							</div>
						</div>
					</div>


					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
							<!-- 							<input type="hidden" name="method" value="save" />	 -->

							<button class="index_input_body_third_body_foot_btn1">
								提交</button>

							<button class="index_input_body_third_body_foot_btn2">

								取消</button>

						</div>

					</div>
				</form>
			</div>

		</div>
	</div>
</body>

</html>