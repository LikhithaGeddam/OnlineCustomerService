package com.customerService.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.customerService.app.Entity.Operator;
import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Exception.NoOperatorsListFoundException;
import com.customerService.app.Exception.OperatorIdNotFoundException;
import com.customerService.app.Repository.DepartmentRepository;
import com.customerService.app.Repository.OperatorRepository;
import com.customerService.app.Service.DepartmentService;
import com.customerService.app.Service.OperatorService;

/************************************************************************************
 * @author        Likhitha Geddam
 
 * Description    It is a Test class that provides the Testing methods for adding a new Operator, 
                  Updating existing Operator details ,Deleting Operator details By Department Id, Fetching Details of a 
                  Operator by Id, Fetching all Operator Details, Fetching all Operator details of a Department.
       
 *Version         1.0         
 *Created Date    10-FEB-2023
 ************************************************************************************/
@SpringBootTest
public class OperatorTest {
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private OperatorRepository operatorRepository;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
//	@Test
//	public void addOperatorTest() throws  DepartmentIdNotFoundException {
//		assertNotNull(operatorService.addOperatorToDepartmentById(new Operator(31,"Sowmya","Bura","sowmya@yahoo.com","7997249928","Karimnagar"),5));
//	}
	
//	@Test
//	public void testCreateOperatorException() 
//	{
//		assertThrows(DepartmentIdNotFoundException.class,()->operatorService.addOperatorToDepartmentById(new Operator(90,"Hamster","Sloth","Tapirus@gmail.com","Ape","Armadillos"),10));
//	}
//	
//	@Test
//	public void testCreateOperatorException2() 
//	{
//		assertThrows(DepartmentIdNotFoundException.class,()->operatorService.addOperatorToDepartmentById(new Operator(93,"Hamster","Sloth","Tapirus@gmail.com","Ape","Armadillos"),10));
//	}
	
	@Test
	public void testGetOperatorById() throws OperatorIdNotFoundException
	{
		assertNotNull(operatorService.getOperatorById(23));
	}
	
	@Test
	public void testGetOperatorById1() throws OperatorIdNotFoundException
	{
		assertNotNull(operatorService.getOperatorById(24));
	}
	
	@Test
	public void testGetOperatorById2() throws OperatorIdNotFoundException
	{
		assertNotNull(operatorService.getOperatorById(25));
	}
	
	@Test
	public void testGetOperatorById3() throws OperatorIdNotFoundException
	{
		assertNotNull(operatorService.getOperatorById(26));
	}
	
	@Test
	public void testGetOperatorByIdException() 
	{
		assertThrows(OperatorIdNotFoundException.class,()->operatorService.getOperatorById(98));
	}
	
	@Test
	public void testGetAllOperators() throws NoOperatorsListFoundException
	{
		assertNotNull(operatorService.getAllOperators());
	}
	
//	@Test
//	public void testUpdateOperatorByIdException()
//	{
//		assertThrows(OperatorIdNotFoundException.class, ()->operatorService.updateOperatorById(2, new Operator(26, "Sneha", "Ullal", "sneha@yahoo.com", "9898988998", "Banglore")));
//	}
	
//	@Test
//	public void testGetOperatorsByDepartmentIdException()
//	{
//		assertThrows(DepartmentIdNotFoundException.class,()->operatorService.getOperatorsByDepartmentByName("Network"));
//	}

	@Test 
	public void getOperatorByIdTestException() {
		
		String msg = null;
		
			try {
				operatorService.getOperatorById(100);
			} 
			catch (OperatorIdNotFoundException e) {
				e.printStackTrace();
			}
		
		assertEquals("!!! Operator ID Not Found !!!", msg);
	}

	@Test
	public void deleteOperatorFromDepartmentByIdExceptionTest()  
	{
		assertThrows(DepartmentIdNotFoundException.class, ()->operatorService.deleteOperatorFromDepartmentById(20,21));
	}
	
//	@Test
//	public void getOperatorsByDepartmentIdTestException() {
//		
//		String msg = null;
//		String msg1 = null;
//			try {
//				operatorService.getOperatorsByDepartmentId(25);
//			} 
//			catch (DepartmentIdNotFoundException e) {
//				msg = e.getMessage();
//			} 
//			catch (NoOperatorsListFoundException e) {
//				msg1 = e.getMessage();
//			}
//		assertEquals("Department Id does not Exist", msg);
//		assertEquals("!!! Operator ID Not Found !!!", msg1);
//	}
	
}
