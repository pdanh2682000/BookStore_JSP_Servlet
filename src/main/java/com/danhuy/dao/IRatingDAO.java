package com.danhuy.dao;

import java.util.List;

import com.danhuy.model.RatingModel;

public interface IRatingDAO {
	Long insert(RatingModel model);
	List<RatingModel> findAllByItem(Long id);
}
