<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/b.css"/>
</head>
<body style="margin:0px;">
		<div>
			<div style="float:left;margin-left: 424px;"><img src="${pageContext.request.contextPath}img/goudong.png" alt="logo" title="1"/>
			</div>
			<div style="float:left;font-size:25px;margin-top: 28px;">欢迎登录</div>
			<div style="float:left;font-size:12px;margin-left: 610px;margin-top: 46px;"><span class="dr">登录页面，调查问卷</span></span></div>
			<div style="clear:both;">
		</div>	
		
		<div class="welcome">
			<div style="font-size:12px;margin-left: 567px;">
				<span class="dr">依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！ 新版</span>
				《京东隐私政策》<span class="dr">已上线，将更有利于保护您的个人隐私。</span></div>
		</div>
		
		<div class="bg">
			<div style="float:left;margin-left: 417px;">
				<img src="img/tup.png" alt="logo" title="1"/>
			</div>
			<div style="float:left;width:346px;height:440px;margin-top: 11px;">
				<div id="hb">京东不会以任何理由要求您转账汇款，谨防诈骗。</div>
				<div class="jh">
					<!-- <div id="smdl"style="float:left;">扫码登录</div>
					<div id="shux"style="float:left;">｜</div> -->
					<div id="zhdl"style="float:left;margin-left: 125px;">账户登录</div>
					
					<div style="clear:both;"></div>
					
				<!-- 登录form处 -->
				<form action="LoginServlet.do" method="post" target="_blank">
				<input type="hidden" name="method" value="login" >
				<div style="width: 260px;text-align: right;">
					<div style="margin-top: 15px;margin-left: 12px;">
						手机号：<input type="text" name="customerPhone" value="${session_customer.customerPhone }" /><br/>
					</div>
					<div style="margin-left: 12px;" >
						密码：<input type="password" name="password"  /> <%-- value="${customer.customerPwd } --%>
					</div>
					<div style="margin-left: 12px;" >
						<input type="submit" value="登录" />
					</div>
				</div>
				</form>
				</div>
					
					
				<!-- <div class="erweima">
					<div class="erwei"><img src="img/show.png" style="margin-left:100px;margin-top: 30px;"/></div>
				</div>
				<div id="dakai">打开 <span style="color:red;">手机京东</span>  扫描二维码</div>
				<div id="momo">
					<div style="float:left;margin-top:21px;margin-left:80px;">免输入</div>
					<div style="float:left;margin-top:21px;margin-left: 55px;">更快</div>
					<div style="float:left;margin-top:21px;margin-left: 58px;">更安全</div>
					<div style="clear:both;"></div>
				</div> -->
				<div class="nml">
					<div style="float:left;margin-top:17px;margin-left:21px;"><img src="img/qq.png"/></div>
					<div style="float:left;margin-top:18px;font-size:8px;color:darkgray;">QQ</div>
					<div style="float:left;margin-top:17px;font-size:8px;margin-left:4px;color:darkgray;">｜</div>
					<div style="float:left;margin-top:17px;margin-left: 4px;"><img src="img/weixin.jpg"/></div>
				    <div style="float:left;margin-top:18px;font-size:8px;color:darkgray;">微信</div>
					<div style="float:left;margin-top:17px;margin-left: 107px;"><img src="img/rt.png"/></div>
					<div style="float:left;margin-top:17px;">
					
						<button>
							<a href="${pageContext.request.contextPath}/user/RegisterServlet.do">立即注册</a>
						</button>
					
					</div>
					<div style="clear:both;"></div>
				</div>
			</div>
			<div style="clear:both;"></div>
		</div>
		<div class="ert">
			<div style="float:left;margin-left: 516px;">关于我们</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">联系我们</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">人才招聘</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">商家入驻</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">广告服务</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">手机京东</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">友情链接</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">销售联盟</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">京东社区</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">京东公益</div>
			<div style="float:left;margin-left: 4px;">｜</div>
			<div style="float:left;margin-left: 4px;">English Site</div>
			<div style="clear:both;"></div>
		</div>
		<div style="font-size:12px;text-align:center;margin-top:10px;color:darkgray;height: 60px;">Copyright © 2004-2018  京东JD.com 版权所有</div>
</html>