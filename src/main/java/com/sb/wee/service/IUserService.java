package com.sb.wee.service;

import java.util.List;

import com.sb.wee.model.UserDTO;

public interface IUserService {

	UserDTO create(UserDTO userDTO);

	List<UserDTO> getAll();

}
