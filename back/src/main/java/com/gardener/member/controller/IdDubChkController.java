package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.FindException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		String loginId=request.getParameter("idcheck");
		System.out.println(loginId);
		String memberJson = null;
			try {
				service.idDupChk(loginId);
				memberJson = "1";		//��� ������ ���̵�
				System.out.println("��� ������ ���̵� �Դϴ�");
			} catch (com.gardener.exception.FindException e) {
				memberJson = "0";
				e.printStackTrace();
			}
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson);
				
		
	}
	
	

}
