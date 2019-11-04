package com.tyss.services;

import java.util.List;


import com.tyss.dto.BookAction;

public interface BookActionService {
	public boolean addBook(BookAction bookAction);

	public List<BookAction> getAllBook();
	
	public boolean removeBook(int bId);
}
