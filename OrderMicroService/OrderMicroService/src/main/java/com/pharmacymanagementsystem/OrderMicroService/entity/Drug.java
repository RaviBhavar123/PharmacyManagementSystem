package com.pharmacymanagementsystem.OrderMicroService.entity;

import java.util.Date;


public class Drug {
	private String drugName;
	private long drugQuantity;
	
	private long drugid;
	private String eMail;
	private Date expiryDate;
	private long price;

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public long getDrugQuantity() {
		return drugQuantity;
	}

	public void setDrugQuantity(long drugQuantity) {
		this.drugQuantity = drugQuantity;
	}

	public long getDrugid() {
		return drugid;
	}

	public void setDrugid(long drugid) {
		this.drugid = drugid;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Drug(String drugName, long drugQuantity, long drugid, Date expiryDate, long price,String eMail) {
		super();
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.drugid = drugid;
		this.eMail=eMail;
		this.expiryDate = expiryDate;
		this.price = price;
	}

	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}

}
