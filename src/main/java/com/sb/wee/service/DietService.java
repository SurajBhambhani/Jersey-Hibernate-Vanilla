/**
 *
 */
package com.sb.wee.service;

import com.sb.wee.entity.Diet;
import com.sb.wee.entity.User;
import com.sb.wee.model.DietDTO;
import com.sb.wee.repository.DietDao;
import com.sb.wee.repository.UserDao;
import com.sb.wee.util.HibernateDAOFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Suraj
 *
 */
public class DietService implements IDietService {

	@Override
	public DietDTO create(DietDTO dietDTO) {

		UserDao userDao = (UserDao) HibernateDAOFactory.instantiateDAO(UserDao.class);
		User user = userDao.findById(dietDTO.getUserId(), false);

		DietDao dietDao = (DietDao) HibernateDAOFactory.instantiateDAO(DietDao.class);
		Diet diet = dietDao
				.makePersistent(new Diet(dietDTO.getFoodName(), dietDTO.getQuantity(), dietDTO.getUnit(), user));

		DietDTO dto = dietDTO;
		dto.setId(diet.getId());

		return dto;
	}

	@Override
	public void remove(DietDTO dietDTO) {
		DietDao dietDao = (DietDao) HibernateDAOFactory.instantiateDAO(DietDao.class);

		dietDao.makeTransient(dietDTO.getId());
	}

	@Override
	public List<DietDTO> getAll() {
		DietDao dietDao = (DietDao) HibernateDAOFactory.instantiateDAO(DietDao.class);
		List<DietDTO> users = dietDao.findAll().stream().map(diet -> new DietDTO(diet.getId(), diet.getFoodName(),
				diet.getQuantity(), diet.getUnit(), diet.getUser().getId())).collect(Collectors.toList());
		return users;
	}

}
