package com.mat.mvc.dao;

import java.util.List;

public interface BoardDAO {
	public List<BoardVO> list() throws Exception;
	
	public void write(BoardVO vo) throws Exception;
	
	public BoardVO view(int bno) throws Exception;
	
	public void modify(BoardVO vo) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void viewCnt(int bno) throws Exception;
	
	

}
