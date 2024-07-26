package com.mat.mvc.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mat.mvc.dao.ShopDAO;
import com.mat.mvc.vo.GoodsViewVO;

@Repository
public class ShopDAOImpl implements ShopDAO{
	
	@Inject
	private SqlSession sql;
	
	private static String namespace="com.jbb.mappers.shopMapper";

	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);

		return sql.selectList(namespace + ".list_1", map);
	}
	
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		
		return sql.selectList(namespace + ".list_2", cateCode);
	}
	
	
	
}//클래스끝
