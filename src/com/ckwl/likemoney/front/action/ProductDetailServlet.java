package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;

/**
 * Servlet implementation class orderDetailServlet
 */
@WebServlet("/user/ProductDetailServlet.do")
public class ProductDetailServlet extends BaseServlet {
	private IProductSkuService productSkuService=(IProductSkuService) super.getDaoImpProxyFacroty(ProductSkuServiceImp.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String product_sku_id=request.getParameter("productSkuId");
		ArrayList<ProductSkuQueryView> listProductSku = productSkuService.list(product_sku_id);
		
		ArrayList<ProductSkuQueryView> listProductSku1 = productSkuService.list1(new ProductSkuConditionView());
		// 传递对象数据
		request.setAttribute("listProductSku", listProductSku);
		request.setAttribute("listProductSku1", listProductSku1);
		request.setAttribute("productSkuId", product_sku_id);
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/ProductDetail.jsp").forward(request, response);
	}

	
	

}
