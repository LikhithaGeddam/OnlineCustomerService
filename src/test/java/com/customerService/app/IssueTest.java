//package com.customerService.app;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.customerService.app.Entity.Issue;
//import com.customerService.app.Exception.IssueException;
//import com.customerService.app.Repository.IssueRepository;
//import com.customerService.app.Service.IssueService;
//
///************************************************************************************
// * @author        Pisariwar Sameeksha
// 
// * Description    It is a Test class that provides the Testing methods for adding a new Solution, 
//                  Updating existing Solution details ,Fetching Details of Solution by issue Id, Fetching all Solution Details,
//                  deleting solution using issue Id.
//       
// *Version         1.0  
//        
// *Created Date    10-FEB-2023
// ************************************************************************************/
//@SpringBootTest
//class IssueTest {
//
//	
//	@Autowired
//	private IssueService issueService;
//	
//	@Autowired
//	private IssueRepository issueRepository;
//
//	@Test
//	void addIssueTest() throws IssueException {
//		assertNotNull(issueService.addIssue(new Issue(13,"xyz related","Plan will expire soon","Open")));
//	}
//	
//	@Test
//	void addIssueTest1() throws IssueException {
//		assertNotNull(issueService.addIssue(new Issue(14,"xyz related","Plan will expire soon","Open")));
//	}
//	
//	@Test
//	void addIssueTest2() throws IssueException {
//		assertNotNull(issueService.addIssue(new Issue(15,"xyz related","Plan will expire soon","Open")));
//	}
//	
//	@Test
//	void addIssueExceptionTest() {
//		assertThrows(IssueException.class,()->issueService.addIssue(new Issue(11,"abc related","Your account is not active","Open")));
//	}
//	
//	@Test
//	void addIssueExceptionTest1() {
//		assertThrows(IssueException.class,()->issueService.addIssue(new Issue(10,"abc related","Your account is not active","Open")));
//	}
//	
//	@Test
//	void addIssueExceptionTest2() {
//		assertThrows(IssueException.class,()->issueService.addIssue(new Issue(12,"abc related","Your account is not active","Open")));
//	}
//	
//	@Test
//	void updateIssueTest() throws IssueException {
//		assertNotNull(issueService.updateCustomerIssue(new Issue(5,"xyz related","Plan will expire soon","Open")));
//	}
//	
//	@Test
//	void updateIssueExceptionTest(){
//		assertThrows(IssueException.class,()->issueService.updateCustomerIssue(new Issue(555,"Sim related","Sim might be out of the place","Open")));
//	}
//	
//	@Test
//	void getIssueByIdTest() throws IssueException{
//		assertNotNull(issueService.getIssueById(2));
//	}
//	
//	@Test
//	void getIssueByIdTest1() throws IssueException{
//		assertNotNull(issueService.getIssueById(5));
//	}
//	
//	@Test
//	void getIssueByIdTest2() throws IssueException{
//		assertNotNull(issueService.getIssueById(3));
//	}
//	
//	@Test
//	void getIssueByIdExceptionTest() {
//		assertThrows(IssueException.class,()->issueService.getIssueById(50));
//	}
//	
//	@Test
//	void getIssueByIdExceptionTest1() {
//		assertThrows(IssueException.class,()->issueService.getIssueById(999));
//	}
//	
//	@Test
//	void getIssueByIdExceptionTest2() {
//		assertThrows(IssueException.class,()->issueService.getIssueById(500));
//	}
//	
//	@Test
//	void getAllIssuesTest()
//	{
//		assertNotNull(issueService.getAllIssues());
//	}
//	
//
//
//    @Test
//	public void testAddIssue() throws IssueException 
//    {
//		Issue issue = new Issue(16, "Type 1", "Description 1", "Open");
//		Issue savedIssue = issueService.addIssue(issue);
//		assertNotNull(savedIssue);
//	}
//
//		
//	@Test
//	public void testGetIssueById() throws IssueException 
//	{
//		Issue issue = new Issue(53, "Type 1", "Description 1", "Open");
//		issueRepository.save(issue);
//		Issue foundIssue = issueService.getIssueById(53);
//		assertNotNull(foundIssue);
//	}
//
//	@Test
//	public void testGetIssueByInvalidId() throws IssueException 
//	{
//		assertThrows(IssueException.class,()->issueService.getIssueById(999));
//	}
//
//}
