<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta charset="UTF-8">
<title>入库列表页</title>

<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/index_input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/manage_table.css" />
</head>

<body>
	<div class="manage_table_all">

		<!--第一排-->
		<div class="index_input_body_first fsz28">

			<span>入库管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">
				<form action="StockInServlet.do?method=list" method="post">
					<li>
						<span>入库编号：</span>
						 <input type="text" style="width: 100px" name="code" value="${code }" />
					</li>
					<li>
						<span>入库时间：</span>
						 <input type="text" style="width: 100px" name="start" value="${start }" /> 
						 <span>~</span> 
						<input type="text" style="width: 100px" name="end" value="${end }" />
					</li>
					<li>
						<span>入库金额：</span> 
						<input type="text" style="width: 100px" name="pay" value="${pay}"/>
					</li>
					<li>
						<span>员工名称：</span>
						 <input type="text" style="width: 100px" name="empName" value="${empName }"/>
						<button>
							<i class="icon iconfont icon-fangdajing"></i>
						</button>
					</li>
				</form>
			</ul>
		</div>
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>入库管理</span>
				</div>
				<a href="StockInServlet.do?method=edit"> <!-- 新增	--> >>>新增
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 1440px">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 " style="width: 50px">
								<button class="button_style6">
									<a href="StockInServlet.do?method=edit" class="button_style6 ">
										新增 </a>	
								</button>
							</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px">入库id</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px">入库编号</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px">入库时间</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px">入库金额</th>
							<th class="width_style5 bgcddd c666 " style="width: 150px">员工名称</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${listStockIn}" var="stockIn">
							<tr>
								<td class="bgc_f9 ">
									<button class="button_style6">
										<a
											href="StockInServlet.do?method=edit&stockInId=${stockIn.stockInId}">
											<i class="icon iconfont icon-bi"></i>
										</a>
									</button>
									<button class="button_style7">
										<a
											href="StockInServlet.do?method=delete&stockInId=${stockIn.stockInId}">
											<i class="icon iconfont icon-shanchu"></i>
										</a>
									</button>

								</td>
								<td class="bgc_f9 c4a8bc2 ">${stockIn.stockInId}</td>
								<td class="bgc_f9 ">${stockIn.stockInCode}</td>
								<td class="bgc_f9 ">${stockIn.stockInTime}</td>
								<td class="bgc_f9  ">${stockIn.stockInPay}</td>
								<td class="bgc_f9 ">${stockIn.employeeName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>

</html>