package com.gardener.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.member.service.MemberService;

@WebServlet("/findid")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;      
   
    public FindIdController() {
      MemberService.getInstance();        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
