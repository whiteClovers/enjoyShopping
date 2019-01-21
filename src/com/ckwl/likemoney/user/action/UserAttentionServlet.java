package com.ckwl.likemoney.user.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.service.IProductService;
import com.ckwl.likemoney.product.service.IProductStoreService;
import com.ckwl.likemoney.product.service.imp.ProductServiceImp;
import com.ckwl.likemoney.product.service.imp.ProductStoreServiceImp;
import com.ckwl.likemoney.product.view.ProductConditionView;
import com.ckwl.likemoney.product.view.ProductQueryView;
import com.ckwl.likemoney.product.view.ProductStoreConditionView;
import com.ckwl.likemoney.product.view.ProductStoreQueryView;
import com.ckwl.likemoney.user.dao.imp.UserAttentionDaoImp;
import com.ckwl.likemoney.user.entity.UserAttention;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserAttentionService;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserAttentionServiceImp;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserAttentionConditionView;
import com.ckwl.likemoney.user.view.UserAttentionQueryView;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class UserAttentionServlet
 */
@WebServlet("/admin/user/UserAttentionServlet.do")
public class UserAttentionServlet extends BaseServlet {
	private IUserAttentionService iUserAttentionService=(IUserAttentionService)super.getDaoImpProxyFacroty(UserAttentionServiceImp.class);
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	private IProductStoreService iProductStoreService = (IProductStoreService) super.getDaoImpProxyFacroty(ProductStoreServiceImp.class);
	private IProductService iProductService = (IProductService) super.getDaoImpProxyFacroty(ProductServiceImp.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAttentionServlet() {
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
    	    String attentionId=request.getParameter("attentionId");
    	    String storeId=request.getParameter("storeId");
    	    String customerId=request.getParameter("customerId");
    	    
    	    if(StringUtil.isNotEmpty(attentionId)){
    	    	attentionId = attentionId.trim() ;
    		}
    	    if(StringUtil.isNotEmpty(storeId)){
    	    	storeId = storeId.trim() ;
    		}
    	    if(StringUtil.isNotEmpty(customerId)){
    	    	customerId = customerId.trim() ;
    		}
    	// 根据业务逻辑，查询数据
	
    			//ArrayList<UserAttention> listUserAttention =iUserAttentionService.select() ;
    	    UserAttentionConditionView userAttentionConditionView=new UserAttentionConditionView();
    	    userAttentionConditionView.setAttentionId(attentionId);
    	    userAttentionConditionView.setStoreId(storeId);
    	    userAttentionConditionView.setCustomerId(customerId);
    	    
    	    ArrayList<UserAttentionQueryView> listUserAttention =iUserAttentionService.list(userAttentionConditionView) ;
    	    request.setAttribute("attentionId", attentionId);
    	    request.setAttribute("storeId", storeId);
    	    request.setAttribute("customerId", customerId);
    				// 传递对象数据
    				request.setAttribute("listUserAttention6", listUserAttention);

    				// 页面的跳转：转发
    				request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/usr/usr_Attention_list.jsp").forward(request, response);
		
	}
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// s1.取参数
    			String attentionId7 = request.getParameter("attentionId6");
    	      
    			// s2.业务逻辑
    			System.out.println("删除ID:" + attentionId7);
    			
    			
    			
    			iUserAttentionService.delete(attentionId7);


    			// s3.页面跳转：重定向
    			response.sendRedirect("UserAttentionServlet.do?method=list");
	
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	// S1.获取参数
    			String attentionId = request.getParameter("attentionId6");
    			UserAttention userAttention=new UserAttention();
    			ArrayList<UserCustomer> listUserCustomer= iUserCustomerService.list(new UserCustomerConditionView()) ;
    			 ArrayList<ProductQueryView> listProductQueryView= iProductService.list(new ProductConditionView()) ;
    			 ArrayList<ProductStoreQueryView> listProductStoreQueryView= iProductStoreService.list(new ProductStoreConditionView()) ;
    			request.setAttribute("listUserCustomer", listUserCustomer);
    			request.setAttribute("listProductQueryView", listProductQueryView);
    			request.setAttribute("listProductStoreQueryView", listProductStoreQueryView);
    			// 根据BankId是否为空判断是新增还是修改的编辑

    			if (StringUtil.isEmpty(attentionId)) {// 新增
    				
    			} else {// 修改
    					// S2.业务逻辑操作
    				userAttention=iUserAttentionService.load(attentionId);
    				

    				request.setAttribute("userAttention4", userAttention);

    			}

    			// S3.跳转
    			request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/usr/usr_Attention_edit.jsp").forward(request, response);
    }
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// S1.接收请求参数
		String attentionId = request.getParameter("attentionId");
		String storeId = request.getParameter("storeId");
		String productId=request.getParameter("productId");
		String customerId=request.getParameter("customerId");
		String attentionDate=request.getParameter("attentionDate");

		UserAttention userAttention=new UserAttention();
		userAttention.setAttentionId(attentionId);
		userAttention.setStoreId(storeId);
		userAttention.setProductId(productId);
		userAttention.setCustomerId(customerId);
		try {
			userAttention.setAttentionDate(StringUtil.stringToDate(attentionDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		UserAttentionDaoImp userAttentionDaoImp=new UserAttentionDaoImp();
		// 根据studentId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(attentionId)) {// 新增
			System.out.println("新增保存:" + attentionId);
			userAttentionDaoImp.insert(userAttention);
			
			
		} else {// 修改
			// S2.业务处理：调数据库,略
			userAttention.setAttentionId(attentionId);
			userAttentionDaoImp.update(userAttention);
			
			System.out.println("修改的保存:" + "attentionId:" + attentionId + ",storeId:" + storeId+"productId:"+productId+
					"customerId:"+customerId+"attentionDate:"+attentionDate);

		}

		// S3.页面跳转：重定向
		response.sendRedirect("UserAttentionServlet.do?method=list");
	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
