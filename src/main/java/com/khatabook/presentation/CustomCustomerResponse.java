package com.khatabook.presentation;

public class CustomCustomerResponse {
	private int status_code;
	private String messsage_tag;
	private String message;
	private CustomCustomer customCustomer;
	
	public CustomCustomerResponse(int status_code, String messsage_tag, String message, CustomCustomer customCustomer) {
		super();
		this.status_code = status_code;
		this.messsage_tag = messsage_tag;
		this.message = message;
		this.customCustomer = customCustomer;
	}
	
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	public String getMesssage_tag() {
		return messsage_tag;
	}
	public void setMesssage_tag(String messsage_tag) {
		this.messsage_tag = messsage_tag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomCustomer getCustomCustomer() {
		return customCustomer;
	}
	public void setCustomCustomer(CustomCustomer customCustomer) {
		this.customCustomer = customCustomer;
	}
	
}
