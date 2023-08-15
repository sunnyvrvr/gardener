package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.exception.AddException;
import com.gardener.member.dto.Member;
import com.gardener.member.service.MemberService;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;

	public MemberController() {
		service = MemberService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		System.out.println("회원가입확인");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(getServletName());
			session.invalidate();
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		
		String memberJson = null;
		try {
			Member m = new Member(loginId, pwd, email, name, intro);
			service.signup(m);
			System.out.println("회원가입성공");
			memberJson = "1";
		} catch (AddException e) {
			e.printStackTrace();
			memberJson = "2";
			System.out.println("회원가입실패");
		}
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson);
	}
}
