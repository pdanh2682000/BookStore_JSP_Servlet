package com.danhuy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.danhuy.model.EditorialModel;
import com.danhuy.model.ItemsModel;

public class EditorialMapper implements RowMapper<EditorialModel> {

	@Override
	public EditorialModel mapRow(ResultSet rs) {
		EditorialModel model = new EditorialModel();
		try {
			model.setArticle_id(rs.getLong("article_id"));
			model.setEditorial_cat_id(rs.getLong("editorial_cat_id"));
			model.setItem_id(rs.getLong("item_id"));
			model.setArticle_title(rs.getString("article_title"));
			model.setArticle_desc(rs.getString("article_desc"));
			
			if(rs.getLong("category_id") != 0) {
				ItemsModel items = new ItemsMapper().mapRow(rs);
				model.setItems(items);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mapper Editorial fail!");
			return null;
		}
		return model;
	}

}
