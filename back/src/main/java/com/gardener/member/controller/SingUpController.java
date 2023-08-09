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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("겟");
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
			memberJson = "1";		//회원가입 성공
			System.out.println("회원가입 성공!");
		} catch (AddException e) {			
			e.printStackTrace();
			memberJson = "0";		//회원가입 실패
			System.out.println("회원가입 실패");
		}
		PrintWriter out = response.getWriter();		
		System.out.println(memberJson);
		out.print(memberJson);		
	}
	
}
