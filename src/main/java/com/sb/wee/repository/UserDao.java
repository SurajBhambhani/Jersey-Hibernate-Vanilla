package com.sb.wee.repository;

import java.util.List;

import com.sb.wee.entity.User;
import com.sb.wee.util.GenericDAO;
import com.sb.wee.util.GenericHibernateDAO;

public class UserDao extends GenericHibernateDAO<User, Integer> implements GenericDAO<User, Integer> {

	@Override
	public List<User> findByExample(User exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
