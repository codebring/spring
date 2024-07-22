package com.mat.mvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mat.mvc.dao.BoardDAO;
import com.mat.mvc.dao.BoardVO;
import com.mat.mvc.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list() throws Exception {
	 return dao.list();
	}
	
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
		
	}
	
	@Override
	public BoardVO view(int bno) throws Exception {
		dao.viewCnt(bno);
		return dao.view(bno);
		
	}
	
	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);
		
	}
	
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
		
	}

}
