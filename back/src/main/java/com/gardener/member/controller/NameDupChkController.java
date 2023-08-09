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


@WebServlet("/namechk")
public class NameDupChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service; 
    public NameDupChkController() {
       service = MemberService.getInstance();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("namecheck");
		System.out.println(name);
		String memberJson = null;
		try {
			service.nameDupChk(name);
			memberJson = "1";		//사용 가능한 필명
			System.out.println("사용 가능한 필명입니다");
		} catch (FindException e) {			
			memberJson = "0";		//중복 필명
			e.printStackTrace();
		}		
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson);		
	}
}
