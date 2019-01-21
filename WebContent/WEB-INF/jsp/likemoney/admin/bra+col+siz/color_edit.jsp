<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/iconfont/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/admin_css/manage_comman.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/login.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin_css/index_input.css" />

<link href="${pageContext.request.contextPath}/admin_img/login_logo.png" rel="SHORTCUT ICON" />
<title></title>
</head>

<body>
	<div class="index_input_all">
		<!--第一排-->
		<!--<div class="index_input_body_first fsz28">

				<span>用户编辑</span>
			</div>-->
		<!--第二排-->

		<!--第三排-->
		<div class="index_input_body_third">
			<div class="index_input_body_third_header clearfix">
				<div class="index_input_body_third_header_1">
					<i class="icon iconfont icon-santiaogang"></i> <span>颜色编辑</span>
				</div>
				<div class="index_input_body_third_header_2">
					<i class="icon iconfont icon-dui">&nbsp;&nbsp;</i> <i
						class="icon iconfont icon-cha"></i>
				</div>
			</div>

			<div class="index_input_body_third_body">

				<form action="ProductColorServlet.do" method="post">
					<input type="hidden" name="method" value="save" /> <input
						type="hidden" name="color_id" value="${ProductColor4.color_id}" />
					<div class="index_input_body_third_body_all clearfix">
						<div class="index_input_body_third_body_1 clearfix"
							style="display:${displaystatus}">
							<div class="c888 fsz14 index_input_body_third_body_style1">颜色id:</div>

							<div>
								<input class="index_input_style1" type="text" name="color_id"
									id="color_id" disabled="disabled" value="${ProductColor4.color_id}" />

							</div>
						</div>
						<div class="index_input_body_third_body_1 clearfix">
							<div class="c888 fsz14 index_input_body_third_body_style1">颜色：</div>

							<div>
								<input class="index_input_style1" type="text" id="color_name"
									name="color_name" />
							</div>
						</div>

						<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
						<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">尺寸：</div> -->

						<!-- 								<select name=""> -->
						<!-- 									<option value="">SS</option> -->
						<!-- 									<option value="">S</option> -->
						<!-- 									<option value="">M</option> -->
						<!-- 									<option value="">L</option> -->
						<!-- 									<option value="">XL</option> -->
						<!-- 									<option value="">XXL</option> -->
						<!-- 									<option value="">均码</option> -->
						<!-- 								</select> -->
						<!-- 							</div> -->

						<!-- 							<div class="index_input_body_third_body_1 clearfix"> -->
						<!-- 								<div class="c888 fsz14 index_input_body_third_body_style1">颜色：</div> -->

						<!-- 								<div> -->
						<!-- 									<input class="index_input_style1" type="text"/> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!--<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">支付密码：</div>

								<div>
									<input class="index_input_style1" type="password" />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">昵称：</div>

								<div>
									<input class="index_input_style1" type="text"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 index_input_select1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">性别：</div>
								<select name="">
									<option value="">男</option>
									<option value="">女</option>
								</select>

							</div>
							<div class="index_input_body_third_body_1 index_input_select2 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">出生日期：</div>
								<select name="">
									<option value="">1995</option>
									<option value="">1996</option>
									<option value="">1997</option>
									<option value="">1998</option>
									<option value="">1999</option>
									<option value="">2000</option>
									<option value="">2001</option>
									<option value="">2002</option>
									<option value="">2003</option>
									<option value="">2004</option>
									<option value="">2005</option>
									<option value="">2006</option>
									<option value="">2007</option>
									<option value="">2008</option>
									<option value="">2009</option>
									<option value="">2010</option>
									<option value="">2011</option>
									<option value="">2012</option>
									<option value="">2013</option>
									<option value="">2014</option>
									<option value="">2015</option>
									<option value="">2016</option>
									<option value="">2017</option>
								</select>
								<select name="">
									<option value="">1</option>
									<option value="">2</option>
									<option value="">3</option>
									<option value="">4</option>
									<option value="">5</option>
									<option value="">6</option>
									<option value="">7</option>
									<option value="">8</option>
									<option value="">9</option>
									<option value="">10</option>
									<option value="">11</option>
									<option value="">12</option>

								</select>
								<select name="">
									<option value="">1</option>
									<option value="">2</option>
									<option value="">3</option>
									<option value="">4</option>
									<option value="">5</option>
									<option value="">6</option>
									<option value="">7</option>
									<option value="">8</option>
									<option value="">9</option>
									<option value="">10</option>
									<option value="">11</option>
									<option value="">12</option>
									<option value="">13</option>
									<option value="">14</option>
									<option value="">15</option>
									<option value="">16</option>
									<option value="">17</option>
									<option value="">18</option>
									<option value="">19</option>
									<option value="">20</option>
									<option value="">21</option>
									<option value="">22</option>
									<option value="">23</option>
									<option value="">24</option>
									<option value="">25</option>
									<option value="">26</option>
									<option value="">27</option>
									<option value="">28</option>
									<option value="">29</option>
									<option value="">30</option>
									<option value="">31</option>
								</select>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">邮箱：</div>

								<div class="index_input_body_third_body_1_style1 clearfix">

									<div>
										<input style="width: 220px" class="index_input_style4 index_input_style3" type="text" />
										<i class="icon iconfont icon-xiaoxixinxiduanxintixingyoujiantongzhisixin"></i>
									</div>

								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">手机：</div>

								<div class="index_input_body_third_body_1_style1 clearfix">

									<div>
										<input style="width: 220px" class="index_input_style4 index_input_style3 " type="text"  />
										<i class="icon iconfont icon-shouji"></i>
									</div>

								</div>
							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">头像地址：</div>

								<div>
									<input class="index_input_style1" type="text"  />
								</div>
							</div>

							<div class="index_input_body_third_body_1 index_input_select1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">婚姻状况：</div>
								<select name="">
									<option value="">已婚</option>
									<option value="">未婚</option>
								</select>

							</div>
							<div class="index_input_body_third_body_1 index_input_select1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">学历：</div>
								<select name="">
									<option value="">小学</option>
									<option value="">初中</option>
									<option value="">高中</option>
									<option value="">本科</option>
									<option value="">研究生</option>
									<option value="">博士</option>
								</select>

							</div>

							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">余额：</div>

								<div>
									<input class="index_input_style1" type="text"  />
								</div>
							</div>
							<div class="index_input_body_third_body_1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">身份证号：</div>

								<div>
									<input class="index_input_style1" type="text" />
								</div>
							</div>

							<div class="index_input_body_third_body_1 index_input_select1 clearfix">
								<div class="c888 fsz14 index_input_body_third_body_style1">是否实名认证：</div>
								<select name="">
									<option value="">是</option>
									<option value="">否</option>

								</select>

							</div>-->
					</div>


					<div class="index_input_body_third_body_foot">
						<div class="index_input_body_third_body_foot_btnall">
							<button class="index_input_body_third_body_foot_btn1">提交
							</button>
							<button class="index_input_body_third_body_foot_btn2">取消
							</button>

						</div>

					</div>
			</div>
			</form>
		</div>
	</div>
</body>

</html>