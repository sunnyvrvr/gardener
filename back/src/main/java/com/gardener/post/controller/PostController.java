package com.gardener.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.post.dto.Imgs;
import com.gardener.post.dto.Post;
import com.gardener.post.service.PostService;
import com.google.gson.Gson;

@WebServlet("/post")
public class PostController extends HttpServlet {
	private final PostService service;

	public PostController() {
		service = PostService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		int id = Integer.parseInt(request.getParameter("num"));

		Post post = service.findPost(id);
		String postJson = gson.toJson(post);
		System.out.println(postJson + " -- > ");
		out.print(postJson);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("utf-8");
		Post post = null;
		List<String> imgList = new ArrayList<>();

		String title = request.getParameter("title");
		String subTitle = request.getParameter("subtitle");
		String content = request.getParameter("content");
		String mainImg = request.getParameter("mainImg");
		String cate = request.getParameter("cate");
		Integer secret = Integer.parseInt(request.getParameter("secret"));
		String[] imgArr = request.getParameterValues("imgs[]");
		Optional<String[]> imgOp = Optional.ofNullable(imgArr);

		if (imgOp.isEmpty()) {
			System.out.println("비어있어요");
			post = new Post(0, 1, title, subTitle, content, mainImg, cate, secret, 0, null);
			service.savePost(post);
			return;
		}

		for (int i = 1; i < imgArr.length; i++) {
			imgList.add(imgArr[i]);
		}

		Imgs imgs = new Imgs(imgList);
		System.out.println(imgs.getImg() + " --");
		// post = new Post(0, 1, title, subTitle, content, mainImg, cate, secret, 0,
		// null);
	}
}
