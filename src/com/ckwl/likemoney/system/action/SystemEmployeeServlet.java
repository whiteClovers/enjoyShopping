package com.ckwl.likemoney.system.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.constant.DictConstant;
import com.ckwl.likemoney.bas.service.IDictionariesDetailService;
import com.ckwl.likemoney.bas.service.imp.DictionariesDetailServiceImpl;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.entity.SystemEmployee;
import com.ckwl.likemoney.system.service.ISystemEmployeeService;
import com.ckwl.likemoney.system.service.imp.SystemEmployeeServiceImp;
import com.ckwl.likemoney.system.view.SystemEmployeeConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeQueryView;

/**
 * Servlet implementation class EmployeeAdmin
 */
@WebServlet("/admin/system/SystemEmployeeServlet.do")
public class SystemEmployeeServlet extends BaseServlet {
	private ISystemEmployeeService systemEmployeeService = (ISystemEmployeeService) super.getDaoImpProxyFacroty(
			SystemEmployeeServiceImp.class);
	private IDictionariesDetailService iDictionariesDetailService=(IDictionariesDetailService) super.getDaoImpProxyFacroty(DictionariesDetailServiceImpl.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SystemEmployeeServlet() {
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
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/employee_meun.jsp").forward(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName = request.getParameter("employeeName");
		String employeeStatus = request.getParameter("employeeStatus");
		String employeeInformation = request.getParameter("employeeInformation");
		
		SystemEmployeeConditionView systemEmployeeConditionView=new SystemEmployeeConditionView();
		systemEmployeeConditionView.setEmployeeName(employeeName);
		systemEmployeeConditionView.setEmployeeStatus(employeeStatus);
		systemEmployeeConditionView.setEmployeeInformation(employeeInformation);
		
		ArrayList<SystemEmployeeQueryView> listSystemEmployee = systemEmployeeService.list(systemEmployeeConditionView);

		request.setAttribute("listSystemEmployee", listSystemEmployee);

		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/sys_employee/employee_list.jsp").forward(request,
				response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		System.out.println("删除ID:" + employeeId);

		systemEmployeeService.delete(employeeId);

		response.sendRedirect("SystemEmployeeServlet.do?method=list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		SystemEmployee systemEmployee = new SystemEmployee();

		ArrayList<DictionariesDetailQueryView> listDictionariesDetail = (ArrayList<DictionariesDetailQueryView>) iDictionariesDetailService.findByDictCode(DictConstant.EMPLOYEE_STATUS);
		request.setAttribute("listDictionariesDetail", listDictionariesDetail);
		
		if (StringUtil.isEmpty(employeeId)) {
			String displaystatus = "none";
			request.setAttribute("displaystatus", displaystatus);

		} else {

			String displaystatus = "block";
			request.setAttribute("displaystatus", displaystatus);
			systemEmployee = systemEmployeeService.load(employeeId);

			request.setAttribute("systemEmployee", systemEmployee);

		}
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/sys_employee/employee_edit.jsp").forward(request,
				response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String employeeId = request.getParameter("employeeId");
		String employeeName = request.getParameter("employeeName");
		String employeePwd = request.getParameter("employeePwd");
		String employeePhone = request.getParameter("employeePhone");
		String employeeSex = request.getParameter("employeeSex");
		String employeeStatus = request.getParameter("employeeStatus");
		String employeeBirthday = request.getParameter("employeeBirthday");
		String employeeInformation = request.getParameter("employeeInformation");

		// 根据s为空tudentId是否判断是新增还是修改的编辑

		if (StringUtil.isEmpty(employeeId)) {// 新增
			SystemEmployee systemEmployee = new SystemEmployee();
			systemEmployee.setEmployeeId(employeeId);
			systemEmployee.setEmployeeName(employeeName);
			systemEmployee.setEmployeePwd(employeePwd);
			systemEmployee.setEmployeePhone(employeePhone);
			systemEmployee.setEmployeeSex(employeeSex);
			systemEmployee.setEmployeeStatus(employeeStatus);
			systemEmployee.setEmployeeBirthday(StringUtil.stringToDate(employeeBirthday));
			systemEmployee.setEmployeeInformation(employeeInformation);

			systemEmployeeService.insert(systemEmployee);
			
			System.out.println("新增保存:" + systemEmployee.toString());

		} else {// 修改
				// S2.业务处理：调数据库,略
			SystemEmployee systemEmployee = new SystemEmployee();
			systemEmployee.setEmployeeId(employeeId);
			systemEmployee.setEmployeeName(employeeName);
			systemEmployee.setEmployeePwd(employeePwd);
			systemEmployee.setEmployeePhone(employeePhone);
			systemEmployee.setEmployeeSex(employeeSex);
			systemEmployee.setEmployeeStatus(employeeStatus);
			systemEmployee.setEmployeeBirthday(StringUtil.stringToDate(employeeBirthday));
			systemEmployee.setEmployeeInformation(employeeInformation);
			systemEmployeeService.update(systemEmployee);
			System.out.println("修改的保存:" + systemEmployee.toString());

		}

		response.sendRedirect("SystemEmployeeServlet.do?method=list");

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
