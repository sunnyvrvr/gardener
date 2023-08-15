package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.member.service.MemberService;

@WebServlet("/iddukchk")
public class IdDupChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;

	public IdDupChkController() {
		service = MemberService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		String loginId = request.getParameter("idcheck");
		System.out.println(loginId);
		String memberJson = null;
			try {
				service.idDupChk(loginId);
				memberJson = "{\"status\": \"available\"}";		//
				System.out.println("중복아이디가 아님");
			} catch (com.gardener.exception.FindException e) {
				memberJson = "{\"status\": \"duplicate\"}";
				e.printStackTrace();
			}
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson);

	}
}
