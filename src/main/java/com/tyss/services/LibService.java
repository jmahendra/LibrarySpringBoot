package com.tyss.services;

import com.tyss.dto.Librarian;

public interface LibService {
	public boolean register(Librarian librarian);

	public boolean login(String lEmail, String lPassword);
	
	public boolean changePassword(String lEmail, String lPassword);
}
