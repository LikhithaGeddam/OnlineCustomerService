package com.customerService.app.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Repository.CustomerRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/************************************************************************************
 * @author        Shaswat Jain
 
 * Description    It is a Service class that provides the service methods for adding a new Customer, 
                  Updating existing Customer details ,Deleting Customer details By Id, Fetching Details of a Customer by Id,
                  Fetching all Customers Details, Fetching all call details of a Customer By Id.
                  
 *Version         1.0                
 *Created Date    09-FEB-2023
 ************************************************************************************/

@Service
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer addCustomer) throws CustomerException{
		
		Customer getCustomerByEmail=customerRepository.findByEmail(addCustomer.getEmail());
		if(getCustomerByEmail != null)
		{
			throw new CustomerException("Cannot create new Customer As Email Already Exists");
		}
		
		Customer getCustomerByMobileNumber=customerRepository.findByMobileNumber(addCustomer.getMobileNumber());
		if(getCustomerByMobileNumber!= null)
		{
			throw new CustomerException("Cannot create new Customer As Mobile Number Already Exists");
		}
		return customerRepository.save(addCustomer);
	}
	
	@Override
	public Customer updateCustomer(Customer updateCustomer) throws CustomerException {
		
		Optional<Customer> getCustomerById=customerRepository.findById(updateCustomer.getCustomerId());
		if(getCustomerById.isEmpty())
		{
			throw new CustomerException("Cannot Update Customer Details As Customer Id not found");
		}
		
		
		Customer getCustomerByEmail=customerRepository.findByEmail(updateCustomer.getEmail());
		if(getCustomerByEmail != null)
		{
			if(getCustomerByEmail.getCustomerId()!=updateCustomer.getCustomerId())
			{
				throw new CustomerException("Cannot Update Customer Details As Email Already Exists");
			}
		}
		
		Customer getCustomerByMobileNumber=customerRepository.findByMobileNumber(updateCustomer.getMobileNumber());
		if(getCustomerByMobileNumber!=null)
		{
			if(getCustomerByMobileNumber.getCustomerId()!=updateCustomer.getCustomerId())
			{
				throw new CustomerException("Cannnot Update Customer Details As Mobile Number Already Exists");
			}
		}
		return customerRepository.save(updateCustomer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		
		Optional<Customer> getCustomer=customerRepository.findById(customerId);
		if(getCustomer.isEmpty())
		{
			throw new CustomerException("Customer ID Not Found");
		}
		return getCustomer.get();
		
	}
    

	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerException {
		
		Optional<Customer> getCustomer=customerRepository.findById(customerId);
		if(getCustomer.isEmpty())
		{
			throw new CustomerException("Invalid Customer Details");
		}
		customerRepository.deleteById(customerId);
		return getCustomer.get();
	}


	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByEmailId(String emailId) throws CustomerException {
		Customer customer = customerRepository.findByEmail(emailId);
		if(customer == null) {
			throw new CustomerException("User not found");
		}
		return customer;
	}



	@Override
	public Customer loginCustomer(String emailId, String password) throws CustomerException {
		Customer customerFound=customerRepository.findByEmail(emailId);
		if(customerFound==null){
			throw new CustomerException("Email Id does not exists");
		}
		if(customerFound.getPassword()==null || !customerFound.getPassword().equals(password)){
			throw new CustomerException("password is incorrect");
		}
		return customerFound;
	}



	@Override
	public Customer changePassword(Integer id, String password) {
		if (customerRepository.existsById(id)) {
			Customer customer=customerRepository.findById(id).get();
			customer.setPassword(password);
			customerRepository.save(customer);
			return customer;
		}
		else {
			return null;
		}
	}

	@Override
	public Customer loginCustomerCredentials(Customer customerCredentials) throws CustomerException {
		Customer customerFound=customerRepository.findByEmail(customerCredentials.getEmail());
		if(customerFound==null){
			throw new CustomerException("Email Id does not exists");
		}
		if(customerFound.getPassword()==null || !customerFound.getPassword().equals(customerCredentials.getPassword())){
			throw new CustomerException("password is incorrect");
		}
		return customerFound;
	}

//	@Override
//	public String loginCustomer(Customer customerCredentials) throws CustomerException {
//		Customer customerFound=customerRepository.findByEmail(customerCredentials.getEmail());
//		if(customerFound==null){
//			throw new CustomerException("Email Id does not exists");
//		}
//		if(customerFound.getPassword()==null || !customerFound.getPassword().equals(customerCredentials.getPassword())){
//			throw new CustomerException("password is incorrect");
//		}
//		
//    	String issuer=customerFound.getEmail();
//        Date expiry=new Date(System.currentTimeMillis()+(60*60*1000));		
//    	return Jwts.builder().setIssuer(issuer).setExpiration(expiry).signWith(SignatureAlgorithm.HS512,"Customer123").compact();
//	
//	}
	

}