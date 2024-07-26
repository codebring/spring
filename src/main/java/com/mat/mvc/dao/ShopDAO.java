package com.mat.mvc.dao;

import java.util.List;

import com.mat.mvc.vo.GoodsViewVO;

public interface ShopDAO {
	
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	public List<GoodsViewVO> list(int cateCode) throws Exception;
	
	
	

}
