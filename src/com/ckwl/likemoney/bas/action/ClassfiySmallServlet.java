package com.ckwl.likemoney.bas.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.entity.ClassfiySmall;
import com.ckwl.likemoney.bas.service.IClassfiyBigService;
import com.ckwl.likemoney.bas.service.IClassfiySmallService;
import com.ckwl.likemoney.bas.service.imp.ClassfiyBigServiceImp;
import com.ckwl.likemoney.bas.service.imp.ClassfiySmallServiceImp;
import com.ckwl.likemoney.bas.view.ClassfiyBigConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;


/**
 * Servlet implementation class ClassfiySmallServlet
 */
@WebServlet("/admin/bas/ClassfiySmallServlet.do")
public class ClassfiySmallServlet extends BaseServlet {
	private IClassfiySmallService classfiySmallService=(IClassfiySmallService) super.getDaoImpProxyFacroty(ClassfiySmallServiceImp.class);
	private IClassfiyBigService classfiyBigService = (IClassfiyBigService) super.getDaoImpProxyFacroty(
			ClassfiyBigServiceImp.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassfiySmallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String classfiyBigName = request.getParameter("classfiyBigName");
		String classfiySmallName = request.getParameter("classfiySmallName");
		System.out.println("classbigname"+classfiyBigName);
		if(!StringUtil.isEmpty(classfiyBigName)){
			classfiyBigName = classfiyBigName.trim() ;
		}
		
		if(!StringUtil.isEmpty(classfiySmallName)){
			classfiySmallName = classfiySmallName.trim() ;
		}
		
		ClassfiySmallConditionView classfiySmallConditionView=new ClassfiySmallConditionView();
		classfiySmallConditionView.setClassfiyBigName(classfiyBigName);
		classfiySmallConditionView.setClassfiySmallName(classfiySmallName);
		
		
		
		ArrayList<ClassfiySmallQueryView> listClassfiySmall=classfiySmallService.list(classfiySmallConditionView);
		
		request.setAttribute("listClassfiySmall", listClassfiySmall);

		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bas/classfiy_small_list.jsp").forward(request,
				response);
		
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classfiySmallId = request.getParameter("classfiySmallId");
		System.out.println("删除ID:" + classfiySmallId);

		classfiySmallService.delete(classfiySmallId);

		response.sendRedirect("ClassfiySmallServlet.do?method=list");
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classfiySmallId = request.getParameter("classfiySmallId");
		
		ClassfiySmall classfiySmall = new ClassfiySmall();
		
		ArrayList<ClassfiyBig> listClassfiyBig= classfiyBigService.list(new ClassfiyBigConditionView());
		
		request.setAttribute("listClassfiyBig", listClassfiyBig);

		if (StringUtil.isEmpty(classfiySmallId)) {
			String displaystatus = "none";
			request.setAttribute("displaystatus", displaystatus);

		} else {

			String displaystatus = "block";
			request.setAttribute("displaystatus", displaystatus);
			
			classfiySmall = classfiySmallService.load(classfiySmallId);

			request.setAttribute("classfiySmall", classfiySmall);

		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bas/classfiy_small_edit.jsp").forward(request,
				response);
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String classfiySmallId = request.getParameter("classfiySmallId");
		String classfiyBigId = request.getParameter("classfiyBigId");
		String classfiySmallName = request.getParameter("classfiySmallName");


		// 根据s为空tudentId是否判断是新增还是修改的编辑

		if (StringUtil.isEmpty(classfiySmallId)) {// 新增
			
			ClassfiySmall classfiySmall = new ClassfiySmall();
			
			classfiySmall.setClassfiySmallId(classfiySmallId);
			classfiySmall.setClassfiyBigId(classfiyBigId);
			classfiySmall.setClassfiySmallName(classfiySmallName);


			classfiySmallService.insert(classfiySmall);
			
			System.out.println("新增保存:" + classfiySmall.toString());

		} else {// 修改
				// S2.业务处理：调数据库,略
			ClassfiySmall classfiySmall = new ClassfiySmall();
			
			classfiySmall.setClassfiySmallId(classfiySmallId);
			classfiySmall.setClassfiyBigId(classfiyBigId);
			classfiySmall.setClassfiySmallName(classfiySmallName);

			classfiySmallService.update(classfiySmall);
			System.out.println("修改的保存:" + classfiySmall.toString());

		}

		response.sendRedirect("ClassfiySmallServlet.do?method=list");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	super.doPost(request, response);
	}

}
