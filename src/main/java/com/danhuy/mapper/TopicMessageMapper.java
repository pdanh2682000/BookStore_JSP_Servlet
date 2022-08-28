package com.danhuy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.danhuy.model.TopicMessageModel;

public class TopicMessageMapper implements RowMapper<TopicMessageModel> {

	@Override
	public TopicMessageModel mapRow(ResultSet rs) {
		TopicMessageModel model = new TopicMessageModel();
		try {
			
			try {
				if(rs.getLong("id") != 0) {
					model.setId(rs.getLong("id"));
				}
			}catch(Exception e) {}
			
			model.setMessage_id(rs.getLong("message_id"));
			model.setAuthor(rs.getString("author"));
			
			try {
				if(rs.getString("topic") != null) {
					model.setTopic(rs.getString("topic"));
				}
			}catch(Exception e) {}
			
			model.setDate_entered(rs.getTimestamp("date_entered"));
			
			try {
				if(rs.getString("message") != null) {
					model.setMessage(rs.getString("message"));
				}
			}catch(Exception e) {}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mapper Topic Message fail!");
			return null;
		}
		return model;
	}

}
