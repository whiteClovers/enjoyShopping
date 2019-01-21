<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/manage_index.css" />
		<meta charset="utf-8" />
		<title></title>
</head>
<body>


		<!--最外层div-->
		<div>
			<!--内容部分-->
			<div>
				<div class="manage_index_important">
					<!--第一排-->
					<div class="manage_index_body_header fsz28">

						<span>财务管理</span>
					</div>
					<!--第二排-->
					<div class="manage_index_body_header2">
						<ul class="clearfix">
							<li style="float: left;">首页<span> /&nbsp;</span></li>

							<li style="float: left;"> 控制台</li>
							<li style="float: right;">
								<form action="">
									<input type="text" />
									<button>
										<i class="icon iconfont icon-fangdajing"></i>
									</button>
								</form>
							</li>
						</ul>
					</div>
					<!--第三排-->
				
					<div class="manage_index_body_first clearfix">
						<div class="box_small manage_index_body_first_1 clearfix">
							<a href="BankServlet.do?method=edit">
								<div class="box_pad_style">
									<i class="icon iconfont icon-ren box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">321</div>
								</div>
								
								<div class="box_pad_style2">新增银行卡</div>
							</a>

						</div>
						
					</div>
				</div>
			</div>

			<!--固定部分-->
			<div class="manage_index_fixed">
				<!--顶部固定栏-->
				<div class="manage_index_fixed_top clearfix">
					<div class="manage_index_fixed_top_1">
						<i class="icon iconfont icon-santiaogang"></i>
					</div>
					<div class="manage_index_fixed_top_2">
						<img src="admin_img/login_logo.png" />
					</div>
					<div class="manage_index_fixed_top_3">
						<ul class="manage_index_fixed_top_3_ul clearfix">
							<li>
								<i class="icon iconfont icon-shu"></i>
							</li>
							<li>
								<i class="icon iconfont icon-xiaoxixinxiduanxintixingyoujiantongzhisixin"></i>
							</li>
							<li>
								<i class="icon iconfont icon-click-16"></i>
							</li>
						</ul>
					</div>
					<div class="manage_index_fixed_top_4 " style="float: right;">
						<ul class="manage_index_fixed_top_4_ul clearfix">
							<li>
								<span>&nbsp;军哥</span>
								<i class="icon iconfont icon-f11"></i>
							</li>
							<li class="mar_le20">
								<img src="admin_img/manage_index_header.jpg" />
							</li>
							<li>
								<i class="icon iconfont icon-erji fsz20 mar_le20"></i>
							</li>
							<li>
								<i class="icon iconfont icon-weixin fsz20 "></i>
							</li>
						</ul>
					</div>
				</div>
				<!--中间部分-->
				<div class="manage_index_fixed_body">
					<!--左边固定栏-->
					<div class="manage_index_fixed_middle">
						<a href="">
							<div class="manage_index_fixed_middle_div_style" style="background-color:#4a8bc2 ;">
								<i class="icon iconfont icon-diaoseban"></i>&nbsp;&nbsp;
								<span>控制台</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>

						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-shu"></i>&nbsp;&nbsp;
								<span>财务管理</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>

							</div>
						</a>
						<div class="manage_index_fixed_middle_div_style2">
							<a href="BankServlet.do?method=list">
								<div>
									银行卡管理
								</div>
							</a>
							
					</div>

				</div>

				<!--底部固定栏-->
				<div class="manage_index_fixed_bottom">
					<span>Made_in 2018-8-11 &nbsp;版权归刘军所有</span>
				</div>
			</div>

		</div>

</body>
</html>