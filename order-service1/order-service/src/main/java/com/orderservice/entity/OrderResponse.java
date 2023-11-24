package com.orderservice.entity;

import java.util.Date;

public class OrderResponse {

	private int orderId;
	private Drug drug;
	private User user;
	private int quantity;
	private Date orderDate;
	
	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public OrderResponse() {
		
	}

	public OrderResponse(int orderId, Drug drug, User user, int quantity, Date orderDate) {
			super();
			this.orderId = orderId;
			this.drug = drug;
			this.user = user;
			this.quantity = quantity;
			this.orderDate = orderDate;
		}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
