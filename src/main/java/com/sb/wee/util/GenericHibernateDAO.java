package com.sb.wee.util;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	private Session session;

	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public void setSession(Session s) {
		this.session = s;
	}

	protected Session getSession() {
		if (session == null)
			throw new IllegalStateException("Session has not been set on DAO before usage");
		return session;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entity;
		Transaction beginTransaction = session.beginTransaction();
		if (lock)
			entity = (T) session.load(getPersistentClass(), id, LockMode.UPGRADE);
		else
			entity = (T) session.load(getPersistentClass(), id);
		beginTransaction.commit();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> resultList;
		Transaction beginTransaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getPersistentClass());
		Root<T> rootEntry = cq.from(getPersistentClass());
		CriteriaQuery<T> all = cq.select(rootEntry);

		Query<T> allQuery = session.createQuery(all);
		resultList = allQuery.getResultList();
		beginTransaction.commit();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public T makePersistent(T entity) {

		Transaction beginTransaction = getSession().beginTransaction();

		getSession().saveOrUpdate(entity);

		beginTransaction.commit();
		return entity;
	}

	public void makeTransient(ID id) {
		Transaction beginTransaction = getSession().beginTransaction();
		T entity = (T) session.load(getPersistentClass(), id);
		getSession().delete(entity);

		beginTransaction.commit();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		// TODO
		return null;

	}

}