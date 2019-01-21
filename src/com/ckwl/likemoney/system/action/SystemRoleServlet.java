package com.ckwl.likemoney.system.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.entity.SystemRole;
import com.ckwl.likemoney.system.service.ISystemRoleService;
import com.ckwl.likemoney.system.service.imp.SystemRoleServiceImpl;
import com.ckwl.likemoney.system.view.SystemRoleConditionView;

/**
 * Servlet implementation class SystemRole
 */
@WebServlet("/admin/system/SystemRoleServlet.do")
public class SystemRoleServlet extends BaseServlet {
	
	private ISystemRoleService iSystemRoleService = (ISystemRoleService) super.getDaoImpProxyFacroty(SystemRoleServiceImpl.class);
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    String roleName = request.getParameter("roleName");
	    if(!StringUtil.isEmpty(roleName)){
	    	roleName = roleName.trim();
	    }
	    SystemRoleConditionView systemRoleConditionView = new SystemRoleConditionView();
	    systemRoleConditionView.setRoleName(roleName);
		ArrayList<SystemRole> arrayList =  iSystemRoleService.list(systemRoleConditionView);
	    request.setAttribute("list", arrayList);
	    request.setAttribute("roleName", roleName);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/systemRole/systemRole_list.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roleId = request.getParameter("roleId");
		if(StringUtil.isEmpty(roleId)){//新增编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
		}else{//编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
			SystemRole role = iSystemRoleService.load(roleId);
			request.setAttribute("role", role);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/systemRole/systemRole_editor.jsp").forward(request, response);
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roleId = request.getParameter("roleId");
		String roleName = request.getParameter("roleName");
		SystemRole systemRole = new SystemRole();
		if(StringUtil.isEmpty(roleId)){//新增保存
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			systemRole.setRoleId(id);
			systemRole.setRoleName(roleName);
			iSystemRoleService.insert(systemRole);
		}else{//修改保存
			systemRole.setRoleId(roleId);
			systemRole.setRoleName(roleName);
			iSystemRoleService.update(systemRole);
		}
		response.sendRedirect("SystemRoleServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roleId = request.getParameter("roleId");
		iSystemRoleService.delete(roleId);
		response.sendRedirect("SystemRoleServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
}
