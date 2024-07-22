package com.mat.mvc.service.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.mat.mvc.dao.MemberDAO;
import com.mat.mvc.dao.MemberVO;
import com.mat.mvc.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;
	
	@Override
	public void signup(MemberVO vo) throws Exception {
		dao.signup(vo);
		
	}
	
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
		
	}
	
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();	
	}


}
