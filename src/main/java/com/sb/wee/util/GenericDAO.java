package com.sb.wee.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface GenericDAO<T, ID extends Serializable> {

	T findById(ID id, boolean lock);

	List<T> findAll();

	List<T> findByExample(T exampleInstance);

	T makePersistent(T entity);

	void makeTransient(T entity);
	
	void setSession(Session s);
}