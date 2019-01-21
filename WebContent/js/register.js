	function createXMLHttpRequest() {
			if (window.XMLHttpRequest) {
				XMLHttpRequest = new XMLHttpRequest();
			}else {
				XMLHttpRequest = new ActiveXObject(MSXML.XMLHTTP); // Microsoft
			}
			
			if (XMLHttpRequest == undefined || XMLHttpRequest == null) {
				alert("XMLHttpRequest创建失败");
			}
	}
	function  checkNameExit() {
		var customerNameNode = document.getElementById("customerName");
		var customerName = customerNameNode.value;
		if (customerName == "" || customerName == null) {
			 alert("用户名不能为空");
			 document.getElementById("checkName").innerHTML = "<font color='red'>用户名不能为空</font>";
	    	 /* customerNameNode.focus(); */
	    	 
	    	 return ;
		}
		
		var url = "${pageContext.request.contextPath}/user/RegisterServlet.do?method=checkName";
	    //创建核心xmlhttprequest组件
	    createXMLHttpRequest();
	    //设置回调函数
	    XMLHttpRequest.onreadystatechange = myCallback;
	    //初始化核心组件
	    XMLHttpRequest.open("post", url, true);
	    //设置请求头
	    XMLHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
	    //发送请求
	    XMLHttpRequest.send("customerName="+customerName); 
	}

	function myCallback() {
		if (XMLHttpRequest.readyState == 4 ) {
			if (XMLHttpRequest.status == 200) {
				var b = XMLHttpRequest.responseText;
				if (b == "true") {
					alert("抱歉，该用户名已经存在！");
					document.getElementById("checkName").innerHTML = "<font color='red'>该用户名已经存在！</font>";
				} else if(b == "false"){
					alert("恭喜，该用户名可以使用 ");
					document.getElementById("checkName").innerHTML = "<font color='blue'>该用户名可以使用</font>";
				}
				
			}
		}
	}