package com.gardener.category.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gardener.category.service.CategoryService;
import com.gardener.exception.FindException;
import com.gardener.search.dto.Search;
import com.gardener.search.service.SearchService;
import com.google.gson.Gson;


@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryService service;
	
	public CategoryController() {
		service = new CategoryService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//검색할 카테고리 값 
		String categoryValue = request.getParameter("category");
		
		//검색된 카테고리를 받을 리스트
		List<Search> categoryList = new ArrayList<>();
		
		//Json으로 변환할 Gson객체 생성
		Gson gson = new Gson();
		
		//gson으로 변환된 객체는 직렬화되어서 String으로 값을 받아야 한다.
		String categoryJson = null;
		
		System.out.println("클릭한 카테고리= "+categoryValue);
		
		if(categoryValue != "") {
			try {
				categoryList = service.selectCategory(categoryValue);
				System.out.println("categoryList.size() = "+categoryList.size());
				categoryJson = gson.toJson(categoryList);
				System.out.println(categoryJson);
			} catch (FindException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("categoryValue에 값이 없습니다.");
		}
		
		//json형태로 응답
		out.print(categoryJson);
		
		
		
		
		
		
	}

}
