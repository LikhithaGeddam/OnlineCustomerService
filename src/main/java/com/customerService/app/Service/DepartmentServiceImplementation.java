package com.customerService.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerService.app.Entity.Department;
import com.customerService.app.Entity.Issue;
import com.customerService.app.Exception.DepartmentException;
import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Exception.IssueException;
import com.customerService.app.Repository.DepartmentRepository;

/***********************************************************************************
* @author        Siva SaiMounika.Penneru
* Description    It is a Service class that provides the service methods for adding a new Department, 
                 Modifying existing Department details ,Deleting Department details By Id, Fetching Details of a Department by Id,
                 Fetching all Department Details.
                 
*Version         1.0                
*Created Date    09-FEB-2023
************************************************************************************/
@Service
public class DepartmentServiceImplementation implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {

		return departmentRepository.save(department);
	}
	

	@Override
	public Department removeDepartment (Integer departmentId) throws DepartmentIdNotFoundException {
		Optional<Department> optDepartment = this.departmentRepository.findById(departmentId);
				if(optDepartment.isEmpty()) {
					throw new DepartmentIdNotFoundException("Department ID doesn't exist to delete");
				}
				
		Department department = optDepartment.get();
		this.departmentRepository.delete(department);
		return department;
	
	}
	

	@Override
	
	public Department modifyDepartmentById(Integer departmentId, Department modifyDepartment) throws DepartmentException {
		Optional<Department> optDept = departmentRepository.findById(modifyDepartment.getDepartmentId());
		if(optDept.isEmpty()) {
			throw new DepartmentException("Invalid Department");
		}
		return departmentRepository.save(modifyDepartment);
		
	}   

	public List<Department> getAllDepartment() {
		
		return this.departmentRepository.findAll();
	
	}


    @Override
	public Department findDepartmentById(Integer departmentId) throws DepartmentIdNotFoundException {
    	Optional<Department> optDepartment = departmentRepository.findById(departmentId);
    	if(optDepartment == null) {
    		throw new DepartmentIdNotFoundException("Department ID not found");
    	}
    	return optDepartment.get();
	}
  
}
