
package com.sb.wee.model;

/**
 * @author Suraj
 */
public class DietDTO {

	private int id;

	private String foodName;

	private int quantity;

	private String unit;

	private int userId;

	/**
	 * @param id
	 * @param foodName
	 * @param quantity
	 * @param unit
	 * @param userId
	 */
	public DietDTO(int id, String foodName, int quantity, String unit, int userId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.quantity = quantity;
		this.unit = unit;
		this.userId = userId;
	}

	/**
	 * @param foodName
	 * @param quantity
	 * @param unit
	 * @param userId
	 */
	public DietDTO(String foodName, int quantity, String unit, int userId) {
		super();
		this.foodName = foodName;
		this.quantity = quantity;
		this.unit = unit;
		this.userId = userId;
	}

	/**
	 *
	 */
	public DietDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
