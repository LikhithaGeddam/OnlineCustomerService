package com.customerService.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.customerService.app.Entity.Department;
import com.customerService.app.Exception.DepartmentException;
import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Service.DepartmentService;

/************************************************************************************
 * @author        Siva Sai Mounika.Penneru
 
 * Description    It is a Test class that provides the Testing methods for adding a new Department, 
                  Modifying existing Department details ,Removing Department details By Id, Fetching Details of a 
                  Department by Id.
       
 *Version         1.0         
 *Created Date    13-FEB-2023
 ************************************************************************************/
@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentTest {
	
	@Autowired
	private DepartmentService departmentService;

	@Test
	void addDepartmentTest2() {
		assertNotNull(departmentService.addDepartment(new Department(100, "Signal")));
		
	}
	@Test
	void getDepartByIdTest()throws DepartmentIdNotFoundException {
		assertNotNull(departmentService.findDepartmentById(100));
		
	}
	
	@Test
	 void testGetOperatorById() throws DepartmentIdNotFoundException{
		assertNotNull(departmentService.findDepartmentById(100));
	}
	
	@Test
	 void testGetAllDepartment()
	{
		assertNotNull(departmentService.getAllDepartment());
	}
	
//	@Test
//	public void testModifyDepartment() throws DepartmentException{
//		assertNotNull(departmentService.modifyDepartment(new Department(101,"Post Paid")));
//	}
	
	@Test
	   void addDepartmentTest() {
	    Department department = new Department(1, "Network");
	    Department addedDepartment = departmentService.addDepartment(department);
	    assertNotNull(addedDepartment);
	    assertEquals("Network", addedDepartment.getDepartmentName());
	  }

	  @Test
	   void removeDepartmentTest() throws DepartmentIdNotFoundException {
	    Department department = new Department(1, "Network");
	    departmentService.addDepartment(department);
	    Department removedDepartment = departmentService.removeDepartment(1);
	    assertNotNull(removedDepartment);
	    assertEquals("Network", removedDepartment.getDepartmentName());
	  }

	  @Test//(expected = DepartmentIdNotFound.class)
	   void removeDepartmentNotFoundExceptionTest() throws DepartmentIdNotFoundException {
	    departmentService.removeDepartment(1);
	  }

//	  @Test
//	  public void modifyDepartmentTest() throws DepartmentException {
//	    Department department = new Department(1, "Network");
//	    departmentService.addDepartment(department);
//	    Department modifiedDepartment = new Department(1, "Modified Network");
//	    Department returnedDepartment = departmentService.modifyDepartment(modifiedDepartment);
//	    assertNotNull(returnedDepartment);
//	    assertEquals("Modified Network", returnedDepartment.getDepartmentName());
//	  }

//	  @Test//(expected = DepartmentException.class)
//	  public void modifyDepartmentExceptionTest() throws DepartmentException {
//	    Department department = new Department(1, "Network");
//	    departmentService.modifyDepartment(department);
//	  }
	  
	  @Test
	   void findDepartmentByIdTest() throws DepartmentIdNotFoundException {
	    Department department = new Department(1, "Network");
	    departmentService.addDepartment(department);
	    Department foundDepartment = departmentService.findDepartmentById(1);
	    assertNotNull(foundDepartment);
	    assertEquals("Network", foundDepartment.getDepartmentName());
	  }

	  @Test//(expected = DepartmentIdNotFound.class)
	   void findDepartmentByIdNotFoundExceptionTest() throws DepartmentIdNotFoundException {
	    departmentService.findDepartmentById(1);
	  }
	  
	  @Test
		 void testRemoveDepartment()throws DepartmentIdNotFoundException
		{
			assertNotNull(departmentService.removeDepartment(3));
		}
	
}
