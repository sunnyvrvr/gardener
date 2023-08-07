package com.gardener.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.member.dto.Member;
import com.gardener.member.service.MemberService;

@WebServlet("/findmember")
public class FindMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;

	public FindMemberController() {
		service = MemberService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("id");
		// 요청전달 데이터 얻기

		// MemberService를 통해 아이디로 저장된 회원 정보 조회
		Member m = service.findByMember(loginId);

		// 조회된 회원 정보를 이용하여 클라이언트로 응답
		if (m != null) {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(m.toJsonString()); // 회원 정보를 JSON 형태로 응답

		} else {
			// 회원 정보를 찾을 수 없는 경우, 적절한 오류 처리를 해야 합니다.
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Member not found");
		}
	}
}
