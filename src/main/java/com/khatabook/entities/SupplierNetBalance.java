
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
public class SupplierNetBalance {
	@Id
	@GeneratedValue
	private long id;
	
	@ColumnDefault("0")
	private long payment;
	
	@ColumnDefault("0")
	private long purchase;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "user", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "supplier", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Supplier supplier;

	public SupplierNetBalance(long id, long payment, long purchase, User user, Supplier supplier) {
		super();
		this.id = id;
		this.payment = payment;
		this.purchase = purchase;
		this.user = user;
		this.supplier = supplier;
	}

	public SupplierNetBalance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPayment() {
		return payment;
	}

	public void setPayment(long payment) {
		this.payment = payment;
	}

	public long getPurchase() {
		return purchase;
	}

	public void setPurchase(long purchase) {
		this.purchase = purchase;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}
