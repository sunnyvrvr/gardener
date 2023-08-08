package com.gardener.post.controller;

import java.io.IOException;
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


@WebServlet("/writerpost")
public class PostWriterPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private myPostService service;
	
	public PostWriterPostController() {
		service = myPostService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json; charset=UTF-8");

		int writerid = Integer.parseInt(request.getParameter("writerid"));
		System.out.println("writerid:"+writerid);
		
		//세션얻기
		HttpSession session = request.getSession();
		String memberJson = null;
		
		List<String> listPost = new ArrayList<>();
		try {
			listPost = service.selectByWriterPost(writerid);
			session.setAttribute("writerid", writerid); 
			Gson gson = new Gson();
			memberJson = gson.toJson(listPost);
			PrintWriter out = response.getWriter(); 
			out.print(listPost);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		
	}
}
