package com.gardener.writer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.writer.service.WriterService;
import com.google.gson.Gson;

@WebServlet("/apply")
public class ApplyWriterController extends HttpServlet {
	private WriterService service;

	public ApplyWriterController() {
		service = WriterService.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		HttpSession session = request.getSession();
		Integer memberId = (Integer) session.getAttribute("id");

		// WriterService를 사용하여 작가 정보 삽입
		boolean result = service.insertWriter(5);

		// 작가 정보 삽입 결과를 클라이언트에 반환
		out.print(gson.toJson(result));
		System.out.println("제출성공");

	}

}
