package com.customerService.app.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.CustomerJwt;
import com.customerService.app.Entity.LoginDTO;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Service.CustomerService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

/************************************************************************************
 * @author        Shaswat Jain
 
 * Description    It is a Customer Controller class where basically the flow of the data is controlled. 
                  It controls the data flow into model object and updates the view whenever data changes.
                  
 *Version         1.0                
 *Created Date    12-FEB-2023
 ************************************************************************************/
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody @Valid Customer addCustomer)throws CustomerException
	{
		return customerService.addCustomer(addCustomer);
		
	}
		
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody @Valid Customer updateCustomer)throws CustomerException
	{
		return customerService.updateCustomer(updateCustomer);
//		return "Customer Id:"+updatedCustomer.getCustomerId()+" Details Updated Successfully";
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable("id") Integer customerId)throws CustomerException
	{
		return customerService.getCustomerById(customerId);
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomerById(@PathVariable("id") Integer customerId)throws CustomerException
	{
		Customer getCustomer=customerService.deleteCustomerById(customerId);
		return "Customer Id:"+customerId+" Details Deleted Successfully";
	}
	
//	@GetMapping("/customers")
//	public List<Customer> getAllCustomer()
//	{
//		return customerService.getAllCustomer();
//	}
	
	@GetMapping("/customers/{jwt}")
	public List<Customer> getAllCustomer(@PathVariable("jwt") String jwt)throws CustomerException
	{
		if(jwt == null)
		{
			throw new CustomerException("Unauthenticated !");
		}

		try {
		Claims claim = Jwts.parser().setSigningKey("Customer123").parseClaimsJws(jwt).getBody();
		//String email = claim.getIssuer();
		return this.customerService.getAllCustomer();		
		}
		catch(ExpiredJwtException e) {
			throw new CustomerException("JWT got expired please try re loging. ");
		}
		catch(SignatureException e) {
			throw new CustomerException("JWT SignatureException. ");
		}
		 
		catch (Exception e) {
			throw new CustomerException("Unauthenticated !");
		}
		
	}
	
	@PostMapping("/customer/login")
	public Customer loginCustomer(@RequestBody LoginDTO login) throws CustomerException{
		return this.customerService.loginCustomer(login.getEmail(), login.getPassword());
	}
	
//		@PostMapping("/customer/loginCredentials")
//		public CustomerJwt loginCustomer(@RequestBody Customer customerCredentials,HttpServletResponse response) throws CustomerException{
//		
//		//Cookie cookie=new Cookie("jwt",this.customerService.loginCustomer(customerCredentials));
//		//response.addCookie(cookie);
//		String jwt= this.customerService.loginCustomer(customerCredentials);
//		Customer customer=this.customerService.loginCustomerCredentials(customerCredentials);
//		return new CustomerJwt(customer,jwt);
//	}
	
	 @PutMapping("/customer/changepassword/{id}")
	 public Customer changePassword(@PathVariable ("id") Integer customerId, @RequestBody String password) {
		 return this.customerService.changePassword(customerId, password);
	 }
}
