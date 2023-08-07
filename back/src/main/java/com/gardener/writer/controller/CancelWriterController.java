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

@WebServlet("/cancel")
public class CancelWriterController extends HttpServlet {
	private WriterService service;

	public CancelWriterController() {
		service = WriterService.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		// 요청 파라미터에서 작가 ID 추출
		HttpSession session = request.getSession();
		int writerId = Integer.parseInt(request.getParameter("id"));

		// CancelWriterService를 사용하여 작가 정보 삭제
		boolean result = service.cancelWriter(writerId);

		// 작가 정보 삭제 결과를 클라이언트에 반환
		out.print(gson.toJson(result));
	}

}
