package com.ckwl.likemoney.stock.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;
import com.ckwl.likemoney.stock.entity.StockInDetail;
import com.ckwl.likemoney.stock.service.IStockInDetailService;
import com.ckwl.likemoney.stock.service.IStockInService;
import com.ckwl.likemoney.stock.service.imp.StockInDetailServiceImp;
import com.ckwl.likemoney.stock.service.imp.StockServiceImp;
import com.ckwl.likemoney.stock.view.StockInConditionView;
import com.ckwl.likemoney.stock.view.StockInDetailConditionView;
import com.ckwl.likemoney.stock.view.StockInDetailQueryView;
import com.ckwl.likemoney.stock.view.StockInQueryView;

@WebServlet("/admin/stock/StockInDetailServlet.do")
public class StockInDetailServlet extends BaseServlet {
	private IStockInDetailService iStockInDetailService = (IStockInDetailService) super.getDaoImpProxyFacroty(
			StockInDetailServiceImp.class);
	private IStockInService iStockInService = (IStockInService) super.getDaoImpProxyFacroty(StockServiceImp.class);
	private IProductSkuService iProductSkuService = (IProductSkuService) super.getDaoImpProxyFacroty(ProductSkuServiceImp.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StockInDetailServlet() {
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
		String skuCode = request.getParameter("skuCode");// 搜索框产品skuCode
		String minPrice = request.getParameter("minPrice");
		String maxPrice = request.getParameter("maxPrice");
		String inCode = request.getParameter("inCode");
		// 数据回显

		StockInDetailConditionView conditionView = new StockInDetailConditionView();
		conditionView.setProductSkuCode(skuCode);
		conditionView.setMinPrice(minPrice);
		conditionView.setMaxPrice(maxPrice);
		conditionView.setStockInCode(inCode);
		// 根據業務邏輯查詢數據
		ArrayList<StockInDetailQueryView> listStockInDetail = iStockInDetailService.list(conditionView);
		// 传数据
		request.setAttribute("listStockInDetail", listStockInDetail);

		request.setAttribute("skuCode", skuCode);
		request.setAttribute("minPrice", minPrice);
		request.setAttribute("maxPrice", maxPrice);
		request.setAttribute("inCode", inCode);
		// 页面跳转 转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/stock_in/stockIn_detail_list.jsp").forward(request,
				response);
	}

	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取id
		String stockIn_detail_id = request.getParameter("stockIn_detail_id");
		iStockInDetailService.delete(stockIn_detail_id);
		response.sendRedirect("StockInDetailServlet.do?method=list");
	}

	@SuppressWarnings("unused")
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取id
		String stockIn_detail_id = request.getParameter("stockIn_detail_id");
		String product_sku_id = request.getParameter("product_sku_id");
		String stockIn_detail_amount = request.getParameter("stockIn_detail_amount");
		String stockIn_detail_price = request.getParameter("stockIn_detail_price");
		String stockIn_id = request.getParameter("stockIn_id");
		Integer amount = StringUtil.stringToInteger(stockIn_detail_amount);
		stockIn_detail_amount = String.valueOf(amount);
		if (StringUtil.isEmpty(stockIn_detail_id)) {// 新增
			StockInDetail stockInDetail = new StockInDetail();
			stockInDetail.setStockIn_detail_id(stockIn_detail_id);
			stockInDetail.setProduct_sku_id(product_sku_id);
			stockInDetail.setStockIn_detail_amount(stockIn_detail_amount);
			stockInDetail.setStockIn_detail_price(StringUtil.stringToBigdecimal(stockIn_detail_price));
			stockInDetail.setStockIn_id(stockIn_id);
			iStockInDetailService.insert(stockInDetail);
		} else {// 修改
			StockInDetail stockInDetail = new StockInDetail();
			StringUtil stringUtil = new StringUtil();
			stockInDetail.setStockIn_detail_id(stockIn_detail_id);
			stockInDetail.setProduct_sku_id(product_sku_id);
			stockInDetail.setStockIn_detail_amount(stockIn_detail_amount);
			stockInDetail.setStockIn_detail_price(StringUtil.stringToBigdecimal(stockIn_detail_price));
			stockInDetail.setStockIn_id(stockIn_id);
			iStockInDetailService.update(stockInDetail);
		}
		// 重定向到list
		response.sendRedirect("StockInDetailServlet.do?method=list");
	}

	@SuppressWarnings("unused")
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取包含外键的数据对象并传输
		ArrayList<StockInQueryView> list = iStockInService.list(new StockInConditionView());
		request.setAttribute("stoList", list);
		ArrayList<ProductSkuQueryView> list2 = iProductSkuService.list(new ProductSkuConditionView());
		request.setAttribute("proList", list2);
		// 获取id
		String stockIn_detail_id = request.getParameter("stockIn_detail_id");
		if (StringUtil.isEmpty(stockIn_detail_id)) {// 新增

		} else {// 修改
			StockInDetail stockInDetail = iStockInDetailService.load(stockIn_detail_id);
			stockInDetail.setStockIn_detail_id(stockIn_detail_id);
			request.setAttribute("stockInDetail", stockInDetail);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/stock_in/stockIn_detail_edit.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
