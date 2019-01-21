<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台管理系统登录页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/manage_comman.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin_css/login.css" />
		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
	</head>

	<body bgcolor="#393939">
		<!--页面主体div-->
		<div class="login_all">
			<!--上方logodiv-->
			<div class="login_logo">
				<a href="">
					<img src="${pageContext.request.contextPath}/admin_img/login_logo.png" />
				</a>
			</div>
			<div class="login_frame clearfix">
				<!--登录-->
				
				<div class="login_loginlock square">
					<i class="icon iconfont icon-lock fsz60"></i>
					<span class="fsz20">登录</span>
				</div>
				
				<form action="LoginAdmin.do" method="post">
				<input type="hidden" name="method" value="loginAdmin" />
				<!--username-->
				<div>
					<div class="rectangle login_input_username"style="float:left;">
	
							<div class="login_input_div">
								<input type="text" name="username" />
							</div>
	<!-- 					</form> -->
					</div>
					<!--password-->
					<div class="rectangle login_input_pwd"style="float:left;">
	<!-- 					<form action="LoginBackServlet.do" method="post" target="_blank"> -->
							<div class="login_input_div">
								<input type="password" name="password"  />
							</div>
	<!-- 					</form> -->
					</div>
					<!--登录go-->
					<div class="square login_logingo"style="float:left;">
	<!-- 					<form action="LoginBackServlet.do" method="post" target="_blank">  -->
							<input type="submit" value="登录" class="login_btn1 clearfix">
								<i class="icon iconfont icon-youjiantou"></i>
								
					</div>
				</div>
				
				</form>
				
				<!--facebooklogin-->
				<div class="rectangle login_facebookgo fsz20">
					<a href="index.html">
						<i class="icon iconfont icon-facebook fsz28"></i>
						<span>Facebook登录</span>
					</a>
				</div>
				<!--geoglelogin-->
				<div class="square login_geoglego fsz20">
					<a href="index.html">
						<i class="icon iconfont icon-google fsz28"></i>
						<span>Google 登录</span>
					</a>
				</div>
				<!--twitterlogin-->
				<div class="rectangle login_twittergo fsz20">
					<a href="index.html">
						<i class="icon iconfont icon-twitter fsz28"></i>
						<span>Twitter 登录</span>
					</a>
				</div>
				<!--skypelogin-->
				<div class="square login_skypego fsz20">
					<a href="index.html">
						<i class="icon iconfont icon-skype fsz28"></i>
						<span>Skype 登录</span>
					</a>
				</div>
				<!--记住密码，忘记密码栏-->
				<div class="login_frame_election ">
					<div class="login_frame_election_left">
						<input type="checkbox"class="login_checkbox"/>
						记住密码
					</div>
					<div class="login_frame_election_right">
						<a href="index.html">忘记密码？</a>
					</div>
				</div>
			</div>
		</div>

	</body>

</html>