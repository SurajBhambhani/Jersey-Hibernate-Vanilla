package com.sb.wee.repository;

import com.sb.wee.entity.Diet;
import com.sb.wee.util.GenericDAO;
import com.sb.wee.util.GenericHibernateDAO;

import java.util.List;

public class DietDao extends GenericHibernateDAO<Diet, Integer> implements GenericDAO<Diet, Integer> {

	@Override
	public List<Diet> findByExample(Diet exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
