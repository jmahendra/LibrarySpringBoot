package com.tyss.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.dao.AllocateBookDao;
import com.tyss.dto.AllocateBook;

@Service
public class AllocateBookServiceImpl implements AllocateBookService{
	@Autowired
	private AllocateBookDao dao;

	@Override
	public boolean allocateBook(AllocateBook book) {
		// TODO Auto-generated method stub
		return dao.allocateBook(book);
	}

	@Override
	public List<AllocateBook> getAllBook(int uId) {
		// TODO Auto-generated method stub
		return dao.getAllBook(uId);
	}

	@Override
	public boolean removeBook(int bId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bId);
	}
}
