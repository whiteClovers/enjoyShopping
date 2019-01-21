package com.ckwl.likemoney.system.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.entity.SystemEmployee;
import com.ckwl.likemoney.system.entity.SystemEmployeeRole;
import com.ckwl.likemoney.system.entity.SystemRole;
import com.ckwl.likemoney.system.service.ISystemEmployeeRoleService;
import com.ckwl.likemoney.system.service.ISystemEmployeeService;
import com.ckwl.likemoney.system.service.ISystemRoleService;
import com.ckwl.likemoney.system.service.imp.SystemEmployeeRoleServiceImp;
import com.ckwl.likemoney.system.service.imp.SystemEmployeeServiceImp;
import com.ckwl.likemoney.system.service.imp.SystemRoleServiceImpl;
import com.ckwl.likemoney.system.view.SystemEmployeeConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeQueryView;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleQueryView;
import com.ckwl.likemoney.system.view.SystemRoleConditionView;

/**
 * Servlet implementation class SystemEmployeeRole
 */
@WebServlet("/admin/system/SystemEmployeeRoleServlet.do")
public class SystemEmployeeRoleServlet extends BaseServlet {
	private ISystemEmployeeRoleService systemEmployeeRoleService = (ISystemEmployeeRoleService) super.getDaoImpProxyFacroty(
			SystemEmployeeRoleServiceImp.class);
	private ISystemEmployeeService systemEmployeeService = (ISystemEmployeeService) super.getDaoImpProxyFacroty(
			SystemEmployeeServiceImp.class);
	private ISystemRoleService systemRoleService = (ISystemRoleService) super.getDaoImpProxyFacroty(
			SystemRoleServiceImpl.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SystemEmployeeRoleServlet() {
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

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emPloyeeName = request.getParameter("emPloyeeName");
		String roleName = request.getParameter("roleName");
		if(!StringUtil.isEmpty(roleName)){
			roleName = roleName.trim() ;
		}
		if(!StringUtil.isEmpty(emPloyeeName)){
			emPloyeeName = emPloyeeName.trim() ;
		}
		SystemEmployeeRoleConditionView systemEmployeeRoleConditionView=new SystemEmployeeRoleConditionView();
		systemEmployeeRoleConditionView.setEmPloyeeName(emPloyeeName);
		systemEmployeeRoleConditionView.setRoleName(roleName);
		
		
		ArrayList<SystemEmployeeRoleQueryView> listSystemEmployeeRole = systemEmployeeRoleService.list(systemEmployeeRoleConditionView);

		request.setAttribute("listSystemEmployeeRole", listSystemEmployeeRole);
		
		request.setAttribute("employeeName", emPloyeeName);
		
		request.setAttribute("roleName", roleName);
		

		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/sys_employee/sys_employeerole_list.jsp")
				.forward(request, response);

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emPloyeeRoleId = request.getParameter("emPloyeeRoleId");
		System.out.println("删除ID:" + emPloyeeRoleId);

		systemEmployeeRoleService.delete(emPloyeeRoleId);

		response.sendRedirect("SystemEmployeeRoleServlet.do?method=list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emPloyeeRoleId = request.getParameter("emPloyeeRoleId");
		SystemEmployeeRole systemEmployeeRole = new SystemEmployeeRole();

		
		ArrayList<SystemEmployeeQueryView> listSystemEmployee=systemEmployeeService.list(new SystemEmployeeConditionView());
		ArrayList<SystemRole> listSystemRole=systemRoleService.list(new SystemRoleConditionView());
		
		request.setAttribute("listSystemEmployee", listSystemEmployee);
		request.setAttribute("listSystemRole", listSystemRole);
		if (StringUtil.isEmpty(emPloyeeRoleId)) {
			String displaystatus = "none";
			request.setAttribute("displaystatus", displaystatus);

		} else {

			String displaystatus = "block";
			request.setAttribute("displaystatus", displaystatus);

			systemEmployeeRole = systemEmployeeRoleService.load(emPloyeeRoleId);

			request.setAttribute("systemEmployeeRole", systemEmployeeRole);

		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/sys_employee/sys_employeerole_edit.jsp")
				.forward(request, response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emPloyeeRoleId = request.getParameter("emPloyeeRoleId");
		String emPloyeeId = request.getParameter("emPloyeeId");
		String roleId = request.getParameter("roleId");

		// 根据s为空tudentId是否判断是新增还是修改的编辑

		if (StringUtil.isEmpty(emPloyeeRoleId)) {// 新增

			SystemEmployeeRole systemEmployeeRole = new SystemEmployeeRole();

			systemEmployeeRole.setEmPloyeeRoleId(emPloyeeRoleId);
			systemEmployeeRole.setEmPloyeeId(emPloyeeId);
			systemEmployeeRole.setRoleId(roleId);

			systemEmployeeRoleService.insert(systemEmployeeRole);

			System.out.println("新增保存:" + systemEmployeeRole.toString());

		} else {// 修改
				// S2.业务处理：调数据库,略
			SystemEmployeeRole systemEmployeeRole = new SystemEmployeeRole();

			systemEmployeeRole.setEmPloyeeRoleId(emPloyeeRoleId);
			systemEmployeeRole.setEmPloyeeId(emPloyeeId);
			systemEmployeeRole.setRoleId(roleId);

			systemEmployeeRoleService.update(systemEmployeeRole);
			System.out.println("修改的保存:" + systemEmployeeRole.toString());

		}

		response.sendRedirect("SystemEmployeeRoleServlet.do?method=list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
