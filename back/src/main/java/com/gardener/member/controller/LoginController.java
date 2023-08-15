package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;
import com.gardener.member.service.MemberService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;

	public LoginController() {
		service = MemberService.getInstance();
	}       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		//요청전달데이터 얻기
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("pwd");
		//세션얻기
		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginId);
		session.setAttribute("pwd", pwd);

		String memberJson = null;
		try {
			Member m = service.login(loginId, pwd);
			session = request.getSession();
			session.setAttribute("loginedId", loginId);
			System.out.println("loginedId:" + loginId);
			memberJson = "1";
		} catch (FindException e) {
			e.printStackTrace();
			memberJson = "0";
		}
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson);
	}
}
