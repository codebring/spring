package com.mat.mvc.service;

import java.util.List;

import com.mat.mvc.vo.CategoryVO;
import com.mat.mvc.vo.GoodsVO;
import com.mat.mvc.vo.GoodsViewVO;

public interface AdminService {
	public List<CategoryVO> category() throws Exception;
	
	public void register(GoodsVO vo) throws Exception;
	
	public List<GoodsViewVO> goodsList() throws Exception;
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	public void goodsModify(GoodsVO vo) throws Exception;
	
	public void goodsDelete(int gdsNum) throws Exception;
	
	
	

}
