package com.customerService.app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerService.app.Entity.Department;
import com.customerService.app.Exception.DepartmentException;
import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Service.DepartmentService;
import com.customerService.app.util.JwtTokenMalformedException;
import com.customerService.app.util.JwtTokenMissingException;
import com.customerService.app.util.JwtUtil;

/************************************************************************************
 * @author        Siva Sai Mounika Penneru
 
 * Description    It is a Department Controller class where basically the flow of the data is controlled. 
                  It controls the data flow into model object and updates the view whenever data changes.
                  
 *Version         1.0                
 *Created Date    12-FEB-2023
 ************************************************************************************/
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/department")
	public Department addDepartment(@Valid @RequestBody Department newDepartment) {
		
		return departmentService.addDepartment(newDepartment);
		
	}
	
	@DeleteMapping("/department/{id}")
	public Department deleteDepartment(@PathVariable("id") Integer departmentId) throws DepartmentIdNotFoundException {
		
			return this.departmentService.removeDepartment(departmentId);
		
	}
	
	@PutMapping("/department/{departmentId}/")
	public Department modifyDepartment(@PathVariable("departmentId") Integer departmentId, @RequestBody Department newDepartment) {
		try {
			return departmentService.modifyDepartmentById(departmentId, newDepartment);
		} 
		catch (DepartmentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/department/{id}/")
	public Department findDepartmentById(@PathVariable ("id") Integer departmentId) {
		try {
			return departmentService.findDepartmentById(departmentId);
		} 
	catch (DepartmentIdNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
//	public List<Department> getAllDepartments(@CookieValue("jwt") String jwt) throws JwtTokenMalformedException, JwtTokenMissingException, DepartmentException{
//	if(jwt == null)
//		throw new DepartmentException("Unauthenticated !");
//	JwtUtil.validateToken(jwt);
	return departmentService.getAllDepartment();
	}

}
