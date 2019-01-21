package com.ckwl.likemoney.bas.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.entity.Dictionaries;
import com.ckwl.likemoney.bas.service.IDictionariesService;
import com.ckwl.likemoney.bas.service.imp.DictionariesServiceImpl;
import com.ckwl.likemoney.bas.view.DictionariesConditionView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.dao.proxy.DaoImpProxyFactory;
import com.ckwl.likemoney.frame.util.StringUtil;

/**
 * Servlet implementation class DictionariesServlet
 */
@WebServlet("/admin/bas/DictionariesServlet.do")
public class DictionariesServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DictionariesServlet() {
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
	
	//创建被代理对象new DictionariesServiceImpl();
	private IDictionariesService iDictionariesService = (IDictionariesService) DaoImpProxyFactory.getProxyInstance(DictionariesServiceImpl.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    String code = request.getParameter("code");
	    String label = request.getParameter("label");
	    if(!StringUtil.isEmpty(code)){
	    	code = code.trim();
	    }
	    if(!StringUtil.isEmpty(label)){
	    	label = label.trim();
	    }
	    DictionariesConditionView conditionView = new DictionariesConditionView();
	    conditionView.setDictCode(code);
	    conditionView.setDictLabel(label);
		ArrayList<Dictionaries> arrayList =  iDictionariesService.list(conditionView);
	    request.setAttribute("list", arrayList);
	    request.setAttribute("code", code);
	    request.setAttribute("label", label);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/dictionaries/dictionaries_list.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		if(StringUtil.isEmpty(id)){//新增编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
		}else{//编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
			Dictionaries dictionaries = iDictionariesService.load(id);
			request.setAttribute("dictionaries", dictionaries);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/dictionaries/dictionaries_editor.jsp").forward(request, response);
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		String label = request.getParameter("label");
		Dictionaries dictionaries = new Dictionaries();
		if(StringUtil.isEmpty(id)){//新增保存
			id = UUID.randomUUID().toString().replaceAll("-", "");
			dictionaries.setId(id);
			dictionaries.setDictCode(code);
			dictionaries.setDictLabel(label);
			iDictionariesService.insert(dictionaries);
		}else{//修改保存
			dictionaries.setId(id);
			dictionaries.setDictCode(code);
			dictionaries.setDictLabel(label);
			iDictionariesService.update(dictionaries);
		}
		response.sendRedirect(request.getServletContext().getContextPath()+"/admin/DictionariesServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		iDictionariesService.delete(id);
		response.sendRedirect(request.getServletContext().getContextPath()+"/admin/DictionariesServlet.do");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
}
