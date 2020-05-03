package com.sb.wee.util;

import org.hibernate.Session;

public class HibernateDAOFactory {

	public static GenericHibernateDAO instantiateDAO(Class daoClass) {
		try {
			GenericHibernateDAO dao = (GenericHibernateDAO) daoClass.newInstance();
			dao.setSession(getCurrentSession());
			return dao;
		} catch (Exception ex) {
			throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
		}
	}

	// You could override this if you don't want HibernateUtil for lookup
	private static Session getCurrentSession() {
        return HibernateUtility.getSession();
    }
}