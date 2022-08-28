package com.danhuy.dao;

import java.util.List;

import com.danhuy.model.ItemsModel;

public interface IItemsDAO {
	List<ItemsModel> findAll();
	List<ItemsModel> findByField(String field, Object value);
	List<ItemsModel> findAllItemsPagination(ItemsModel model);
	ItemsModel findOne(Long id);
	Long insert(ItemsModel model);
	void update(ItemsModel model);
	void delete(Long id);
	int count();
}
