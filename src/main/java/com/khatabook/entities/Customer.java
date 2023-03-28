package com.khatabook.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false,unique = true)
	private String phone;
	
	@Column (columnDefinition = "timestamp default current_timestamp" )
	private LocalDateTime date;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	
	public Customer(Long id, String name, String phone,LocalDateTime date,User user) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.user = user;
	}
	
	public Customer() {
		
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", phone=" + phone + ", date=" + date + ", user=" + user
				+ "]";
	}

	

}

