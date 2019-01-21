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
import com.ckwl.likemoney.stock.entity.StockIn;
import com.ckwl.likemoney.stock.service.IStockInService;
import com.ckwl.likemoney.stock.service.imp.StockServiceImp;
import com.ckwl.likemoney.stock.view.StockInConditionView;
import com.ckwl.likemoney.stock.view.StockInQueryView;
import com.ckwl.likemoney.system.service.ISystemEmployeeService;
import com.ckwl.likemoney.system.service.imp.SystemEmployeeServiceImp;
import com.ckwl.likemoney.system.view.SystemEmployeeConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeQueryView;


@WebServlet("/admin/stock/StockInServlet.do")
public class StockInServlet extends BaseServlet {
	private IStockInService iStockInService = (IStockInService) super.getDaoImpProxyFacroty(StockServiceImp.class);
	private ISystemEmployeeService iSystemEmployeeService = (ISystemEmployeeService) super.getDaoImpProxyFacroty(SystemEmployeeServiceImp.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
	}
	@SuppressWarnings("unused")
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String code = request.getParameter("code");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String pay = request.getParameter("pay");
		String empName = request.getParameter("empName");
		if(!StringUtil.isEmpty(code)){
			code = code.trim();
		}
		if(!StringUtil.isEmpty(start)){
			start = start.trim();
		}
		if(!StringUtil.isEmpty(code)){
			end = end.trim();
		}
		if(!StringUtil.isEmpty(code)){
			pay = pay.trim();
		}
		if(!StringUtil.isEmpty(code)){
			empName = empName.trim();
		}
		//生成模糊查询对象
		StockInConditionView conditionView = new StockInConditionView();
		conditionView.setStockInCode(code);
		conditionView.setStartTime(start);
		conditionView.setEndTime(end);
		conditionView.setStockInPay(pay);
		conditionView.setEmployeeName(empName);
		//回显数据
		request.setAttribute("code", code);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("pay", pay);
		request.setAttribute("empName", empName);
		//根據業務邏輯查詢數據
		ArrayList<StockInQueryView> listStockIn = iStockInService.list(conditionView);
		//传数据
		request.setAttribute("listStockIn",listStockIn);
		//页面跳转 转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/stock_in/stockIn_list.jsp").forward(request, response);
	}
	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取id
		String stockInId = request.getParameter("stockInId");
		iStockInService.delete(stockInId);
		response.sendRedirect("StockInServlet.do?method=list");
	}
	@SuppressWarnings({ "static-access", "unused" })
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取id
		String stockInId = request.getParameter("stockInId");
		String stockInCode = request.getParameter("stockInCode");
		String stockInTime = request.getParameter("stockInTime");
		String stockInPay = request.getParameter("stockInPay");
		String employeeId = request.getParameter("employeeId");
		if (StringUtil.isEmpty(stockInId)){//新增
			StockIn stockIn = new StockIn();
			StringUtil stringUtil =new StringUtil();
			stockIn.setStockInId(stockInId);
			stockIn.setStockInCode(stockInCode);
			stockIn.setStockInTime(stockInTime);
			stockIn.setStockInPay(stringUtil.stringToBigdecimal(stockInPay));
			stockIn.setEmployeeId(employeeId);
			iStockInService.insert(stockIn);
		}else{//修改
			StockIn stockIn = new StockIn();
			StringUtil stringUtil =new StringUtil();
			stockIn.setStockInId(stockInId);
			stockIn.setStockInCode(stockInCode);
			stockIn.setStockInTime(stockInTime);
			stockIn.setStockInPay(stringUtil.stringToBigdecimal(stockInPay));
			stockIn.setEmployeeId(employeeId);
			iStockInService.update(stockIn);
		}
		//重定向到list
		response.sendRedirect("StockInServlet.do?method=list");
	}
	@SuppressWarnings("unused")
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取id
		String stockInId = request.getParameter("stockInId");
		//生成外键对象
		ArrayList<SystemEmployeeQueryView> arrayList = iSystemEmployeeService.list(new SystemEmployeeConditionView());
		if(StringUtil.isEmpty(stockInId)){//新增
			
		}else{//修改
			StockIn stockIn = iStockInService.load(stockInId);
			stockIn.setStockInId(stockInId);
			request.setAttribute("stockIn", stockIn);
		}
		request.setAttribute("empList", arrayList);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/stock_in/stockIn_edit.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

