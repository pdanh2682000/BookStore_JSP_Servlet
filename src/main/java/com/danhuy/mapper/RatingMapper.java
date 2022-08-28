package com.danhuy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.danhuy.model.RatingModel;

public class RatingMapper implements RowMapper<RatingModel> {

	@Override
	public RatingModel mapRow(ResultSet rs) {
		RatingModel model = new RatingModel();
		try {
			model.setId(rs.getLong("id"));
			model.setItem_id(rs.getLong("item_id"));
			model.setCustomer(rs.getString("customer"));
			model.setRating(rs.getString("rating"));
			model.setComment(rs.getString("comment"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mapper rating fail!");
			return null;
		}
		
		return model;
	}

}
