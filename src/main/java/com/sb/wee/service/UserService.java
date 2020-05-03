package com.sb.wee.service;

import java.util.List;
import java.util.stream.Collectors;

import com.sb.wee.entity.User;
import com.sb.wee.model.UserDTO;
import com.sb.wee.repository.UserDao;
import com.sb.wee.util.HibernateDAOFactory;

public class UserService implements IUserService {

	@Override
	public UserDTO create(UserDTO userDTO) {
		UserDao dao = (UserDao) HibernateDAOFactory.instantiateDAO(UserDao.class);

		User user = dao.makePersistent(new User(userDTO.getUserName(), userDTO.getFirstName(), userDTO.getLastName(),
				userDTO.getEmail(), userDTO.getPhone()));

		UserDTO dto = userDTO;
		dto.setId(user.getId());

		return dto;
	}

	@Override
	public List<UserDTO> getAll() {
		UserDao dao = (UserDao) HibernateDAOFactory.instantiateDAO(UserDao.class);
		List<UserDTO> users = dao.findAll().stream().map(user -> new UserDTO(user.getId(), user.getUserName(),
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone()))
				.collect(Collectors.toList());
		return users;
	}

}
