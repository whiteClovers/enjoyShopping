<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/foot.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pjdd.css" />
<title>EvaluateCenter</title>
</head>
<body>

<div id="shortcut">
			<div class="w">
		    	<div class="top_nav clearfix"><!--顶部导航条-->
			    	<ul class="top_ul_left clearfix">
			    		<li id="top_nav_home_id"><i class="top_nav_home"></i><a href="${pageContext.request.contextPath}/user/HomepageServlet.do" target="_blank">京东首页</a></li>
			    		<li class="top_nav_position" id="top_nav_position_id">北京</li><!--定位-->
			    	</ul>
			    	<ul class="top_ul_right clearfix">
						<li class="login" id="login_id">
							<!-- <a href="MyInformServerlet.do">你好，请登录<a>&nbsp;&nbsp;<a href="javascript:regist();" class="link-regist style-red">免费注册</a> -->
						
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
								<a target="_blank" href="${pageContext.request.contextPath}/user/MyOrderServerlet.do">我的订单</a>
							</div>
						</li>
						<li class="spacer">|</li>
						
						<li class="ower" id="ower_id">
							<div class="ower_div">
								<!-- <i class="ci-right"><s>◇</s></i> -->
								<a target="_blank" href="xx">我的京东</a><i class="iconfont"></i>
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
						
						<li class="buy" id="buy_id">
							<div class="buy_div">
								<a target="_blank" href="xx">企业采购</a>
							</div>
						</li>
						<li class="spacer">|</li>
						
						<li class="fuwu" id="fuwu_id">
							<div class="fuwu_div">
								客户服务<i class="iconfont"></i>
							</div>
							<div class="fuwu_div_2"></div>
						</li>
						<li class="spacer">|</li>
						
						<li class="daohang" id="daohang_id">
							<div class="daohang_div">
								网站导航<i class="iconfont"></i>
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
	 	</div>
	 	<div class="redheader_wrap">
	    	<div class="redheader clearfix" style="width: 1210px; margin: 0 auto;">
	    
	    		<div class="redhjdlogo clearfix redheader_left">
	    			<a href="" class="redhjdlogo1 redheader_left">
	    				<img src="img/jdlogo233.png" alt="" width="158px" height="80px">
	    			</a>
	    			<div class="redhjdlogo_link redheader_left">
	    				<a href="" class="redhjdlogo_link1 redheader_fsz20">我的京东</a>
	    
	    				<a href="" class="redhjdlogo_link2 fsz12 fsz12">返回京东首页</a>
	    			</div>
	    		</div>
	    		<div class="redheader_navitems redheader_left">
	    			<ul class="clearfix fsz14">
	    				<li class="redheader_navitem">
	    					<span class="redheader_navitem1">首页</span>
	    				</li>
	    				<li class="redheader_navitem">
	    					<span class="redheader_navitem_icon">
	    								<span>账户设置</span>
	    					<i class="iconfont icon-icon_on_the_down fsz12"></i>
	    					</span>
	    				</li>
	    				<li class="redheader_navitem">
	    					<span class="redheader_navitem_icon">
	    								<span>社区</span>
	    					<i class="iconfont icon-icon_on_the_down fsz12"></i>
	    					</span>
	    				</li>
	    				<li class="redheader_navitem">
	    					<span>消息</span>
	    				</li>
	    			</ul>
	    		</div>
	    		<div class="redheader_navr clearfix fsz12 redheader_right">
	    			<div class="redheader_navr1" clearfix="">
	    				<input type="text" class="redheader_navr1_input" style="padding-bottom: 3px;">
	    				<button class="redheader_navr1_btn" style="margin-left: -4px;">搜索</button>
	    			</div>
	    			<div class="redheader_navr2">
	    				<span>
	    						<i class="iconfont icon-gouwuche1 redheader_navr2_gouwuche1"></i>
	    						<a href="${pageContext.request.contextPath}/user/SettlementServlet.do">
									我的购物车
									</a>
	    				<i class="iconfont icon-xiangyou redheader_navr2_xiangyou"></i>
	    				</span>
	    			</div>
	    
	    		</div>
	    
	    	</div>
	    
	    </div>
		<div class="background2">
			<div class="div_wrap clearfix float">
				<div>
					<div class="m_top30 m_top10">
						<div class="jiacu">订单中心</div>
						<div>我的订单</div>
						<div>我的活动</div>
						<div>评价晒单</div>
						<div>我的常购商品</div>
						<div>购物助手</div>
					</div>
					<div class="m_top30 m_top10">
						<div class="jiacu">关注中心</div>
						<div>关注的商品</div>
						<div>关注的店铺</div>
						<div>关注的专辑</div>
						<div>收藏的内容</div>
						<div>关注的活动</div>
					</div>
					<div class="m_top30 m_top10">
						<div class="jiacu">资产中心</div>
						<div>小金库</div>
						<div>京东白条</div>
						<div>领货码</div>
						<div>余额</div>
						<div>优惠券</div>
						<div>礼品卡</div>
						<div>京豆</div>
						<div>京东钢镚</div>
					</div>
					<div class="m_top30 m_top10">
						<div class="jiacu">特色业务</div>
						<div>我的营业厅</div>
						<div>京东通信</div>
						<div>定期购</div>
						<div>我的回收单</div>
						<div>节能补贴</div>
						<div>医药服务</div>
						<div>流量加油站</div>
						<div>黄金托管</div>
						<div>视频教育订单</div>
						<div>海外房产预约</div>
						<div>我的全球购</div>
						<div>装修服务/div&gt;
						<div>我的拍卖</div>
						<div>我的集运</div>
					</div>
					<div class="m_top30 m_top10">
						<div class="jiacu">客户服务</div>
						<div>返修退换货</div>
						<div>价格保护</div>
						<div>意见建议</div>
						<div>我的问答</div>
						<div>购买咨询</div>
						<div>交易纠纷</div>
						<div>京东维修</div>
						<div>上门预约服务</div>
						<div>我的发票</div>
						<div>举报中心</div>
					</div>
					<div class="m_top30 m_top10">
						<div class="jiacu">设置</div>
						<div>个人信息</div>
						<div>收货地址</div>
					</div>
					<div class="m_top30"><img src="img/黄渤.jpg"></div>
				</div>
			</div>
			<div>
				<div class="background3 mod1">
                    <div class="jiacu m_move font_size">评价晒单</div>
                </div>
                <div class="background3 ">
	                <div class="mod2 m_move2 clearfix float">
	                	<div class="m_move3 font_size">
	                		<span>待评价订单</span>
	                		<span class="m_move4">待晒单</span>
	                		<span class="m_move4">待评价</span>
	                		<span class="m_move4">服务评价</span>
	                		<span class="m_move4">已评价</span>
	                	</div>
	                	<div class="m-joytip">
							<div class="tip-main face-wx">
								<i class="tip-icon"></i>
								<div class="tip-info">
									<h5 class="tip-title">没有要评价的订单，看看下面推荐的好评商品吧~</h5>
								</div>
							</div>
						</div>
	                </div>
	                	
	              
                </div>
                <div class="m_move6 background3">
                	<div class="float clearfix">
                		<div class="m_move15">买什么</div>
                		<div class="m_move16">查看更多商品专辑</div>
                	</div>
                	<div class="float clearfix">
                		<div class="m_move15"><img src="img/shuiguo.png"></div>
                		<div class="m_move15"><img src="img/chufangxiaogongju.png"> </div>
                		<div class="m_move15"><img src="img/xuegao.png"></div>
                		<div class="m_move15"><img src="img/chiji.png"></div>
                	</div>
	            </div>
	            <div class="m_move6 background3">
                	<div>
                		<img src="img/jdzzzzzzz.png">
                	</div>
                	<div>
                		<div class="m_move6"><img src="img/meiren.png"></div>
                	</div>
	            </div>
                
					
			</div>
				
		</div>

	</div>
		
		<div id="GLOBAL_FOOTER" >        <!--service start-->
			<div id="service-2017">
				<div class="w">
					<ol class="slogen">
						<li class="item fore1">
							<i>多</i>品类齐全，轻松购物
						</li>
						<li class="item fore2">
							<i>快</i>多仓直发，极速配送
						</li>
						<li class="item fore3">
							<i>好</i>正品行货，精致服务
						</li>
						<li class="item fore4">
							<i>省</i>天天低价，畅选无忧
						</li>
					</ol>
				</div>
				<div class="jd-help">
					<div class="w">
						<div class="wrap">
							<dl class="fore1">
								<dt>购物指南</dt>
								<dd><a rel="nofollow" target="_blank" href="">购物流程</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">会员介绍</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">生活旅行/团购</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">常见问题</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">大家电</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">联系客服</a></dd>
							</dl>
							<dl class="fore2">		
								<dt>配送方式</dt>
								<dd><a rel="nofollow" target="_blank" href="">上门自提</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">211限时达</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">配送服务查询</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">配送费收取标准</a></dd>				
								<dd><a target="_blank" href="">海外配送</a></dd>
							</dl>
							<dl class="fore3">
								<dt>支付方式</dt>
								<dd><a rel="nofollow" target="_blank" href="">货到付款</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">在线支付</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">分期付款</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">邮局汇款</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">公司转账</a></dd>
							</dl>
							<dl class="fore4">		
								<dt>售后服务</dt>
								<dd><a rel="nofollow" target="_blank" href="">售后政策</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">价格保护</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">退款说明</a></dd>
								<dd><a rel="nofollow" target="_blank" href="n">返修/退换货</a></dd>
								<dd><a rel="nofollow" target="_blank" href="l">取消订单</a></dd>
							</dl>
							<dl class="fore5">
								<dt>特色服务</dt>	
								<dd><a target="_blank" href="">夺宝岛</a></dd>
								<dd><a target="_blank" href="">DIY装机</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">延保服务</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">京东E卡</a></dd>				
								<dd><a rel="nofollow" target="_blank" href="">京东通信</a></dd>
								<dd><a rel="nofollow" target="_blank" href="">京东JD+</a></dd>
							</dl>
							<span class="clr"></span>
						</div>
					</div>
				</div>
			</div>
			<!--service end-->        <!--footer start-->
			<div id="footer-2017">
				<div class="w">
					<div class="copyright_links">
						<p>
							<a href="" target="_blank">关于我们</a><span class="copyright_split">|</span>
							<a href="" target="_blank">联系我们</a><span class="copyright_split">|</span>
							<a href="" target="_blank">联系客服</a><span class="copyright_split">|</span>
							<a href="" target="_blank">合作招商</a><span class="copyright_split">|</span>
							<a href="" target="_blank">商家帮助</a><span class="copyright_split">|</span>
							<a href="">营销中心</a><span class="copyright_split">|</span>
							<a href="">手机京东</a><span class="copyright_split">|</span>
							<a href="" target="_blank">友情链接</a><span class="copyright_split">|</span>
							<a href="" target="_blank">销售联盟</a><span class="copyright_split">|</span>
							<a href="" target="_blank">京东社区</a><span class="copyright_split">|</span>
							<a href="" target="_blank">风险监测</a><span class="copyright_split">|</span>
							<a href="" target="_blank">隐私政策</a><span class="copyright_split">|</span>
							<a href="" target="_blank">京东公益</a><span class="copyright_split">|</span>
							<a href="" target="_blank">English Site</a><span class="copyright_split">|</span>
							<a href="" target="_blank">Media &amp; IR</a>
						</p>
					</div>
					<div class="copyright_info">
						<p>
							<a href="" target="_blank">京公网安备 11000002000088号</a><span class="copyright_split">|</span><span>京ICP证070359号</span><span class="copyright_split">|</span>
							<a href="//img14.360buyimg.com/da/jfs/t256/349/769670066/270505/3b03e0bb/53f16c24N7c04d9e9.jpg" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span></p>
						<p><span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span>
							<a href="" target="_blank">出版物经营许可证</a><span class="copyright_split">|</span>
							<a href="//misc.360buyimg.com/wz/wlwhjyxkz.jpg" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span></p>
						<p><span class="copyright_text">Copyright&nbsp;©&nbsp;2004&nbsp;-&nbsp;<em id="copyright_year">2018</em>&nbsp;&nbsp;京东JD.com&nbsp;版权所有</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span>
							<a href="" target="_blank" class="copyright_license">经营证照</a><span class="copyright_split">|</span><span>(京)网械平台备字(2018)第00003号</span>
						</p>
						<p class="mod_copyright_inter">
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_global"></i>Global Site</a><span class="copyright_split">|</span>
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_rissia"></i>Сайт России</a><span class="copyright_split">|</span>
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_indonesia"></i>Situs Indonesia</a><span class="copyright_split">|</span>
							<a class="mod_copyright_inter_lk" href="" target="_blank" ><i class="mod_copyright_inter_ico mod_copyright_inter_ico_spain"></i>Sitio de Espa?a</a>
						</p>
						<p><span>京东旗下网站：</span>
							<a href="https:" target="_blank">京东钱包</a><span class="copyright_split">|</span>
							<a href="" target="_blank">京东云</a>
						</p>
					</div>
					<p class="copyright_auth">
						<a class="copyright_auth_ico copyright_auth_ico_1" href="" target="_blank">经营性网站备案中心</a>
						
								<a id="urlknet" class="copyright_auth_ico copyright_auth_ico_2"  oncontextmenu="return false;" name="CNNIC_seal" href="" target="_blank">可信网站信用评估</a>
								<a class="copyright_auth_ico copyright_auth_ico_3" href="" target="_blank"><i ></i>网络警察提醒你</a>
								<a class="copyright_auth_ico copyright_auth_ico_4" href="" target="_blank">诚信网站</a>
								<a class="copyright_auth_ico copyright_auth_ico_5" href="" target="_blank">中国互联网举报中心</a>
								<a class="copyright_auth_ico copyright_auth_ico_6" href="" target="_blank">网络举报APP下载</a>
					</p>
				</div>
			</div>
			<!--footer end-->
		</div>

</body>
</html>