package org.cap.service;

import java.util.Map;

import org.cap.dao.ILoginDao;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private ILoginDao loginDao;

	@Override
	public boolean validateLogin(int customerId, String custPwd) {
		
		return loginDao.validateLogin(customerId, custPwd);
	}

	@Override
	public String getCustomerName(int customerId) {
		
		return loginDao.getCustomerName(customerId);
	}

	@Override
	public Customer findCustomer(int customerId) {
		
		return loginDao.findCustomer(customerId);
	}
	
	
	

}
