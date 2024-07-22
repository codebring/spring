package com.mat.mvc.dao;

public interface MemberDAO {
	
	
	public void signup(MemberVO vo) throws Exception;
	
	public MemberVO signin(MemberVO vo) throws Exception;

}
