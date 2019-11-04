package com.tyss.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.dao.BookActionDao;
import com.tyss.dto.BookAction;

@Service
public class BookActionServiceImpl implements BookActionService {
	@Autowired
	private BookActionDao dao;

	@Override
	public boolean addBook(BookAction bookAction) {
		
		return dao.addBook(bookAction);
	}

	@Override
	public List<BookAction> getAllBook() {
		// TODO Auto-generated method stub
		return dao.getAllBook();
	}

	@Override
	public boolean removeBook(int bId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bId);
	}

}
