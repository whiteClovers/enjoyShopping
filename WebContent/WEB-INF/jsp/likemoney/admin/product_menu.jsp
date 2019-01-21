<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>

	<link href="${pageContext.request.contextPath}/img/login_logo.png" rel="SHORTCUT ICON" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_comman.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage_index.css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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

					<span>控制台</span>
				</div>
				<!--第二排-->
				<div class="manage_index_body_header2">
					<ul class="clearfix">
						<li style="float: left;">首页
							<span> /&nbsp;</span>
						</li>

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
						<a href="/ProductServlet.do?method=list">
							<div class="box_pad_style">
								<i class="icon iconfont icon-gouwuche box_pad_style4"></i>
								<div class="box_pad_style3 fsz20">321</div>
							</div>
							<div class="box_pad_style2">产品管理</div>
						</a>

					</div>
					<div class="box_small manage_index_body_first_1 clearfix">
						<a href="/ProductSkuServlet.do?method=list">
							<div class="box_pad_style">
								<i class="icon iconfont icon-gouwuche box_pad_style4"></i>
								<div class="box_pad_style3 fsz20">321</div>
							</div>
							<div class="box_pad_style2">产品SKU管理</div>
						</a>

					</div>


					<!--<div class="box_big manage_index_body_first_4">
							<a href="">
								<div class="box_pad_style">
									<i class="icon iconfont icon-biaoge box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">897</div>
								</div>
								<div class="box_pad_style2">颜色尺码品牌</div>
							</a>

						</div>-->
					<!--<div class="box_small manage_index_body_first_5">
							<a href="">
								<div class="box_pad_style">
									<i class="icon iconfont icon-shujia box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">288</div>
								</div>
								<div class="box_pad_style2">更新</div>
							</a>

						</div>
					</div>
					<!--第四排-->
					<!--<div class="manage_index_body_second clearfix">

						<div class="box_small manage_index_body_second_1">
							<a href="">
								<div class="box_pad_style">
									<i class="icon iconfont icon-gouwuche box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">29</div>
								</div>
								<div class="box_pad_style2">新增订单</div>
							</a>

						</div>
						<div class="box_big manage_index_body_second_2">
							<a href="">
								<div class="box_pad_style">
									<i class="icon iconfont icon-shu1 box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">37624</div>
								</div>
								<div class="box_pad_style2">品牌颜色尺码</div>
							</a>

						</div>
						<div class="box_small manage_index_body_second_3">
							<a href="">
								<div class="box_pad_style">
									<i class="icon iconfont icon-xiaoxixinxiduanxintixingyoujiantongzhisixin box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">123</div>
								</div>
								<div class="box_pad_style2">消息</div>
							</a>

						</div>
						<div class="box_small manage_index_body_second_4">
							<a href="">
								<div class="box_pad_style">
									<i class="icon iconfont icon-cha box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">34</div>
								</div>
								<div class="box_pad_style2">取消订单</div>
							</a>
						</div>
						<div class="box_small manage_index_body_second_5">
							<a href="">
								<div class="box_pad_style">
									<i class="icon iconfont icon-zhuanfa box_pad_style4"></i>
									<div class="box_pad_style3 fsz20">53412</div>
								</div>
								<div class="box_pad_style2">总利润</div>
							</a>
						</div>-->
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
					<img src="img/login_logo.png" />
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
							<span>&nbsp;销售经理</span>
							<i class="icon iconfont icon-f11"></i>
						</li>
						<li class="mar_le20">
							<img src="img/manage_index_header_01.jpg" />
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
							<span>菜单</span>
							<i class="icon iconfont icon-arrow-fill-right i_style1"></i>

						</div>
					</a>
					<div class="manage_index_fixed_middle_div_style2">
						<a href="OrderServlet.do?method=menu">
							<div>订单管理</div>
						</a> <a href="ProductSizeServlet.do?method=menu">
							<div>尺码管理</div>
						</a> <a href="ProductBrandServlet.do?method=menu">
							<div>品牌管理</div>
						</a> <a href="ProductColorServlet.do?method=menu">
							<div>颜色管理</div>
						</a> <a href="ProductServlet.do?method=menu">
							<div>产品管理</div>
						</a>

						<!--<a href="">
								<div>
									选项卡
								</div>
							</a>
							<a href="">
								<div>
									文字排版
								</div>
							</a>
							<a href="">
								<div>
									树菜单
								</div>
							</a>
							<a href="">
								<div>
									镶嵌列表
								</div>
							</a>
						</div>
						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-21"></i> &nbsp;&nbsp;
								<span>插件</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>

						<a href="">
							<div class=" manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-shu1"></i> &nbsp;&nbsp;
								<span>表单</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>
						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-biaoge"></i> &nbsp;&nbsp;
								<span>数据表格</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>
						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-tubiaozhizuomoban"></i> &nbsp;&nbsp;
								<span>Icon图标</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>

						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-jiangbei"></i> &nbsp;&nbsp;
								<span>代码片段</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>
						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-tubiaozhizuomoban1"></i> &nbsp;&nbsp;
								<span>地图</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>
						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-wenjian"></i> &nbsp;&nbsp;
								<span>基本页面</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>
						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-beizi"></i> &nbsp;&nbsp;
								<span>其他</span>
								<i class="icon iconfont icon-arrow-fill-right i_style1"></i>
							</div>
						</a>-->
						<a href="">
							<div class="manage_index_fixed_middle_div_style">
								<i class="icon iconfont icon-ren"></i> &nbsp;&nbsp;
								<span>登录页面</span>

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
