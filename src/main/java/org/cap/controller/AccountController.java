package org.cap.controller;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.model.Transaction;
import org.cap.service.IAccountService;
import org.cap.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IAccountService acccountService;
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	

	@PostMapping("/validateLogin")
	public String validateLogin(ModelMap map, 
			@RequestParam("customerId") String customerId,
			@RequestParam("customerPwd") String customerPwd,
			HttpSession session) {
		
		Integer custId=Integer.parseInt(customerId);
		
		
		if(loginService.validateLogin(custId, customerPwd)) {
			//Store CustId into the session object
			session.setAttribute("custId", custId);
			
			String custName=loginService.getCustomerName(custId);
			map.put("custName", custName);
			
			return "main";
			
			
		}
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	@RequestMapping("/createAccount")
	public String showCreateAccountPage(ModelMap map) {
		
		map.put("account", new Account());
		return "createAccount";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccountDetails(HttpSession session,
			@ModelAttribute("account") Account account) {
		account.setOpeningDate(new Date());
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		
		Customer customer= loginService.findCustomer(customerId);
		/*Customer customer=new Customer();
		customer.setCustomerId(customerId);*/
		account.setCustomer(customer);
		
		account.setStatus("active");
		
		//System.out.println(account);
		
		acccountService.createAccount(account);
		
		return "redirect:createAccount";
	}
	
	@RequestMapping("/showBalance")
	public String showBalanceDetails(ModelMap map,
			HttpSession session) {
		
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
		List<Account> accounts= acccountService.getAccountWithBalance(custId);
		
		map.put("accounts", accounts);
		
		return "showBalance";
	}
	
	
	
	@RequestMapping("/depositWithdraw")
	public String depositWithdrawOperation(ModelMap map,
			HttpSession session) {
		
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
	
		List<Account> accounts= acccountService.getAllAccounts(custId);
		map.put("accounts", accounts);
		map.put("transaction1", new Transaction());
		
		return "depositWithdraw";
	}
	
	
	@PostMapping(value="/addTransaction")
	public String addTransaction(
			@ModelAttribute("transaction1") Transaction transaction1,
			HttpSession session) {
		
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		
		Customer customer= loginService.findCustomer(customerId);
		
		transaction1.setTransactionDate(new Date());
		transaction1.setStatus("completed");
		transaction1.setCustomer(customer);
		
		long accNo=transaction1.getFromAccount().getAccountNo();
		Account account=acccountService.findAccount(accNo);
		transaction1.setFromAccount(account);
		
		acccountService.addTransaction(transaction1);
		
		return "redirect:depositWithdraw";
	}
	
	
	@RequestMapping("/fundTransfer")
	public String fundTransfer(ModelMap map,HttpSession session) {

		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
	
		List<Account> accounts= acccountService.getAllAccounts(custId);
		List<Account> otheraccounts= acccountService.getAllOtherAccounts(custId);
		
		map.put("accounts", accounts);
		map.put("otheracc", otheraccounts);
		map.put("txs", new Transaction());
		return "fundTransfer";
	}
	
	
	
	@PostMapping("/doFundTransfer")
	public String doFundTransfer(@ModelAttribute("txs") Transaction transaction,
			HttpSession session) {
		
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
		Customer customer= loginService.findCustomer(custId);
		transaction.setCustomer(customer);
		transaction.setTransactionDate(new Date());
		Account fromAcc=acccountService.findAccount(transaction.getFromAccount().getAccountNo());
		transaction.setFromAccount(fromAcc);
		
		Account toAcc=acccountService.findAccount(transaction.getToAccount().getAccountNo());
		transaction.setToAccount(toAcc);
		
		transaction.setTransactionType("debit");
		transaction.setStatus("completed");
		
		acccountService.addTransaction(transaction);
		
		Transaction transaction2=new Transaction();
		long accNo=transaction.getToAccount().getAccountNo();
		
		Customer customer2=acccountService.findCustomerFor_AccNo(accNo);
		
		transaction2.setCustomer(customer2);
		transaction2.setTransactionDate(new Date());
		transaction2.setTransactionType("credit");
		transaction2.setFromAccount(toAcc);
		transaction2.setToAccount(fromAcc);
		transaction2.setStatus("completed");
		transaction2.setDescription(transaction.getDescription());
		transaction2.setAmount(transaction.getAmount());
		
		acccountService.addTransaction(transaction2);
		
		return "redirect:fundTransfer";
	}
	
	@RequestMapping("/printTransaction")
	public String printTransaction() {
		return "printTransaction";
	}
	
	@RequestMapping("/printTrans")
	public String printTransactions(
			@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,
			ModelMap map) {
	//	System.out.println(fromDate + "-->" + toDate); 
		
		
		String[] dates=fromDate.split("-");
		Date fromTxDate=new Date(Integer.parseInt(dates[0])-1900,
				Integer.parseInt(dates[1])-1,
				Integer.parseInt(dates[2]));
		//System.out.println(fromTxDate);
		
		
		String[] todates=toDate.split("-");
		Date toTxDate=new Date(Integer.parseInt(todates[0])-1900,
				Integer.parseInt(todates[1])-1,
				Integer.parseInt(todates[2]));
		
		List<Transaction> transactions= acccountService.findTransactions(fromTxDate, toTxDate);
		map.put("txs", transactions);
		
		System.out.println(transactions);
		return "printTransaction";
	}
	
}
