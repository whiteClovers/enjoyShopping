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
import com.ckwl.likemoney.product.entity.ProductSize;
import com.ckwl.likemoney.product.service.IProductSizeService;
import com.ckwl.likemoney.product.service.imp.ProductSizeServiceImp;
import com.ckwl.likemoney.product.view.ProductSizeConditionView;

/**
 * Servlet implementation class ProductSizeServlet
 */
@WebServlet("/admin/product/ProductSizeServlet.do")
public class ProductSizeServlet extends BaseServlet {
	private IProductSizeService iProductSizeService = (IProductSizeService) super.getDaoImpProxyFacroty(ProductSizeServiceImp.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSizeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
	    String size_name = request.getParameter("size_name");
	    if(!StringUtil.isEmpty(size_name)){
	    	size_name = size_name.trim();//去掉空格
		}
	   
	    ProductSizeConditionView ProductSizeConditionView=new ProductSizeConditionView();
	    ProductSizeConditionView.setSize_name(size_name);
		ArrayList<ProductSize> listProductSize = iProductSizeService.list(ProductSizeConditionView);

		// 传递对象数据
		request.setAttribute("listProductSize6", listProductSize);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bra+col+siz/size_list.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String ProductSize_id = request.getParameter("size_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		ProductSize ProductSize = new ProductSize();
		ProductSize.setSize_id(ProductSize_id);
		iProductSizeService.delete(ProductSize);

		// s3.页面跳转：重定向
		response.sendRedirect("ProductSizeServlet.do?method=list");

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String ProductSizeId7 = request.getParameter("size_id");

		// 根据ProductSizeId是否为空判断是新增还是修改的编辑

		if (StringUtil.isEmpty(ProductSizeId7)) {// 新增
			String displaystatus="none";
			request.setAttribute("displaystatus",displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus="block";
			request.setAttribute("displaystatus",displaystatus);
			ProductSize ProductSize = new ProductSize();
			ProductSize.setSize_id(ProductSizeId7);

			request.setAttribute("ProductSize4", ProductSize);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bra+col+siz/size_edit.jsp").forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String ProductSize_id = request.getParameter("size_id");
		String ProductSize_name = request.getParameter("size_name");

		
		

		// 根据ProductSizeId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(ProductSize_id)) {// 新增
			
			ProductSize ProductSize = new ProductSize();
			ProductSize.setSize_id(ProductSize_id);
			ProductSize.setSize_name(ProductSize_name);

			
			iProductSizeService.insert(ProductSize);
		} else {// 修改
				// S2.业务处理：调数据库,略
			ProductSize ProductSize = new ProductSize();
			ProductSize.setSize_id(ProductSize_id);
			ProductSize.setSize_name(ProductSize_name);
			iProductSizeService.update(ProductSize);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("ProductSizeServlet.do?method=list");

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
super.doGet(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
