package com.pharmacymanagementsystem.OrderMicroService.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

	private User user;

	private List<Drug> medicineDetails;
	private int quantity;
	private Date orderDate;
	private boolean isValid;
	private boolean isPickedup;
	private List<Long> drugIds;
	public Order(int orderId, User user,List<Long> drugIds,List<Drug> medicineDetails, int quantity, Date orderDate, boolean isValid,
			boolean isPickedup) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.drugIds=drugIds;
		this.medicineDetails = medicineDetails;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.isValid = isValid;
		this.isPickedup = isPickedup;
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

	public List<Drug> getMedicineDetails() {
		return medicineDetails;
	}

	public void setMedicineDetails(List<Drug> medicineDetails) {
		this.medicineDetails = medicineDetails;
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

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isPickedup() {
		return isPickedup;
	}

	public void setPickedup(boolean isPickedup) {
		this.isPickedup = isPickedup;
	}

	public List<Long> getDrugIds() {
		return drugIds;
	}

	public void setDrugIds(List<Long> drugIds) {
		this.drugIds = drugIds;
	}

	
}
