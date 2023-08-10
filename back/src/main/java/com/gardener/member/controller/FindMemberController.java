package com.gardener.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.member.dto.Member;
import com.gardener.member.service.MemberMypageService;
import com.google.gson.Gson;
import com.gradener.exception.FindException;


@WebServlet("/findmember")
public class FindMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberMypageService service;

	public FindMemberController() {
		service = MemberMypageService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//세션에서 아이디 얻기
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
         System.out.println("로그인된ID: "+loginId);
         
        // 요청전달 데이터 얻기
          //String loginId =request.getParameter("id");
		 try {
	            Member m = service.findByMember(loginId);

	            if (m != null) {
	                response.setContentType("application/json; charset=utf-8");
	                response.getWriter().write(m.toJsonString());
	            } else {
	                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	                response.getWriter().write("Member not found");
	            }
	        } catch (FindException e) {
	            handleException(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
	                            "Error occurred while finding member");
	        }
	    }

	    private void handleException(HttpServletResponse response, int status, String message) throws IOException {
	        response.setStatus(status);
	        response.getWriter().write(message);
	    }
	}