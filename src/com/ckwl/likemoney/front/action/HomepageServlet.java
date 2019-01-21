package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.service.IClassfiyBigService;
import com.ckwl.likemoney.bas.service.imp.ClassfiyBigServiceImp;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.front.view.ClassfiyBigView;
import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.service.IProductBrandService;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductBrandServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;

/**
 * Servlet implementation class jdnzServerlet
 */
@WebServlet("/user/HomepageServlet.do")
public class HomepageServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IClassfiyBigService iClassfiyBigService = (IClassfiyBigService) super.getDaoImpProxyFacroty(ClassfiyBigServiceImp.class);
	private IProductBrandService iProductBrandService = (IProductBrandService) super.getDaoImpProxyFacroty(ProductBrandServiceImp.class);
	private IProductSkuService iProductSkuService = (IProductSkuService)super.getDaoImpProxyFacroty(ProductSkuServiceImp.class);
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 业务流程
		ArrayList<ClassfiyBigView> listBig = iClassfiyBigService.listView();
		ArrayList<ProductBrand> listBrand = iProductBrandService.list(new ProductBrandConditionView());
		ArrayList<ProductSkuQueryView> listProductSku = iProductSkuService.list(new ProductSkuConditionView());
		
		request.setAttribute("listBig", listBig);
		request.setAttribute("listBrand", listBrand);
		request.setAttribute("listProductSku", listProductSku);
		
		// 页面跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/Homepage.jsp").forward(request, response);
	}
	
}
