package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.cart.dao.imp.CartDaoImp;
import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.cart.service.ICartService;
import com.ckwl.likemoney.cart.service.imp.CartServiceImp;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.front.view.MyCartQueryView;

/**
 * Servlet implementation class zfjsServerlet
 */
@WebServlet("/user/SettlementServerlet.do")
public class SettlementServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private ICartService iCartService = (ICartService) super.getDaoImpProxyFacroty(CartServiceImp.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettlementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取传过来的productSkuId
		String[] arrayCarId = request.getParameterValues("carId");
		
		// 做两件事，购物车假删除，结算页商品数据展示
		int skuSum = 0 ; // 购物车商品数量
		BigDecimal priceSum = new BigDecimal(0.00) ; // 总价
		
		if (arrayCarId==null) {
			System.out.println("未选择任何商品");
			// 重定向到当前页面 
			response.sendRedirect(request.getServletContext().getContextPath()+"/user/SettlementServerlet.do");
		}
		
		// 假删除
		for (String carId : arrayCarId) {
			Cart cart = new Cart();
			cart.setCar_id(carId);
			
			iCartService.delete(cart);
			System.out.println("假删除成功");
		}
		
		// 结算页商品展示
		CartDaoImp cartDaoImp = new CartDaoImp();
		List<ArrayList<MyCartQueryView>> listCarts = new ArrayList<ArrayList<MyCartQueryView>>();
		
		for (String carId : arrayCarId) {
			ArrayList<MyCartQueryView> listView = cartDaoImp.listByCarId(carId);
			for (MyCartQueryView myCartQueryView : listView) {
				String sku_amount = myCartQueryView.getSku_amount();
				skuSum+=StringUtil.stringToInteger(sku_amount);
				priceSum = priceSum.add(myCartQueryView.getProduct_sku_realPrice().multiply(new BigDecimal(sku_amount)));
			}
			listCarts.add(listView);
			
		}
		// 转两位小数，怎么转不成功
		BigDecimal priceSums = priceSum.setScale(2, BigDecimal.ROUND_HALF_UP);
		// 实付金额，减去优惠6.9
		BigDecimal priceSumS = priceSum.subtract(new BigDecimal("0.00"));
		
		HttpSession session = request.getSession();
		String customerName = (String) session.getAttribute("customerName");
		
		request.setAttribute("listCarts", listCarts);
		request.setAttribute("skuSum", skuSum);
		request.setAttribute("priceSum", priceSums);
		request.setAttribute("customerName", customerName);
		
		request.setAttribute("priceSumS", priceSumS);
		
		// session传递priceSum给支付页面调用
		
		session.setAttribute("priceSumS", priceSumS);
		session.setAttribute("listCarts", listCarts);
		session.setAttribute("priceSumS", priceSumS);
		session.setAttribute("arrayCarId", arrayCarId);
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/Settlement.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
