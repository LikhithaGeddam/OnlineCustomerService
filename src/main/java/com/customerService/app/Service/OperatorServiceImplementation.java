package com.customerService.app.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.Department;
import com.customerService.app.Entity.Issue;
import com.customerService.app.Entity.Operator;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Exception.DepartmentException;
import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Exception.NoOperatorsListFoundException;
import com.customerService.app.Exception.OperatorException;
import com.customerService.app.Exception.OperatorIdNotFoundException;
import com.customerService.app.Repository.DepartmentRepository;
import com.customerService.app.Repository.IssueRepository;
import com.customerService.app.Repository.OperatorRepository;

/************************************************************************************
 * @author        Likhitha Geddam
 
 * Description    It is a Service class that provides the service methods for adding a new Operator, 
                  Updating existing Operator details ,Fetching Details of a Operator by operator Id,
                  Fetching all Operators List, Assigning Operator to Departments By Id.
                  
 *Version         1.0 
                
 *Created Date    09-FEB-2023
 ************************************************************************************/
@Service
public class OperatorServiceImplementation implements OperatorService{
	@Autowired
	private OperatorRepository operatorRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private IssueRepository issueRepository;
	


	@Override
	public Operator addOperator(Operator newOperator){
		
		return operatorRepository.save(newOperator);
		
	}

	
	@Override
	public Operator getOperatorById(Integer operatorId) throws OperatorIdNotFoundException {

		Optional<Operator> optOperator = operatorRepository.findById(operatorId);
		if(optOperator.isEmpty()) {
			throw new OperatorIdNotFoundException("!!! Operator ID Not Found !!!");
		}
		return optOperator.get();
	}
	
	
	@Override
	public List<Operator> getAllOperators() throws NoOperatorsListFoundException {
		List<Operator> optOperator = this.operatorRepository.findAll();
		if(optOperator.isEmpty()) {
			throw new NoOperatorsListFoundException("!!! No Operators Found in the List !!!");
		}
		return this.operatorRepository.findAll();
	}
	
	
	@Override
	public Operator updateOperatorById(Integer operatorId, Operator updateOperator) throws OperatorException {
		Optional<Operator> findOperator = operatorRepository.findById(operatorId);
		if(findOperator.isEmpty()) {
			throw new OperatorException("No Department Found for Id :"+updateOperator.getOperatorId());
		}
		return operatorRepository.save(updateOperator);
	}

	
	@Override
	public Operator deleteOperatorFromDepartmentById(Integer departmentId, Integer operatorId) throws DepartmentIdNotFoundException, OperatorIdNotFoundException {
		Optional<Department> optDepartment = this.departmentRepository.findById(departmentId);
		if(optDepartment.isEmpty()) {
			throw new DepartmentIdNotFoundException("!!! Department Id "+departmentId+" Not Found !!!");
		}
		Department foundDepartment = optDepartment.get();
		Optional<Operator> optOperator = this.operatorRepository.findById(operatorId);
		if(optOperator.isEmpty()) {
			throw new OperatorIdNotFoundException("!!! Operator Id "+departmentId+" Not Found !!!");
		}
		Operator foundOperator = optOperator.get();
		foundDepartment.getOperatorList().remove(foundOperator);
		this.departmentRepository.save(foundDepartment);
		this.operatorRepository.delete(foundOperator);
		return foundOperator;
	
	}
	
	@Override
	public List<Issue> getIssuesBydept(String departmentName){
		Iterable<Issue> issue = issueRepository.findAll();
		List<Issue> issueList=new ArrayList<>();
		issue.forEach(issue1->{if(issue1.getIssueType().contains(departmentName))issueList.add(issue1);});
		return issueList;
	}
	
	
	@Override
	public List<Operator> getOperatorByDepartmentName(String departmentName) throws DepartmentException, NoOperatorsListFoundException{
		Optional<Department> optDepartment = this.departmentRepository.findByDepartmentName(departmentName);
		if(optDepartment.isEmpty()) {
			throw new DepartmentException("Department does not Exist");
		}
		Department department = optDepartment.get();
		if(department.getOperatorList().isEmpty()) {
			throw new NoOperatorsListFoundException("!!! No Operators Found in the List !!!");
			}
		List<Issue> issueList=this.issueRepository.findByIssueType(departmentName);
		if(issueList.isEmpty()) {
			//exception
		}
		for(Operator operator:department.getOperatorList()) {
			for(Issue issue:issueList) {
				operator.getIssueList().add(issue);
				}}
		return department.getOperatorList();
	}
	

//	@Override
//	public List<Operator> getOperatorByDepartmentName(String departmentName) throws DepartmentException, NoOperatorsListFoundException{
//		Optional<Department> optDepartment = this.departmentRepository.findByDepartmentName(departmentName);
//		if(optDepartment.isEmpty()) {
//			throw new DepartmentException("Department does not Exist");
//		}
//		Department opt = optDepartment.get();
//		if(opt.getOperatorList().isEmpty()) {
//			throw new NoOperatorsListFoundException("!!! No Operators Found in the List !!!");
//		}
//		return opt.getOperatorList();
//	}
	
	@Override
	public Operator loginOperator (String emailId, String password) throws OperatorException {
		Operator operatorFound=operatorRepository.findByEmail(emailId);
		if(operatorFound==null){
			throw new OperatorException("Email Id does not exists");
		}
		if(operatorFound.getPassword()==null || !operatorFound.getPassword().equals(password)){
			throw new OperatorException("password is incorrect");
		}
		return operatorFound;
	}


	@Override
	public Operator loginOperatorCredentials(Operator operatorCredentials) throws OperatorException {
		Operator operatorFound=operatorRepository.findByEmail(operatorCredentials.getEmail());
		if(operatorFound==null){
			throw new OperatorException("Email Id does not exists");
		}
		if(operatorFound.getPassword()==null || !operatorFound.getPassword().equals(operatorCredentials.getPassword())){
			throw new OperatorException("password is incorrect");
		}
		return operatorFound;
	}
	
	
}
