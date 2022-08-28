package com.danhuy.service.impl;

import javax.inject.Inject;

import com.danhuy.dao.IMembersDAO;
import com.danhuy.model.MembersModel;
import com.danhuy.service.IMembersService;

public class MembersService implements IMembersService {
	
	@Inject IMembersDAO membersDao;

	@Override
	public MembersModel findByUsernamePassword(String username, String password) {
		return membersDao.findByUsernamePassword(username, password);
	}

	@Override
	public Long insertMember(MembersModel model) {
		return membersDao.insertMember(model);
	}

}
