package com.danhuy.service;

import java.util.List;

import com.danhuy.model.RatingModel;

public interface IRatingService {
	Long insert(RatingModel model);
	List<RatingModel> findAllByItem(Long id);
}
