package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.member.service.MemberMypageService;
import com.google.gson.Gson;

@WebServlet("/deletemember")
public class DeleteController extends HttpServlet {
	private MemberMypageService service;

	public DeleteController() {
		service = MemberMypageService.getInstance();
	}

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		// 클라이언트로부터 전달된 사용자 ID를 받아옴
		 HttpSession session = request.getSession(false);
		 String loginId = request.getParameter("loginId");
		 System.out.println("넘어오셨습니까?");
	

        // 사용자 ID가 null 또는 빈 문자열인 경우 오류 응답을 보냄
        if (loginId == null || loginId.isEmpty()) {
            String errorMessage = "사용자 ID가 전달되지 않았습니다.";
            String jsonResponse = gson.toJson(errorMessage);
            out.print(jsonResponse);
            return;
        }

        // 회원 탈퇴 로직 수행
        boolean isDeleted = service.deleteMember(loginId);

        // 회원 탈퇴 결과에 따라 응답을 보냄
        if (isDeleted) {
            String successMessage = "회원탈퇴가 성공적으로 처리되었습니다.";
            System.out.println("회원탈퇴 완료");
            String jsonResponse = gson.toJson(successMessage);
            out.print(jsonResponse);
            
        } else {
            String errorMessage = "회원탈퇴를 처리하는 중에 오류가 발생했습니다.";
            String jsonResponse = gson.toJson(errorMessage);
            out.print(jsonResponse);
        }
    }
}