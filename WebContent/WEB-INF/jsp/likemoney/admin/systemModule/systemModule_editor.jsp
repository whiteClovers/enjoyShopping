<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>模块编辑</title>
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

					<form action="SystemModuleServlet.do?method=save&moduleId=${module.moduleId }" method="post"><!-- 修改	 -->
						<div class="index_input_body_third_body_all clearfix">
							<div class="index_input_body_third_body_1 clearfix" style="display:${flag}">
								<div class="c888 fsz14 index_input_body_third_body_style1">模块ID：</div>

								<div>
				<!-- 修改 -->			<input class="index_input_style1" type="text" value="${module.moduleId}" /><!-- 修改	 -->
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">模块名：</div>

								<div>
									<input class="index_input_style1" type="text" name="moduleName" value="${module.moduleName }"/>
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