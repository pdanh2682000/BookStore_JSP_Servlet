package com.danhuy.dao.impl;

import java.util.List;

import com.danhuy.dao.IRatingDAO;
import com.danhuy.mapper.RatingMapper;
import com.danhuy.model.RatingModel;

public class RatingDAO extends AbstractDAO<RatingModel> implements IRatingDAO {

	@Override
	public Long insert(RatingModel model) {
		StringBuilder sql = new StringBuilder("insert into rating(item_id, rating, customer, comment)");
		sql.append(" values(?,?,?,?)");
		return insert(sql.toString(), model.getItem_id(), model.getRating(), model.getCustomer(), model.getComment());
	}

	@Override
	public List<RatingModel> findAllByItem(Long id) {
		String sql =  "select * from rating where item_id=?";
		return query(sql, new RatingMapper(), id);
	}

}
