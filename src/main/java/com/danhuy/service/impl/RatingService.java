package com.danhuy.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.danhuy.dao.IRatingDAO;
import com.danhuy.model.RatingModel;
import com.danhuy.service.IRatingService;


public class RatingService implements IRatingService {
	
	@Inject IRatingDAO ratingDao;

	@Override
	public Long insert(RatingModel model) {
		return ratingDao.insert(model);
	}

	@Override
	public List<RatingModel> findAllByItem(Long id) {
		return ratingDao.findAllByItem(id);
	}

}
