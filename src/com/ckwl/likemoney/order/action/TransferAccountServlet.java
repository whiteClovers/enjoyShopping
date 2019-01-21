package com.ckwl.likemoney.order.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.order.dao.imp.TransferAccountDaoImp;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.entity.TransferAccount;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.service.ITransferAccountService;
import com.ckwl.likemoney.order.service.imp.OrderServiceImp;
import com.ckwl.likemoney.order.service.imp.TransferAccountImp;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderQueryView;
import com.ckwl.likemoney.order.view.TransferAccountConditionView;
import com.ckwl.likemoney.order.view.TransferAccountQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class TransferAccountServlet
 */ 
@WebServlet("/admin/order/TransferAccountServlet.do")
public class TransferAccountServlet extends BaseServlet{
	
	private ITransferAccountService iTransferAccountService=(ITransferAccountService)super.getDaoImpProxyFacroty(TransferAccountImp.class);
	private IUserCustomerService iUserCustomerService=(IUserCustomerService)super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	private IOrderService iOrderService=(IOrderService)super.getDaoImpProxyFacroty(OrderServiceImp.class);
	private static final long serialVersionUID = 1L;
       

    public TransferAccountServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 根据业务逻辑，查询数据
         String customerId=request.getParameter("customerId");
         String orderId=request.getParameter("orderId");
         if(StringUtil.isNotEmpty(customerId)){
        	 customerId = customerId.trim() ;
 		}
         if(StringUtil.isNotEmpty(orderId)){
        	 orderId = orderId.trim() ;
 		}
         
         TransferAccountConditionView transferAccountConditionView=new TransferAccountConditionView();
         transferAccountConditionView.setCustomerId(customerId);
         transferAccountConditionView.setOrderId(orderId);
				//ArrayList<TransferAccount> listTransferAccount= iTransferAccountService.select() ;
         ArrayList<TransferAccountQueryView> listTransferAccount= iTransferAccountService.select(transferAccountConditionView) ;
         request.setAttribute("customerId", customerId);
         request.setAttribute("orderId", orderId);
					// 传递对象数据
					request.setAttribute("listTransferAccount6", listTransferAccount);

					// 页面的跳转：转发
					request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/TransferAccountList.jsp").forward(request, response);
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// s1.取参数
				String TransferAccountsId7 = request.getParameter("TransferAccountsId6");
		      
				// s2.业务逻辑
				System.out.println("删除ID:" + TransferAccountsId7);
				
				
				
				iTransferAccountService.delete(TransferAccountsId7);


				// s3.页面跳转：重定向
				response.sendRedirect("TransferAccountServlet.do?method=list");
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// S1.获取参数
				String TransferAccountsId = request.getParameter("TransferAccountsId6");
				TransferAccount transferAccount=new TransferAccount();
				// 根据BankId是否为空判断是新增还是修改的编辑
				ArrayList<UserCustomer> listUserCustomer= iUserCustomerService.list(new UserCustomerConditionView()) ;
				ArrayList<OrderQueryView> listOrder= iOrderService.list(new OrderConditionView());
				
				request.setAttribute("listUserCustomer", listUserCustomer);
				request.setAttribute("listOrder", listOrder);
				if (StringUtil.isEmpty(TransferAccountsId)) {// 新增
					
				} else {// 修改
						// S2.业务逻辑操作
					
					TransferAccountDaoImp transferAccountDaoImp = new TransferAccountDaoImp() ;
					transferAccount.setTransferAccountsId(TransferAccountsId);
					

					request.setAttribute("transferAccount4", transferAccount);

				}

				// S3.跳转
				request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/TransferAccountEdit.jsp").forward(request, response);
	}
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// S1.接收请求参数
		String TransferAccountsId = request.getParameter("TransferAccountsId");
		String customerId = request.getParameter("customerId");
		String orderId=request.getParameter("orderId");
		String receivablesId=request.getParameter("receivablesId");
		String receivablesName=request.getParameter("receivablesName");
		String orderSumMoney=request.getParameter("orderSumMoney");
		String orderPaydate=request.getParameter("orderPaydate");

		TransferAccount transferAccount = new TransferAccount() ;
		
		transferAccount.setTransferAccountsId(TransferAccountsId);
		transferAccount.setCustomerId(customerId);
		transferAccount.setOrderId(orderId);;
		transferAccount.setReceivablesId(receivablesId);;
		transferAccount.setReceivablesName(receivablesName);;
		transferAccount.setOrderSumMoney(StringUtil.stringToBigdecimal(orderSumMoney));;
		try {
			transferAccount.setOrderPaydate(StringUtil.stringToDate(orderPaydate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		TransferAccountDaoImp transferAccountDaoImp = new TransferAccountDaoImp() ;
		// 根据studentId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(TransferAccountsId)) {// 新增
			System.out.println("新增保存:" + orderId);
		   
			transferAccountDaoImp.insert(transferAccount);
			
		} else {// 修改
			// S2.业务处理：调数据库,略
			transferAccount.setOrderId(orderId);
			transferAccountDaoImp.update(transferAccount);
			System.out.println("修改的保存:" +transferAccount.toString());

		}

		// S3.页面跳转：重定向
		response.sendRedirect("TransferAccountServlet.do?method=list");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
