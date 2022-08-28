package com.danhuy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.danhuy.model.MembersModel;

public class MembersMapper implements RowMapper<MembersModel> {

	@Override
	public MembersModel mapRow(ResultSet rs) {
		MembersModel model = new MembersModel();
		try {
			model.setMember_id(rs.getLong("member_id"));
			model.setRole_id(rs.getLong("role_id"));
			model.setCard_type_id(rs.getLong("card_type_id"));
			model.setMember_login(rs.getString("member_login"));
			model.setMember_password(rs.getString("member_password"));
			model.setFirst_name(rs.getString("first_name"));
			model.setLast_name(rs.getString("last_name"));
			model.setEmail(rs.getString("email"));
			model.setPhone(rs.getString("phone"));
			model.setAddress(rs.getString("address"));
			model.setNotes(rs.getString("notes"));
			model.setCard_number(rs.getString("card_number"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mapper member fail!");
			return null;
		}
		
		return model;
	}

}
