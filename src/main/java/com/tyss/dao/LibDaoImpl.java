package com.tyss.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.dto.Librarian;
import com.tyss.dto.User;

@Repository
public class LibDaoImpl implements LibDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean register(Librarian librarian) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(librarian);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean login(String lEmail, String lPassword) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String login = "from Librarian where lEmail=:lEmail and lPassword=:lPassword";

		Query query = manager.createQuery(login);
		query.setParameter("lEmail", lEmail);
		query.setParameter("lPassword", lPassword);
		Librarian librarian = (Librarian) query.getSingleResult();
		if (librarian == null)
			return false;
		return true;
	}

	@Override
	public boolean changePassword(String lEmail, String lPassword) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String login = "from Librarian where lEmail=:lEmail ";

		Query query = manager.createQuery(login);
		query.setParameter("lEmail", lEmail);

		Librarian librarian = (Librarian) query.getSingleResult();
		if (librarian != null) {
			transaction.begin();
			librarian.setlPassword(lPassword);
			transaction.commit();
			System.out.println("lib password changed..");
			return true;
		}
		return false;
	}

}
