<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
权限列表：
<div style="width:180px;text-align: left;margin-left: 30px;">
	
		<ul>
			<c:forEach items="${listMenuQuery }" var="list">
				<li><a href="${pageContext.request.contextPath}/${list.url}" target="_blank">${list.menuName }</a></li>
				
			</c:forEach>
			
			
			<li class="mar_le20">
				<a href="${pageContext.request.contextPath}/AdminLogoutServlet.do" >注销</a>
			</li>
		</ul>
</div>
</body>
</html>