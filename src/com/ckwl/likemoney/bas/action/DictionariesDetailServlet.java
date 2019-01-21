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
import com.ckwl.likemoney.bas.entity.DictionariesDetail;
import com.ckwl.likemoney.bas.service.IDictionariesDetailService;
import com.ckwl.likemoney.bas.service.IDictionariesService;
import com.ckwl.likemoney.bas.service.imp.DictionariesDetailServiceImpl;
import com.ckwl.likemoney.bas.service.imp.DictionariesServiceImpl;
import com.ckwl.likemoney.bas.view.DictionariesDetailConditionView;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.dao.proxy.DaoImpProxyFactory;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.frame.view.PageView;

/**
 * Servlet implementation class DictionariesServletDetail
 */
@WebServlet("/admin/bas/DictionariesServletDetail.do")
public class DictionariesDetailServlet extends BaseServlet {
	//代理类
	private IDictionariesDetailService iDictionariesDetailService = (IDictionariesDetailService) DaoImpProxyFactory.getProxyInstance(DictionariesDetailServiceImpl.class);
	private IDictionariesService iDictionariesService = (IDictionariesService) super.getDaoImpProxyFacroty(DictionariesServiceImpl.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DictionariesDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/dictionariesDetailIndex.jsp").forward(request, response);
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//	    ArrayList<DictionariesDetail> arrayList =  iDictionariesDetailService.list();
	    String code = request.getParameter("code");
	    String label = request.getParameter("label");
	    if(!StringUtil.isEmpty(code)){
	    	code = code.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(label)){
	    	label = label.trim();//去掉空格
		}
	    
	    String pageSizeStr = request.getParameter("pageSize");
	    int pageSize = 3 ;
	    if (!StringUtil.isEmpty(pageSizeStr)) {
	    	pageSize = Integer.valueOf(pageSizeStr);
		}
	    
	    String pageIndexStr = request.getParameter("pageIndex");
	    int pageIndex = 3 ;
	    if (!StringUtil.isEmpty(pageIndexStr)) {
			pageIndex = Integer.valueOf(pageIndexStr);
		}
	    
	    
	    DictionariesDetailConditionView dictionariesConditionView = new DictionariesDetailConditionView();
	    dictionariesConditionView.setCode(code);
		dictionariesConditionView.setLabel(label);
		//模糊查询输入框保留文字
		request.setAttribute("code", code);
		request.setAttribute("label", label);
		
//	    ArrayList<DictionariesDetailQueryView> arrayList = iDictionariesDetailService.list(dictionariesConditionView);
		PageView pageView = iDictionariesDetailService.page(dictionariesConditionView, pageIndex, pageSize);
		
		request.setAttribute("pageView", pageView);
		request.setAttribute("dictionariesConditionView", dictionariesConditionView);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/dictionariesDetail/dictionariesDetail_list.jsp").forward(request, response);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String detailId = request.getParameter("detailId");
		//生成外键信息
		ArrayList<Dictionaries> arrayList = iDictionariesService.list();
		request.setAttribute("dictList", arrayList);
		
		if(StringUtil.isEmpty(detailId)){//新增编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
		}else{//编辑
			request.setAttribute("flag", "none");//设置id文本框的显示与否
			DictionariesDetail dictionariesDetail = iDictionariesDetailService.load(detailId);
			request.setAttribute("dictionariesDetail", dictionariesDetail);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/dictionariesDetail/dictionariesDetail_editor.jsp").forward(request, response);
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String detailId = request.getParameter("detailId");
		String dictCode = request.getParameter("dictCode");
		String id = request.getParameter("id");//数据字典id,外键
		String code = request.getParameter("code");
		String label = request.getParameter("label");
		String num = request.getParameter("num");
		DictionariesDetail dictionariesDetail = new DictionariesDetail();
		if(StringUtil.isEmpty(detailId)){//新增保存
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			dictionariesDetail.setDetailId(uuid);
			dictionariesDetail.setDictonaryId(id);
			dictionariesDetail.setCode(code);
			dictionariesDetail.setLabel(label);
			dictionariesDetail.setNum(num);
			dictionariesDetail.setDictCode(dictCode);
			iDictionariesDetailService.insert(dictionariesDetail);
		}else{//修改保存
			dictionariesDetail.setDetailId(detailId);
			dictionariesDetail.setDictonaryId(id);
			dictionariesDetail.setCode(code);
			dictionariesDetail.setLabel(label);
			dictionariesDetail.setNum(num);
			dictionariesDetail.setDictCode(dictCode);
			iDictionariesDetailService.update(dictionariesDetail);
		}
		response.sendRedirect("DictionariesServletDetail.action");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String detailId = request.getParameter("detailId");
		iDictionariesDetailService.delete(detailId);
		response.sendRedirect("DictionariesServletDetail.action");//此处对扩展名进行了修改，忽略了原来的Index.jsp，以后记得加上
	}
}
