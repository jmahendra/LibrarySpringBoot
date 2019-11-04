package com.tyss.dao;

import com.tyss.dto.Admin;

public interface AdminDao {
	public boolean register(Admin admin);
	public boolean login(String email,String password);
}
