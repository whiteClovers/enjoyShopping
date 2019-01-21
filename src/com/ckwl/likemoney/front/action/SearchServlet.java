package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.service.IClassfiyBigService;
import com.ckwl.likemoney.bas.service.imp.ClassfiyBigServiceImp;
import com.ckwl.likemoney.bas.view.ClassfiyBigConditionView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.frame.view.PageView;
import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.entity.ProductSize;
import com.ckwl.likemoney.product.service.IProductBrandService;
import com.ckwl.likemoney.product.service.IProductSizeService;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductBrandServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductSizeServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;
import com.ckwl.likemoney.product.view.ProductSizeConditionView;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;


/**
 * Servlet implementation class ssServerlet
 */
@WebServlet("/user/SearchServerlet.do")
public class SearchServlet extends BaseServlet {
	private IClassfiyBigService iClassfiyBigService=(IClassfiyBigService) super.getDaoImpProxyFacroty(ClassfiyBigServiceImp.class);
	private IProductSizeService iProductSizeService=(IProductSizeService) super.getDaoImpProxyFacroty(ProductSizeServiceImp.class);
	private IProductBrandService iProductBrandService=(IProductBrandService) super.getDaoImpProxyFacroty(ProductBrandServiceImp.class);
	private IProductSkuService iProductSkuService=(IProductSkuService) super.getDaoImpProxyFacroty(ProductSkuServiceImp.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 搜索页
     * Author lj
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClassfiyBigConditionView classfiyBigConditionView=new ClassfiyBigConditionView();
		ArrayList<ClassfiyBig> listClassfiyBig = iClassfiyBigService.list(classfiyBigConditionView);
		
		ProductSizeConditionView productSizeConditionView=new ProductSizeConditionView();
		ArrayList<ProductSize> listProductSize = iProductSizeService.list(productSizeConditionView);
		
		ProductBrandConditionView productBrandConditionView=new ProductBrandConditionView();
		ArrayList<ProductBrand> listProductBrand = iProductBrandService.list(productBrandConditionView);
		
		request.setAttribute("listClassfiyBig6", listClassfiyBig);
		request.setAttribute("listProductSize6", listProductSize);
		request.setAttribute("listProductBrand6", listProductBrand);
		
		
		// 产品sku分页
		String pageIndexStr = request.getParameter("pageIndex");
		int pageIndex = 0 ;
		if (!StringUtil.isEmpty(pageIndexStr)) {
			pageIndex = Integer.valueOf(pageIndexStr);
		}
 		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 3 ;
		if (!StringUtil.isEmpty(pageSizeStr)) {
			pageIndex = Integer.valueOf(pageSizeStr);
		}
		
		ProductSkuConditionView ProductSkuConditionView=new ProductSkuConditionView();
		PageView pageView = iProductSkuService.page(ProductSkuConditionView, pageIndex, pageSize);
		
		request.setAttribute("ProductSkuConditionView", ProductSkuConditionView);
		request.setAttribute("pageView", pageView);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/Search.jsp").forward(request, response);
	}
	
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//
		
		
		// 重定向到当前搜索页
		response.sendRedirect(request.getServletContext().getContextPath()+"/user/SearchServerlet.do");
	}

}
