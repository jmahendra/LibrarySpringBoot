package com.tyss.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.dto.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addBook(Book book) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Book b=new Book();
		b.setbName(book.getbName());
		b.setbAuthor(book.getbAuthor());
		b.setbCategory(book.getbCategory());
		try {
			transaction.begin();
			manager.persist(b);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeBook(int bId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Book book=manager.find(Book.class,bId);
		if(book==null) {
			return false;
		}
		transaction.begin();
		manager.remove(book);
		transaction.commit();
		return true;
	}

	@Override
	public List<Book> getAllBook() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		String get="from Book";
		Query query=manager.createQuery(get);
		List<Book> list=query.getResultList();
		if(list==null) {
			return null;
		}
		return list;
	}

	@Override
	public List<Book> searchBook(String bName) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String get="from Book where bName like :bName";
		Query query=manager.createQuery(get);
		query.setParameter("bName", "%"+bName+"%");
		List<Book> list=query.getResultList();
		if(list==null) {
			return null;
		}
		return list;
	}

	@Override
	public boolean updateBook(Book book) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Book book1=manager.find(Book.class,book.getbId());
		if(book1==null) {
			return false;
		}
		transaction.begin();
		book1.setbAuthor(book.getbAuthor());
		book1.setbName(book.getbName());
		book1.setbCategory(book.getbCategory());
		transaction.commit();
		return true;
	}
}
