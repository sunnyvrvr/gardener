package com.gardener.comments.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.comments.dto.Comments;
import com.gardener.comments.service.CommentsService;
import com.gardener.util.PageBean;
import com.google.gson.Gson;

@WebServlet("/comments")
public class CommentsController extends HttpServlet {
	private CommentsService service;

	public CommentsController() {
		service = CommentsService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();

		int num = Integer.parseInt(request.getParameter("num"));
		Optional<String> cNum = Optional.ofNullable(request.getParameter("cNum"));
		int cp = 0;
		if (cNum.isPresent()) {
			cp = Integer.parseInt(cNum.orElse("-1"));
		}
		int currentPage = 1;
		// List<Comments> comments = service.findAllComments(num);
		// response.getWriter().print(gson.toJson(comments));
		PageBean<Comments> comments = service.findAll(cp, num);
		response.getWriter().print(gson.toJson(comments));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		Comments comments = null;
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num"));
		comments = new Comments(0, num, 2, content, null, 0);

		service.saveReply(comments);

		response.getWriter().print("댓글 완료");
	}

}
