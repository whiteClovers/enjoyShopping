<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cjz-common.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cjz-iconfont.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cjz-index.css" />
		<title></title>
	</head>

	<body>
		<div id="toptop">
			<div id="topmid">
				<ul class="fl">
					<li class="topleft"><i class="icon iconfont icon-shouye"></i>
						<a href="${pageContext.request.contextPath}/user/CartSettleServlet.do" target="_blank">
						京东首页
						</button>
					</li>

					<li class="topleft">
						<div> <i class="icon iconfont icon-didian"></i> <span data-id="1" title="北京">北京</span> </div>
					</li>
				</ul>
				<ul class="fr">
					<li class="topright">
						<a href="${pageContext.request.contextPath}/LoginServlet.do">
							你好，${sessionScope.session_customer.customerNickName }
						</a>&nbsp;&nbsp;
							
						<c:if test="${sessionScope.session_customer.customerNickName==null }">
							<a>免费注册</a>
						</c:if>
						<c:if test="${sessionScope.session_customer.customerNickName!=null }">
							<a href="${pageContext.request.contextPath}/LogoutServlet.do" >注销</a>
						</c:if>
					</li>
					<li class="spacer"></li>
					<li class="topright">
						<div>
							<a href="${pageContext.request.contextPath}/user/MyOrderServerlet.do?method=list" target="_blank">我的订单</a>
						</div>
					</li>
					<li class="spacer"></li>
					<li class="topright">
						<div>

							<a>我的京东</a><i class="icon iconfont icon-xiala"></i>
						</div>
					</li>
					<li class="spacer"></li>
					<li class="topright">
						<div>
							<a>京东会员</a>
						</div>
					</li>
					<li class="spacer"></li>
					<li class="topright">
						<div>
							<a>企业采购</a><i class="icon iconfont icon-xiala"></i></div>

					</li>
					<li class="spacer"></li>
					<li class="topright">
						<div>

							客户服务<i class="icon iconfont icon-xiala"></i>
						</div>

					</li>
					<li class="spacer"></li>
					<li class="topright">
						<div>

							网站导航<i class="icon iconfont icon-xiala"></i>
						</div>
					</li>
					<li class="spacer"></li>
					<li class="topright">
						<div>
							<a>手机京东</a>
						</div>
					</li>
					
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>

		<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：导航栏下面--广告栏
       -->
		<div>
			<div class="mid">
				<img src="img/cjz-01.jpg" />
			</div>
			<div class="clearfix"></div>
		</div>
		<!--
       	作者：1060996414@qq.com
       	时间：2018-08-02
       	描述：广告栏下方logo和搜索
       -->
		<div id="title">
			<div class="mid">
				<div id="logo-left" class="divfloat">
					<a class="logo"><img src="img/jdlogo.png" /></a>
					<div class="extra">
						<div id="channel">女装</div>
						<div id="categorys-mini">
							<div class="cw-icon">
								<h2><a>全部分类<i class="icon iconfont icon-xiala"></i></a></h2>
							</div>
						</div>
					</div>
				</div>
				<div id="search-all" class="divfloat">
					<ul id="shelper" class="hide" style="display: none;"></ul>
					<div class="form">
						<input type="text" onkeydown="javascript:if(event.keyCode==13) search('key');" autocomplete="off" id="key" accesskey="s" class="text">
						<form action="SearchServerlet.do" method="post" target="_blank">
							<button onclick="search('key');return false;" class="button cw-icon">搜索
							<!-- <a href="http://127.0.0.1:8020/coding/%E4%BA%AC%E4%B8%9C%E6%90%9C%E7%B4%A2hzw.html?__hbt=1533516586173" target="_blank"	style="color: white;">搜索</a> -->
							</button>
						</from>
					</div>
				</div>
				<div id="shopcar" class="dorpdown">
					<div class="cw-icon">
						<i class="icon iconfont icon-qicheqianlian-"></i>
						<a href="${pageContext.request.contextPath}/user/CartSettle.do?method=list" target="_blank">我的购物车</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		
		<!-- 女装商品分类 -->
		
		<div class="mid">
			<div id="classify">

				<div id="categorys-2014" class="dorpdown">
					<div class="dt">女装商品分类</div>
				</div>
				<div id="navitems-2014">
					<ul id="commodity-all">
						<li class="fore1">
							<a>女装新品</a>

						</li>
						<li class="fore2">
							<a>童装</a>
						</li>
						<li class="fore3">
							<a>内衣</a>
						</li>
						<li class="fore4">
							<a>配饰</a>
						</li>

						<li class="fore1">
							<a>男装</a>
						</li>
						<li class="fore2">
							<a>设计师</a>
						</li>
						<li class="fore3">
							<a>定制</a>
						</li>
						<li class="fore5">
							<a>闪购</a>
						</li>
					</ul>
				</div>
				<div id="treasure"></div>
				<span class="clr"></span>

			</div>
		</div>
		<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：正文
        -->
		<div class="mid">
			<!--
	        	作者：1060996414@qq.com
	        	时间：2018-08-02
	        	描述：左侧菜单
	       -->

			<!-- 大类小类 -->
			
			<div class="women-type-con clearfix">
				<div class="menu">
					<dl class="first">
						<%-- <c:forEach items="${listBig }" var="list">
							${list.classfiyBigName }<br/>
							<c:forEach items="${list.listSmall }" var="small">
								<a href="#" title="短袖衬衫">${small.classfiySmallName }</a>
							</c:forEach>
						</c:forEach> --%>
					
						<c:forEach items="${listBig }" var="list">
						<dt>${list.classfiyBigName }<br/></dt>
						<dd>
							<c:forEach items="${list.listSmall }" var="small">
							<a title="18新品">${small.classfiySmallName }</a>
							</c:forEach>
						</dd>
						</c:forEach>
						
						<!-- <dt>大家都在穿</dt>
						<dd>
							<a title="18新品">18新品</a>
							<a title="连衣裙">连衣裙</a>
							<a href="#" title="短袖衬衫">短袖衬衫</a>
							<a href="#" title="T恤">T恤</a>
							<a href="#" title="雪纺连衣裙">雪纺连衣裙</a>
							<a href="#" title="防晒衣">防晒衣</a>
							<a href="#" title="卫衣">卫衣</a>
							<a href="#" title="牛仔短外套">牛仔短外套</a>
							<a href="#" title="自营女装">自营女装</a>
						</dd> -->
					</dl>
				</div>

			
			<!-- <div class="women-type-con">
				<div class="menu">
					<dl class="first">
						<dt>大家都在穿</dt>
						<dd>
							<a title="18新品">18新品</a>
							<a title="连衣裙">连衣裙</a>
							<a href="#" title="短袖衬衫">短袖衬衫</a>
							<a href="#" title="T恤">T恤</a>
							<a href="#" title="雪纺连衣裙">雪纺连衣裙</a>
							<a href="#" title="防晒衣">防晒衣</a>
							<a href="#" title="卫衣">卫衣</a>
							<a href="#" title="牛仔短外套">牛仔短外套</a>
							<a href="#" title="自营女装">自营女装</a>
						</dd>
					</dl>
					<dl>
						<dt>女士裙装</dt>
						<dd>
							<a href="#" title="哥弟新品">哥弟新品</a>
							<a href="#" title="热卖新品">热卖新品</a>
							<a href="#" title="碎花连衣裙">碎花连衣裙</a>
							<a href="#" title="背带裙">背带裙</a>
							<a href="#" title="蕾丝裙">蕾丝裙</a>
							<a href="#" title="印花连衣裙">印花连衣裙</a>
							<a href="#" title="长裙">长裙</a>
							<a href="#" title="短袖连衣裙">短袖连衣裙</a>
							<a href="#" title="衬衫裙">衬衫裙</a>
							<a href="#" title="一字肩连衣裙">一字肩连衣裙</a>
							<a href="#" title="吊带连衣裙">吊带连衣裙</a>
							<a href="#" title="春季新品">春季新品</a>
							<a href="#" title="T恤裙">T恤裙</a>
						</dd>
					</dl>
					<div class="women-menu-category">
						<div class="menu">
							<dl class="item fore1">
								<dt>女士上装<i class="arrow">&gt;</i></dt>
								<dd>
									<a href="#" title="针织衫">针织衫</a>
									<a href="#" title="卫衣">卫衣</a>
									<a href="#" title="衬衫">衬衫</a>
									<a href="#" title="T恤">T恤</a>
									<a href="#" title="雪纺衫">雪纺衫</a>
									<a href="#" title="短外套">短外套</a>
									<a href="#" title="风衣">风衣</a>
									<a href="#" title="毛衣">毛衣</a>
									<a href="#" title="小西装">小西装</a>
									<a href="#" title="打底衫">打底衫</a>
									<a href="#" title="棉服">棉服</a>
									<a href="#" title="皮衣">皮衣</a>
									<a href="#" title="皮草">皮草</a>
									<a href="#" title="羽绒服">羽绒服</a>
									<a href="#" title="毛呢大衣">毛呢大衣</a>
								</dd>
							</dl>
							<dl class="item fore2">
								<dt>女士下装<i class="arrow">&gt;</i></dt>
								<dd>
									<a href="#" title="牛仔裤">牛仔裤</a>
									<a href="#" title="休闲裤">休闲裤</a>
									<a href="#" title="阔腿裤">阔腿裤</a>
									<a href="#" title="哈伦裤">哈伦裤</a>
									<a href="#" title="小脚裤">小脚裤</a>
									<a href="#" title="背带裤">背带裤</a>
									<a href="#" title="喇叭裤">喇叭裤</a>
									<a href="#" title="运动裤">运动裤</a>
									<a href="#" title="黑色牛仔">黑色牛仔</a>
								</dd>
							</dl>
						</div>

					</div>
					<dl class="no-bg">
						<dt>特色品类</dt>
						<dd>
							<a href="#" title="大码女装">大码女装</a>
							<a href="#" title="中老年女装">中老年女装</a>
							<a href="#" title="旗袍">旗袍</a>
							<a href="#" title="唐装">唐装</a>
							<a href="#" title="设计师">设计师</a>
							<a href="#" title="婚纱">婚纱</a>
							<a href="#" title="礼服">礼服</a>
						</dd>
					</dl>
				</div>
			</div> -->

			<!--
	        	作者：1060996414@qq.com
	        	时间：2018-08-02
	        	描述：右侧菜单
	        -->
			<div id="women-menu" style="margin-top: 2100px;margin-left: 3000px;">
				<img src="img/cjz-03.jpg" />
			</div>
			<div id="women-ads">
				<img src="${pageContext.request.contextPath}/img/cjz-04.jpg" class="photo-ads" />
				<img src="${pageContext.request.contextPath}/img/cjz-05.jpg" class="photo-ads" />
				<img src="${pageContext.request.contextPath}/img/cjz-06.jpg" class="photo-ads" />
				<img src="${pageContext.request.contextPath}/img/cjz-07.jpg" class="photo-ads" />
			</div>
			<div class="clearfix"></div>
		</div>

		</div>

		<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：精选品牌
        -->

		<div class="mid">

			<div id="brand">
				<h3 style="margin-bottom: 10px;">
	        			<em>精选品牌</em>
	        			<span>SELECTED</span>
	        		</h3>
				<div>
					<div class="divfloat">
						<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
					</div>
					<div class="divfloat" style="width: 717px;">

						<div>
							<ul class="brand-list">
								<li class="brand-class">
									知名品牌
								</li>
								<li class="brand-class">
									大众品牌
								</li>
								<li class="brand-class">
									潮流品牌
								</li>
								<li class="clearfix"></li>
							</ul>
						</div>

						<div style="margin-top: 50px;">
							<%-- <ul>
								<c:forEach items="${listBrand }" var="brand" begin="1" end="9">
									<img src="${pageContext.request.contextPath }/webContent/${brand.brand_img } " />
									<img src="${brand.brand_img } " />
								</c:forEach>
							</ul> --%>
						
							<ul>
								<c:forEach items="${listBrand }" var="brand" >
									<li class="brand-logo">
										<img src="${pageContext.request.contextPath}/${brand.brand_img } " />
									</li>
								</c:forEach>
							</ul>
						
						
							<!-- <ul>
								<li class="brand-logo">
									<img src="img/cjz-08.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-09.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-10.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-11.jpg" class="imgmid" />
								</li>
							</ul> -->
							<!-- <ul>
								<li class="brand-logo">
									<img src="img/cjz-11.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-10.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-09.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-08.jpg" class="imgmid" />
								</li>
							</ul>
							<ul>
								<li class="brand-logo">
									<img src="img/cjz-08.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-09.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-10.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-11.jpg" class="imgmid" />
								</li>
							</ul>
							<ul>
								<li class="brand-logo">
									<img src="img/cjz-11.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-10.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-09.jpg" class="imgmid" />
								</li>
								<li class="brand-logo">
									<img src="img/cjz-08.jpg" class="imgmid" />
								</li>
							</ul> -->
						</div>
					</div>
				</div>
			</div>

		</div>

		<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：品牌上新
        -->

		<div class="mid">

			<div id="brand">
				<h3 style="margin-bottom: 10px;">
	        			<em>品牌上新</em>
	        			<span>new</span>
	        		</h3>
				<div>
					<div class="newbrand">
						<img src="${pageContext.request.contextPath}/img/cjz-16.jpg" />
					</div>
					<div class="newbrand">
						<img src="${pageContext.request.contextPath}/img/cjz-15.jpg" />
					</div>
					<div class="newbrand">
						<img src="${pageContext.request.contextPath}/img/cjz-14.jpg" />
					</div>
					<div class="newbrand">
						<img src="${pageContext.request.contextPath}/img/cjz-13.jpg" />
					</div>
					<div class="newbrand">
						<img src="${pageContext.request.contextPath}/img/cjz-12.jpg" />
					</div>
					<div class="clearfix"></div>
				</div>
			</div>

		</div>

		<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：潮流穿搭
        -->
		
		<!--

		<div class="mid">

			<div id="outfit">
				<h3 style="margin-bottom: 10px;">
	        			<em>潮流穿搭</em>
	        			<span>TREND</span>
	        		</h3>

				<div class="divfloat">
					<img src="img/cjz-17.jpg" />
				</div>
				<div class="divfloat" style="width: 717px;">

					<div>
						<ul class="brand-list">
							<li class="brand-class">
								知名品牌
							</li>
							<li class="brand-class">
								大众品牌
							</li>
							<li class="brand-class">
								潮流品牌
							</li>
							<li class="clearfix"></li>
						</ul>
					</div>

					<div style="margin-top: 50px;">
						<ul>
							<li class="brand-logo">
								<img src="img/cjz-08.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-09.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-10.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-11.jpg" class="imgmid" />
							</li>
						</ul>
						<ul>
							<li class="brand-logo">
								<img src="img/cjz-11.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-10.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-09.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-08.jpg" class="imgmid" />
							</li>
						</ul>
						<ul>
							<li class="brand-logo">
								<img src="img/cjz-08.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-09.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-10.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-11.jpg" class="imgmid" />
							</li>
						</ul>
						<ul>
							<li class="brand-logo">
								<img src="img/cjz-11.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-10.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-09.jpg" class="imgmid" />
							</li>
							<li class="brand-logo">
								<img src="img/cjz-08.jpg" class="imgmid" />
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		-->
		
			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：国际大牌
        -->

			<div class="mid">
				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>国际大牌</em>
	        			<span>INTERNATIONAL</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-18.jpg" />
						</div>
						
						<!-- <div>
								<div class="bigbrand"><img src="img/cjz-19.jpg" /> </div>
								<div class="bigbrand"><img src="img/cjz-20.jpg" /> </div>
								<div class="bigbrand"><img src="img/cjz-21.jpg" /> </div>
								<div class="bigbrand"><img src="img/cjz-19.jpg" /> </div>
						</div> -->
						
						<div>
							<c:forEach items="${listProductSku}" var="listProSku">
								<div class="bigbrand"><img src="${pageContext.request.contextPath}/${listProSku.product_sku_img_mid}" /> </div>
								<!-- <div class="bigbrand"><img src="img/cjz-20.jpg" /> </div>
								<div class="bigbrand"><img src="img/cjz-21.jpg" /> </div>
								<div class="bigbrand"><img src="img/cjz-19.jpg" /> </div> -->
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：品牌上新
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>品牌上新</em>
	        			<span>new</span>
	        		</h3>
					<div>
						<div class="newbrand">
							<img src="${pageContext.request.contextPath}/img/cjz-16.jpg" />
						</div>
						<div class="newbrand">
							<img src="${pageContext.request.contextPath}/img/cjz-15.jpg" />
						</div>
						<div class="newbrand">
							<img src="${pageContext.request.contextPath}/img/cjz-14.jpg" />
						</div>
						<div class="newbrand">
							<img src="${pageContext.request.contextPath}/img/cjz-13.jpg" />
						</div>
						<div class="newbrand">
							<img src="${pageContext.request.contextPath}/img/cjz-12.jpg" />
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>

			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：商场大牌
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>商场大牌</em>
	        			<span>MARKET</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
						</div>
					</div>
				</div>
				<div class="clearfix"></div>

			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：温婉淑女
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>温婉淑女</em>
	        			<span>LADY</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
						</div>
					</div>
				</div>
				<div class="clearfix"></div>

			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>品牌上新</em>
	        			<span>new</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
						</div>
					</div>
				</div>
				<div class="clearfix"></div>

			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：品牌上新
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>品牌上新</em>
	        			<span>new</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
						</div>
					</div>
				</div>
				<div class="clearfix"></div>

			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：品牌上新
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>品牌上新</em>
	        			<span>new</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
						</div>
					</div>
				</div>

			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：品牌上新
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>品牌上新</em>
	        			<span>new</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
						</div>
					</div>
				</div>

			</div>

			<!--
        	作者：1060996414@qq.com
        	时间：2018-08-02
        	描述：品牌上新
        -->

			<div class="mid">

				<div id="brand">
					<h3 style="margin-bottom: 10px;">
	        			<em>品牌上新</em>
	        			<span>new</span>
	        		</h3>
					<div>
						<div class="divfloat">
							<img src="${pageContext.request.contextPath}/img/cjz-17.jpg" />
						</div>
					</div>
				</div>

			</div>

	</body>

</html>