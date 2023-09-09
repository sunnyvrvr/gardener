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
		
		//寃����� 移댄��怨�由� 媛� 
		String categoryValue = request.getParameter("category");
		
		//寃����� 移댄��怨�由щ�� 諛��� 由ъ�ㅽ��
		List<Search> categoryList = new ArrayList<>();
		
		//Json�쇰� 蹂����� Gson媛�泥� ����
		Gson gson = new Gson();
		
		//gson�쇰� 蹂����� 媛�泥대�� 吏��ы�����댁�� String�쇰� 媛��� 諛����� ����.
		String categoryJson = null;
		
		System.out.println("�대┃�� 移댄��怨�由�= "+categoryValue);
		
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
			System.out.println("categoryValue�� 媛��� ���듬����.");
		}
		
		//json����濡� ����
		out.print(categoryJson);
		
		
		
		
		
		
	}

}
