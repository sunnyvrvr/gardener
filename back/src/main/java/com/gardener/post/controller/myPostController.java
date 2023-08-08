package com.gardener.post.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.exception.FindException;
import com.gardener.post.dto.Post;
import com.gardener.post.service.myPostService;
import com.google.gson.Gson;


@WebServlet("/mypost")
public class myPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private myPostService service;
	
	public myPostController() {
		service = myPostService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json, charset=UTF-8");
		//��泥� �곗�댄�� �산린
		String loginid = request.getParameter("loginid"); 
		System.out.println("loginid:" + loginid);
		//�몄���산린
		HttpSession session = request.getSession();
		String memberJson = null;
		
		List<Post> listPost = new ArrayList<Post>();
		try {
			listPost = service.selectByLoginid(loginid);
			session.setAttribute("listPost", listPost); //setAttribute瑜� ������
			Gson gson = new Gson();
			memberJson = gson.toJson(listPost);
		} catch (FindException e) {
			e.printStackTrace();
		}
        		
		PrintWriter out = response.getWriter(); 
		System.out.println(memberJson + " -- ");
        out.print(memberJson);
        out.flush();
	}
}


