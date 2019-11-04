package com.tyss.dao;

import com.tyss.dto.Librarian;

public interface LibDao {
	public boolean register(Librarian librarian);

	public boolean login(String lEmail, String lPassword);
}
