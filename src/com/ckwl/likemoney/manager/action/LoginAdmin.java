package com.ckwl.likemoney.manager.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.system.entity.SystemEmployee;
import com.ckwl.likemoney.system.service.ISystemEmployeeService;
import com.ckwl.likemoney.system.service.ISystemMenuService;
import com.ckwl.likemoney.system.service.imp.SystemEmployeeServiceImp;
import com.ckwl.likemoney.system.service.imp.SystemMenuServiceImpl;
import com.ckwl.likemoney.system.view.SystemMenuQueryView;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin.do")
public class LoginAdmin extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	ISystemEmployeeService employeeService = (ISystemEmployeeService) super.getDaoImpProxyFacroty(SystemEmployeeServiceImp.class);
	
	ISystemMenuService iSystemMenuService = (ISystemMenuService) super.getDaoImpProxyFacroty(SystemMenuServiceImpl.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/login.jsp").forward(request, response);
		
	}
	
	@SuppressWarnings("unused")
	protected void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		SystemEmployee employee =  employeeService.loginAdmin(username, password);
		System.out.println(employee);
		
		HttpSession session = request.getSession();
		String employeeId = employee.getEmployeeId();
		ArrayList<SystemMenuQueryView> listMenuQuery = iSystemMenuService.selectByEmployeeId(employeeId);
		
		if (employee!=null) {
			System.out.print("登录成功");
			System.out.println("...");
			session.setAttribute("session_employee", employee);
			// 权限集合
			session.setAttribute("session_listMenuQuery", listMenuQuery);
			
			response.sendRedirect(request.getServletContext().getContextPath()+"/IndexManager.do");
		}else {
			System.out.println("登录失败");
			request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/admin_login_error.jsp").forward(request, response);
		}
		
	}
	/*public void setSysMenuQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		SystemEmployee employee = (SystemEmployee) session.getAttribute("session_emloyee");
		
		String employeeId = employee.getEmployeeId();
		
		ArrayList<SystemMenuQueryView> listMenuQuery = iSystemMenuService.selectByEmployeeId(employeeId);
		
		session.setAttribute("session_listMenuQuery", listMenuQuery);
		
	}*/

}
