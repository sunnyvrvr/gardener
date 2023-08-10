package com.gardener.writer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;
import com.gardener.post.dto.Post;
import com.gardener.writer.service.WriterService;
import com.google.gson.Gson;


@WebServlet("/subscribewriter")
public class SubscribeWriterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WriterService service;	

	public SubscribeWriterController() {
		service = WriterService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json; charset=UTF-8");

		String loginId = request.getParameter("loginId");
		System.out.println("loginId:"+ loginId);

		HttpSession session = request.getSession();
		String memberJson = null;

		List<Member>SubscribeWriter = new ArrayList<Member>();		
		try {
			SubscribeWriter = service.subscribeWriter(loginId);
			session.setAttribute("loginId", loginId);
			Gson gson = new Gson();
			memberJson = gson.toJson(SubscribeWriter);
			PrintWriter out;
			out = response.getWriter();
		} catch (FindException e) {
			e.printStackTrace();
		}			
		PrintWriter out = response.getWriter(); 
		out.print(memberJson);	
	}
}
