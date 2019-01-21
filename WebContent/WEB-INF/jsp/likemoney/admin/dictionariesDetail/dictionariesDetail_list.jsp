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
		
		<script type="text/javascript">
			function goPage(pageIndex) {
				
				document.getElementById('pageIndex').value = pageIndex;
				document.getElementById('fromDetail').submit();
				
			}
		</script>
		
	</head>
	<body>
		<div class="manage_table_all">

			<!--第一排-->
			<div class="index_input_body_first fsz28">

				<span>数据字典明细</span>
				<c:forEach begin="0" end="${pageView.pageCount-1 }" varStatus="status" >
					<a style="color: blue"  href="javascript:goPage(${status.index })">${status.index + 1}</a>
				</c:forEach>
			</div>
			<!--第二排-->
			<div class="index_input_body_second">
				<ul class="clearfix">

	<form action="DictionariesServletDetail.do?method=list"  method="post" id="fromDetail">
			
		<input type="hidden" name="pageIndex" id="pageIndex" value="${studentConditionView.pageIndex }" />
		
		<select name="pageSize" id="size">
			<c:forEach begin="5" end="20" step="5" varStatus="status">
				<option <c:if test="${status.index==pageView.pageSize}">selected="selected" </c:if> >
					${status.index }
				</option>
			</c:forEach>
		</select>
		
		
			<li>
					<span>明细英文：</span>
					<input type="text" style="width:150px" name="code" value="${studentConditionView.code }"/>
					<button>
						<i class="icon iconfont icon-fangdajing"></i>
					</button>
			</li>
			<li>
					<span>明细中文：</span>
					<input type="text" style="width:150px" name="label" value="${studentConditionView.label }"/>
			</li>
	</form>
		</ul>
			</div>
			
			<div class="table_body_first table_style2 border_style5">
				<div class="table_body_first_header bgc_f37b53  clearfix">
					<div class="table_body_first_header_1">
						<i class="icon iconfont icon-santiaogang"></i>
						<span>数据字典明细管理</span>
					</div>
					<div class="table_body_first_header_1">
						<a href="DictionariesServletDetail.action?method=edit&detailId=${dic.detailId }">
							>>>新增
						</a>
					</div>
					<div class="table_body_first_header_2">
						<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i>
						<i class="icon iconfont icon-cha"></i>
					</div>
				</div>
				<div class="table_body_first_body manage_index_new_style table_table4 ">
					<table border="" cellspacing="0" style="width: 1610px;">
						<thead>
							<tr>
								<th class="width_style5 bgcddd c666 ">
						<!-- 修改	 -->	<a href="DictionariesServletDetail.action?method=edit&detailId=${dic.detailId }">
											<button class="button_style6">
											新增<!-- <i class="icon iconfont icon-bi"></i> -->
											</button>
										</a>
								</th>
								<th class="width_style5 bgcddd c666 "> 数据字典明细ID</th>
								<th class="width_style5 bgcddd c666 "> 数据字典Code</th>
								<th class="width_style5 bgcddd c666 "> 数据字典名称</th>
								<th class="width_style5 bgcddd c666 "> 明细英文</th>
								<th class="width_style5 bgcddd c666 "> 明细中文</th>
								<th class="width_style5 bgcddd c666 "> 同一字典ID顺序</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageView.list }" var="dic">
								<tr>
									<td class="bgc_f9 ">
										<button class="button_style6">
						<!-- 修改	 -->		<a href="DictionariesServletDetail.action?method=edit&detailId=${dic.detailId }">
												<i class="icon iconfont icon-bi"></i>
											</a>
										</button>
						<!-- 修改	 -->	<button class="button_style6">
											<a href="DictionariesServletDetail.action?method=delete&detailId=${dic.detailId }">
												<i class="icon iconfont icon-shanchu"></i>
											</a>
										</button>
	
									</td>
									<td class="bgc_f9 c4a8bc2 ">${dic.detailId }</td>
									<td class="bgc_f9 ">${dic.dictCode }</td>
									<td class="bgc_f9 ">${dic.dictLabel }</td>
									<td class="bgc_f9 ">${dic.code }</td>
									<td class="bgc_f9 ">${dic.label }</td>
									<td class="bgc_f9 ">${dic.num }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
					
					<%-- <c:forEach begin="0" end="${pageView.pageCount-1 }" varStatus="status">
						<a href="javascript:goPage(${status.index })">${status.index + 1}</a>
					</c:forEach> --%>
					
				</div>
			</div>

		</div>
		
	</body>
</html>