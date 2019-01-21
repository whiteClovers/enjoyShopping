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
import com.ckwl.likemoney.system.entity.SystemModule;
import com.ckwl.likemoney.system.service.ISystemMenuService;
import com.ckwl.likemoney.system.service.ISystemModuleService;
import com.ckwl.likemoney.system.service.imp.SystemMenuServiceImpl;
import com.ckwl.likemoney.system.service.imp.SystemModuleServiceImpl;
import com.ckwl.likemoney.system.view.SystemMenuConditionView;
import com.ckwl.likemoney.system.view.SystemMenuQueryView;

/**
 * Servlet implementation class SystemMenu
 */
@WebServlet("/admin/system/SystemMenuServlet.do")
public class SystemMenuServlet extends BaseServlet {
	//代理对象
	private ISystemMenuService iSystemMenuService = (ISystemMenuService)super.getDaoImpProxyFacroty(SystemMenuServiceImpl.class);
	private ISystemModuleService iSystemModuleService = (ISystemModuleService) super.getDaoImpProxyFacroty(SystemModuleServiceImpl.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemMenuServlet() {
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
//	    ArrayList<SystemMenu> arrayList =  iSystemMenuService.list();
//	    request.setAttribute("list", arrayList);
		//获取查询参数(如果没有值得话，就系list，带有值得话就系条件筛选)
//		String moduleName = request.getParameter("moduleName");
		String menuName = request.getParameter("menuName");
		if(!StringUtil.isEmpty(menuName)){
			menuName = menuName.trim();//去掉空格
		}
		//创建对象，设置参数
		SystemMenuConditionView systemMenuConditionView = new SystemMenuConditionView();
		systemMenuConditionView.setMenuName(menuName);
		//根据筛选条件得出结果集
		ArrayList<SystemMenuQueryView> arrayList = iSystemMenuService.list(systemMenuConditionView);
		request.setAttribute("list", arrayList);
		request.setAttribute("menuName", menuName);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/systemPermissionsMenu/systemPermissionsMenu_list.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String menuId = request.getParameter("menuId");
		//传递外键对应信息的集合，这里应该是SystemModuleCoditionView(只包含id和name),这里偷懒就不写了
		ArrayList<SystemModule> arrayList = iSystemModuleService.list();
		request.setAttribute("moduleList", arrayList);
		if(StringUtil.isEmpty(menuId)){//新增编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
		}else{//编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
			SystemMenu menu = iSystemMenuService.load(menuId);
			request.setAttribute("menu", menu);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/systemPermissionsMenu/systemPermissionsMenu_editor.jsp").forward(request, response);
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String menuId = request.getParameter("menuId");
		String menuName = request.getParameter("menuName");
		String moduleId = request.getParameter("moduleId");
		//获得外键的信息
//		String moduleName = request.getParameter("moduleName");//其实也不要，因为字表只要改变了外键，对应的主表名称就会该表
		SystemMenu menu = new SystemMenu();
		if(StringUtil.isEmpty(menuId)){//新增保存
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			menu.setMenuId(id);
			menu.setMenuName(menuName);
			menu.setModuleId(moduleId);
			iSystemMenuService.insert(menu);
		}else{//修改保存
			menu.setMenuId(menuId);
			menu.setMenuName(menuName);
			menu.setModuleId(moduleId);
			iSystemMenuService.update(menu);
		}
		response.sendRedirect(request.getServletContext().getContextPath()+"/SystemMenuServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String menuId = request.getParameter("menuId");
		iSystemMenuService.delete(menuId);
		response.sendRedirect(request.getServletContext().getContextPath()+"/SystemMenuServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
	
}
