package com.ckwl.likemoney.product.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.entity.ProductStore;
import com.ckwl.likemoney.product.service.IProductStoreService;
import com.ckwl.likemoney.product.service.imp.ProductStoreServiceImp;
import com.ckwl.likemoney.product.view.ProductStoreConditionView;
import com.ckwl.likemoney.product.view.ProductStoreQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class ProductStore
 */
@WebServlet("/admin/product/ProductStoreServlet.do")
public class ProductStoreServlet extends BaseServlet {
	private IProductStoreService productStoreService = (IProductStoreService) super.getDaoImpProxyFacroty(
			ProductStoreServiceImp.class);
	private IUserCustomerService iuserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductStoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeName = request.getParameter("storeName");
		String storeMessage = request.getParameter("storeMessage");
		String customerName = request.getParameter("customerName");

		if (!StringUtil.isEmpty(storeName)) {
			storeName = storeName.trim();
		}

		// 根据业务逻辑，查询数据

		// ArrayList<Student> listStudent = studentService.list(name ,remark ,
		// xyz , gradeId) ;

		ProductStoreConditionView productStoreConditionView = new ProductStoreConditionView();
		productStoreConditionView.setStoreName(storeName);
		productStoreConditionView.setStoreMessage(storeMessage);
		productStoreConditionView.setCustomerName(customerName);

		ArrayList<ProductStoreQueryView> listProductStore = productStoreService.list(productStoreConditionView);
		request.setAttribute("listProductStore", listProductStore);

		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/product/product_store_list.jsp").forward(request,
				response);

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeId = request.getParameter("storeId");
		System.out.println("删除ID:" + storeId);

		productStoreService.delete(storeId);

		response.sendRedirect("ProductStoreServlet.do?method=list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String storeId = request.getParameter("storeId");

		ArrayList<UserCustomer> listUserCustomer = iuserCustomerService.list(new UserCustomerConditionView());

		request.setAttribute("listUserCustomer", listUserCustomer);

		ProductStore productStore = new ProductStore();

		if (StringUtil.isEmpty(storeId)) {
			String displaystatus = "none";
			request.setAttribute("displaystatus", displaystatus);

		} else {

			String displaystatus = "block";
			request.setAttribute("displaystatus", displaystatus);

			productStore = productStoreService.load(storeId);

			request.setAttribute("productStore", productStore);

		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/product/product_store_edit.jsp").forward(request,
				response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String storeId = request.getParameter("storeId");
		String storeName = request.getParameter("storeName");
		String storeMessage = request.getParameter("storeMessage");
		String customerId = request.getParameter("customerId");

		// 根据s为空tudentId是否判断是新增还是修改的编辑

		if (StringUtil.isEmpty(storeId)) {// 新增

			ProductStore productStore = new ProductStore();

			productStore.setStoreId(storeId);
			productStore.setStoreName(storeName);
			productStore.setStoreMessage(storeMessage);
			// productStore.setCustomerId(customerId);

			productStoreService.insert(productStore);

			System.out.println("新增保存:" + productStore.toString());

		} else {// 修改
				// S2.业务处理：调数据库,略
			ProductStore productStore = new ProductStore();

			productStore.setStoreId(storeId);
			productStore.setStoreName(storeName);
			productStore.setStoreMessage(storeMessage);
			productStore.setCustomerId(customerId);

			productStoreService.update(productStore);
			System.out.println("修改的保存:" + productStore.toString());

		}

		response.sendRedirect("ProductStoreServlet.do?method=list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
