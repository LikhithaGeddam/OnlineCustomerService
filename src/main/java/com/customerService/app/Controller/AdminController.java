package com.customerService.app.Controller;

import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerService.app.Entity.Admin;
import com.customerService.app.Entity.LoginDTO;
import com.customerService.app.Exception.AdminException;
import com.customerService.app.Exception.IssueException;
import com.customerService.app.Service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping("admin/login")
	public Admin adminLogin(@RequestBody LoginDTO loginDto) throws AdminException {
		return this.adminService.login(loginDto.getEmail(), loginDto.getPassword());
	}

//	@PostMapping("admin/login")
//	public String login(@RequestBody LoginDTO user, HttpServletResponse response) throws LoginException {
//		Cookie cookie = new Cookie("jwt", this.adminService.login(user));
//		response.addCookie(cookie);
//		return "Login Success!";
//		
//	}

	@PostMapping("logout")
	public String logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("jwt", "");
		response.addCookie(cookie);
		return "Logout Success!";
	}

	@PostMapping("/admin")
	public Admin addAdmin(@RequestBody Admin admin) throws AdminException {
		return this.adminService.addAdmin(admin);
	}

	@PutMapping("/admin")
	public String updateAdmin(@RequestBody Admin newAdmin) throws IssueException, AdminException {
		adminService.updateAdmin(newAdmin);
		return "Details of admin: " + newAdmin.getName() + " updated successfully";
	}

	@GetMapping("/admins")
	public List<Admin> getAdmins() throws AdminException {
		return adminService.getAdmins();
	}

}
