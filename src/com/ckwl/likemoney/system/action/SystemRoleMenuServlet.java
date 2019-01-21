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
import com.ckwl.likemoney.system.entity.SystemMenu;
import com.ckwl.likemoney.system.entity.SystemRole;
import com.ckwl.likemoney.system.entity.SystemRoleMenu;
import com.ckwl.likemoney.system.service.ISystemMenuService;
import com.ckwl.likemoney.system.service.ISystemRoleMenuService;
import com.ckwl.likemoney.system.service.ISystemRoleService;
import com.ckwl.likemoney.system.service.imp.SystemMenuServiceImpl;
import com.ckwl.likemoney.system.service.imp.SystemRoleMenuServiceImpl;
import com.ckwl.likemoney.system.service.imp.SystemRoleServiceImpl;
import com.ckwl.likemoney.system.view.SystemRoleMenuConditionView;
import com.ckwl.likemoney.system.view.SystemRoleMenuQueryView;

/**
 * Servlet implementation class SystemRoleMenu
 */
@WebServlet("/admin/system/SystemRoleMenuServlet.do")
public class SystemRoleMenuServlet extends BaseServlet {
	//生成代理对象
	private ISystemRoleMenuService iSystemRoleMenuService = (ISystemRoleMenuService) super.getDaoImpProxyFacroty(SystemRoleMenuServiceImpl.class);
	//edit使用
	private ISystemRoleService iSystemRoleService = (ISystemRoleService) super.getDaoImpProxyFacroty(SystemRoleServiceImpl.class);
	private ISystemMenuService iSystemMenuService = (ISystemMenuService) super.getDaoImpProxyFacroty(SystemMenuServiceImpl.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemRoleMenuServlet() {
        super();
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
		super.doPost(request, response);
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    String roleName = request.getParameter("roleName");
	    String menuName = request.getParameter("menuName");
	    if(!StringUtil.isEmpty(roleName)){
	    	roleName = roleName.trim();
	    }
	    if(!StringUtil.isEmpty(menuName)){
	    	menuName = menuName.trim();
	    }
	    SystemRoleMenuConditionView conditionView = new SystemRoleMenuConditionView();
	    conditionView.setMenuName(menuName);
	    conditionView.setRoleName(roleName);
		ArrayList<SystemRoleMenuQueryView> arrayList =  iSystemRoleMenuService.list(conditionView);
		request.setAttribute("roleName", roleName);
		request.setAttribute("menuName", menuName);
	    request.setAttribute("list", arrayList);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/roleMenu/roleMenu_list.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roleMenuId = request.getParameter("roleMenuId");
		
		ArrayList<SystemRole> arrayRoleList = iSystemRoleService.list();
		ArrayList<SystemMenu> arrayMenuList = iSystemMenuService.list();
		request.setAttribute("roleList", arrayRoleList);
		request.setAttribute("menuList", arrayMenuList);
		if(StringUtil.isEmpty(roleMenuId)){//新增编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
		}else{//编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
			SystemRoleMenu systemRoleMenu = iSystemRoleMenuService.load(roleMenuId);
			request.setAttribute("roleMenu", systemRoleMenu);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/roleMenu/roleMenu_edit.jsp").forward(request, response);
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roleMenuId = request.getParameter("roleMenuId");
		String roleId = request.getParameter("roleId");
		String menuId = request.getParameter("menuId");
		SystemRoleMenu systemRoleMenu = new SystemRoleMenu();
		if(StringUtil.isEmpty(roleMenuId)){//新增保存
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			systemRoleMenu.setRoleMenuId(id);
			systemRoleMenu.setRoleId(roleId);
			systemRoleMenu.setMenuId(menuId);
			iSystemRoleMenuService.insert(systemRoleMenu);
		}else{//修改保存
			systemRoleMenu.setRoleMenuId(roleMenuId);
			systemRoleMenu.setRoleId(roleId);
			systemRoleMenu.setMenuId(menuId);
			iSystemRoleMenuService.update(systemRoleMenu);
		}
		response.sendRedirect("SystemRoleMenuServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roleMenuId = request.getParameter("roleMenuId");
		iSystemRoleMenuService.delete(roleMenuId);
		response.sendRedirect("SystemRoleMenuServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
}
