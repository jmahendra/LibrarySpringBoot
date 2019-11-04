package com.tyss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.dto.Admin;
import com.tyss.dto.Book;
import com.tyss.dto.User;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean userRegister(User user) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User userLogin(String uEmail, String uPassword) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String login = "from User where uEmail=:uEmail and uPassword=:uPassword";

		Query query = manager.createQuery(login);
		query.setParameter("uEmail", uEmail);
		query.setParameter("uPassword", uPassword);
		User user = (User) query.getSingleResult();
		
		if (user == null)
			return null;
		return user;
	}

	@Override
	public boolean userUpdate(User user) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User user2 = manager.find(User.class, user.getuId());
		if (user2 == null) {
			return false;
		}
		transaction.begin();
		user2.setuAge(user.getuAge());
		user2.setuEmail(user.getuEmail());
		user2.setuGender(user.getuGender());
		user2.setuMobileNo(user.getuMobileNo());
		user2.setuName(user2.getuName());
		user2.setuPassword(user.getuPassword());
		transaction.commit();
		return true;
	}

	@Override
	public boolean userDelete(int uId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User user2 = manager.find(User.class, uId);
		if (user2 == null) {
			return false;
		}
		transaction.begin();
		manager.remove(user2);
		transaction.commit();
		return true;

	}

	@Override
	public List<User> userGet() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String get = "from User";
		Query query = manager.createQuery(get);
		List<User> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

}
