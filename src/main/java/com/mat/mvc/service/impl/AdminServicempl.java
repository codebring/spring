package com.mat.mvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mat.mvc.dao.AdminDAO;
import com.mat.mvc.service.AdminService;
import com.mat.mvc.vo.CategoryVO;
import com.mat.mvc.vo.GoodsVO;
import com.mat.mvc.vo.GoodsViewVO;

@Service
public class AdminServicempl implements AdminService {
	@Inject
	private AdminDAO dao;
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}
	
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
	}
	
	@Override
	public List<GoodsVO> goodsList() throws Exception {
		return dao.goodsList();
	}
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {

		return dao.goodsView(gdsNum);
	}
	
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}
	
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
	}
	
	
	
}
