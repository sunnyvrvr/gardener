package com.gardener.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<Product> list = new ArrayList<>();
		Product p = new Product("C0001","아메리카노",1000);
		list.add(p);
		list.add(new Product("C0002","카페라떼",2000));
		list.add(new Product("C0003","아이스초코",3000));
		list.add(new Product("C0004","망고스무디",5000));
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		System.out.println(jsonStr);
		out.print(jsonStr);
	}

	

}
