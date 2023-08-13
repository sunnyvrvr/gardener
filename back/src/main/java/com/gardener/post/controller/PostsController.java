package com.gardener.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.post.dto.Post;
import com.gardener.post.service.PostService;
import com.google.gson.Gson;

@WebServlet("/posts")
public class PostsController extends HttpServlet {

	private PostService service;

	public PostsController() {
		service = PostService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		List<Post> allPosts = service.findAllPosts();
		response.getWriter().print(gson.toJson(allPosts));
	}
}
