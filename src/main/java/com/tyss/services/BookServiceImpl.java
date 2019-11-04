package com.tyss.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.dao.BookDao;
import com.tyss.dto.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao dao;

	@Override
	public boolean addBook(Book book) {

		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int bId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bId);
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return dao.getAllBook();
	}

	@Override
	public List<Book> searchBook(String bName) {
		// TODO Auto-generated method stub
		return dao.searchBook(bName);
	}

	@Override
	public boolean updateBook(Book book) {

		return dao.updateBook(book);
	}
}
