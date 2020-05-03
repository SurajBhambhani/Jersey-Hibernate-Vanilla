package com.sb.wee.util;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	T findById(ID id, boolean lock);

	List<T> findAll();

	List<T> findByExample(T exampleInstance);

	T makePersistent(T entity);

	void makeTransient(ID entity);

	void setSession(Session s);
}