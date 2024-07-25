package com.mat.mvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mat.mvc.dao.AdminDAO;
import com.mat.mvc.vo.CategoryVO;
import com.mat.mvc.vo.GoodsVO;
import com.mat.mvc.vo.GoodsViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Inject
	private SqlSession sql;
	
	private static String namespace="com.jbb.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}
	
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	@Override
	public List<GoodsViewVO> goodsList() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	}
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {

		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}
	
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
	} 
	
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sql.update(namespace + ".goodsDelete", gdsNum);
	} 

	
	
}
