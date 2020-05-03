package com.sb.wee.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sb.wee.model.UserDTO;
import com.sb.wee.service.IUserService;
import com.sb.wee.service.UserService;

@Path("/api")
public class UserController {
	
	IUserService userService =  new UserService();
	
	@GET
	@Path(value = "/hello")
	public String getMsg() {
		return "Hello World !! - Jersey 2";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/users/all")
	public List<UserDTO> getUsers() {
		return userService.getAll();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value = "/user/add")
	public Response addUser(UserDTO userDTO) {
		
		return Response.ok(userService.create(userDTO)).build();
		
	}
}