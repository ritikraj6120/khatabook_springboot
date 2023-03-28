package com.khatabook.presentation;


public class CustomCustomer {
	private Long id;
    private String name;
    private String phone;
    private Long userId;
    
	public CustomCustomer(Long id, String name, String phone, Long userId) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.userId = userId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
