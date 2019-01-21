package com.ckwl.likemoney.cart.action;

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
import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.cart.service.ICartService;
import com.ckwl.likemoney.cart.service.imp.CartServiceImp;
import com.ckwl.likemoney.cart.view.CartConditionView;
import com.ckwl.likemoney.cart.view.CartQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class cartServerlet 购物车结算页
 * 
 * @author lwh
 */
@WebServlet("/admin/cart/CartServlet.do")
public class CartServlet extends BaseServlet {
	private ICartService iCartservice = (ICartService) super.getDaoImpProxyFacroty(CartServiceImp.class);
	private IProductSkuService iProductSkuservice = (IProductSkuService) super.getDaoImpProxyFacroty(
			ProductSkuServiceImp.class);
	private IUserCustomerService iUserCustomerservice = (IUserCustomerService) super.getDaoImpProxyFacroty(
			UserCustomerServiceImp.class);
	private IDictionariesDetailService iDictionariesDetailService = (IDictionariesDetailService) super.getDaoImpProxyFacroty(DictionariesDetailServiceImpl.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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

	@SuppressWarnings("unused")
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
		String customer_name = request.getParameter("customer_name");
		String car_select = request.getParameter("car_select");
		String car_detect = request.getParameter("car_detect");
		String car_date = request.getParameter("car_date");
		request.setAttribute("customer_name", customer_name);
		request.setAttribute("car_select", car_select);
		request.setAttribute("car_detect", car_detect);
		if (!StringUtil.isEmpty(customer_name)) {
			customer_name = customer_name.trim();// 去掉空格
		}
		if (!StringUtil.isEmpty(car_select)) {
			car_select = car_select.trim();// 去掉空格
		}
		if (!StringUtil.isEmpty(car_detect)) {
			car_detect = car_detect.trim();// 去掉空格
		}
		if (!StringUtil.isEmpty(car_date)) {
			car_date = car_date.trim();// 去掉空格
		}
		CartConditionView CartConditionView = new CartConditionView();
		CartConditionView.setCustomer_name(customer_name);
		CartConditionView.setCar_select(car_select);
		CartConditionView.setCar_detect(car_detect);
		CartConditionView.setCar_date(car_date);
		ArrayList<CartQueryView> listCart = iCartservice.list(CartConditionView);

		// 传递对象数据
		request.setAttribute("listCart6", listCart);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/cart/cart_list.jsp").forward(request, response);
	}

	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String car_id = request.getParameter("car_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		Cart Cart = new Cart();
		Cart.setCar_id(car_id);
		iCartservice.delete(Cart);

		// s3.页面跳转：重定向
		response.sendRedirect("CartServlet.do?method=list");
	}

	@SuppressWarnings("unused")
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String CartId7 = request.getParameter("car_id");
		String car_select = request.getParameter("car_select");
		String car_delete = request.getParameter("car_delete");
		request.setAttribute("car_select", car_select);
		request.setAttribute("car_delete", car_delete);
		// 根据CartId是否为空判断是新增还是修改的编辑

		ProductSkuConditionView ProductSkuConditionView = new ProductSkuConditionView();
		UserCustomerConditionView UserCustomerConditionView = new UserCustomerConditionView();

		ArrayList<UserCustomer> listUserCustomer = iUserCustomerservice.list(UserCustomerConditionView);
		ArrayList<ProductSkuQueryView> listProductSku = iProductSkuservice.list(ProductSkuConditionView);
		List<DictionariesDetailQueryView> selectQueryViews =  iDictionariesDetailService.findByDictCode(DictConstant.CAR_SELECT);
		List<DictionariesDetailQueryView> deleteQueryViews =  iDictionariesDetailService.findByDictCode(DictConstant.CAR_DETECT);
		
		request.setAttribute("listProductSku6", listProductSku);
		request.setAttribute("listUserCustomer6", listUserCustomer);
		request.setAttribute("selectQueryViews", selectQueryViews);
		request.setAttribute("deleteQueryViews", deleteQueryViews);
		
		if (StringUtil.isEmpty(CartId7)) {// 新增
			String displaystatus = "none";
			request.setAttribute("displaystatus", displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus = "none";
			request.setAttribute("displaystatus", displaystatus);
			Cart Cart = new Cart();
			Cart.setCar_id(CartId7);
			request.setAttribute("Cart4", Cart);
		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/cart/cart_edit.jsp").forward(request, response);

	}

	@SuppressWarnings("unused")
	private void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String car_id = request.getParameter("car_id");
		String product_sku_id = request.getParameter("product_sku_id");
		String car_date = request.getParameter("car_date");// 外键
		String customer_id = request.getParameter("customer_id");
		String car_select = request.getParameter("car_select");
		String car_detect = request.getParameter("car_detect");

		// 根据CartId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(car_id)) {// 新增

			Cart Cart = new Cart();

			Cart.setProduct_sku_id(product_sku_id);
			Cart.setCar_date(StringUtil.stringToDate(car_date));
			Cart.setCustomer_id(customer_id);
			Cart.setCar_select(car_select);
			Cart.setCar_detect(car_detect);

			iCartservice.insert(Cart);
		} else {// 修改
				// S2.业务处理：调数据库,略
			Cart Cart = new Cart();
			Cart.setCar_id(car_id);
			Cart.setProduct_sku_id(product_sku_id);
			Cart.setCar_date(StringUtil.stringToDate(car_date));
			Cart.setCustomer_id(customer_id);
			Cart.setCar_select(car_select);
			Cart.setCar_detect(car_detect);
			iCartservice.update(Cart);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("CartServlet.do?method=list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

}
