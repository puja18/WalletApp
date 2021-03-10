package org.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.cap.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("loginDao")
@javax.transaction.Transactional
public class LoginDaoImpl implements ILoginDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	public boolean validateLogin(int customerId, String custPwd) {
		Query query
			= entityManager.createQuery("from Customer where customerId=? and customerPwd=?");
		query.setParameter(0, customerId);
		query.setParameter(1, custPwd);
		
		List<Customer> customers= query.getResultList();
		if(!customers.isEmpty())
			return true;
		return false;
	}

	@Override
	public String getCustomerName(int customerId) {
		Query query
		= entityManager.createQuery("select cust.firstName from Customer cust where cust.customerId=:custId");
	query.setParameter("custId", customerId);
	List<String> customers= query.getResultList();
	
		return customers.get(0);
	}

	@Override
	public Customer findCustomer(int customerId) {
		
		Customer customer= entityManager.find(Customer.class, customerId);
		
		
		return customer;
	}
	


}
