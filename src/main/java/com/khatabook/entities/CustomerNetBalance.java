package com.khatabook.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerNetBalance {
	@Id
	@GeneratedValue
	private long id;
	
	@ColumnDefault("0")
	private long amounttoget;
	
	@ColumnDefault("0")
	private long amounttogive;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "user", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "customer", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;
	
	

	public CustomerNetBalance(long id, long amounttoget, long amounttogive, User user, Customer customer) {
		super();
		this.id = id;
		this.amounttoget = amounttoget;
		this.amounttogive = amounttogive;
		this.user = user;
		this.customer = customer;
	}
	
	public CustomerNetBalance() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAmounttoget() {
		return amounttoget;
	}

	public void setAmounttoget(long amounttoget) {
		this.amounttoget = amounttoget;
	}

	public long getAmounttogive() {
		return amounttogive;
	}

	public void setAmounttogive(long amounttogive) {
		this.amounttogive = amounttogive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
