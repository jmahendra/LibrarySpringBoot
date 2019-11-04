package com.tyss.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.dao.UserDao;
import com.tyss.dto.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public boolean userRegister(User user) {
		// TODO Auto-generated method stub
		return dao.userRegister(user);
	}

	@Override
	public User userLogin(String uEmail, String uPassword) {
		// TODO Auto-generated method stub
		return dao.userLogin(uEmail, uPassword);
	}

	@Override
	public boolean userUpdate(User user) {
		// TODO Auto-generated method stub
		return dao.userUpdate(user);
	}

	@Override
	public boolean userDelete(int uId) {
		// TODO Auto-generated method stub
		return dao.userDelete(uId);
	}

	@Override
	public List<User> userGet() {
		// TODO Auto-generated method stub
		return dao.userGet();
	}

}
