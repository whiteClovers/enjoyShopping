<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据字典首页</title>
<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_comman.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_index.css" />
</head>
<body>
	<!--最外层div-->
	<div>
		<!--内容部分-->
		<div>
			<div class="manage_index_important">
				<!--第一排-->
				<div class="manage_index_body_header fsz28">

					<span>控制台</span>
				</div>
				<!--第二排-->
				<div class="manage_index_body_header2">
					<ul class="clearfix">
						<li style="float: left;">首页<span> /&nbsp;</span></li>

						<li style="float: left;">控制台<span> /&nbsp;</span></li>
						<li style="float: left;">数据字典管理</li>
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
						<a href="DictionariesServlet.do?method=list">
							<div class="box_pad_style">
								<i class="icon iconfont icon-ren box_pad_style4"></i>
							</div>
							<div class="box_pad_style2">数据字典详情</div>
						</a>

					</div>
					<div class="box_small manage_index_body_first_2">
						<a href="DictionariesServlet.do?method=editor">
							<div class="box_pad_style">
								<i class="icon iconfont icon-bi box_pad_style4"></i>
							</div>
							<div class="box_pad_style2">新增数据字典</div>
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
						<li><i class="icon iconfont icon-shu"></i></li>
						<li><i
							class="icon iconfont icon-xiaoxixinxiduanxintixingyoujiantongzhisixin"></i>
						</li>
						<li><i class="icon iconfont icon-click-16"></i></li>
					</ul>
				</div>
				<div class="manage_index_fixed_top_4 " style="float: right;">
					<ul class="manage_index_fixed_top_4_ul clearfix">
						<li><span>&nbsp;哈哈哈</span> <i class="icon iconfont icon-f11"></i>
						</li>
						<li class="mar_le20"><img
							src="admin_img/manage_index_header.jpg" /></li>
						<li><i class="icon iconfont icon-erji fsz20 mar_le20"></i></li>
						<li><i class="icon iconfont icon-weixin fsz20 "></i></li>
					</ul>
				</div>
			</div>
			<!--中间部分-->
			<div class="manage_index_fixed_body">
				<!--左边固定栏-->
				<div class="manage_index_fixed_middle">
					<a href="">
						<div class="manage_index_fixed_middle_div_style"
							style="background-color: #4a8bc2;">
							<i class="icon iconfont icon-diaoseban"></i>&nbsp;&nbsp; <span>控制台</span>
							<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
						</div>
					</a> <a href="">
						<div class="manage_index_fixed_middle_div_style">
							<i class="icon iconfont icon-shu"></i>&nbsp;&nbsp; <span>后台管理</span>
							<i class="icon iconfont icon-arrow-fill-right i_style1"></i>

						</div>
					</a>
					<div class="manage_index_fixed_middle_div_style2">
						<a href="">
							<div>菜单管理</div>
						</a> <a href="">
							<div>模块管理</div>
						</a> <a href="">
							<div>角色管理</div>
						</a> <a href="">
							<div>角色菜单管理</div>
						</a> <a href="">
							<div>数据字典管理</div>
						</a> <a href="">
							<div>数据字典详细管理</div>
						</a>
					</div>
					<a href="">
						<div class="manage_index_fixed_middle_div_style">
							<i class="icon iconfont icon-ren"></i> &nbsp;&nbsp; <span>登录页面</span>

						</div>
					</a>
				</div>

			</div>

			<!--底部固定栏-->
			<div class="manage_index_fixed_bottom">
				<span>Made_in 2018-8-11 &nbsp;版权归阮康所有</span>
			</div>
		</div>

	</div>
</body>
</html>