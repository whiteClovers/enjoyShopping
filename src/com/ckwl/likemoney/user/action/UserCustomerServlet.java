package com.ckwl.likemoney.user.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.user.dao.imp.UserCustomerDaoImp;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class UserCustomerServlet
 */
@WebServlet("/admin/user/UserCustomerServlet.do")
public class UserCustomerServlet extends BaseServlet {
	private IUserCustomerService iuserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		String customerSex=request.getParameter("customerSex");
		
		 if(StringUtil.isNotEmpty(customerId)){
			 customerId = customerId.trim() ;
			}
		 if(StringUtil.isNotEmpty(customerName)){
			 customerName = customerName.trim() ;
			}
		 if(StringUtil.isNotEmpty(customerSex)){
			 customerSex = customerSex.trim() ;
			}
		// 根据业务逻辑，查询数据
		UserCustomerConditionView conditionView=new UserCustomerConditionView();
		conditionView.setCustomerId(customerId);
		conditionView.setCustomerName(customerName);
		conditionView.setCustomerSex(customerSex);
				ArrayList<UserCustomer> listUserCustomer = iuserCustomerService.list(conditionView) ;
				
				request.setAttribute("customerId", customerId);
				request.setAttribute("customerName", customerName);
				request.setAttribute("customerSex", customerSex);
				
					// 传递对象数据
				request.setAttribute("listUserCustomer6", listUserCustomer);
					// 页面的跳转：转发
				request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/usr/usr_customer_list.jsp").forward(request, response);
			
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// s1.取参数
				String customerId7 = request.getParameter("customerId6");
		      
				// s2.业务逻辑
				System.out.println("删除ID:" + customerId7);
				
				
				
				iuserCustomerService.delete(customerId7);


				// s3.页面跳转：重定向
				response.sendRedirect("UserCustomerServlet.do?method=list");
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// S1.获取参数
				String customerId = request.getParameter("customerId6");
				UserCustomer userCustomer=new UserCustomer();
				ArrayList<UserCustomer> listUserCustomer= iuserCustomerService.list(new UserCustomerConditionView()) ;
				request.setAttribute("listUserCustomer", listUserCustomer);
				// 根据customerId是否为空判断是新增还是修改的编辑

				if (StringUtil.isEmpty(customerId)) {// 新增
					
				} else {// 修改
						// S2.业务逻辑操作
					userCustomer=iuserCustomerService.load(customerId);				

					request.setAttribute("userCustomer4", userCustomer);

				}

				// S3.跳转
				request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/usr/usr_customer_edit.jsp").forward(request, response);
	}
	protected void save(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// S1.接收请求参数
		String customerId=request.getParameter("customerId");
		String customerEd=request.getParameter("customerEd");
		String customerName=request.getParameter("customerName");
		String customerPwd=request.getParameter("customerPwd");
		String customerPayPwd=request.getParameter("customerPhone");
		String customerPhone=request.getParameter("customerId");
		String customerEmail=request.getParameter("customerEmail");
		String customerSex=request.getParameter("customerSex");
		String customerVip=request.getParameter("customerVip");
		
		String customerBirthday=request.getParameter("customerBirthday");
		String customerHobby=request.getParameter("customerHobby");
		String customerNickName=request.getParameter("customerNickName");
		String customerImg=request.getParameter("customerImg");
		String customerBalance=request.getParameter("customerBalance");
		String customerIncome=request.getParameter("customerIncome");
		String customerIdCard=request.getParameter("customerIdCard");
		String customerMaritalStatus=request.getParameter("customerMaritalStatus");
		String customerAvailableStatus=request.getParameter("customerAvailableStatus");
		
		
	

		UserCustomer userCustomer=new UserCustomer();
		
		userCustomer.setCustomerId(customerId);
		userCustomer.setCustomerEd(customerEd);
		userCustomer.setCustomerName(customerName);
		userCustomer.setCustomerPwd(customerPwd);
		userCustomer.setCustomerPayPwd(customerPayPwd);
		userCustomer.setCustomerPhone(customerPhone);
		userCustomer.setCustomerEmail(customerEmail);
		userCustomer.setCustomerSex(customerSex);
		userCustomer.setCustomerVip(customerVip);
		try {
			userCustomer.setCustomerBirthday(StringUtil.stringToDate(customerBirthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userCustomer.setCustomerHobby(customerHobby);
		userCustomer.setCustomerNickName(customerNickName);
		userCustomer.setCustomerImg(customerImg);
		userCustomer.setCustomerBalance(StringUtil.stringToBigdecimal(customerBalance));
		userCustomer.setCustomerIncome(StringUtil.stringToBigdecimal(customerIncome));
		userCustomer.setCustomerIdCard(customerIdCard);
		userCustomer.setCustomerMaritalStatus(customerMaritalStatus);
		userCustomer.setCustomerAvailableStatus(customerAvailableStatus);
		
		
		UserCustomerDaoImp userCustomerDaoImp=new UserCustomerDaoImp();
		// 根据studentId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(customerId)) {// 新增
			System.out.println("新增保存:" + customerId);
		   
			userCustomerDaoImp.insert(userCustomer);
			
		} else {// 修改
			// S2.业务处理：调数据库,略
			userCustomer.setCustomerId(customerId);
			userCustomerDaoImp.update(userCustomer);
			
			System.out.println("修改的保存:" + "customerId:" + customerId + ",customerEd:" + customerEd+"customerName:"+customerName+
					"customerPwd:"+customerPwd+"customerPayPwd:"+customerPayPwd+ ",customerPhone:" + customerPhone+ ",customerEmail:" + customerEmail+
					",customerSex:" + customerSex+ ",customerVip:" + customerVip+ ",customerBirthday:" + customerBirthday+ ",customerHobby:" + customerHobby+ 
					",customerNickName:" + customerNickName+ ",customerImg:" + customerImg+ ",customerBalance:" + customerBalance+ ",customerIncome:" + customerIncome+ 
					",customerIdCard:" + customerIdCard+ ",customerMaritalStatus:" + customerMaritalStatus+ ",customerAvailableStatus:" + customerAvailableStatus);

		}

		// S3.页面跳转：重定向
		response.sendRedirect("UserCustomerServlet.do?method=list");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
