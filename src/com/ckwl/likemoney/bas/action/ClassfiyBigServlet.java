package com.ckwl.likemoney.bas.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.service.IClassfiyBigService;
import com.ckwl.likemoney.bas.service.imp.ClassfiyBigServiceImp;
import com.ckwl.likemoney.bas.view.ClassfiyBigConditionView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;

/**
 * Servlet implementation class ClassfiyBigServlet
 */
@WebServlet("/admin/bas/ClassfiyBigServlet.do")
public class ClassfiyBigServlet extends BaseServlet {
	private IClassfiyBigService classfiyBigService = (IClassfiyBigService) super.getDaoImpProxyFacroty(
			ClassfiyBigServiceImp.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassfiyBigServlet() {
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

	public void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/").forward(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classfiyBigName = request.getParameter("classfiyBigName");

		ClassfiyBigConditionView classfiyBigConditionView = new ClassfiyBigConditionView();
		classfiyBigConditionView.setClassfiyBigName(classfiyBigName);

		ArrayList<ClassfiyBig> listClassfiyBig = classfiyBigService.list(classfiyBigConditionView);

		request.setAttribute("listClassfiyBig", listClassfiyBig);

		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bas/classfiy_big_list.jsp").forward(request,
				response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classfiyBigId = request.getParameter("classfiyBigId");
		System.out.println("删除ID:" + classfiyBigId);

		classfiyBigService.delete(classfiyBigId);

		response.sendRedirect("ClassfiyBigServlet.do?method=list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classfiyBigId = request.getParameter("classfiyBigId");

		ClassfiyBig classfiyBige = new ClassfiyBig();

		if (StringUtil.isEmpty(classfiyBigId)) {
			String displaystatus = "none";
			request.setAttribute("displaystatus", displaystatus);

		} else {

			String displaystatus = "block";
			request.setAttribute("displaystatus", displaystatus);
			classfiyBige = classfiyBigService.load(classfiyBigId);
			request.setAttribute("classfiyBige", classfiyBige);

		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/bas/classfiy_big_edit.jsp").forward(request,
				response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String classfiyBigId = request.getParameter("classfiyBigId");
		String classfiyBigName = request.getParameter("classfiyBigName");

		// 根据s为空tudentId是否判断是新增还是修改的编辑

		if (StringUtil.isEmpty(classfiyBigId)) {// 新增
			ClassfiyBig classfiyBig = new ClassfiyBig();
			classfiyBig.setClassfiyBigId(classfiyBigId);
			classfiyBig.setClassfiyBigName(classfiyBigName);

			classfiyBigService.insert(classfiyBig);

			System.out.println("新增保存:" + classfiyBig.toString());

		} else {// 修改
				// S2.业务处理：调数据库,略
			ClassfiyBig classfiyBig = new ClassfiyBig();
			classfiyBig.setClassfiyBigId(classfiyBigId);
			classfiyBig.setClassfiyBigName(classfiyBigName);

			classfiyBigService.update(classfiyBig);
			System.out.println("修改的保存:" + classfiyBig.toString());

		}

		response.sendRedirect("ClassfiyBigServlet.do?method=list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

}
