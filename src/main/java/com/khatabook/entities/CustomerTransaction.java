package com.khatabook.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerTransaction {
	@Id
	@GeneratedValue
	private long id;
	
	@ColumnDefault("0")
	private long lendamount_singleCustomer;
	
	@ColumnDefault("0")
	private long takeamount_singleCustomer;
	
	private String billNo;
	
	private String billDetails;
	
	@Column (columnDefinition = "timestamp default current_timestamp" )
	private LocalDateTime date;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "customer", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;
	
	public CustomerTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerTransaction(long id, long lendamount_singleCustomer, long takeamount_singleCustomer, String billNo,
			String billDetails, LocalDateTime date, Customer customer) {
		super();
		this.id = id;
		this.lendamount_singleCustomer = lendamount_singleCustomer;
		this.takeamount_singleCustomer = takeamount_singleCustomer;
		this.billNo = billNo;
		this.billDetails = billDetails;
		this.date = date;
		this.customer = customer;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLendamount_singleCustomer() {
		return lendamount_singleCustomer;
	}

	public void setLendamount_singleCustomer(long lendamount_singleCustomer) {
		this.lendamount_singleCustomer = lendamount_singleCustomer;
	}

	public long getTakeamount_singleCustomer() {
		return takeamount_singleCustomer;
	}

	public void setTakeamount_singleCustomer(long takeamount_singleCustomer) {
		this.takeamount_singleCustomer = takeamount_singleCustomer;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(String billDetails) {
		this.billDetails = billDetails;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
