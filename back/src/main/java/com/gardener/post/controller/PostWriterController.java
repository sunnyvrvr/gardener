package com.gardener.post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.post.dto.Post;
import com.gardener.post.service.PostService;


@WebServlet("/post")
public class PostWriterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;
	
	public PostWriterController() {
		service = PostService.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Post p = service.selectById(id);
		
		String path="http://localhost:8888/gardner/back";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("id", id);
		rd.forward(request, response);	
	}
}
