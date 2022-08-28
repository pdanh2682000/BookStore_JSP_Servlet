package com.danhuy.service;

import com.danhuy.model.MembersModel;

public interface IMembersService {
	MembersModel findByUsernamePassword(String username, String password);
	Long insertMember(MembersModel model);
}
