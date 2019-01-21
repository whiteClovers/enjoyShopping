<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/zc.css" />
		
	 	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>  --%>
	</head>
	<script type="text/javascript">
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) {
			xmlHttpRequest = new XMLHttpRequest();
		}else {
			xmlHttpRequest = new ActiveXObject(MSXML.XMLHTTP); // Microsoft
		}
		
		if (XMLHttpRequest == undefined || XMLHttpRequest == null) {
			alert("XMLHttpRequest创建失败");
		}
	}
	function  checkNameExit() {
		var customerNameNode = document.getElementById("customerName");
		var customerName = customerNameNode.value;
		if (customerName == "" || customerName == null) {
			 document.getElementById("checkName").innerHTML = "<font color='red'>用户名不能为空</font>";
	    	 
	    	 return false ;
		}
		
	 	var url = "${pageContext.request.contextPath}/user/RegisterServlet.do?method=checkName&customerName="+document.getElementById("customerName").value;
		//var url = "${pageContext.request.contextPath}/user/RegisterServlet.do?method=checkName";
	    //创建核心xmlhttprequest组件
	    createXMLHttpRequest();
	    //设置回调函数
	    xmlHttpRequest.onreadystatechange = myCallback;
	    //初始化核心组件
	    xmlHttpRequest.open("get", url, true);
	    //设置请求头
// 		xmlHttpRequest.setRequestHeader("Content-Type","application/x-form-www-urlencoded;");
	    //发送请求
// 	    alert(customerName);
	    xmlHttpRequest.send(null); 
	}

	/* function checkNickNameExit() {
		var customerNickNameNode = document.getElementById("customerNickName");
		var customerNickName = customerNickNameNode.value ;
		if (customerNickName == "" || customerNickName == null) {
			 document.getElementById("checkNickName").innerHTML = "<font color='red'>昵称不能为空</font>";
	    	 
	    	 return false ;
		}
		
		var url = "${pageContext.request.contextPath}/user/RegisterServlet.do?method=checkName";
	} */
	
	function myCallback() {
		if (xmlHttpRequest.readyState == 4 ) {
			if (xmlHttpRequest.status == 200) {
				var b = xmlHttpRequest.responseText;
				if (b == "true") {
					document.getElementById("checkName").innerHTML = "<font color='red'>该用户名已经存在！</font>";
					
					/* location.reload(); */
				} else if(b == "false"){
					document.getElementById("checkName").innerHTML = "<font color='blue'>该用户名可以使用</font>";
					//return ;
				}
				
			}
		}
	}
	</script>
	<body>
		<div class="header">
	        <div class="logo-con w clearfix">
	            <a href="#none" class="logo">
	            </a>
	            <div class="logo-title">欢迎注册</div>
						
	            <div class="have-account">已有账号？ <a href="#none">
	            	<form action="LoginServlet.do" method="post">
	            		<button>请登录&gt;</button>
	            	</form>
	            </a></div>
	
	        </div>
	    </div>
	    <div class="w">
	    	<div class="progress-bar clearfix">
		        <div class="pro-step cur-step ">
		            <span class="step-index">1</span>
		            <p class="step-desc">验证手机号</p>
		        </div>
		        <div class="pro-line pro-line1 person-pro-line person-pro-line1 "></div>
		        <div class="pro-step pro-step2 person-pro-step2  ">
		            <span class="step-index">2</span>
		            <p class="step-desc">填写账号信息</p>
		        </div>
		        <div class="pro-line pro-line2 person-pro-line person-pro-line2 "></div>
		        <div class="pro-step pro-step3 person-pro-step3  ">
		            <span class="step-index">3</span>
		            <p class="step-desc">注册成功</p>
		        </div>
		    </div>
		    <div class="main">
		    	<div class="reg-form">
		    		<!-- <form action="" id="register-form" method="POST" novalidate="novalidate"> -->
		    			<div id="step1-wrap" style="width: 800px;">
	<div class="item-phone-wrap">
		 <div class="form-item form-item-phone">
                   <form action="RegisterServlet.do" method="post"> 
                   <input type="hidden" name="method" value="register" >
                   
                     <label class="select-country" id="select-country" country_id="0086" 
                     	style="border-top: 1px solid rgb(221, 221, 221); border-right: none rgb(221, 221, 221); 
                     	border-bottom: 1px solid rgb(221, 221, 221); border-left: 1px solid rgb(221, 221, 221); 
                     	border-image: initial;">中国 0086<a href="javascript:void(0) " class="arrow"></a></label>
                     	
                     <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);width: 520px;">
 					<input type="text" name="customerPhone" id="customerPhone" onblur="checkPhone()" 
 						style="margin: 1px;width:282px;height:22px;" />
                     	<p type="text" id="checkPhone"  style="display: inline;"></p>
                     </div>
                     
                     <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);width: 520px;
                     	margin-left: 108px;margin-top: 15px;">
                     	姓名：<input type="text" name="customerName" id="customerName" onblur="checkNameExit()" style="margin: 1px;width:282px;height:22px;"/>
                     	<p type="text" id="checkName"  style="display: inline;"></p>
                     	
                     </div>
                     
                     <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);width: 520px;
                     	margin-left: 108px;margin-top: 15px;">
                     	昵称：<input type="text" name="customerNickName" id="customerNickName" onchange="checkNickNameExit()" style="margin: 1px;width:282px;height:22px;">
                     	<p type="text" id="checkNickName"  style="display: inline;"></p>
                     </div>
                     
                     <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);width: 520px;
                     	margin-left: 108px;margin-top: 15px;">
                     	密码：<input type="text" name="customerPwd" style="margin: 1px;width:282px;height:22px;">
                     	<p type="text" id="checkPassword"  style="display: inline;"></p>
                     </div>
                     
                     <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);width: 720px;
                     	margin-left: 108px;margin-top: 15px;">
                     	确认密码：<input type="text" name="customerPwd" style="margin: 1px;width:282px;height:22px;">
                     	<p type="text" id="checkPasswordConfirm"  style="display: inline;"></p>
                     </div>
                     
                     <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);width: 720px;
                     	margin-left: 108px;margin-top: 15px;">
                     	身份证号码：<input type="text" name="customerIdCard" style="margin: 1px;width:282px;height:22px;">
                     	<p type="text" id="checkIdCard"  style="display: inline;"></p>
                     </div>
                     
                      <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);width: 720px;
                     	 margin-left: 108px;margin-top: 15px;">
                     	邮箱：<input type="text" name="customerEmail" style="margin: 1px;width:282px;height:22px;">
                     	<p type="text" id="checkEmail"  style="display: inline;"></p>
                     </div>
                     
                     <!-- <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);margin-left: 108px;">
                     	性别：<input type="text" name="customerSex" style="margin: 1px;width:282px;height:42px;">
                     </div> -->
                     
                      <!-- <div class="item-input-wrap form-item-error" style="border: 1px solid rgb(221, 221, 221);margin-left: 108px;">
                     	生日：<input type="text" name="phone" style="margin: 1px;width:282px;height:42px;">
                     </div> -->
                  
                     <!-- <input type="submit" value="注册" style="width: 55px;height: 20px;"> -->
                     
                     <button id="button" >注册</button>
                 </form>    
                     <!-- <div class="input-tip">
                     	<span id="form-phone-error" class="error">
                     		<i class="i-error"></i>请输入手机号
                     	</span>
                     </div> -->
     </div>
		    				</div>
		    				<div class="item-getcode-wrap" style="margin-top: 400px;">
		    					<div class="form-item form-item-getcode" >
		    						点击按钮进行验证
                                    <div id="slideAuthCode" class="JDValidate-wrap"></div>
                                </div>
		    				</div>
		    				<div class="form-agreen"></div>
		    				<div id="step1-next" class="btn-register" >下一步</div>
		    			</div>
		    		<!-- </form> -->
		    	</div>
		    	<div class="reg-other clearfix">
	                <a href="" class="reg-other-item reg-other-person" >
	                   <i class=""></i>企业用户注册
	                </a>
	                <a href="" class="reg-other-item reg-other-inter" >
                        <i class=""></i>国际站注册
                    </a>
	            </div>
		    </div>
	    </div>
	    
	    <div id="form-footer" class="footer w">
            <div class="links">
            <a rel="nofollow" target="_blank" href=""> 关于我们</a>|
	            <a rel="nofollow" target="_blank" href="">联系我们</a>|
	            <a rel="nofollow" target="_blank" href="">人才招聘</a>|
	            <a rel="nofollow" target="_blank" href="">商家入驻</a>|
	            <a rel="no  follow" target="_blank" href="">广告服务</a>|
	            <a rel="nofollow" target="_blank" href="">手机京东</a>|
	            <a target="_blank" href="">友情链接</a>|
	            <a target="_blank" href="">销售联盟</a>|
	            <a href="" target="_blank">京东社区</a>|
	            <a href="" target="_blank">京东公益</a>|
	            <a target="_blank" href="" >English Site</a>
	        </div>
	        <div class="copyright">
	            Copyright©2004-2018&nbsp;&nbsp;京东JD.com&nbsp;版权所有
	        </div>
	    </div>
	</body>
</html>
