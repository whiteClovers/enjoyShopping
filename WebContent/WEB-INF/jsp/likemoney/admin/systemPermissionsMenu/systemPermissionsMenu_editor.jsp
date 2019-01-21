<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>菜单编辑</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_comman.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index_input.css" />
		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />	
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

				<div class="index_input_body_third_body">
					<form action="SystemMenuServlet.do?method=save&menuId=${menu.menuId}" method="post"><!-- 修改 -->
						<div class="index_input_body_third_body_all clearfix">
							<div class="index_input_body_third_body_1 clearfix" style="display:${flag}">
								<div class="c888 fsz14 index_input_body_third_body_style1">菜单ID：</div>

								<div>
									<input class="index_input_style1" type="text" value="${menu.menuId}" /><!-- 修改 -->
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">菜单名：</div>

								<div>
									<input class="index_input_style1" type="text" name="menuName" value="${menu.menuName}" />
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">模块名：</div>

								<div>
									<%-- <input class="index_input_style1" type="text" name="moduleId" value="${menu.moduleId}"/> --%>
									<select name="moduleId">
										<c:forEach items="${moduleList}" var="module">	
												<option value="${module.moduleId}">${module.moduleName}</option>
										</c:forEach>
									</select>
								</div>
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