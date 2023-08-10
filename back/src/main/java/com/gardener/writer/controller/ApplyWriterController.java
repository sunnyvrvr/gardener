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
	    int memberId = (int) session.getAttribute("Id");

				

        if (memberId != 0) {
            boolean writerInserted = service.insertWriterByMemberId(memberId);
            if (writerInserted) {
              out.print(gson.toJson(true));
              System.out.println("작가 정보 등록 성공");
            } else {
              out.print(gson.toJson(false));
              System.out.println("작가 정보 등록 실패");
            }
          } else {
            out.print(gson.toJson(false));
            System.out.println("세션 불일치");
          }
        }
      }