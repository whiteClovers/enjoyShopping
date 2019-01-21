<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>类别信息</title>
<link href="img/login_logo.png" rel="SHORTCUT ICON" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/index_input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/manage_table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body>
	<div class="manage_table_all">

		<!--第一排-->
		<div class="index_input_body_first fsz28">

			<span>类别信息管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">


				<li>
					<form action="ClassfiyBigServlet.do" method="post">
					<input type="hidden" name="method" value="list" /> 
						<span> 类别名称：</span> <input type="text" name="classfiyBigName" value="${classfiyBigName}" />
						<button>
							<i class="icon iconfont icon-fangdajing"></i>
						</button>
					</form>
				</li>
			</ul>
		</div>
		<!--第五排-->

		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>类别管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="ClassfiyBigServlet.do?method=edit"> <i
						class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 800px;">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">类别id</th>
							<th class="width_style5 bgcddd c666 ">类别名称</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listClassfiyBig }" var="classfiyBig">
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<a
											href="ClassfiyBigServlet.do?method=edit&classfiyBigId=${classfiyBig.classfiyBigId }">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="ClassfiyBigServlet.do?method=delete&classfiyBigId=${classfiyBig.classfiyBigId }">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">${classfiyBig.classfiyBigId }</td>
								<td class="bgc_f9 ">${classfiyBig.classfiyBigName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>