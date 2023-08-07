package com.gardener.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.member.service.MemberService;


@WebServlet("/signup")
public class SingUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService sevice;
       

    public SingUpController() {
        MemberService.getInstance();        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//요청전달데이터 얻기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String memberJson = null;
		
//		service.signup();
		
		
		
	}
	
}
