<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>数据字典明细编辑</title>
		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_comman.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_input.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manage_table.css" />
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
					<!-- -这里删除了&dictCode=${dictionariesDetail.dictCode}- -->
					<form action="DictionariesServletDetail.do?method=save&detailId=${dictionariesDetail.detailId} " method="post"><!-- 可以传对象,然后获得属性值 -->
						<div class="index_input_body_third_body_all clearfix">
							<div class="index_input_body_third_body_1 clearfix" style="display:${flag}">
								<div class="c888 fsz14 index_input_body_third_body_style1">字典明细ID：</div>

								<div>
					<!-- 修改	 -->	<input class="index_input_style1" type="text" value="${dictionariesDetail.detailId}" readonly="readonly" /><!-- 修改	 -->
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">数据字典名称：</div>

								<div>
									<%-- <input class="index_input_style1" type="text" value="${dictionariesDetail.dictonaryId}" name="id" " /><!-- 修改	 --> --%>
									<select name="id">
										<c:forEach items="${dictList}" var="dict">	
												<option value="${dict.id}" <c:if test="${dictionariesDetail.dictCode == dict.dictCode}">selected="selected"</c:if> >${dict.dictLabel}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">明细英文：</div>

								<div>
									<input class="index_input_style1" value="${dictionariesDetail.code}" name="code"/>
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">明细中文：</div>

								<div>
									<input class="index_input_style1"  value="${dictionariesDetail.label}" name="label"/>
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1" style="font-size:12px">数据字典Code：</div>

								<div>
									<select name="dictCode">
										<c:forEach items="${dictList}" var="dict">	
												<option value="${dict.dictCode}" <c:if test="${dictionariesDetail.dictCode == dict.dictCode}">selected="selected"</c:if> >${dict.dictCode}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">同一ID顺序：</div>

								<div>
									<input class="index_input_style1"  value="${dictionariesDetail.num}" name="num"/>
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