<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
 <head>
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta charset=utf-8>
  
  <link href="${pageContext.request.contextPath}/css/a.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lwh.css"/>
 
  <title>搜索页</title>
  
  <script type="text/javascript">
  		function go(pageIndex){
  			
  		}
  
  </script>
 </head>
 <body>
 	
   <div class="shouye";style="position:relative;border:solid #0FF000;top:0px;">
		<div class="c";>
			<div style="float:left;">京东首页
			</div>
			<div style="float:left;margin-left: 22px;">北京
			</div>
				<div style="float:left;margin-left:540px;">
					${sessionScope.session_customer.customerName }
				</div>
				<div style="float:left;margin-left: 9px;">
				
					<c:if test="${sessionScope.session_customer.customerNickName==null }">
						<a href="${pageContext.request.contextPath}/LoginServlet.do"  target="_blank">
							你好，${sessionScope.session_customer.customerNickName }
						</a>&nbsp;&nbsp;
					</c:if>
						<a href="${pageContext.request.contextPath}/user/MyCenterServerlet.do" target="_blank">
							你好，${sessionScope.session_customer.customerNickName }
						</a>&nbsp;&nbsp;
						
						<c:if test="${sessionScope.session_customer.customerNickName==null }">
							<a>免费注册</a>
						</c:if>
						<c:if test="${sessionScope.session_customer.customerNickName!=null }">
							<a href="${pageContext.request.contextPath}/LogoutServlet.do" target="_blank" >注销</a>
						</c:if>
				
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;"><a href="${pageContext.request.contextPath}/user/MyOrderServerlet.do?method=list" target="_Blank">我的订单</a>
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">我的京东
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">京东会员
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">企业采购
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">客户服务
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">网站导航
				</div>
				<div style="float:left;">｜
				</div>
				<div style="float:left;">手机京东
				</div>
				<div style="clear:both;">
				</div>
			</div> <!--第一行-->
		
		    <%-- <c:forEach begin="0" end="${pageView.pageCount-1 }" var="status" >
		    	<a style="color: red" href="javascript:goPage(${status.index })" >${status.index+1 }</a>
		    </c:forEach> --%>
		    
		    
	<div class="ww">
		<div >
		    <div style="float:left; ">
		        <img src="img/1.png" alt="logo" title="logo"/>
		    </div>
			<div  class="s" style="float:left;">
			    
			    <input class="search"type="text" name="搜索" value="" > 
			  <!--  <form action="MyInformServerlet.do" method="get"> -->
			  <a href="${pageContext.request.contextPath}/user/ProductDetailServlet.do" target="_blank">
                	<input class="shousuo" type="button" name="button" value="搜索" style="width:65px; ">
                </a>
                <!-- </form> -->
			</div>
			<div class="shoppingcar" style="border:1px solid #DFDFDF;float:left;">
			<!-- 	<form action="CartSettleServerlet.do"></form> -->
				<a href="${pageContext.request.contextPath}/user/CartSettleServerlet.do?method=list">我的购物车</a>
			</div>
			<div style="clear:both;"></div> <!--第二行-->
        </div>

		
           <div id="fenlei">
				<div  id="categroys">全部商品分类</div>
				<div  id="colthes">京东服饰</div>
				<div  id="beauty">美妆馆</div>
				<div  id="supermarket">超市</div>
				<div  id="shengxian">生鲜</div>
				<div  id="wshop">全球购</div>
				<div  id="fshop">闪购</div>
				<div  id="sort">拍卖</div>
				<div id="jinrong">金融</div>
				<div style="clear:both;"></div> <!--第四行-->
			</div>
		</div>
			
			<div class="line"></div>
			
			
			
			<div class="a">
				<div>全部结果><strong>"2018新品"</strong></div>
				
           <div>				
				<div class="pinpai"style="border:1px solid #DDDDDD;">品牌：</div>
				<div class="ppfenlei">
				<c:forEach items="${listProductBrand6 }" var="listProductBrand" >
					
						<div style="border:1px solid #DDDDDD;float:left;">
							<img src="${listProductBrand.brand_img}" alt="logo" title="1"/>
						</div>
					
				</c:forEach>
					<!-- <div style="border:1px solid #DDDDDD;float:left;"><img src="img/ccc.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/ddd.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/eee.jpg" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/fff.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/ggg.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/hhh.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/iii.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/jjj.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/kkk.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/lll.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/mmm.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/nnn.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/ooo.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/ppp.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/qqq.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/rrr.png" alt="logo" title="1"/></div>
					<div style="border:1px solid #DDDDDD;float:left;"><img src="img/sss.png" alt="logo" title="1"/></div> -->
					<div style="clear:both;"></div>
				</div>
				<div style="float:right;">
					<div style="float:right;"> <input type="button" name="更多" value="更多" style="width:40px;"></div>
                    <div style="float:right;"><input type="button" name="多选" value="多选" style="width:40px;"></div>
                    <div style="clear:both;"></div>
				</div>
				<div style="clear:both;"></div> 
		   </div>
           

			<div>
			
					<div id="nvzhuang"style="float:left;">女装：</div>
					<c:forEach items="${listClassfiyBig6 }" var="listClassfiyBig" >
					<div id="lianyi"style="float:left;margin-left: 25px;">${listClassfiyBig.classfiyBigName}</div>
					</c:forEach>
					<!-- <div id="txue"style="float:left;">T恤</div>
					<div id="xiuxian"style="float:left;">休闲裤</div>
					<div id="zhonglao"style="float:left;">中老年女装</div>
					<div id="banshen"style="float:left;">半身裙</div>
					<div id="chensan"style="float:left;">衬衫</div>
					<div id="niuzai"style="float:left;">牛仔裤</div> -->
					<label id="duo" style="margin-left: 747px;">更多：
						<select>
						<c:forEach items="${listClassfiyBig6 }" var="listClassfiyBig">
						<option value="${listClassfiyBig.classfiyBigId}">${listClassfiyBig.classfiyBigName}</option>
						</c:forEach>
						</select>
						</label>
						<div style="clear:both;"></div> <!--第六行-->
			    </div>


             <div class="cmbk">				
				  <div id="chima"style="float:left;">尺码：</div>
				  <c:forEach items="${listProductSize6 }" var="listProductSize" >
				  <div id="sanba"style="float:left;">${listProductSize.size_name}</div>
				  </c:forEach>
				  <!-- <div id="sishi"style="float:left;">40</div>
			      <div id="sier"style="float:left;">42</div>
				  <div id="sisi"style="float:left;">44</div>
				  <div id="XXS"style="float:left;">XXS</div>
                  <div id="XS"style="float:left;">XS</div>
				  <div id="S"style="float:left;">S</div>
				  <div id="M"style="float:left;">M</div>
				  <div id="L"style="float:left;">L</div> -->
	             <input type="button" name="更多" value="更多" style="width:65px;margin-left: 232px;">
	              <input type="button" name="多选" value="多选" style="width:65px;">
				<div style="clear:both;"></div> <!--第六行-->
			</div>


			<div class="line2">
				<div style="float:left;">颜色：</div>
				<div style="float:left;">
				<div id="heise" style="float:left;"><img src="img/heise.png" alt="logo" title="1"/></div>
				<div id="huise" style="float:left;"><img src="img/huise.png" alt="logo" title="1"/></div>
				<div id="baise" style="float:left;"><img src="img/baise.png" alt="logo" title="1"/></div>
				<div id="fense" style="float:left;"><img src="img/fense.png" alt="logo" title="1"/></div>
				<div id="hongse" style="float:left;"><img src="img/hongse.png" alt="logo" title="1"/></div>
				<div id="zise" style="float:left;"><img src="img/zise.png" alt="logo" title="1"/></div>
				<div id="lanse" style="float:left;"><img src="img/lanse.png" alt="logo" title="1"/></div>
				<div id="lvse" style="float:left;"><img src="img/lvse.png" alt="logo" title="1"/></div>
				<div id="huangse" style="float:left;"><img src="img/huangse.png" alt="logo" title="1"/></div>
				<div id="zongse" style="float:left;"><img src="img/zongse.png" alt="logo" title="1"/></div>
				<div id="qianhui" style="float:left;"><img src="img/qianhui.png" alt="logo" title="1"/></div>
				<div id="caise" style="float:left;"><img src="img/caise.png" alt="logo" title="1"/></div>
				<div id="xiaohongse" style="float:left;"><img src="img/xiaohongse.png" alt="logo" title="1"/></div>
				<div id="mise" style="float:left;"><img src="img/mise.png" alt="logo" title="1"/></div>
				<div id="chengse" style="float:left;"><img src="img/chengse.png" alt="logo" title="1"/></div>
				</div>
				<input type="button" name="多选" value="多选" style="width:65px;margin-left: 732px;">
				<div style="clear:both;"></div> <!--第七行-->
			</div>


            <div class="line3">
				<div style="float:left;">高级选项：</div>
				<div id="hou" style="float:left;"><input type="button" name="厚度" value="厚度" style="width:65px;"/></div>
				<div id="yimen" style="float:left;"><input type="button" name="衣门襟" value="衣门襟" style="width:65px;"/></div>
				<div id="shi" style="float:left;"><input type="button" name="适用年龄" value="适用年龄" style="width:65px;"/></div>
				<div id="ban" style="float:left;"<input type="button" name="版型" value="版型" style="width:65px;"/></div>
				<div id="qun" style="float:left;"><input type="button" name="裙长" value="裙长" style="width:65px;"/></div>
				<div id="feng" style="float:left;"><input type="button" name="风格" value="风格" style="width:65px;"/></div>
				<div id="fen" style="float:left;"><input type="button" name="分类" value="分类" style="width:65px;"/></div>
				<div id="xiu" style="float:left;"><input type="button" name="袖长" value="袖长" style="width:65px;"/></div>
				<div id="xiuxing" style="float:left;"><input type="button" name="袖型" value="袖型" style="width:65px;"/></div>
				<div id="ling" style="float:left;"><input type="button" name="领型" value="领型" style="width:65px;"/></div>
				<div id="qi" style="float:left;"><input type="button" name="其他分类" value="其他分类" style="width:65px;"/></div>
				<div style="clear:both;"></div> <!--第四行-->
			</div>
		</div>
		
		
		<div class="xia">				
			<div class="zuobian" style="border:1px solid #E1E1E1; float:left;width:198px;"><!--左边-->
				<div>
					<div style="float:left;">商品精选</div>
					<div style="float:left; font-size:10px;margin-left: 101px;">广告</div>
					<div style="clear:both;"></div>
				</div>
				<div><img src="img/aaa.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
				
				<div><img src="img/aaa.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
				<div><img src="img/aaa.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
				<div><img src="img/aaa.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
				<div><img src="img/aaa.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
				<div><img src="img/aaa.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
	   	    </div>

			<div id="youbian"style="float:left;">  <!--右边-->
				<div class="na"style="border:1px solid #E1E1E1; float:left;">
					<div id="zonghe" style="float:left;"><input type="button" name="综合" value="综合" style="width:65px;"></div>
					<div id="xiaoling" style="float:left;"><input type="button" name="销量" value="销量" style="width:65px;"></div>
					<div id="ping" style="float:left;"><input type="button" name="评论数" value="评论数" style="width:65px;"></div>
					<div id="xinping" style="float:left;"<input type="button" name="新品" value="新品" style="width:65px;"></div>
					<div id="jiage" style="float:left;"><input type="button" name="价格" value="价格" style="width:65px;"></div>
					<div id="kong1" style="float:left;"><input type="button" name="" value="" style="width:65px;margin-left: 32px;"></div>
					<div id="xian" style="float:left;">-</div>
					<div id="kong2" style="float:left;"><input type="button" name="" value="" style="width:65px;"></div>
					<div id="gong" style="float:left; margin-left: 428px;">
						<span>共84万+件商品</span>
					</div>
					
					<div id="baifenyi" style="float:left;">
						<span style="color:red">1</span>
						<span>/100</span>
					</div>
					<div id="baibai" style="float:left;"><input type="button" name="" value="" style="width:65px;margin-left: 39px;"></div>
					<div id="baibai2" style="float:left;"><input type="button" name="" value="" style="width:65px;"></div>
					<div style="clear:both;"></div>
				</div>
				
				<div class="dier"style="border:1px solid #E1E1E1;">
					<div style="float:left;"><span>配送至</span></div>
					<div id="" style="float:left;margin-top: 6px;"><input type="buttom" name="" value="北京朝阳三环以内" style="width:140px;"></div>
					<input type="checkbox" name="" value="">京东物流
					<input type="checkbox" name="" value="">货到付款
					<input type="checkbox" name="" value="">仅显示有货
					<input type="checkbox" name="" value="">可配送全球
					<input type="checkbox" name="" value="">新品
					<input type="text" name="" value="在结果中搜索" style="margin-left: 328px;">
					<input type="button" name="" value="确定">
					<div style="clear:both;"></div>
				</div>				
				
				<div class="da" clearfix  style="width:1150px">	
					 	 <c:forEach items="${pageView.list }" var="listProductSku">
					 	 				
								<div style=" margin: 5px 5px;float:left;">
								<form action="ProductDetailServlet.do" method="post" target="_blank">
								<input type="hidden" name="productSkuId" value="${listProductSku.product_sku_id }" />
								
									<button>
										<img src="${listProductSku.product_sku_img_mid}" alt="logo" title="1" style="width:220px;height:282px;"/>
									</button>
								</form>   
								    <div><span style="color:red;">￥${listProductSku.product_sku_price}</span></div>
								    <div>
								    	<span>子牧棉麻<span style="color:red;">2018</span>夏季新款 <span style="color:red;">女</span>新品</span>
								    </div>
								    <div><span>子牧棉麻旗舰店</span></div>
								    <div><input id="xin" type="button"value="新品"></div>		 			    
								 </div>
						 </c:forEach>	 
						    
					</div>	   
					
				</div>
			</div>	  
			</div>
			<div style="clear:both;"></div> 
		</div>
		
		
		
		<div class=au style="border:1px solid #DFDFDF;margin-top: 20px;">	
			<div>
				<div style="float:left;">商品精选</div>
				<div style="float:left;margin-left: 1236px;">广告</div>
				<div style="clear:both;"></div>	
			</div>								
			<div class="vv"style="float:left;margin-left: 86px;">
				<div><img src="img/pp.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
			</div>
			<div class="vv"style="float:left;">
				<div><img src="img/oo.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
			</div>
			<div class="vv"style="float:left;">
				<div><img src="img/kk.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
			</div>
			<div class="vv"style="float:left;">
				<div><img src="img/nn.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
			</div>
			<div class="vv"style="float:left;">
				<div><img src="img/siwa.jpg"/></div>
				<div style="color:red;">￥:1428.00</div>	
				<div><span>BORCHIARL品牌 真丝上衣女2018夏装新款短袖v领</span></div>
				<div><span>已有2人评价</span></div>
			</div>
			<div style="clear:both;"></div>	
			</div>
			
			
			<div class="ff"style="margin-top: 14px;">
				<div class="uu">
					<div style="float:left;"><span>您是不是要找：</span></div>
					<div style="float:left;"><span>2018新品女装</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>连衣裙2018</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>中老年女装</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>连衣裙</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>连衣裙短袖</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>连衣裙碎花</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>蕾丝雪纺衫</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>t恤女</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>自营女装</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>2018新品二件休闲套装夏女</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>连衣裙春</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>雪纺连衣裙</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>阔腿裤女</span></div>
					<div style="float:left;">｜</div>
					<div style="float:left;"><span>雪纺衫女</span></div>
					<div style="clear:both;"></div>	
				</div>
				<div style="margin-bottom: 26px; margin-left: 60px">
					<div style="font-size: 14px;float:left;"><strong>重新搜索：</strong></div>
					<div style="float:left;">
						 <input type="text" name="搜索" value="2018新品"style="width:450px;height:40px;margin-left:28px" > 
					     <input type="button" value="搜索" style="width:70px;height:46px; background: #f30213;
					      color: #FFFFFF;border:2px;margin-left: 8px;">
					</div>
					<div><span style="margin-left: 33px;font-size:14px;">说说我使用搜索的感受<span></div>
					<div style="clear:both;"></div>
				</div>																
	    	</div>
	    	
	    			    	<div id="buttom">
			<div class="dkhs">
				<img src="img/多快好省.jpg" />
			</div>
			<div id="buttom_lianjie"style="margin-top:-10px;">
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
	</div>	
	
 </body>
</html>