package com.danhuy.service;

import java.util.List;

import com.danhuy.model.CategoriesModel;

public interface ICategoriesService {
	List<CategoriesModel> findAll();
	CategoriesModel findOne(Long id);
	CategoriesModel findOneByName(String name);
}
