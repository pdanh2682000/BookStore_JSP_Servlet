package com.danhuy.dao;

import com.danhuy.model.MembersModel;

public interface IMembersDAO {
	MembersModel findByUsernamePassword(String username, String password);
	Long insertMember(MembersModel model);
}
