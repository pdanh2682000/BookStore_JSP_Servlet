package com.danhuy.dao;

import java.util.List;

import com.danhuy.model.CategoriesModel;

public interface ICategoriesDAO {
	List<CategoriesModel> findAll();
	CategoriesModel findOne(Long id);
	CategoriesModel findOneByName(String name);
}
