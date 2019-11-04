package com.tyss.dao;

import java.util.List;


import com.tyss.dto.BookAction;

public interface BookActionDao {
	public boolean addBook(BookAction bookAction);

	public List<BookAction> getAllBook();
	
	public boolean removeBook(int bId);
}
