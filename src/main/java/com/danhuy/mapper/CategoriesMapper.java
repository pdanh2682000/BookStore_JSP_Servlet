package com.danhuy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.danhuy.model.CategoriesModel;

public class CategoriesMapper implements RowMapper<CategoriesModel> {

	@Override
	public CategoriesModel mapRow(ResultSet rs) {
		CategoriesModel model = new CategoriesModel();
		try {
			model.setCategory_id(rs.getLong("category_id"));
			model.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mapper categories fail!");
			return null;
		}
		
		return model;
	}

}
