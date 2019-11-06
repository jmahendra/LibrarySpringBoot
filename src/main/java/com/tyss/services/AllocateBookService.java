package com.tyss.services;

import java.util.List;


import com.tyss.dto.AllocateBook;

public interface AllocateBookService {
	public boolean allocateBook(AllocateBook book);	
	public List<AllocateBook> getAllBook(int id);
	public boolean removeBook(int bId);
}
