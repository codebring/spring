package com.mat.mvc.dao;

import java.util.List;

import com.mat.mvc.vo.CategoryVO;

public interface AdminDAO {
	public List<CategoryVO> category() throws Exception;

}
