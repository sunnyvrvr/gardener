package com.gardener.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.member.dto.Member;
import com.gardener.member.service.MemberService;

@WebServlet("/iddupchk")
public class IdDubChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service;      
    public IdDubChkController() {
        service = MemberService.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String id = request.getParameter("id");
		
		//service.idDupChk(id);
		
		
		
	}


	
	

}
