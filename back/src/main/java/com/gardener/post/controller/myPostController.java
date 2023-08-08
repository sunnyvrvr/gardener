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

import com.gardener.post.dto.Post;
import com.gardener.post.service.myPostService;
import com.google.gson.Gson;
import com.my.exception.FindException;


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
		response.setContentType("application/json; charset=UTF-8");
		//요청 데이터 얻기
//		String login_id = request.getParameter("login_id"); 
		//세션얻기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id"); //세션에 저장된 로그인아이디
		System.out.println("id:" + id);
		String memberJson = null;
		
		List<Post> listPost = new ArrayList<Post>();
		try {
			listPost = service.selectByLoginid(id);
			session.setAttribute("listPost", listPost); //setAttribute를 수정함
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


