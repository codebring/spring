package com.mat.mvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mat.mvc.dao.ShopDAO;
import com.mat.mvc.service.ShopService;
import com.mat.mvc.vo.GoodsViewVO;

@Service
public class ShopServicempl implements ShopService {
	
	@Inject
	private ShopDAO dao;

	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		int cateCodeRef = 0;
		
		if(level == 1) {
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
			//두가지 모두 cateCode로 해도 무관
		} else {
			return dao.list(cateCode);
		}
	}//퍼블릭 끝
	
	
	
}//클래스 끝
