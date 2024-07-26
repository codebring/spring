package com.mat.mvc.service;

import java.util.List;

import com.mat.mvc.vo.GoodsViewVO;

public interface ShopService {

	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	

}
