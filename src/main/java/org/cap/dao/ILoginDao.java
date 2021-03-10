package org.cap.dao;

import org.cap.model.Customer;

public interface ILoginDao {

	public boolean validateLogin(int customerId, String custPwd);
	public String getCustomerName(int customerId);
	public Customer findCustomer(int customerId);
}
