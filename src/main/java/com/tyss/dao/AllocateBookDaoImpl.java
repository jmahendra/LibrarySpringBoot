package com.tyss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.dto.AllocateBook;
import com.tyss.dto.Book;
import com.tyss.dto.BookAction;

@Repository
public class AllocateBookDaoImpl implements AllocateBookDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean allocateBook(AllocateBook book) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<AllocateBook> getAllBook(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		String get = "from AllocateBook where id=:id";
		Query query = manager.createQuery(get);
		query.setParameter("id", id);
		List<AllocateBook> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

	@Override
	public boolean removeBook(int bId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		AllocateBook book = manager.find(AllocateBook.class, bId);
		if (book == null) {
			return false;
		}
		transaction.begin();
		manager.remove(book);
		transaction.commit();
		return true;
	}

}
