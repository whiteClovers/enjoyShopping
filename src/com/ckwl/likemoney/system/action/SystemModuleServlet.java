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
import com.ckwl.likemoney.frame.dao.proxy.DaoImpProxyFactory;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.entity.SystemModule;
import com.ckwl.likemoney.system.service.ISystemModuleService;
import com.ckwl.likemoney.system.service.imp.SystemModuleServiceImpl;
import com.ckwl.likemoney.system.view.SystemModuleConditionView;

/**
 * Servlet implementation class SystemModule
 */
@WebServlet("/admin/system/SystemModuleServlet.do")
public class SystemModuleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemModuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  //创建被代理对象new DictionariesServiceImpl();
  	private ISystemModuleService iSystemModuleService = (ISystemModuleService) DaoImpProxyFactory.getProxyInstance(SystemModuleServiceImpl.class);
    
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
	    String moduleName = request.getParameter("moduleName");
	    if(!StringUtil.isEmpty(moduleName)){
	    	moduleName = moduleName.trim();
	    }
	    SystemModuleConditionView systemModuleConditionView = new SystemModuleConditionView();
	    systemModuleConditionView.setModuleName(moduleName);
		ArrayList<SystemModule> arrayList =  iSystemModuleService.list(systemModuleConditionView);
	    request.setAttribute("list", arrayList);
	    request.setAttribute("moduleName", moduleName);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/systemModule/systemModule_list.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String moduleId = request.getParameter("moduleId");
		if(StringUtil.isEmpty(moduleId)){//新增编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
		}else{//编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
			SystemModule module = iSystemModuleService.load(moduleId);
			request.setAttribute("module", module);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/systemModule/systemModule_editor.jsp").forward(request, response);
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String moduleId = request.getParameter("moduleId");
		String moduleName = request.getParameter("moduleName");
		SystemModule systemModule = new SystemModule();
		if(StringUtil.isEmpty(moduleId)){//新增保存
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			systemModule.setModuleId(id);
			systemModule.setModuleName(moduleName);
			iSystemModuleService.insert(systemModule);
		}else{//修改保存
			systemModule.setModuleId(moduleId);
			systemModule.setModuleName(moduleName);
			iSystemModuleService.update(systemModule);
		}
		response.sendRedirect("SystemModuleServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String moduleId = request.getParameter("moduleId");
		iSystemModuleService.delete(moduleId);
		response.sendRedirect("SystemModuleServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
}
