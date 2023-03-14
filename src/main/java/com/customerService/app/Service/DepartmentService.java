package com.customerService.app.Service;

import java.util.List;

import com.customerService.app.Entity.Department;
import com.customerService.app.Exception.DepartmentException;
import com.customerService.app.Exception.DepartmentIdNotFoundException;

public interface DepartmentService {
	
	Department addDepartment(Department department);
	
	Department removeDepartment(Integer departmentId) throws DepartmentIdNotFoundException;
	
	Department modifyDepartmentById(Integer departmentId, Department modifyDepartment) throws DepartmentException;
	
	Department findDepartmentById(Integer departmentId) throws DepartmentIdNotFoundException;

	List<Department> getAllDepartment();

}
