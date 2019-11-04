package com.tyss.dao;

import java.util.List;


import com.tyss.dto.AllocateBook;
import com.tyss.dto.BookAction;

public interface AllocateBookDao {
	public boolean allocateBook(AllocateBook book);	
	public List<AllocateBook> getAllBook(int uId);
	public boolean removeBook(int bId);
}
