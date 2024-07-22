package com.mat.mvc.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");

		if(member == null) {
			res.sendRedirect("/member/signin");
			return false;
		}
		
		if(member == null || member.getVerify() != 9) {
			res.sendRedirect("/");
			return false;
		}
		
		return true;
	}
		
}
