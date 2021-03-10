package org.cap.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String customerPwd;
	private String status;
	private Date lastLoginDate;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	

	@OneToMany(targetEntity=Account.class,mappedBy="customer",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Account> accounts;
	
	@OneToMany(targetEntity=Transaction.class,mappedBy="customer",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Transaction> transactions;

	
	public Customer() {
		
	}
	
	public Customer(int customerId, String customerPwd, String status, Date lastLoginDate, String firstName,
			String lastName, String email, String mobile, List<Account> accounts, List<Transaction> transactions) {
		super();
		this.customerId = customerId;
		this.customerPwd = customerPwd;
		this.status = status;
		this.lastLoginDate = lastLoginDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.accounts = accounts;
		this.transactions = transactions;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPwd() {
		return customerPwd;
	}

	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/*@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPwd=" + customerPwd + ", status=" + status
				+ ", lastLoginDate=" + lastLoginDate + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", mobile=" + mobile + ", accounts=" + accounts + ", transactions="
				+ transactions + "]";
	}
	*/
	
	
}
