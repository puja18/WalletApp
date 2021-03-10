package org.cap.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createAccount(Account account) {
		
		Query query= entityManager.createQuery("select max(accountNo) from Account");
		
		List<Long> max= query.getResultList();
		
		account.setAccountNo(max.get(0)+1);
		
		//System.out.println(account);
		
		entityManager.persist(account);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAllAccounts(int customerId) {
		
		Query query= entityManager
			.createQuery("from Account acc where acc.customer.customerId=:custId");
		
		query.setParameter("custId", customerId);
		
		
		List<Account> accounts= query.getResultList();
		
		
		return accounts;
	}
	
	
	
	@Transactional(readOnly=true)
	public Map<Account, Double> getAmoutCrDe(String strQuery,int customerId){
	
		
		Query query2=entityManager
				.createQuery(strQuery);
		
		query2.setParameter("custId", customerId);
		
		List<Transaction> transactions=query2.getResultList();
		Map<Account, Double> map=
		transactions.stream()
				.collect(
				Collectors.groupingBy(Transaction::getFromAccount,
					Collectors.summingDouble(Transaction::getAmount))
				);
		return map;
	}

	@Transactional
	public void addTransaction(Transaction transaction1) {
		//System.out.println("Transaction complete............");
		entityManager.persist(transaction1);
		
	}

	@Override
	public Account findAccount(long accountNo) {
		Query query= entityManager.createQuery("from Account where accountNo=:accno");
		query.setParameter("accno", accountNo);
		List<Account> accounts= query.getResultList();
		return accounts.get(0);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAllOtherAccounts(int customerId) {
		Query query= entityManager
				.createQuery("from Account acc where acc.customer.customerId!=:custId");
			
			query.setParameter("custId", customerId);
			
			
			List<Account> accounts= query.getResultList();
			
			
			return accounts;
	}

	@Override
	@Transactional(readOnly=true)
	public Customer findCustomerFor_AccNo(long accNo) {
		Query query= entityManager
				.createQuery("from Account acc where acc.accountNo=:accountNo");
		query.setParameter("accountNo", accNo);
		List<Account> account=query.getResultList();
		
		return account.get(0).getCustomer();
	}

	@Override
	public List<Transaction> findTransactions(Date fromDate, Date toDate) {
		
		
		Query query=entityManager.createQuery("from  Transaction tx where tx.transactionDate>=:fromDate and "
				+ "tx.transactionDate<=:toDate");
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		
		List<Transaction> transactions=query.getResultList();
		return transactions;
	}
	
	
}
 