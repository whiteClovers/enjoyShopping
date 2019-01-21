package com.ckwl.likemoney.user.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.user.dao.imp.UserAddressDaoImp;
import com.ckwl.likemoney.user.entity.UserAddress;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserAddressService;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserAddressServiceImp;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserAddressConditionView;
import com.ckwl.likemoney.user.view.UserAddressQueryView;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class UserAddressServlet
 */
@WebServlet("/admin/user/UserAddressServlet.do")
public class UserAddressServlet extends BaseServlet {
	private IUserAddressService iUserAddressservice=(IUserAddressService)super.getDaoImpProxyFacroty(UserAddressServiceImp.class);
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String addressName=request.getParameter("addressName");
    	String addressConsignee=request.getParameter("addressConsignee");
    	if(StringUtil.isNotEmpty(addressName)){
    		addressName = addressName.trim() ;
		}
    	if(StringUtil.isNotEmpty(addressConsignee)){
    		addressConsignee = addressConsignee.trim() ;
		}
    	//ArrayList<UserAddress> listUserAddress=iUserAddressservice.select();
    	UserAddressConditionView userAddressConditionView=new UserAddressConditionView();
    	userAddressConditionView.setAddressConsignee(addressConsignee);
    	userAddressConditionView.setAddressName(addressName);
    	
    	ArrayList<UserAddressQueryView> listUserAddress=iUserAddressservice.select(userAddressConditionView);
    	request.setAttribute("addressName", addressName);
    	request.setAttribute("addressConsignee", addressConsignee);
		// 传递对象数据
		request.setAttribute("listUserAddress6", listUserAddress);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/usr/usr_address_list.jsp").forward(request, response);
		
	}
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// s1.取参数
		String addressId7 = request.getParameter("addressId6");
      
		// s2.业务逻辑
		System.out.println("删除ID:" + addressId7);
		
		
		
		iUserAddressservice.delete(addressId7);


		// s3.页面跳转：重定向
		response.sendRedirect("BankServlet.do?method=list");
	
   }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	// S1.获取参数
    			String addressId = request.getParameter("bankId6");
    			UserAddress userAddress=new UserAddress();
    			
    			ArrayList<UserCustomer> listUserCustomer= iUserCustomerService.list(new UserCustomerConditionView()) ;
    			
    			request.setAttribute("listUserCustomer", listUserCustomer);
    			// 根据BankId是否为空判断是新增还是修改的编辑

    			if (StringUtil.isEmpty(addressId)) {// 新增
    				
    			} else {// 修改
    					// S2.业务逻辑操作
    				userAddress=iUserAddressservice.load(addressId);
    				

    				request.setAttribute("userAddress4", userAddress);

    			}

    			// S3.跳转
    			request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/usr/usr_address_edit.jsp").forward(request, response);
    }
     protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// S1.接收请求参数
			String addressId = request.getParameter("addressId");
			String addressName = request.getParameter("addressName");
			String addressPhone=request.getParameter("addressPhone");
			String addressConsignee=request.getParameter("addressConsignee");
			String addressEmail=request.getParameter("addressEmail");
			String addressCode=request.getParameter("addressCode");
			String customerId=request.getParameter("customerId");
			String addressRegion=request.getParameter("addressRegion");
			String addressDefault=request.getParameter("addressDefault");

			UserAddress userAddress=new UserAddress(); 
			  
			userAddress.setAddressId(addressId);
			userAddress.setAddressName(addressName);
			userAddress.setAddressPhone(addressPhone);
			userAddress.setAddressConsignee(addressConsignee);
			userAddress.setAddressEmail(addressEmail);
			userAddress.setAddressCode(addressCode);
			userAddress.setCustomerId(customerId);
			userAddress.setAddressRegion(addressRegion);
			userAddress.setAddressDefault(addressDefault);
		
			UserAddressDaoImp userAddressDaoImp=new UserAddressDaoImp();
			
			// 根据addressId是否为空判断是新增还是修改的编辑
			if (StringUtil.isEmpty(addressId)) {// 新增
				System.out.println("新增保存:" + addressName);
			   
				userAddressDaoImp.insert(userAddress);
				
			} else {// 修改
				// S2.业务处理：调数据库,略
				userAddress.setAddressId(addressId);
				userAddressDaoImp.update(userAddress);
				
				System.out.println("修改的保存:" + "addressId:" + addressId + ",addressName:" + addressName+"addressPhone:"+addressPhone+
						"addressConsignee:"+addressConsignee+"addressEmail:"+addressEmail+"addressCode:"+addressCode+"customerId:"+customerId+
						"addressRegion:"+addressRegion+"addressDefault:"+addressDefault);

			}

			// S3.页面跳转：重定向
			response.sendRedirect("UserAddressServlet.do?method=list");
	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
