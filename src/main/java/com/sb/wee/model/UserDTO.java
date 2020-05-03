/**
 * 
 */
package com.sb.wee.model;

/**
 * @author Suraj
 *
 */
public class UserDTO {



	private int id;

	private String userName;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
	/**
	 * 
	 */
	public UserDTO() {
		super();
	}

	/**
	 * @param id
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 */
	public UserDTO(int id, String userName, String firstName, String lastName, String email, String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	/**
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 */
	public UserDTO(String userName, String firstName, String lastName, String email, String phone) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

}
