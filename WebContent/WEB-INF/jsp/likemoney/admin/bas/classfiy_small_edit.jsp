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
<title>小类别添加</title>
</head>
<body>
	<div class="index_input_all">

		<div class="index_input_body_third">
			<div class="index_input_body_third_header clearfix">
				<div class="index_input_body_third_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>类别编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="classfiySmallId"
						value="${classfiySmall.classfiySmallId}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">小类id：</div>

							<div>
								<input class="index_input_style1" type="text"
									disabled="disabled" name="classfiySmallId"
									value="${classfiySmall.classfiySmallId}" />
							</div>
						</div>

						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">类别NAME：</div>

							<div>
								<select name=classfiyBigId>
									<c:forEach items="${listClassfiyBig }" var="classfiyBig">
										<option value="${classfiyBig.classfiyBigId}">${classfiyBig.classfiyBigName}</option>
									</c:forEach>
								</select>

							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">小类名称：</div>

							<div>
								<input class="index_input_style1" type="text"
									name="classfiySmallName"
									value="${classfiySmall.classfiySmallName}" />
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

				</form>
			</div>

		</div>
	</div>
</body>
</html>