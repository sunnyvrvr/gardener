package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.exception.FindException;
import com.gardener.member.service.MemberService;

@WebServlet("/findpwd")
public class FindPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service;	
    public FindPwdController() {
      service = MemberService.getInstance();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String email = request.getParameter("email");
		
		String memberJson = null;
		
		try {
			String findPwd =  service.findPwd(loginId, email);
			memberJson = findPwd;
			System.out.println("비밀번호 찾기 성공");
		} catch (FindException e) {		
			e.printStackTrace();
			memberJson = "0";
			System.out.println("비밀번호 찾기 실패");
		}
		
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson);
		
	}

}
