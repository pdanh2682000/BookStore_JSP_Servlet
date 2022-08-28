package com.danhuy.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.danhuy.dao.IEditorialDAO;
import com.danhuy.model.EditorialModel;
import com.danhuy.service.IEditorialService;

public class EditorialService implements IEditorialService {
	
	@Inject IEditorialDAO editorialDao;

	@Override
	public List<EditorialModel> findByCodeEditorial(Long id) {
		return editorialDao.findByCodeEditorial(id);
	}

	@Override
	public Long insert(EditorialModel model) {
		return editorialDao.insert(model);
	}

	@Override
	public void update(EditorialModel model) {
		editorialDao.update(model);	
	}

	@Override
	public void delete(Long id) {
		editorialDao.delete(id);
	}

	@Override
	public List<EditorialModel> findAllItemsByCodeEditorial(Long id) {
		return editorialDao.findAllItemsByCodeEditorial(id);
	}

	@Override
	public List<EditorialModel> findAllItemsByCodeEditorialAndPagination(EditorialModel model) {
		return editorialDao.findAllItemsByCodeEditorialAndPagination(model);
	}

	@Override
	public int countByCodeEditorial(Long id) {
		return editorialDao.countByCodeEditorial(id);
	}



}
