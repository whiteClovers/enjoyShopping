package com.ckwl.likemoney.frame.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.system.view.SystemMenuQueryView;

/**
 * Servlet implementation class AuthorityShowServlet
 */
@WebServlet("/AuthorityShowServlet.do")
public class AuthorityShowServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorityShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<SystemMenuQueryView> listMenuQuery = (ArrayList<SystemMenuQueryView>) session.getAttribute("session_listMenuQuery");
		
		request.setAttribute("listMenuQuery", listMenuQuery);
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/authorityShow.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
