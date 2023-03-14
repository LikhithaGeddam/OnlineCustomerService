package com.customerService.app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.Issue;
import com.customerService.app.Entity.LoginDTO;
import com.customerService.app.Entity.Operator;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Exception.DepartmentException;
import com.customerService.app.Exception.NoOperatorsListFoundException;
import com.customerService.app.Exception.OperatorException;
import com.customerService.app.Exception.OperatorIdNotFoundException;
import com.customerService.app.Service.OperatorService;

/************************************************************************************
 * @author        Likhitha Geddam
 
 * Description    It is a Operator Controller class where basically the flow of the data is controlled. 
                  It controls the data flow into model object and updates the view whenever data changes.
                  
 *Version         1.0                
 *Created Date    12-FEB-2023
 ************************************************************************************/

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
//to create RESTful web services using Spring MVC
public class OperatorController {
	
	@Autowired
	private OperatorService operatorService;
	
	@PostMapping(value = "/operator")
	public String addOperatorToDepartmentByName(@Valid @RequestBody Operator newOperator){
		operatorService.addOperator(newOperator);
		return "Operator ID: "+newOperator.getOperatorId()+" Detalis Added Successfully";
	}
	
	
	
	@GetMapping(value = "/operator/{opId}")
	public Operator getOperatorById(@PathVariable("opId") Integer operatorId) throws OperatorIdNotFoundException {
		
		return operatorService.getOperatorById(operatorId);
		
	}

	
	@GetMapping(value = "/operators")
	public List<Operator> getAllOperators() throws NoOperatorsListFoundException{
		
		return operatorService.getAllOperators();
	}
	
	
	@PutMapping(value = "/operator/{operatorId}")
	public String updateOperator(@PathVariable("operatorId")Integer operatorId, @RequestBody Operator updateOperator) throws OperatorException {
		operatorService.updateOperatorById(operatorId, updateOperator);
		return "Operator ID:"+operatorId+" Details Updated Successfully";
	}
	
//	@DeleteMapping(value = "/operator/{deptId}/{opId}")
//	public String deleteOperatorFromDepartmentById(@PathVariable("deptId") Integer departmentId, @PathVariable("opId") Integer operatorId) throws DepartmentIdNotFoundException, OperatorIdNotFoundException { 
//		this.operatorService.deleteOperatorFromDepartmentById(departmentId, operatorId);
//		return "Operator ID:"+operatorId+" Details Deleted Successfully";
//	}
	
	@GetMapping(value="/issues/{departmentName}/")
	public List<Issue> getIssuesBydept(@PathVariable("departmentName") String department){
		return operatorService.getIssuesBydept(department);
	}
	
	@GetMapping(value = "/operators/{deptName}/")
	public List<Operator> getAllOperatorsByDepartmentName(@PathVariable("deptName") String departmentName) throws DepartmentException, NoOperatorsListFoundException{
		
		return operatorService.getOperatorByDepartmentName(departmentName);
	}
	
	@PostMapping("/operator/login")
	public Operator loginOperator(@RequestBody LoginDTO login) throws OperatorException{
		return this.operatorService.loginOperator(login.getEmail(), login.getPassword());
	}

}
