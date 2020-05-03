package com.sb.wee.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sb.wee.entity.User;
import com.sb.wee.util.HibernateUtility;

public class App {
	public static void main(String[] args) {
		User user = new User("Just_Like", "just", "like", "rameshfadatare@javaguides.com", "+491332423423431");

		Transaction transaction = null;
		try (Session session = HibernateUtility.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student objects
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}
}