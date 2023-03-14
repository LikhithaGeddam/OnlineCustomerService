//package com.customerService.app;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.customerService.app.Entity.Call;
//import com.customerService.app.Entity.Customer;
//import com.customerService.app.Exception.CallException;
//import com.customerService.app.Exception.CustomerException;
//import com.customerService.app.Service.CustomerService;
///************************************************************************************
// * @author        Shaswat Jain
// 
// * Description    It is a Test class that provides the Testing methods for adding a new Customer, 
//                  Updating existing Customer details ,Deleting Customer details By Id, Fetching Details of a 
//                  Customer by Id, Fetching all Customers Details, Fetching all call details of a Customer.
//       
// *Version         1.0         
// *Created Date    10-FEB-2023
// ************************************************************************************/
//@SpringBootTest
//class CustomerTest {
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	
////	@Test
////	public void testCreateCustomer()throws CustomerException
////	{
////		assertNotNull(customerService.addCustomer(new Customer("Sakshi","Sinha","sakshi@gmail.com","9676676543","Jaipur")));
////	}
////	
////	@Test
////	public void testCreateCustomerEmailException()throws CustomerException
////	{
////		try
////		{
////			customerService.addCustomer(new Customer("Shiva","Reddy","Kailash@yahoo.com","9988876545","Gonda"));
////		}
////		catch(CustomerException exception)
////		{
////			String str="Cannot create new Customer As Email Already Exists";
////			
////			assertEquals(str,exception.getMessage());
////		}	
////	}
//	
////	@Test
////	public void testCreateCustomerMobileException()throws CustomerException
////	{
////		try
////		{
////			customerService.addCustomer(new Customer("Shiva","Reddy","Kailashee@yahoo.com","8877665544","Gonda"));
////		}
////		catch(CustomerException exception)
////		{
////			String str="Cannot create new Customer As Mobile Number Already Exists";
////			
////			assertEquals(str,exception.getMessage());
////		}	
////	}
//	
//	@Test
//	public void testUpdateCustomer() throws CustomerException
//	{
//		assertNotNull(customerService.updateCustomer(new Customer(101,"Shaswat","Jain","Shaswat@gmail.com","8877665544","Pune")));
//	}
//	
//	@Test
//	public void testUpdateCustomerIDException()throws CustomerException
//	{
//		assertThrows(CustomerException.class,()->customerService.updateCustomer(new Customer(500,"Yash","Jalan","Jalan@yahoo.com","7766554488","Karachi")));
//	}
//	
//	
//	@Test
//	public void testUpdateCustomerEmailException()throws CustomerException
//	{
//		try
//		{
//			customerService.updateCustomer(new Customer(100,"Shiva","Reddy","Shaswat@gmail.com","8877665544","Gonda"));
//		}
//		catch(CustomerException exception)
//		{
//			String str="Cannot Update Customer Details As Email Already Exists";
//			
//			assertEquals(str,exception.getMessage());
//		}	
//	}
//	
//	@Test
//	public void testUpdateCustomerMobileException()throws CustomerException
//	{
//		try
//		{
//			customerService.updateCustomer(new Customer(100,"Shiva","Reddy","Shaswatdd@gmail.com","8877665544","Gonda"));
//		}
//		catch(CustomerException exception)
//		{
//			String str="Cannnot Update Customer Details As Mobile Number Already Exists";
//			
//			assertEquals(str,exception.getMessage());
//		}	
//	}
//	
//	@Test
//	public void testGetCustomerById()throws CustomerException
//	{
//		assertNotNull(customerService.getCustomerById(101));
//	}
//	
//	@Test
//	public void testGetCustomerById2()throws CustomerException
//	{
//		try
//		{
//			customerService.getCustomerById(501);
//		}
//		catch(CustomerException exception)
//		{
//			String str="Customer ID Not Found";
//			assertEquals(str,exception.getMessage());
//		}
//	}
//	
//	@Test
//	public void testDeleteCustomerById()throws CustomerException
//	{
//			assertNotNull(customerService.deleteCustomerById(13));
//	}
//	
//	@Test
//	public void testDeleteCustomerById2()throws CustomerException
//	{
//		try
//		{
//			customerService.deleteCustomerById(501);
//		}
//		catch(CustomerException exception)
//		{
//			String str="Invalid Customer Details";
//			assertEquals(str,exception.getMessage());
//		}
//	}
//	
//	@Test
//	public void testGetAllCustomer()
//	{
//		assertNotNull(customerService.getAllCustomer());
//	}
//		@Test
//	public void testGetAllCallOfCustomer()throws CustomerException,CallException
//	{
//		List<Call> callList=customerService.getAllCallsOfCustomerById(100);
//		
//		assertEquals(2,callList.size());
//	}
//	
//	@Test
//	public void testGetAllCallOfCustomerException()throws CustomerException,CallException
//	{
//		assertThrows(CustomerException.class,()->customerService.getAllCallsOfCustomerById(501));
//	}
//	
//	@Test
//	public void testGetAllCallOfCustomerException2()throws CustomerException,CallException
//	{
//		assertThrows(CallException.class,()->customerService.getAllCallsOfCustomerById(100));
//	}
//}
