package com.gardener.post.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.post.dto.Imgs;
import com.gardener.post.dto.Post;
import com.gardener.post.service.PostService;

@WebServlet("/post")
public class PostController extends HttpServlet {
	private final PostService service;

	public PostController() {
		service = PostService.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("utf-8");
		Post post = null;
		Imgs imgs = null;

		String title = request.getParameter("title");
		String subTitle = request.getParameter("subtitle");
		String content = request.getParameter("content");
		String mainImg = request.getParameter("mainImg");
		String cate = request.getParameter("cate");
		System.out.println(cate + "--> 카테");
		Integer secret = Integer.parseInt(request.getParameter("secret"));
		System.out.println(secret + "--> 비밀");
		String[] str = request.getParameterValues("imgs[]");
		Optional<String[]> str1 = Optional.ofNullable(str);

		if (str1.isEmpty()) {
			System.out.println("비어있어요");
			post = new Post(0, 1, title, subTitle, content, mainImg, cate, secret, 0, null);
			service.savePost(post);
			return;
		}
		System.out.println("흐음 ..");
	}

}
