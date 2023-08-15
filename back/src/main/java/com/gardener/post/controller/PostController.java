package com.gardener.post.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.exception.AddException;
import com.gardener.post.dto.Post;
import com.gardener.post.service.PostService;
import com.google.gson.Gson;

@WebServlet("/post")
public class PostController extends HttpServlet {
	public PostService service;

	public PostController() {
		service = PostService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");

		HttpSession session = request.getSession();
		System.out.println(session + " -- session");
		Post post = new Post();
		String memberJson = null;
		String loginId = (String) session.getAttribute("loginId");  //세션에 저장된 로그인아이디
		System.out.println("loginId:" + loginId);
		
		try {
//			int postNum = Integer.parseInt(request.getParameter("postNum"));
			String mainTitle = request.getParameter("mainTitle");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			String mainTitleImg = request.getParameter("mainTitleImg");
			
	        post.setMainTitle(mainTitle);
	        post.setWriter(writer);
	        post.setContent(content);
	        post.setMainTitleImg(mainTitleImg);
	        post.setLoginId(loginId);
			
			service.savePost(post);
			System.out.println("글쓰기 성공");
			memberJson = "1";
		} catch (Exception e) {
			e.printStackTrace();
			memberJson = "0";
			System.out.println("글쓰기 실패");
		}
		PrintWriter out = response.getWriter();
		System.out.println(memberJson);
		out.print(memberJson);
	}
}