package com.danhuy.service;

import java.util.List;

import com.danhuy.model.EditorialModel;

public interface IEditorialService {
	List<EditorialModel> findByCodeEditorial(Long id);
	List<EditorialModel> findAllItemsByCodeEditorial(Long id);
	List<EditorialModel> findAllItemsByCodeEditorialAndPagination(EditorialModel model);
	Long insert(EditorialModel model);
	void update(EditorialModel model);
	void delete(Long id);
	int countByCodeEditorial(Long id);
}
