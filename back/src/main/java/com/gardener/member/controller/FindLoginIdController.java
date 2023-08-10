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

@WebServlet("/findloginid")
public class FindLoginIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;    
    public FindLoginIdController() {
      service = MemberService.getInstance();        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String memberJson = null;
		try {
			String loginId = service.findLoginId(name, email);
			memberJson = loginId;
			System.out.println("아이디 찾기 성공");
		} catch (FindException e) {
			e.printStackTrace();
			memberJson = "0";
			System.out.println("아이디 찾기 실패");
		}
	
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson); 
	}

}
