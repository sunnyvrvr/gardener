package com.gardener.member.controller;

import java.io.IOException;
<<<<<<< HEAD
=======

>>>>>>> ca6ce0378bd2e378480644d4496b70b73bf43b04
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
=======

import com.my.gardener.member.service.MemberService;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService servic;

	public MemberService() {
    	service = MemberService.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		String profile = request.getParameter("profile");
		// 요청전달데이터 얻기

=======
/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
>>>>>>> ca6ce0378bd2e378480644d4496b70b73bf43b04
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
<<<<<<< HEAD
=======

>>>>>>> ca6ce0378bd2e378480644d4496b70b73bf43b04
	}

}
