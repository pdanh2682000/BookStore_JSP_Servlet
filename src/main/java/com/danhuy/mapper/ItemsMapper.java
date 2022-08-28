package com.danhuy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.danhuy.model.ItemsModel;

public class ItemsMapper implements RowMapper<ItemsModel> {

	@Override
	public ItemsModel mapRow(ResultSet rs) {
		ItemsModel model = new ItemsModel();
		try {
			model.setItem_id(rs.getLong("item_id"));
			model.setCategory_id(rs.getLong("category_id"));
			model.setName(rs.getString("name"));
			model.setAuthor(rs.getString("author"));
			model.setProduct_url(rs.getString("product_url"));
			model.setImage_url(rs.getString("image_url"));
			model.setNotes(rs.getString("notes"));
			model.setPrice(rs.getFloat("price"));
			model.setIs_recommended(rs.getInt("is_recommended"));
			try {
				if(rs.getString("c.name") != null)	model.setCategory_name(rs.getString("c.name")); // for join with category
			}catch(Exception e) {}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mapper items fail!");
			return null;
		}
		
		return model;
	}

}
