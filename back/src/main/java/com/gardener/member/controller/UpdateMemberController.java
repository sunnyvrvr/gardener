package com.gardener.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardener.member.dto.Member;
import com.gardener.member.service.MemberService;
import com.google.gson.Gson;
import com.gradener.exception.UpdateException;

@WebServlet("/member")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	private Gson gson;

	public UpdateMemberController() {
		service = MemberService.getInstance();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post호출");
		gson = new Gson();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json; charset=utf-8");

		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("id"));
		Member m = service.findByMember(session.getAttribute("id"));

		String loginId = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		String profile = request.getParameter("profile");
		// 요청전달데이터 얻기

		m.setPwd(pwd);
		m.setEmail(email);
		m.setName(name);
		m.setIntro(intro);
		m.setProfile(profile);

		try {
			service.updateMember(m);
			String json = gson.toJson("Update successful.");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (UpdateException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			String json = gson.toJson("Update failed");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		}

	}
}