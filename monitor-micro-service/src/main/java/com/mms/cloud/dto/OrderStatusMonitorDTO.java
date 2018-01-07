package com.mms.cloud.dto;

import java.io.Serializable;

public class OrderStatusMonitorDTO implements Serializable{
	
	private static final long serialVersionUID = -6127196101102494843L;
	
	private String totalPrice;
	
	private String orderCode;
	
	private String user;
	
	private String province;
	
	private String modifyTime;
	
	private String payStatus;
	
	private String sendStatus;
	
	private String receviedStatus;

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getReceviedStatus() {
		return receviedStatus;
	}

	public void setReceviedStatus(String receviedStatus) {
		this.receviedStatus = receviedStatus;
	}

}
