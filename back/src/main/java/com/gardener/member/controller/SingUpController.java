package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.exception.AddException;
import com.gardener.member.dto.Member;
import com.gardener.member.service.MemberService;


@WebServlet("/signup")
public class SingUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;    
    public SingUpController() {
        service = MemberService.getInstance();        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");		
		String name = request.getParameter("name");

	
		String memberJson = null;		
		try {			
			Member m = new Member(loginId,pwd,email,name);
			service.signup(m);
			memberJson = "1";		//ȸ������ ����
			System.out.println("ȸ������ ����!");
		} catch (AddException e) {			
			e.printStackTrace();
			memberJson = "0";		//ȸ������ ����
			System.out.println("ȸ������ ����");
		}
		PrintWriter out = response.getWriter();		
		System.out.println(memberJson);
		out.print(memberJson);
		
		
	}
	
}
