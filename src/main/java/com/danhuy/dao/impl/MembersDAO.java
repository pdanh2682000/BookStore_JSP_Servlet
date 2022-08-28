package com.danhuy.dao.impl;

import java.util.List;

import com.danhuy.dao.IMembersDAO;
import com.danhuy.mapper.MembersMapper;
import com.danhuy.model.MembersModel;

public class MembersDAO extends AbstractDAO<MembersModel> implements IMembersDAO {

	@Override
	public MembersModel findByUsernamePassword(String username, String password) {
		String sql = "select * from members where member_login=? and member_password=?";
		List<MembersModel> results = query(sql, new MembersMapper(), username, password);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public Long insertMember(MembersModel model) {
		StringBuilder sql = new StringBuilder("insert into members(member_login, member_password, role_id, first_name, last_name, email, phone, address, notes, card_type_id, card_number)");
		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), model.getMember_login(), model.getMember_password(), model.getRole_id(),
				model.getFirst_name(), model.getLast_name(), model.getEmail(), model.getPhone(),
				model.getAddress(), model.getNotes(), model.getCard_type_id(), model.getCard_number());
	}
	
//	public static void main(String[] args) {
//		MembersDAO m = new MembersDAO();
//		MembersModel model = m.findByUsernamePassword("pdanh", "pdanh");
//		System.out.print(model);
//	}

}
