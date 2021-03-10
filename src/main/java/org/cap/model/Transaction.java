package org.cap.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	private Date transactionDate;
	private String transactionType;
	
	@ManyToOne
	@JoinColumn(name="fromAccountNo")
	private Account fromAccount;
	
	@ManyToOne
	@JoinColumn(name="toAccountNo")
	private Account toAccount;
	
	
	private double amount;
	private String description;
	private String status;
	
	public Transaction() {
		
	}
	
	
	public Transaction(Customer customer, int transactionId, Date transactionDate, String transactionType,
			Account fromAccount, Account toAccount, double amount, String description, String status) {
		super();
		this.customer = customer;
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.description = description;
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/*@Override
	public String toString() {
		return "Transaction [customer=" + customer + ", transactionId=" + transactionId + ", transactionDate="
				+ transactionDate + ", transactionType=" + transactionType + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", amount=" + amount + ", description=" + description + ", status="
				+ status + "]";
	}
	
	*/
	
	
}
