package com.ckwl.likemoney.product.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.constant.DictConstant;
import com.ckwl.likemoney.bas.service.IDictionariesDetailService;
import com.ckwl.likemoney.bas.service.imp.DictionariesDetailServiceImpl;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.order.service.IOrderEvaluateService;
import com.ckwl.likemoney.order.service.imp.OrderEvaluateServiceImp;
import com.ckwl.likemoney.order.view.OrderEvaluateConditionView;
import com.ckwl.likemoney.order.view.OrderEvaluateQueryView;
import com.ckwl.likemoney.product.entity.ProductColor;
import com.ckwl.likemoney.product.entity.ProductSize;
import com.ckwl.likemoney.product.entity.ProductSku;
import com.ckwl.likemoney.product.service.IProductColorService;
import com.ckwl.likemoney.product.service.IProductService;
import com.ckwl.likemoney.product.service.IProductSizeService;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductColorServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductSizeServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductColorConditionView;
import com.ckwl.likemoney.product.view.ProductConditionView;
import com.ckwl.likemoney.product.view.ProductQueryView;
import com.ckwl.likemoney.product.view.ProductSizeConditionView;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;

/**
 * Servlet implementation class ProductSkuServlet
 */
@WebServlet("/admin/product/ProductSkuServlet.do")
public class ProductSkuServlet extends BaseServlet{
	private IProductSkuService iProductSkuservice = (IProductSkuService) super.getDaoImpProxyFacroty(ProductSkuServiceImp.class);
	private IProductService iProductService = (IProductService) super.getDaoImpProxyFacroty(ProductServiceImp.class);
	private IOrderEvaluateService iOrderEvaluateService = (IOrderEvaluateService) super.getDaoImpProxyFacroty(OrderEvaluateServiceImp.class);
	private IProductColorService iProductColorService = (IProductColorService) super.getDaoImpProxyFacroty(ProductColorServiceImp.class);
	private IProductSizeService iProductSizeService = (IProductSizeService) super.getDaoImpProxyFacroty(ProductSizeServiceImp.class);
	private IDictionariesDetailService detailService = (IDictionariesDetailService) super.getDaoImpProxyFacroty(DictionariesDetailServiceImpl.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSkuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  super.doGet(request, response);	}
  	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// 根据业务逻辑，查询数据
  		String product_code = request.getParameter("product_code");
	    String evaluate_amount = request.getParameter("evaluate_amount");
//	    String product_sku_price = request.getParameter("product_sku_price");
	    if(!StringUtil.isEmpty(product_code)){
	    	product_code = product_code.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(evaluate_amount)){
	    	evaluate_amount = evaluate_amount.trim();//去掉空格
		}
//	    if(!StringUtil.isEmpty(product_code)){
//	    	product_code = product_code.trim();//去掉空格
//		}
	    ProductSkuConditionView ProductSkuConditionView = new ProductSkuConditionView();
	    ProductSkuConditionView.setProduct_code(product_code);
	    ProductSkuConditionView.setEvaluate_amount(evaluate_amount);
//	    ProductSkuConditionView.setProduct_code(product_code);
  		ArrayList<ProductSkuQueryView> listProductSku = iProductSkuservice.list(ProductSkuConditionView);
  	
  		request.setAttribute("listProductSku6", listProductSku);

  		// 页面的跳转：转发
  		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/product/product_sku_list.jsp").forward(request, response);

  	}

  	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// s1.取参数
  		String ProductSku_id = request.getParameter("product_sku_id");

  		// s2.业务逻辑
  		// System.out.println("删除ID:" + studentId7);
  		ProductSku ProductSku = new ProductSku();
  		ProductSku.setProduct_sku_id(ProductSku_id);
  		iProductSkuservice.delete(ProductSku);

  		// s3.页面跳转：重定向
  		response.sendRedirect("ProductSkuServlet.do?method=list");

  	}

  	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// S1.获取参数
  		String ProductSkuId7 = request.getParameter("product_sku_id");

  		// 根据ProductSkuId是否为空判断是新增还是修改的编辑
  		ProductConditionView ProductConditionView = new ProductConditionView();
		ArrayList<ProductQueryView> listProduct = iProductService.list(ProductConditionView);
		request.setAttribute("listProduct6", listProduct);
		OrderEvaluateConditionView OrderEvaluateConditionView = new OrderEvaluateConditionView();
		ArrayList<OrderEvaluateQueryView> listOrderEvaluate = iOrderEvaluateService.list(OrderEvaluateConditionView);
		request.setAttribute("listOrderEvaluate6", listOrderEvaluate);
		ProductColorConditionView ProductColorConditionView = new ProductColorConditionView();
		ArrayList<ProductColor> listProductColor = iProductColorService.list(ProductColorConditionView);
		request.setAttribute("listProductColor6", listProductColor);
		ProductSizeConditionView ProductSizeConditionView = new ProductSizeConditionView();
		ArrayList<ProductSize> listProductSize = iProductSizeService.list(ProductSizeConditionView);
		request.setAttribute("listProductSize6", listProductSize);
		
		List<DictionariesDetailQueryView> findBySkuStock = detailService.findByDictCode(DictConstant.PRODUCT_SKU_STOCK);
  		List<DictionariesDetailQueryView> findByShelfStatus = detailService.findByDictCode(DictConstant.PRODUCT_SHELF_STATUS);
  		
  		// 传递对象数据
  		request.setAttribute("findBySkuStock", findBySkuStock);
  		request.setAttribute("findByShelfStatus", findByShelfStatus);
		
  		if (StringUtil.isEmpty(ProductSkuId7)) {// 新增
  			String displaystatus="none";
  			request.setAttribute("displaystatus",displaystatus);
  		} else {// 修改
  				// S2.业务逻辑操作
  			String displaystatus="block";
  			request.setAttribute("displaystatus",displaystatus);
  			ProductSku ProductSku = new ProductSku();
  			ProductSku.setProduct_sku_id(ProductSkuId7);
  			
  			

  			request.setAttribute("ProductSku4", ProductSku);

  		}

  		// S3.跳转
  		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/product/product_sku_edit.jsp").forward(request, response);

  	}

  	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
  		// 设置请求与响应的编码

  		// S1.接收请求参数
  		String product_sku_id = request.getParameter("product_sku_id");
  		String product_sku_amount = request.getParameter("product_sku_amount");
  		String product_id = request.getParameter("product_id");//外键
 		String color_id = request.getParameter("color_id");
	String size_id = request.getParameter("size_id");
  		String evaluate_id = request.getParameter("evaluate_id");
  		String product_sku_price = request.getParameter("product_sku_price");
  		String product_sku_stock = request.getParameter("product_sku_stock");
  		String product_sku_realPrice = request.getParameter("product_sku_realPrice");
  		String product_sku_img_big = request.getParameter("product_sku_img_big");
  		String product_sku_img = request.getParameter("product_sku_img");
  		String product_sku_img_small = request.getParameter("product_sku_img_small");
  		String product_sku_img_mid = request.getParameter("product_sku_img_mid");

  		String product_stock_max = request.getParameter("product_stock_max");
  		String product_stock_min = request.getParameter("product_stock_min");
  		String product_sku_code = request.getParameter("product_sku_code");
  		
  	

  		// 根据ProductSkuId是否为空判断是新增还是修改的编辑
  		if (StringUtil.isEmpty(product_sku_id)) {// 新增
  			
  			ProductSku ProductSku = new ProductSku();

			ProductSku.setProduct_id(product_id);
			ProductSku.setColor_id(color_id);
			ProductSku.setSize_id(size_id);
			ProductSku.setProduct_sku_amount(product_sku_amount);
			ProductSku.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
			ProductSku.setProduct_sku_img(product_sku_img_mid);
			ProductSku.setProduct_sku_stock(product_sku_stock);
			ProductSku.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));

			ProductSku.setProduct_sku_img_big(product_sku_img_big);

			ProductSku.setProduct_sku_img_small(product_sku_img_small);

			ProductSku.setProduct_sku_img_mid(product_sku_img_mid);
			ProductSku.setProduct_stock_max(product_stock_max);
			ProductSku.setProduct_stock_min(product_stock_min);
			ProductSku.setProduct_sku_code(product_sku_code);
			ProductSku.setEvaluate_id(evaluate_id);
  			iProductSkuservice.insert(ProductSku);
  		} else {// 修改
  				// S2.业务处理：调数据库,略
  			ProductSku ProductSku = new ProductSku();
  			ProductSku.setProduct_sku_id(product_sku_id);
			ProductSku.setProduct_id(product_id);
		ProductSku.setColor_id(color_id);
			ProductSku.setSize_id(size_id);
			ProductSku.setProduct_sku_amount(product_sku_amount);
			ProductSku.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
			ProductSku.setProduct_sku_img(product_sku_img_mid);
			ProductSku.setProduct_sku_stock(product_sku_stock);
			ProductSku.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));

			ProductSku.setProduct_sku_img_big(product_sku_img_big);

			ProductSku.setProduct_sku_img_small(product_sku_img_small);

			ProductSku.setProduct_sku_img_mid(product_sku_img_mid);
			ProductSku.setProduct_stock_max(product_stock_max);
			ProductSku.setProduct_stock_min(product_stock_min);
			ProductSku.setEvaluate_id(evaluate_id);
			ProductSku.setProduct_sku_code(product_sku_code);
  			iProductSkuservice.update(ProductSku);
  		}

  		// S3.页面跳转：重定向
  		response.sendRedirect("ProductSkuServlet.do?method=list");

  	}
  	/**
  	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		super.doGet(request, response);
  	}

}
