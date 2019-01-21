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
import com.ckwl.likemoney.product.entity.ProductColor;
import com.ckwl.likemoney.product.service.IProductColorService;
import com.ckwl.likemoney.product.service.imp.ProductColorServiceImp;
import com.ckwl.likemoney.product.view.ProductColorConditionView;

/**
 * Servlet implementation class ProductColorServlet
 */
@WebServlet("/admin/product/ProductColorServlet.do")
public class ProductColorServlet extends BaseServlet {
	private IProductColorService iProductColorService = (IProductColorService) super.getDaoImpProxyFacroty(ProductColorServiceImp.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductColorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
		 
		    String color_name = request.getParameter("color_name");
		    if(!StringUtil.isEmpty(color_name)){
		    	color_name = color_name.trim();//去掉空格
			}
		   
		    ProductColorConditionView ProductColorConditionView=new ProductColorConditionView();
		    ProductColorConditionView.setColor_name(color_name);
		
		ArrayList<ProductColor> listProductColor = iProductColorService.list(ProductColorConditionView);
	

		// 传递对象数据
		request.setAttribute("listProductColor6", listProductColor);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bra+col+siz/color_list.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String ProductColor_id = request.getParameter("color_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		ProductColor ProductColor = new ProductColor();
		ProductColor.setColor_id(ProductColor_id);
		iProductColorService.delete(ProductColor);

		// s3.页面跳转：重定向
		response.sendRedirect("ProductColorServlet.do?method=list");

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String ProductColorId7 = request.getParameter("color_id");

		// 根据ProductColorId是否为空判断是新增还是修改的编辑

		if (StringUtil.isEmpty(ProductColorId7)) {// 新增
			String displaystatus="none";
			request.setAttribute("displaystatus",displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus="block";
			request.setAttribute("displaystatus",displaystatus);
			ProductColor ProductColor = new ProductColor();
			ProductColor.setColor_id(ProductColorId7);

			request.setAttribute("ProductColor4", ProductColor);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bra+col+siz/color_edit.jsp").forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String ProductColor_id = request.getParameter("color_id");
		String ProductColor_name = request.getParameter("color_name");

		
		

		// 根据ProductColorId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(ProductColor_id)) {// 新增
			
			ProductColor ProductColor = new ProductColor();
			ProductColor.setColor_id(ProductColor_id);
			ProductColor.setColor_name(ProductColor_name);

			
			iProductColorService.insert(ProductColor);
		} else {// 修改
				// S2.业务处理：调数据库,略
			ProductColor ProductColor = new ProductColor();
			ProductColor.setColor_id(ProductColor_id);
			ProductColor.setColor_name(ProductColor_name);
			iProductColorService.update(ProductColor);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("ProductColorServlet.do?method=list");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
