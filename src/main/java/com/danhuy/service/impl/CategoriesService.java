package com.danhuy.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.danhuy.dao.ICategoriesDAO;
import com.danhuy.model.CategoriesModel;
import com.danhuy.service.ICategoriesService;

public class CategoriesService implements ICategoriesService {
	
	@Inject ICategoriesDAO categoriesDao;

	@Override
	public List<CategoriesModel> findAll() {
		return categoriesDao.findAll();
	}

	@Override
	public CategoriesModel findOne(Long id) {
		return categoriesDao.findOne(id);
	}

	@Override
	public CategoriesModel findOneByName(String name) {
		return categoriesDao.findOneByName(name);
	}

}
