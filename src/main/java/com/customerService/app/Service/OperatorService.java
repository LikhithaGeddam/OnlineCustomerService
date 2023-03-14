package com.customerService.app.Service;

import java.util.List;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.Issue;
import com.customerService.app.Entity.Operator;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Exception.DepartmentException;
import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Exception.NoOperatorsListFoundException;
import com.customerService.app.Exception.OperatorException;
import com.customerService.app.Exception.OperatorIdNotFoundException;

public interface OperatorService {
	
	Operator addOperator(Operator newOperator);
	
	Operator getOperatorById(Integer operatorId) throws OperatorIdNotFoundException;
	
	List<Operator> getAllOperators() throws NoOperatorsListFoundException;
	
	List<Issue> getIssuesBydept(String departmentName);
	
	Operator updateOperatorById(Integer operatorId, Operator updatOperator) throws OperatorException;
	
	Operator deleteOperatorFromDepartmentById(Integer departmentId, Integer operatorId) throws DepartmentIdNotFoundException, OperatorIdNotFoundException;
	
	List<Operator> getOperatorByDepartmentName(String departmentName)throws DepartmentException, NoOperatorsListFoundException;
	
	Operator loginOperator (String emailId, String password) throws OperatorException;
	
	Operator loginOperatorCredentials(Operator operatorCredentials) throws OperatorException;

}
