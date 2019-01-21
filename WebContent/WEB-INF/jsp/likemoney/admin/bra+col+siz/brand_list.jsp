<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品牌编辑</title>

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

			<span>品牌管理</span>
		</div>
		<!--第二排-->
		<div class="index_input_body_second">
			<ul class="clearfix">
				<form action="ProductBrandServlet.do" method="post">
					<input type="hidden" name="method" value="list" />
					<li><span>品牌名：</span> <input type="text" name="brand_name" /></li>
					<li><span>图片路径：</span> <input type="text" name="brand_img" /></li>
					
					<button>
						<i class="icon iconfont icon-fangdajing"></i>
					</button>
				</form>
			</ul>
		</div>
		<!--			
			<!--第三排
		
			
				-->
		<!--第五排-->
		<div class="table_body_first table_style2 border_style5">
			<div class="table_body_first_header bgc_f37b53  clearfix">
				<div class="table_body_first_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>品牌管理</span>
				</div>
				<div class="table_body_first_header_2">
					<a href="ProductBrandServlet.do?method=edit"> <i
						class="icon iconfont icon-shuxie">&nbsp;&nbsp;</i>
					</a> <i class="icon iconfont icon-cha"></i>
				</div>
			</div>
			<div
				class="table_body_first_body manage_index_new_style table_table4 ">
				<table border="" cellspacing="0" style="width: 800px;">
					<thead>
						<tr>
							<th class="width_style5 bgcddd c666 "></th>
							<th class="width_style5 bgcddd c666 ">品牌名</th>
							<th class="width_style5 bgcddd c666 ">品牌图片路径</th>
							<!-- 								<th class="width_style5 bgcddd c666 "> 种类</th> -->


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listProductBrand6 }" var="ProductBrand">
							<tr>
								<td class="bgc_f9 "><a
									href="ProductBrandServlet.do?method=edit&brand_id=${ProductBrand.brand_id }">

										<button class="button_style6">
											<i class="icon iconfont icon-bi"></i>
										</button>
								</a> <a
									href="ProductBrandServlet.do?method=delete&brand_id=${ProductBrand.brand_id }">
										<button class="button_style7">
											<i class="icon iconfont icon-shanchu"></i>
										</button>
								</a></td>
								<td style="display: none">${ProductBrand.brand_id }</td>
								<td class="bgc_f9 c4a8bc2">${ProductBrand.brand_name }</td>
								<td class="bgc_f9 ">${ProductBrand.brand_img }</td>

							</tr>
						</c:forEach>
						<!-- 						<tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">尺码</td> -->
						<!-- 								<td class="bgc_f9 ">XL</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">大红</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">橘黄</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">美特斯邦威</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">纯白</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">尺码</td> -->
						<!-- 								<td class="bgc_f9 ">M</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">一人春</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">尺码</td> -->
						<!-- 								<td class="bgc_f9 ">XL</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">浓绿</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">尺码</td> -->
						<!-- 								<td class="bgc_f9 ">XXL</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">尺码</td> -->
						<!-- 								<td class="bgc_f9 ">S</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">Yision</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">森马</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">尺码</td> -->
						<!-- 								<td class="bgc_f9 ">SS</td> -->

						<!-- 							</tr><<tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">JIASD</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">柒牌</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">橘红</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">屎黄</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">海蓝</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">NAS</td> -->

						<!-- 							</tr> -->
						<!-- 							<tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">品牌</td> -->
						<!-- 								<td class="bgc_f9 ">阿迪达斯</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">墨绿</td> -->

						<!-- 							</tr><tr> -->
						<!-- 								<td class="bgc_f9 "> -->

						<!-- 									<button class="button_style6"> -->
						<!-- 										<i class="icon iconfont icon-bi"></i> -->
						<!-- 									</button> -->
						<!-- 									<button class="button_style7"> -->
						<!-- 										<i class="icon iconfont icon-shanchu"></i> -->
						<!-- 									</button> -->

						<!-- 								</td> -->
						<!-- 								<td class="bgc_f9 c4a8bc2 ">1</td> -->
						<!-- 								<td class="bgc_f9 ">颜色</td> -->
						<!-- 								<td class="bgc_f9 ">黄棕</td> -->

						<!-- 							</tr></tbody> -->
				</table>
			</div>
		</div>

	</div>
</body>

</html>