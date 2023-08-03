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
import com.google.gson.Gson;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
    public LoginController() {
       service = MemberService.getInstance();       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		//요청전달데이터 얻기
		String id = request.getParameter("id");
		System.out.println(id);
		String pwd = request.getParameter("pwd");
		
		//세션얻기
		HttpSession session = request.getSession();
		session.removeAttribute("loginedId");
		int status = 0;
		String memberJson = null;
		try {
			Member m = service.login(id, pwd);
			status = 1;
			session.setAttribute("loginedId", id);
			Gson gson = new Gson();
			memberJson = gson.toJson(m);
		} catch (FindException e) {			
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();		
		out.print(memberJson);
	}

}
