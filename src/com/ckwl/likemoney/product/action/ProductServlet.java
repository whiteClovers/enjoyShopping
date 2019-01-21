package com.ckwl.likemoney.product.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.service.IClassfiySmallService;
import com.ckwl.likemoney.bas.service.imp.ClassfiySmallServiceImp;
import com.ckwl.likemoney.bas.view.ClassfiySmallConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.entity.Product;
import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.service.IProductBrandService;
import com.ckwl.likemoney.product.service.IProductService;
import com.ckwl.likemoney.product.service.IProductStoreService;
import com.ckwl.likemoney.product.service.imp.ProductBrandServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductStoreServiceImp;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;
import com.ckwl.likemoney.product.view.ProductConditionView;
import com.ckwl.likemoney.product.view.ProductQueryView;
import com.ckwl.likemoney.product.view.ProductStoreConditionView;
import com.ckwl.likemoney.product.view.ProductStoreQueryView;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/admin/product/ProductServlet.do")
public class ProductServlet extends BaseServlet {
	private IProductService iProductservice = (IProductService) super.getDaoImpProxyFacroty(ProductServiceImp.class);
	private IProductBrandService iProductBrandService = (IProductBrandService) super.getDaoImpProxyFacroty(ProductBrandServiceImp.class);
	private IProductStoreService iProductStoreService = (IProductStoreService) super.getDaoImpProxyFacroty(ProductStoreServiceImp.class);
	private IClassfiySmallService iClassfiySmallService = (IClassfiySmallService) super.getDaoImpProxyFacroty(ClassfiySmallServiceImp.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
super.doGet(request, response);	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
		String classfiy_small_name = request.getParameter("classfiy_small_name");
	    String brand_name = request.getParameter("brand_name");
	    String product_code = request.getParameter("product_code");
	    if(!StringUtil.isEmpty(classfiy_small_name)){
	    	classfiy_small_name = classfiy_small_name.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(brand_name)){
	    	brand_name = brand_name.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(product_code)){
	    	product_code = product_code.trim();//去掉空格
		}
	    ProductConditionView ProductConditionView = new ProductConditionView();
	    ProductConditionView.setClassfiy_small_name(classfiy_small_name);
	    ProductConditionView.setBrand_name(brand_name);
	    ProductConditionView.setProduct_code(product_code);
		ArrayList<ProductQueryView> listProduct = iProductservice.list(ProductConditionView);
	

		// 传递对象数据
		request.setAttribute("listProduct6", listProduct);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/product/product_list.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String Product_id = request.getParameter("product_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		Product Product = new Product();
		Product.setProduct_id(Product_id);;
		iProductservice.delete(Product);

		// s3.页面跳转：重定向
		response.sendRedirect("ProductServlet.do?method=list");

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String ProductId7 = request.getParameter("product_id");

		// 根据ProductId是否为空判断是新增还是修改的编辑
		ProductBrandConditionView ProductBrandConditionView = new ProductBrandConditionView();
		ArrayList<ProductBrand> listProductBrand = iProductBrandService.list(ProductBrandConditionView);
		request.setAttribute("listProductBrand6", listProductBrand);
		ProductStoreConditionView ProductStoreConditionView = new ProductStoreConditionView();
		ArrayList<ProductStoreQueryView> listProductStore = iProductStoreService.list(ProductStoreConditionView);
		request.setAttribute("listProductStore6", listProductStore);
		ClassfiySmallConditionView ClassfiySmallConditionView = new ClassfiySmallConditionView();
		ArrayList<ClassfiySmallQueryView> listClassfiySmall = iClassfiySmallService.list(ClassfiySmallConditionView);
		request.setAttribute("listClassfiySmall6", listClassfiySmall);
		if (StringUtil.isEmpty(ProductId7)) {// 新增
			String displaystatus="none";
			request.setAttribute("displaystatus",displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus="block";
			request.setAttribute("displaystatus",displaystatus);
			Product Product = new Product();
			Product.setProduct_id(ProductId7);
			
			

			request.setAttribute("Product4", Product);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/product/product_edit.jsp").forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String product_id = request.getParameter("product_id");
		String product_name = request.getParameter("product_name");
		String brand_id = request.getParameter("brand_id");//外键
		String store_id = request.getParameter("store_id");
		String classfiy_small_id = request.getParameter("classfiy_small_id");
		String product_code = request.getParameter("product_code");
		String evaluate_amount = request.getParameter("evaluate_amount");
		String evaluate_good = request.getParameter("evaluate_good");
		String evaluate_bad = request.getParameter("evaluate_bad");
		
		String evaluate_common = request.getParameter("evaluate_common");
		String order_detail_evaluate = request.getParameter("order_detail_evaluate");

		String product_shelf_status = request.getParameter("product_shelf_status");
		String product_shelf_time = request.getParameter("product_shelf_time");
		String product_img = request.getParameter("product_img");
		String product_introduce = request.getParameter("product_introduce");
	

		// 根据ProductId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(product_id)) {// 新增
			
			Product Product = new Product();

			Product.setProduct_name(product_name);
			Product.setProduct_code(product_code);
			Product.setBrand_id(brand_id);
			Product.setEvaluate_amount(evaluate_amount);
			Product.setStore_id(store_id);
			Product.setClassfiy_small_id(classfiy_small_id);
			Product.setEvaluate_good(StringUtil.stringToInteger(evaluate_good));
			Product.setEvaluate_bad(StringUtil.stringToInteger(evaluate_bad));

			Product.setEvaluate_common(StringUtil.stringToInteger(evaluate_common));

			Product.setProduct_shelf_status(product_shelf_status);

			Product.setProduct_shelf_time(StringUtil.stringToDate(product_shelf_time));
			Product.setProduct_img(product_img);
			Product.setProduct_introduce(product_introduce);;
			iProductservice.insert(Product);
		} else {// 修改
				// S2.业务处理：调数据库,略
			Product Product = new Product();
			Product.setProduct_id(product_id);
			Product.setProduct_name(product_name);
			Product.setProduct_code(product_code);
			Product.setBrand_id(brand_id);
			Product.setEvaluate_amount(evaluate_amount);
			Product.setStore_id(store_id);
			Product.setClassfiy_small_id(classfiy_small_id);
			Product.setEvaluate_good(StringUtil.stringToInteger(evaluate_good));
			Product.setEvaluate_bad(StringUtil.stringToInteger(evaluate_bad));

			Product.setEvaluate_common(StringUtil.stringToInteger(evaluate_common));

			Product.setProduct_shelf_status(product_shelf_status);

			Product.setProduct_shelf_time(StringUtil.stringToDate(product_shelf_time));
			Product.setProduct_img(product_img);
			Product.setProduct_introduce(product_introduce);
			iProductservice.update(Product);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("ProductServlet.do?method=list");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
