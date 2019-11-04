package com.tyss.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tyss.dao.AdminDao;
import com.tyss.dto.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao dao;

	@Override
	public boolean register(Admin admin) {
		return dao.register(admin);
	}

	@Override
	public boolean login(String email, String password) {

		return dao.login(email, password);
	}

}
