package com.tyss.services;

import java.util.List;

import com.tyss.dto.User;

public interface UserService {
	public User register(User user);

	public User login(String email, String password);

	public boolean changePassword(String email, String password);

	public boolean userUpdate(User user);

	public boolean userDelete(int Id);

	public List<User> userGet();
}
