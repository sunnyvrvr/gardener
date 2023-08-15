package com.gardener.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json; charset=utf-8");
		HttpSession session = request.getSession();
		System.out.println(session + " -- session");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
//		int id = Integer.parseInt(request.getParameter("num"));
		Post post = new Post();
		System.out.println(post + " -- 넘겨주는 post");
		String postJson = gson.toJson(post);
		out.print(postJson);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");

		HttpSession session = request.getSession();
		System.out.println(session + " -- session");
		Post post = null;

		String mainTitle = request.getParameter("mainTitle");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String mainTitleImg = request.getParameter("mainTitleImg");

		
////		post = new Post(0, 1, title, subTitle, content, mainImg, cate, secret, 0, null);

//		service.savePost(post);
//		service.saveImg(imgArr);
		response.getWriter().print(post.getPostNum());

	}
}