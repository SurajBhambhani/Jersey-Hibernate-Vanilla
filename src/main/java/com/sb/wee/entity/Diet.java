package com.sb.wee.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Suraj
 */

@Entity
@Table(name = "diet", schema = "example")
public class Diet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "food_name", nullable = false)
	private String foodName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "unit")
	private String unit;
	
	@CreationTimestamp
	private LocalDateTime timestamp;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	
	/**
	 * 
	 */
	public Diet() {
		super();
	}

	/**
	 * @param foodName
	 * @param quantity
	 * @param unit
	 * @param timestamp
	 * @param user
	 */
	public Diet(String foodName, int quantity, String unit, User user) {
		super();
		this.foodName = foodName;
		this.quantity = quantity;
		this.unit = unit;
		this.user = user;
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}