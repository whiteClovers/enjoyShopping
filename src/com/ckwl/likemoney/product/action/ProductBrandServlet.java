package com.ckwl.likemoney.product.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;

import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.service.IProductBrandService;
import com.ckwl.likemoney.product.service.imp.ProductBrandServiceImp;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;

/**
 * Servlet implementation class ProductBrandServlet
 */
@WebServlet("/admin/product/ProductBrandServlet.do")
public class ProductBrandServlet extends BaseServlet {
	private IProductBrandService iProductBrandService = (IProductBrandService) super.getDaoImpProxyFacroty(ProductBrandServiceImp.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBrandServlet() {
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
		 String brand_img = request.getParameter("brand_img");
		    String brand_name = request.getParameter("brand_name");
		    if(!StringUtil.isEmpty(brand_name)){
		    	brand_name = brand_name.trim();//去掉空格
			}
		    if(!StringUtil.isEmpty(brand_img)){
		    	brand_img = brand_img.trim();//去掉空格
			}
		    ProductBrandConditionView ProductBrandConditionView=new ProductBrandConditionView();
		    ProductBrandConditionView.setBrand_name(brand_name);
		    ProductBrandConditionView.setBrand_img(brand_img);
		    ArrayList<ProductBrand> listProductBrand = iProductBrandService.list(ProductBrandConditionView);
	

		// 传递对象数据
		request.setAttribute("listProductBrand6", listProductBrand);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bra+col+siz/brand_list.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String ProductBrand_id = request.getParameter("brand_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		ProductBrand ProductBrand = new ProductBrand();
		ProductBrand.setBrand_id(ProductBrand_id);
		iProductBrandService.delete(ProductBrand);

		// s3.页面跳转：重定向
		response.sendRedirect("ProductBrandServlet.do?method=list");

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String ProductBrandId7 = request.getParameter("brand_id");

		// 根据ProductBrandId是否为空判断是新增还是修改的编辑

		if (StringUtil.isEmpty(ProductBrandId7)) {// 新增
			String displaystatus="none";
			request.setAttribute("displaystatus",displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus="block";
			request.setAttribute("displaystatus",displaystatus);
			ProductBrand ProductBrand = new ProductBrand();
			ProductBrand.setBrand_id(ProductBrandId7);

			request.setAttribute("ProductBrand4", ProductBrand);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bra+col+siz/brand_edit.jsp").forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String ProductBrand_id = request.getParameter("brand_id");
		String ProductBrand_name = request.getParameter("brand_name");

		String ProductBrand_img = request.getParameter("brand_img");
		

		// 根据ProductBrandId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(ProductBrand_id)) {// 新增
			
			ProductBrand ProductBrand = new ProductBrand();
			ProductBrand.setBrand_id(ProductBrand_id);
			ProductBrand.setBrand_name(ProductBrand_name);

			ProductBrand.setBrand_img(ProductBrand_img);
			
			iProductBrandService.insert(ProductBrand);
		} else {// 修改
				// S2.业务处理：调数据库,略
			ProductBrand ProductBrand = new ProductBrand();
			ProductBrand.setBrand_id(ProductBrand_id);
			ProductBrand.setBrand_name(ProductBrand_name);
			ProductBrand.setBrand_img(ProductBrand_img);
			iProductBrandService.update(ProductBrand);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("ProductBrandServlet.do?method=list");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
