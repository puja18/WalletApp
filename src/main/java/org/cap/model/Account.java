package org.cap.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	
	@Column(unique=true)
	private long accountNo;
	private String accountType;
	private double openingBalance;
	private Date openingDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	private String status;
	
	@Transient
	private double updateBalance;
	
	
	
	
	@OneToMany(targetEntity=Transaction.class,mappedBy="fromAccount")
	private List<Transaction> fromTransactions;
	
	@OneToMany(targetEntity=Transaction.class,mappedBy="toAccount")
	private List<Transaction> toTransactions;

	
	private int years;
	
	
	public Account() {
		
	}
	
	public Account(int accountId, long accountNo, String accountType, double openingBalance, Date openingDate,
			Customer customer, String status, List<Transaction> fromTransactions, List<Transaction> toTransactions) {
		super();
		this.accountId = accountId;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.openingDate = openingDate;
		this.customer = customer;
		this.status = status;
		this.fromTransactions = fromTransactions;
		this.toTransactions = toTransactions;
	}
	
	

	public Account(int accountId, long accountNo, String accountType, double openingBalance, Date openingDate,
			Customer customer, String status, double updateBalance, List<Transaction> fromTransactions,
			List<Transaction> toTransactions, int years) {
		super();
		this.accountId = accountId;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.openingDate = openingDate;
		this.customer = customer;
		this.status = status;
		this.updateBalance = updateBalance;
		this.fromTransactions = fromTransactions;
		this.toTransactions = toTransactions;
		this.years = years;
	}

	public Account(int accountId, long accountNo, String accountType, double openingBalance, Date openingDate,
			Customer customer, String status, List<Transaction> fromTransactions, List<Transaction> toTransactions,
			int years) {
		super();
		this.accountId = accountId;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.openingDate = openingDate;
		this.customer = customer;
		this.status = status;
		this.fromTransactions = fromTransactions;
		this.toTransactions = toTransactions;
		this.years = years;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Transaction> getFromTransactions() {
		return fromTransactions;
	}

	public void setFromTransactions(List<Transaction> fromTransactions) {
		this.fromTransactions = fromTransactions;
	}

	public List<Transaction> getToTransactions() {
		return toTransactions;
	}

	public void setToTransactions(List<Transaction> toTransactions) {
		this.toTransactions = toTransactions;
	}
	
	
	

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	
	
	public double getUpdateBalance() {
		return updateBalance;
	}

	public void setUpdateBalance(double updateBalance) {
		this.updateBalance = updateBalance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNo=" + accountNo + ", accountType=" + accountType
				+ ", openingBalance=" + openingBalance + ", openingDate=" + openingDate + ", customer=" 
				+ ", status=" + status + ", fromTransactions=" + ", toTransactions=" 
				+ ", years=" + years + "]";
	}

	
	
	
}
