package com.gardener.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.exception.FindException;
import com.gardener.search.dto.Search;
import com.gardener.search.service.SearchService;
import com.google.gson.Gson;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SearchService service;

	public SearchController() {
		service = new SearchService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json; charset=utf-8");

		PrintWriter out = response.getWriter();

		// select값 가져오기 (title, name, content) 3개중 1개 저장
		String select = request.getParameter("select");

		// input[type=text]값 가져오기
		String keyword = request.getParameter("text");

		// SQL구문 실행결과를 받아올 변수
		List<Search> resultList = new ArrayList<Search>();

		// json형태로 넘겨줄 Gson객체 생성
		Gson gson = new Gson();

		String result = null;

		System.out.println("html에서 dropdown = " + select);
		System.out.println("html에서 입력한 Text = " + keyword);

		if (select.equals("title")) {
			try {
				resultList = service.selectTitle(keyword);
				System.out.println("resultList.size() = " + resultList.size());
				result = gson.toJson(resultList);
				System.out.println(result);
			} catch (FindException e) {
				e.printStackTrace();
			}
		} else if (select.equals("name")) {
			try {
				resultList = service.selectName(keyword);
				System.out.println("resultList.size() = " + resultList.size());
				result = gson.toJson(resultList);
				System.out.println(result);
			} catch (FindException e) {
				e.printStackTrace();
			}

		} else if (select.equals("content")) {
			try {
				resultList = service.selectContent(keyword);
				System.out.println("resultList.size() = " + resultList.size());
				result = gson.toJson(resultList);
				System.out.println(result);
			} catch (FindException e) {
				e.printStackTrace();
			}
		}

		// json형태로 응답
		out.print(result);

	}// doget end

}// class end
