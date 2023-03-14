package com.customerService.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.Operator;
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer>{
	
	Operator findByEmail(String email);

	List<Operator> findByDepartmentName(String departmentName);
}
