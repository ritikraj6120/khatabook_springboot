
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
public class SupplierTransaction {
	@Id
	@GeneratedValue
	private long id;
	
	@ColumnDefault("0")
	private long purchase_singleSupplier;
	
	@ColumnDefault("0")
	private long payment_singleSupplier;
	
	private String billNo;
	
	private String billDetails;
	
	@Column (columnDefinition = "timestamp default current_timestamp" )
	private LocalDateTime date;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "supplier", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Supplier supplier;

	public SupplierTransaction(long id, long purchase_singleSupplier, long payment_singleSupplier, String billNo,
			String billDetails, LocalDateTime date, Supplier supplier) {
		super();
		this.id = id;
		this.purchase_singleSupplier = purchase_singleSupplier;
		this.payment_singleSupplier = payment_singleSupplier;
		this.billNo = billNo;
		this.billDetails = billDetails;
		this.date = date;
		this.supplier = supplier;
	}

	public SupplierTransaction() {
		super();
		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getPurchase_singleSupplier() {
		return purchase_singleSupplier;
	}

	public void setPurchase_singleSupplier(long purchase_singleSupplier) {
		this.purchase_singleSupplier = purchase_singleSupplier;
	}

	public long getPayment_singleSupplier() {
		return payment_singleSupplier;
	}

	public void setPayment_singleSupplier(long payment_singleSupplier) {
		this.payment_singleSupplier = payment_singleSupplier;
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
