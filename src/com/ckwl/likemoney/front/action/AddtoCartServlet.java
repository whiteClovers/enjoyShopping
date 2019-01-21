package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.cart.service.ICartService;
import com.ckwl.likemoney.cart.service.imp.CartServiceImp;
import com.ckwl.likemoney.cart.view.CartConditionView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.front.view.MyCartQueryView;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;


/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/user/AddtoCart.do")
public class AddtoCartServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	ICartService cartService = (ICartService) super.getDaoImpProxyFacroty(CartServiceImp.class);
	IProductSkuService iProductSkuService = (IProductSkuService) super.getDaoImpProxyFacroty(ProductSkuServiceImp.class);
   
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// 获取skuID
		String productSkuId = (String) session.getAttribute("productSkuId");
		
		// 获取商品详情
		ArrayList<ProductSkuQueryView> listProductSku = iProductSkuService.list(productSkuId);
		ProductSkuQueryView ProductSku = listProductSku.get(0);
		request.setAttribute("ProductSku", ProductSku);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/AddToCar.jsp").forward(request, response);
	}

	protected void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取商品详情中商品数据
		String productSkuId = request.getParameter("productSkuId");
		// 错误1！！！
		CartConditionView cartConditionView = new CartConditionView();
		cartConditionView.setProduct_sku_id(productSkuId);
		
		ArrayList<MyCartQueryView> listView = cartService.listView(new CartConditionView());
		
		
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		
		Cart cart = new Cart();
		
		// 错误的做法
		/*for (MyCartQueryView myCartQueryView : listView) {
			if (myCartQueryView.getProduct_sku_id().equals(productSkuId)) {
				// 将该物品加入购物车
				cartService.cartMount(productSkuId,customerId);
				b = false;
				break;
			}
		}*/
		
		boolean b = true;
		for (MyCartQueryView myCartQueryView : listView) {
			if (myCartQueryView.getCustomer_id().equals(customerId)) {
				if (myCartQueryView.getProduct_sku_id().equals(productSkuId)) {
					cartService.cartMount(productSkuId,customerId);
					b = false;
					break;
				}
			}
		}
		if (b) {
			cart.setProduct_sku_id(productSkuId);
			cart.setCar_date(new Date());
			cart.setCar_detect("false");
			cart.setCar_select("yes");
			cart.setSku_amount("1");
			cart.setCustomer_id(customerId);
			cartService.insert(cart);
		}
		
		// 将skuId加入session
		session.setAttribute("productSkuId", productSkuId);

		response.sendRedirect(request.getServletContext().getContextPath()+"/user/AddtoCart.do?method=list");
	}
	
	

}
