package com.ckwl.likemoney.bas.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.dao.imp.MoneyBankImp;
import com.ckwl.likemoney.bas.entity.Bank;
import com.ckwl.likemoney.bas.service.IBankService;
import com.ckwl.likemoney.bas.service.imp.BankServiceImp;
import com.ckwl.likemoney.bas.view.BankConditionView;
import com.ckwl.likemoney.bas.view.BankQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;


/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/admin/bas/BankServlet.do")
public class BankServlet extends BaseServlet {
	private IBankService iBankservice = (IBankService) super.getDaoImpProxyFacroty(BankServiceImp.class);
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
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

	
	@SuppressWarnings("unused")
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 根据业务逻辑，查询数据
        String bankNum=request.getParameter("bankNum");
        String customerId=request.getParameter("customerId");
		
        if(StringUtil.isNotEmpty(bankNum)){
        	bankNum = bankNum.trim() ;
		}
        if(StringUtil.isNotEmpty(customerId)){
        	customerId = customerId.trim() ;
		}
        
        
		//ArrayList<Bank> listBank = iBankservice.select() ;
        BankConditionView bankConditionView=new BankConditionView();
        bankConditionView.setBankNum(bankNum);
        bankConditionView.setCustomerId(customerId);
        ArrayList<BankQueryView> listBank = iBankservice.select(bankConditionView) ;
       
        request.setAttribute("bankNum", bankNum);
        request.setAttribute("customerId", customerId);
			// 传递对象数据
		request.setAttribute("listBank6", listBank);

			// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bank/bank_list.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// s1.取参数
		String bankId7 = request.getParameter("bankId6");
      
		// s2.业务逻辑
		System.out.println("删除ID:" + bankId7);
		
		
		
		iBankservice.delete(bankId7);


		// s3.页面跳转：重定向
		response.sendRedirect("BankServlet.do?method=list");
	}
	
	@SuppressWarnings("unused")
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// S1.获取参数
		String BankId = request.getParameter("bankId6");
		  Bank bank=new Bank();
		  ArrayList<UserCustomer> listUserCustomer= iUserCustomerService.list(new UserCustomerConditionView()) ;
        request.setAttribute("listUserCustomer", listUserCustomer);
		  

		if (StringUtil.isEmpty(BankId)) {// 新增
			
		} else {// 修改
				// S2.业务逻辑操作
			bank=iBankservice.load(BankId);

			request.setAttribute("bank4", bank);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bank/bank_edit.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unused")
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// S1.接收请求参数
				String bankId = request.getParameter("bankId");
				String bankName = request.getParameter("bankName");
				String bankNum=request.getParameter("bankNum");
				String customerId=request.getParameter("customerId");
				String bankType=request.getParameter("bankType");

				Bank bank = new Bank() ;
				
				bank.setBankId(bankId);
				bank.setBankName(bankName);
				bank.setBankNum(bankNum);
				bank.setCustomerId(customerId);
				bank.setBankType(bankType);
				
				MoneyBankImp moneyBankImp = new MoneyBankImp() ;
				// 根据studentId是否为空判断是新增还是修改的编辑
				if (StringUtil.isEmpty(bankId)) {// 新增
					System.out.println("新增保存:" + bankName);
				   
					moneyBankImp.insert(bank);
					
				} else {// 修改
					// S2.业务处理：调数据库,略
					bank.setBankId(bankId);
					moneyBankImp.update(bank);
					System.out.println("修改的保存:" + "bank_id:" + bankId + ",bank_name:" + bankName+"bank_num:"+bankNum
							+"banktype:"+bankType);

				}

				// S3.页面跳转：重定向
				response.sendRedirect("BankServlet.do?method=list");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
