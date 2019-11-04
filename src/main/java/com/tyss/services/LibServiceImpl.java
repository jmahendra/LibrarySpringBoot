package com.tyss.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tyss.dao.LibDao;
import com.tyss.dto.Librarian;

@Service
public class LibServiceImpl implements LibService {
	@Autowired
	private LibDao dao;

	@Override
	public boolean register(Librarian librarian) {
		// TODO Auto-generated method stub
		return dao.register(librarian);
	}

	@Override
	public boolean login(String lEmail, String lPassword) {
		// TODO Auto-generated method stub
		return dao.login(lEmail, lPassword);
	}

}
