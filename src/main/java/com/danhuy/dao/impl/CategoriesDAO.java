package com.danhuy.dao.impl;

import java.util.List;

import com.danhuy.dao.ICategoriesDAO;
import com.danhuy.mapper.CategoriesMapper;
import com.danhuy.model.CategoriesModel;

public class CategoriesDAO extends AbstractDAO<CategoriesModel> implements ICategoriesDAO {

	@Override
	public List<CategoriesModel> findAll() {
		String sql = "select * from categories";
		return query(sql, new CategoriesMapper());
	}

	@Override
	public CategoriesModel findOne(Long id) {
		String sql = "select * from categories where category_id=?";
		List<CategoriesModel> result = query(sql, new CategoriesMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public CategoriesModel findOneByName(String name) {
		String sql = "select * from categories where name=?";
		List<CategoriesModel> result = query(sql, new CategoriesMapper(), name);
		return result.isEmpty() ? null : result.get(0);
	}
	
//	public static void main(String[] args) {
//		CategoriesDAO cat = new CategoriesDAO();
//		Long id = (long) 3;
//		//List<CategoriesModel> arr = cat.findAll();
//		CategoriesModel arr = cat.findOne(id);
//		System.out.print(arr);
//	}

}
