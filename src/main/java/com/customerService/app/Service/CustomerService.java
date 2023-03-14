package com.customerService.app.Service;

import java.util.List;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Exception.CustomerException;

public interface CustomerService {
	
	Customer addCustomer(Customer addCustomer)throws CustomerException;
	
	Customer updateCustomer(Customer updateCustomer)throws CustomerException;
	
	Customer getCustomerById(Integer customerId) throws CustomerException;

	Customer deleteCustomerById(Integer customerId) throws CustomerException;
	
	Customer getCustomerByEmailId (String emailId) throws CustomerException;
	
	Customer loginCustomerCredentials(Customer customerCredentials) throws CustomerException;
	
	Customer loginCustomer (String emailId, String password)throws CustomerException;
	
//	String loginCustomer (Customer customerCredentials)throws CustomerException;
	
	Customer changePassword(Integer id, String password);

	List<Customer> getAllCustomer();
	

}
