package com.orderservice.entity;

import java.util.Date;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "OrderData")
public class Order {

	@Id
	private int orderId;
	private long drugId;
	private String userId;
	private int quantity;
	private Date orderDate;

	public Order() {

	}

	public Order(int orderId, long drugId, String userId, int quantity, Date orderDate) {
		super();
		this.orderId = orderId;
		this.drugId = drugId;
		this.userId = userId;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}

	public long getDrugId() {
		return drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
