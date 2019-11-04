package com.tyss.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.dto.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean register(Admin admin) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(admin);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String login = "from Admin where email=:email and password=:password";
		
		Query query = manager.createQuery(login);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Admin admin = (Admin) query.getSingleResult();
		if (admin == null)
			return false;
		return true;
	}

}
