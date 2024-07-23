package com.mat.mvc.dao;

import java.util.List;

import com.mat.mvc.vo.CategoryVO;
import com.mat.mvc.vo.GoodsVO;
import com.mat.mvc.vo.GoodsViewVO;

public interface AdminDAO {
	public List<CategoryVO> category() throws Exception;
	
	public void register(GoodsVO vo) throws Exception;
	
	public List<GoodsVO> goodsList() throws Exception;
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	public void goodsModify(GoodsVO vo) throws Exception;
	
	public void goodsDelete(int gdsNum) throws Exception;
	
	

}
