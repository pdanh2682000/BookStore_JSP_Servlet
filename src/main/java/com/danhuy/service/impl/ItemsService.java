package com.danhuy.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.danhuy.dao.IItemsDAO;
import com.danhuy.model.ItemsModel;
import com.danhuy.service.IItemsService;

public class ItemsService implements IItemsService {

	@Inject IItemsDAO itemsDao;
	
	@Override
	public List<ItemsModel> findAll() {
		return itemsDao.findAll();
	}

	@Override
	public List<ItemsModel> findByField(String field, Object value) {
		return itemsDao.findByField(field, value);
	}

	@Override
	public Long insert(ItemsModel model) {
		return itemsDao.insert(model);
	}

	@Override
	public void update(ItemsModel model) {
		itemsDao.update(model);
	}

	@Override
	public void delete(Long id) {
		itemsDao.delete(id);
	}

	@Override
	public int count() {
		return itemsDao.count();
	}

	@Override
	public ItemsModel findOne(Long id) {
		return itemsDao.findOne(id);
	}

	@Override
	public List<ItemsModel> findAllItemsPagination(ItemsModel model) {
		return itemsDao.findAllItemsPagination(model);
	}

}
