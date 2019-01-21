<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人中心</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/self.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/iconfont.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lwh.css">
	</head>
	
	<body>
		<div id="top">
			<div class="top_nav clearfix"><!--顶部导航条-->
		    	<ul class="top_ul_left clearfix">
		    		<li id="top_nav_home_id"><i class="top_nav_home">&#xe608;</i><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">京东首页</a></li>
		    		<li class="top_nav_position" id="top_nav_position_id">北京</li><!--定位-->
		    	</ul>
		    	<ul class="top_ul_right clearfix">
					<li class="login" id="login_id">
					
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
					<li class="spacer">|</li><!--导航栏的竖线-->
					
					<li class="dingdan">
						<div class="dingdan_div">
							<a target="_blank" href="${pageContext.request.contextPath}/user/MyOrderServerlet.do" target="_blank">我的订单</a>
						</div>
					</li>
					<li class="spacer">|</li>
					
					<li class="ower" id="ower_id">
						<div class="ower_div">
							<!-- <i class="ci-right"><s>◇</s></i> -->
							<a target="_blank" href="xx">我的京东</a><i class="iconfont">&#xe605;</i>
						</div>
						<div class="ower_div_2"></div>
					</li>
					<li class="spacer">|</li>
					
					<li class="vip" id="vip_id">
						<div class="vip_div">
							<a target="_blank" href="xx">京东会员</a>
						</div>
					</li>
					<li class="spacer">|</li>
					
					<li class="buy"   id="buy_id">
						<div class="buy_div">
							<a target="_blank" href="xx">企业采购</a>
						</div>
					</li>
					<li class="spacer">|</li>
					
					<li class="fuwu" id="fuwu_id">
						<div class="fuwu_div">
							客户服务<i class="iconfont">&#xe605;</i>
						</div>
						<div class="fuwu_div_2"></div>
					</li>
					<li class="spacer">|</li>
					
					<li class="daohang" id="daohang_id">
						<div class="daohang_div">
							网站导航<i class="iconfont">&#xe605;</i>
						</div>
						<div class="daohang_div_2"></div>
					</li>
					<li class="spacer">|</li>
					
					<li class="phone" id="phone_id">
						<div class="phone_div">
							<a target="_blank" href="//app.jd.com/">手机京东</a>
						</div>
					</li>
		    	</ul>
				<span class="clr"></span>
		    </div>
		</div>
		
		<div class="self clearfix"><!--京东logo行及搜索框-->
			<div><!--京东logo-->
				<img class="logo_img" src="img/京东logo2.jpg">
			</div>
			<div class="logo_our">
				我的京东
			</div>
			<div class="logo_middle clearfix">
				<div class="logo_middle_shouye">
					<span>首页</span>V
				</div>
				<div class="logo_middle_shouye">
					<span>账户设置</span>V
				</div>
				<div class="logo_middle_shouye">
					<span>消息</span>V
				</div>
			</div>
			<div class="logo_right clearfix"><!--输入框及购物车-->
				<div class="logo_input_left"><!--输入框-->
					<input class="input_shuru2" value="自营">
					<input type="button" class="input_sousuo2" value="搜索">
				</div>
				<div class="logo_cart"><!--购物车-->
					<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
						我的购物车
					</a>
					<span>5</span>
				</div>
			</div>
		</div>
		
		<div class="main_color">
			<div class="main clearfix"><!--主体-->
				<div class="main_left"><!--第一列-->
					<div class="tiaozheng">
						<div class="main_dl clearfix">
							<dl>
								<dt>订单中心</dt>
								<dd>我的评价</dd>
								<dd>评价晒单</dd>
							</dl>
							<dl>
								<dt>我的钱包</dt>
								<dd>优惠券</dd>
								<dd>京豆</dd>
								<dd>余额</dd>
								<dd>白条</dd>
								<dd>更多></dd>
							</dl>
							<dl>
								<dt>我的关注</dt>
								<dd>关注商品</dd>
								<dd>关注店铺</dd>
								<dd>内容收藏</dd>
							</dl>
							<dl>
								<dt>我的活动</dt>
								<dd>我的预约</dd>
								<dd>我的拍卖</dd>
								<dd>我的回收单</dd>
								<dd>更多</dd>
							</dl>
							<dl>
								<dt>客户服务</dt>
								<dd>返修退换货</dd>
								<dd>价格保护</dd>
								<dd>我的发票</dd>
								<dd>购买咨询</dd>
								<dd>交易纠纷</dd>
								<dd>更多</dd>
							</dl>
							<dl>
								<dt>特色服务</dt>
								<dd>我的营业厅</dd>
								<dd>京东通信</dd>
								<dd>节能补贴</dd>
								<dd>医疗服务</dd>
								<dd>流量加油站</dd>
								<dd>更多</dd>
							</dl>
						</div>
					</div>
				</div>
				<div class="main_right "><!--第二列-->	
					<div class="right_21 clearfix"><!--第二列第一行-->
						<div class="geren"><!--个人信息-->
							<div><!--姓名图片-->
								<div class="geren_img"><img  class="geren_image" src="img/图片.jpg"></div><!--图片-->
								<div class="geren_xingming">xxx</div><!--姓名-->
								<div class="geren_xinyong"><!--信用-->
									<input class="geren_input" type="button" id="" value="京享值" />
									<input class="geren_input" type="button" name="" id="" value="小白信用" />
								</div>
							</div>
							<div class="huiyuan clearfix"><!--开通会员-->
								<div class="huiyuan_kaitong">
									<span>开通plus会员尊享</span><br/>
									<span id="">
										全年360运费券礼包
									</span>
								</div>
									<a href="xx"><input class="geren_kaitong" type="button"value="立即开通" /></a>
							</div>
						</div>
						<div id="main_qianbao"><!--我的钱包行-->
							<div class="qianbao clearfix">
								<div id="qianbao"><h3>我的钱包</h3></div>
								<div id="yincang" >
									<button  class="qianbao_input"><i class="iconfont icon-eye"></i></button>
								</div>
							</div>
							<div id="">
								<ul class="ul clearfix">
									<li><!--优惠券-->
										<div class="qianbao_1">
											0
										</div>
										<div class="qianbao_height"><!--调整-->
											
										</div>
										<div>
											优惠券
										</div>
										<div class="qianbao_3">
											<a href=""  class="qianbao_2">领券</a>
										</div>
									</li>
									<li class="qianbao_li"><!--京豆-->
										<div class="qianbao_1">
											9
										</div>
										<div class="qianbao_height"><!--调整-->
											
										</div>
										<div>
											京豆
										</div>
										<div class="qianbao_2 qianbao_3">
											<a href=""  class="qianbao_2">赚京豆</a><span>|</span><a href="xx"  class="qianbao_2">花京豆</a>
										</div>
									</li>
									<li class="qianbao_li"><!--余额-->
										<div class="qianbao_1">
											0.00
										</div>
										<div class="qianbao_height"><!--调整-->
											
										</div>
										<div>
											余额
										</div>
										<div  class="qianbao_2 qianbao_3">
											<a href=""  class="qianbao_2">充值</a>
										</div>
									</li>
									<li class="qianbao_li"><!--白条-->
										<div class="qianbao_1">
											——
										</div>
										<div class="qianbao_height"><!--调整-->
											
										</div>
										<div>
											暂未开通白条
										</div>
										<div  class="qianbao_2 qianbao_3">
											<a href=""  class="qianbao_2">立即开通</a>
										</div>
									</li>
									<li class="qianbao_li"><!--收益-->
										<div class="qianbao_1">
											0.00
										</div>
										<div class="qianbao_height"><!--调整-->
											总额0.00
										</div>
										<div>
											小金库昨日收益
										</div>
										<div class="qianbao_2 qianbao_3">
											<a href=""  class="qianbao_2">转入小金库，马上收益</a>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>

					<div style="float: left;" class="clearfix">
						<div class="dingdan_tiaozheng"><!--第二列第二行上半部分调整-->
							<div class="wodedingdan"><!--第二列第二行第一列上半部分 BOX1-->
								<div class="dingdan_text"><!--我的订单-内容-->
									<div class="dingdan_wode">
										<h3>我的订单</h3>
									</div>
									<div class="dingdan_mc">
										<div class="dingdan_nav clearfix">
											<a href="xx"><!--显示各种信息的数量-->
												<div><i class="iconfont icon-daifukuan"></i></div>
												<span class="dingdan_name">待付款</span>
											</a>
											<a href="xx"><!--显示各种信息的数量-->
												<div><i class="iconfont icon-daishouhuo"></i></div>
												<span class="dingdan_name">待收货</span>
											</a>
											<a href="xx"><!--显示各种信息的数量-->
												<div><i class="iconfont icon-wodefankui"></i></div>
												<span class="dingdan_name">待评价</span>
											</a>
											<a href="xx"><!--显示各种信息的数量-->
												<div><i class="iconfont icon-wodefankui"></i></div>
												<span class="dingdan_name">退货/售后</span>
											</a>
											<a href="xx"><!--显示各种信息的数量-->
												<div><i class="iconfont icon-jiantouyou"></i></div>
												<span class="dingdan_name">全部订单</span>
											</a>
										</div>
										<div class="dingdan_xiangxi">
											<i class="iconfont icon-gouwuchetianjia"></i>
											您买的东西太少了，这里都空空的，快去挑选合适的商品吧！
										</div>
									</div>	
								</div>
								<div class="plus"><!--plus尊享-->
									<div class="dingdan_wode">
										<span class="plus_span">plus尊享</span>
										<input class="plus_input" type="button" id="" value="开通plus会员>" /> 
									</div>
										
										
									<div class="dingdan_text2">
										<ul class="ad_ul2 clearfix">
											<li>
												<div><!--第一条广告-->
													<div class="ad_li_div12"><!--图片-->
														<img class="ad_img12" src="img/益达.jpg"/>
													</div>
													<div class="ad_li_div2">
														<a href="xx">益达（Extra）木糖醇无糖口香糖混合味70粒98g单瓶装（新旧包装随机发）</a>
													</div>
													<div class="ad_li_div22"><!--价格-->
														$5.00
													</div>
												</div>
												<div class="ad_li_div22">
													<input type="button" value="加入购物车" class="ad_li_button2"/>
												</div>
											</li>
											<li>
												<div><!--第一条广告-->
													<div class="ad_li_div12"><!--图片-->
														<a href="xx"><img class="ad_img12" src="img/无糖口香糖.jpg"></a>
													</div>
													<div class="ad_li_div2"><!--文字-->
														<a href="xx">曼妥思清劲无糖口香糖清新薄荷味瓶装56克薄荷糖 休闲零食</a>
													</div>
													<div class="ad_li_div22"><!--价格-->
														$6.00
													</div>
												</div>
												<div class="ad_li_div22">
													<input type="button" value="加入购物车" class="ad_li_button2"/>
												</div>
											</li>
											<li>
												<div><!--第一条广告-->
													<div class="ad_li_div12"><!--图片-->
														<a href="xx"><img class="ad_img12" src="img/绿箭.jpg"></a>
													</div>
													<div class="ad_li_div2"><!--文字-->
														<a href="xx">绿箭无糖薄荷糖原味薄荷味35粒23.8g单盒金属装（新旧包装随机发）
															绿箭无糖薄荷糖原味薄荷味35粒23.8g单盒金属装（新旧包装随机发）
														</a>
													</div>
													<div class="ad_li_div22"><!--价格-->
														$7.00
													</div>
												</div>
												<div class="ad_li_div22">
													<input type="button" value="加入购物车" class="ad_li_button2"/>
												</div>
											</li>
											<li>
												<div><!--第一条广告-->
													<div class="ad_li_div12"><!--图片-->
														<a href="xx"><img class="ad_img12" src="img/巧克力.jpg"></a>
													</div>
													<div class="ad_li_div2"><!--文字-->
														<a href="xx">好时之吻Kisses牛奶巧克力82g休闲零食糖果分享（新老包装随机发货）</a>
													</div>
													<div class="ad_li_div22"><!--价格-->
														$8.00
													</div>
												</div>
												<div class="ad_li_div22">
													<input type="button" value="加入购物车" class="ad_li_button2"/>
												</div>
											</li>
										</ul>
									</div>
									<div class="ad_button">
													<input type="button" value="1" class="ad_li_button3"/>
													<input type="button" value="2" class="ad_li_button3"/>
													<input type="button" value="3" class="ad_li_button3"/>
									</div>
								</div>
							</div>	
						</div>
	
	
						<div class="maiju">	
						<div><!--第二列第二行第一列下半部分,BOX2-->
							<div><!--买什么-->
								<div class="dingdan_wode"><!--文字-->
										<span class="plus_span">买什么</span><span>看看达人们都在买的商品</span>
										<a class="float_right" href="">更多<i class="iconfont icon-xiangyoujiantou"></i></a> 
								</div>
								<div class="maiju_mc"><!--图片-->
									<div class="maiju_mc_left">
										<a href="xx" class="maiju_name">2018春天跟着这样穿太美了</a>
										<div class="maiju_owner">
											<a href="xx" class="nickname">shabia</a>
											<button class="maiju_button1"><i class="iconfont icon-huo"></i>5</button>
											<button class="maiju_button2"><i class="iconfont icon-jushoucang"></i>8</button>
										</div>
										<div class="maiju_img">
											<a href="xx" class="maiju_img_a"><img class="maiju_img_img" src="img/买聚1.jpg"></a>
											<ul class="maiju_ul">
												<li>
													<a href="xx"><img src="img/买聚2.jpg"/></a>
												</li>
												<li>
													<a href="xx"><img src="img/买聚3.jpg"/></a>
												</li>
											</ul>
											<span class="maiju_total">19张</apan>
										</div>
									</div>
									<div class="maiju_mc_left">
										<a href="xx" class="maiju_name">2018春天跟着这样穿太美了</a>
										<div class="maiju_owner">
											<a href="xx" class="nickname">shabia</a>
											<button class="maiju_button1"><i class="iconfont icon-huo"></i>5</button>
											<button class="maiju_button2"><i class="iconfont icon-jushoucang"></i>8</button>
										</div>
										<div class="maiju_img">
											<a href="xx" class="maiju_img_a"><img class="maiju_img_img" src="img/买聚1.jpg"></a>
											<ul class="maiju_ul">
												<li>
													<a href="xx"><img src="img/买聚2.jpg"/></a>
												</li>
												<li>
													<a href="xx"><img src="img/买聚3.jpg"/></a>
												</li>
											</ul>
											<span class="maiju_total">19张</apan>
										</div>
									</div>
								</div>
							</div>
							<div><!--巨喜欢-->
								
							</div>
						</div>
					</div>
					</div>
					<div class="right_222"><!--第二列第二行第二列BOX3-->
						<div class="guanzhu"><!--我的关注-->
							<div class="dingdan_wode">
									<h3>我的关注</h3>
							</div>
							<div class="guanzhu_mc">
								<div class="guanzhu_nav clearfix">
									<a href="xx"><!--显示各种信息的数量-->
										<div>0</div>
										<span class="dingdan_name">商品关注</span>
									</a>
									<a href="xx"><!--显示各种信息的数量-->
										<div>1</div>
										<span class="dingdan_name">店铺关注</span>
									</a>
									<a href="xx"><!--显示各种信息的数量-->
										<div>0</div>
										<span class="dingdan_name">收藏内容</span>
									</a>
								</div>
							</div>
						</div>
						<div class="liulan"><!--浏览记录-->
							<div class="dingdan_wode clearfix">
									<h3 style="float: left;">我的关注</h3>
									<a href="xx" style="float: right;">更多<i class="iconfont icon-xiangyoujiantou"></i></a>
							</div>
							<div>
								<div class="liulan_nav clearfix">
									<a href="xx"><!--显示各种信息的数量-->
										<img class="liulan_img" src="img/绿箭.jpg" />
									</a>
									<a href="xx"><!--显示各种信息的数量-->
										<img class="liulan_img" src="img/口香糖.jpg" />
									</a>
									<a href="xx"><!--显示各种信息的数量-->
										<img class="liulan_img" src="img/巧克力.jpg" />
									</a>
									<a href="xx"><!--显示各种信息的数量-->
										<img class="liulan_img" src="img/益达.jpg" />
									</a>
									<ul class="guanzhu_ul">
									<li class="guanzhu_li">
										<button class="guanzhu_button"></button>
									</li>
									<li class="guanzhu_li">
										<button class="guanzhu_button"></button>
									</li>
									<li class="guanzhu_li">
										<button class="guanzhu_button"></button>
									</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="liulan"><!--生活服务-->
							<div class="dingdan_wode clearfix">
									<h3 style="float: left;">生活服务</h3>
							</div>
							<div>
								<div class="liulan_nav clearfix">
									<li class="fuwu_li">
										<ul class="fuwu_ul clearfix">
											<li class="clearfix">
												<a href="xx" class="fuwu_a">
													<i class="iconfont icon-tishi fuwu_i"></i>
													<span class="fuwu_span">话费</span>
												</a>
											</li>
											<li>
												<a href="xx" class="fuwu_a">
													<i class="iconfont icon-tishi fuwu_i"></i>
													<span class="fuwu_span">机票</span>
												</a>
											</li>
											<li>
												<a href="xx" class="fuwu_a">
													<i class="iconfont icon-tishi fuwu_i"></i>
													<span class="fuwu_span">酒店</span>
												</a>
											</li>
											<li>
												<a href="xx" class="fuwu_a">
													<i class="iconfont icon-tishi fuwu_i"></i>
													<span class="fuwu_span">企业购</span>
												</a>
											</li>
											<li>
												<a href="xx" class="fuwu_a">
													<i class="iconfont icon-tishi fuwu_i"></i>
													<span class="fuwu_span">加油卡</span>
												</a>
											</li>
											<li>
												<a href="xx" class="fuwu_a">
													<i class="iconfont icon-tishi fuwu_i"></i>
													<span class="fuwu_span">电影票</span>
												</a>
											</li>
										</ul>
									</li>
								</div>
								<ul class="guanzhu2_ul fuwu_ul2">
									<li class="guanzhu_li">
										<button class="guanzhu_button"></button>
									</li>
									<li class="guanzhu_li">
										<button class="guanzhu_button"></button>
									</li>
								</ul>
							</div>
						</div>
					</div>					
				</div>
			</div>
		</div>	
		
		<div id="buttom">
			<div class="dkhs_2">
				<img src="img/多快好省.jpg" />
			</div>
			<div id="buttom_lianjie">
				<div class="wrap clearfix">
					<dl class="fore1">
						<dt class="fore_dt">购物指南</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-29.html">购物流程</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-151.html">会员介绍</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-297.html">生活旅行/团购</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue.html">常见问题</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-136.html">大家电</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/index.html">联系客服</a></dd>
					</dl>
					<dl class="fore2">		
						<dt class="fore_dt">配送方式</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-81-100.html">上门自提</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-81.html">211限时达</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/103-983.html">配送服务查询</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/109-188.html">配送费收取标准</a></dd>				
						<dd><a target="_blank" href="//help.joybuy.com/help/question-list-201.html">海外配送</a></dd>
					</dl>
					<dl class="fore3">
						<dt class="fore_dt">支付方式</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-172.html">货到付款</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-173.html">在线支付</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-176.html">分期付款</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-174.html">邮局汇款</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-175.html">公司转账</a></dd>
					</dl>
					<dl class="fore4">		
						<dt class="fore_dt">售后服务</dt>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/321-981.html">售后政策</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-132.html">价格保护</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/130-978.html">退款说明</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//myjd.jd.com/repair/repairs.action">返修/退换货</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//help.jd.com/user/issue/list-50.html">取消订单</a></dd>
					</dl>
					<dl class="fore5">
						<dt class="fore_dt">特色服务</dt>	
						<dd><a target="_blank" href="//help.jd.com/user/issue/list-133.html">夺宝岛</a></dd>
						<dd><a target="_blank" href="//help.jd.com/user/issue/list-134.html">DIY装机</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//fuwu.jd.com/">延保服务</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//o.jd.com/market/index.action">京东E卡</a></dd>				
						<dd><a rel="nofollow" target="_blank" href="//mobile.jd.com/">京东通信</a></dd>
						<dd><a rel="nofollow" target="_blank" href="//s.jd.com/">京东JD+</a></dd>
					</dl>
				</div>
				<div id="footer-2017">
					<div class="w">
						<div class="copyright_links">
							<p>
								<a href="//about.jd.com" target="_blank">关于我们</a><span class="copyright_split">|</span>
								<a href="//about.jd.com/contact/" target="_blank">联系我们</a><span class="copyright_split">|</span>
								<a href="//help.jd.com/user/custom.html" target="_blank">联系客服</a><span class="copyright_split">|</span>
								<a href="//vc.jd.com/cooperation.html" target="_blank">合作招商</a><span class="copyright_split">|</span>
								<a href="//helpcenter.jd.com/venderportal/index.html" target="_blank">商家帮助</a><span class="copyright_split">|</span>
								<a href="//jzt.jd.com" target="_blank">营销中心</a><span class="copyright_split">|</span>
								<a href="//app.jd.com/" target="_blank">手机京东</a><span class="copyright_split">|</span>
								<a href="//club.jd.com/links.aspx" target="_blank">友情链接</a><span class="copyright_split">|</span>
								<a href="//media.jd.com/" target="_blank">销售联盟</a><span class="copyright_split">|</span>
								<a href="//club.jd.com/" target="_blank">京东社区</a><span class="copyright_split">|</span>
								<a href="//sale.jd.com/act/FTrWPesiDhXt5M6.html" target="_blank">风险监测</a><span class="copyright_split">|</span>
								<a href="//about.jd.com/privacy/" target="_blank">隐私政策</a><span class="copyright_split">|</span>
								<a href="//gongyi.jd.com" target="_blank">京东公益</a><span class="copyright_split">|</span>
								<a href="//en.jd.com/" target="_blank">English Site</a><span class="copyright_split">|</span>
								<a href="//corporate.jd.com/" target="_blank">Media & IR</a>
							</p>
						</div>
						<div class="copyright_info">
							<p>
								<a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000088" target="_blank">京公网安备 11000002000088号</a><span class="copyright_split">|</span><span>京ICP证070359号</span><span class="copyright_split">|</span>
								<a
								 href="//img14.360buyimg.com/da/jfs/t256/349/769670066/270505/3b03e0bb/53f16c24N7c04d9e9.jpg" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span></p>
							<p><span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span>
								<a href="//sale.jd.com/act/pQua7zovWdJfcIn.html"
								 target="_blank">出版物经营许可证</a><span class="copyright_split">|</span>
								<a href="//misc.360buyimg.com/wz/wlwhjyxkz.jpg" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span></p>
							<p><span class="copyright_text">Copyright&nbsp;&copy;&nbsp;2004&nbsp;-&nbsp;<em id="copyright_year">2018</em>&nbsp;&nbsp;京东JD.com&nbsp;版权所有</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span>
								<a
								 href="//sale.jd.com/act/7Y0Rp81MwQqc.html" target="_blank" class="copyright_license">经营证照</a><span class="copyright_split">|</span><span>(京)网械平台备字(2018)第00003号</span>
							</p>
							<p class="mod_copyright_inter">
								<a class="mod_copyright_inter_lk" href="//www.joybuy.com/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0501"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_global"></i>Global Site</a><span class="copyright_split">|</span>
								<a
								 class="mod_copyright_inter_lk" href="//www.jd.ru/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0502"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_rissia"></i>Сайт России</a><span class="copyright_split">|</span>
									<a
									 class="mod_copyright_inter_lk" href="//www.jd.id/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0503"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_indonesia"></i>Situs Indonesia</a><span class="copyright_split">|</span>
										<a
										 class="mod_copyright_inter_lk" href="//www.joybuy.es/?source=1&visitor_from=3" target="_blank" clstag="h|keycount|btm|btmnavi_null0503"><i class="mod_copyright_inter_ico mod_copyright_inter_ico_spain"></i>Sitio de España</a>
							</p>
							<p><span>京东旗下网站：</span>
								<a href="https://www.jdpay.com/" target="_blank">京东钱包</a><span class="copyright_split">|</span>
								<a href="http://www.jcloud.com" target="_blank">京东云</a>
							</p>
						</div>
						<p class="copyright_auth">
							<a class="copyright_auth_ico copyright_auth_ico_1" href="http://www.hd315.gov.cn/beian/view.asp?bianhao=010202007080200026"
							 target="_blank">经营性网站备案中心</a>
							<script type="text/JavaScript">function CNNIC_change(eleId){var str= document.getElementById(eleId).href;var str1 =str.substring(0,(str.length-6));str1+=CNNIC_RndNum(6);
								document.getElementById(eleId).href=str1;}function CNNIC_RndNum(k){var rnd=""; for (var i=0;i
								< k;i++) rnd+=Math.floor(Math.random()*10);
								 return rnd;};(function(){var d=new Date;document.getElementById( "copyright_year").innerHTML=d.getFullYear()})();</script>
									<a id="urlknet" class="copyright_auth_ico copyright_auth_ico_2" onclick="CNNIC_change('urlknet')" oncontextmenu="return false;"
									 name="CNNIC_seal" href="https://ss.knet.cn/verifyseal.dll?sn=2008070300100000031&ct=df&pa=294005" target="_blank">可信网站信用评估</a>
									<a class="copyright_auth_ico copyright_auth_ico_3" href="http://www.cyberpolice.cn/" target="_blank">网络警察提醒你</a>
									<a class="copyright_auth_ico copyright_auth_ico_4" href="https://search.szfw.org/cert/l/CX20120111001803001836"
									 target="_blank">诚信网站</a>
									<a class="copyright_auth_ico copyright_auth_ico_5" href="http://www.12377.cn" target="_blank">中国互联网举报中心</a>
									<a class="copyright_auth_ico copyright_auth_ico_6" href="http://www.12377.cn/node_548446.htm" target="_blank">网络举报APP下载</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>