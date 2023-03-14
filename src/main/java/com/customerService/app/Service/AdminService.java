package com.customerService.app.Service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.customerService.app.Entity.Admin;
import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.LoginDTO;
import com.customerService.app.Exception.AdminException;
import com.customerService.app.Exception.CustomerException;

public interface AdminService {
	Admin login(String email, String password) throws AdminException;
	
	Admin addAdmin(Admin admin) throws AdminException;
	
	Admin updateAdmin(Admin newadmin) throws AdminException;
	
	List<Admin> getAdmins() throws AdminException;
	
	Admin loginAdminCredentials(Admin adminCredentials) throws AdminException;

//	String login(LoginDTO user) throws LoginException;

}
