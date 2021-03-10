package org.cap.service;

import org.cap.model.Customer;

public interface ILoginService {
	public boolean validateLogin(int customerId, String custPwd);
	public String getCustomerName(int customerId);
	public Customer findCustomer(int customerId) ;
}
