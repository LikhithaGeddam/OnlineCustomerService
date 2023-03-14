package com.customerService.app.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerService.app.Entity.Admin;
import com.customerService.app.Entity.Customer;
import com.customerService.app.Entity.Issue;
import com.customerService.app.Entity.LoginDTO;
import com.customerService.app.Exception.AdminException;
import com.customerService.app.Exception.CustomerException;
import com.customerService.app.Exception.IssueException;
import com.customerService.app.Repository.AdminRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AdminServiceImplementation implements AdminService{
	@Autowired
	private AdminRepository adminRepository;
	
//	@Override
//	public String login(LoginDTO user) throws LoginException {
//		Admin admin = this.adminRepository.findByEmail(user.getEmail());
//		if(admin==null)
//			throw new LoginException("Operator does't exists with given email/user id.");
//		if (!admin.getPassword().equals(user.getPassword()))
//			throw new LoginException("Password does't match.");
//		String issuer = admin.getEmail();
//		Date expiry = new Date(System.currentTimeMillis() + (60 * 60 * 1000));
//		return Jwts.builder().setIssuer(issuer).setExpiration(expiry).signWith(SignatureAlgorithm.HS512, "Secret1234").compact();
//	}
	
	@Override
	public Admin login(String email, String password) throws AdminException {
		Admin admin = adminRepository.findByEmail(email);
		if(admin == null) {
			throw new AdminException("email Id does not exist");
		}
		else if(admin.getPassword()==null || !admin.getPassword().equals(password)) {
			throw new AdminException("password is incorrect");
		}return admin;
	}

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		if(adminRepository.findByEmail(admin.getEmail())!= null) {
			throw new AdminException("email already exists, try another email");
		}
		adminRepository.save(admin);
		return admin;
	}

	@Override
	public List<Admin> getAdmins() {
		return this.adminRepository.findAll();
	}
	
	@Override
	public Admin updateAdmin(Admin newadmin) throws AdminException{
		Admin optAdmin = adminRepository.findByEmail(newadmin.getEmail());
		if(optAdmin == null) {
			throw new AdminException("Invalid Admin details");
		}
		return adminRepository.save(newadmin);
	}

	@Override
	public Admin loginAdminCredentials(Admin adminCredentials) throws AdminException {
		Admin adminFound=adminRepository.findByEmail(adminCredentials.getEmail());
		if(adminFound==null){
			throw new AdminException("Email Id does not exists");
		}
		if(adminFound.getPassword()==null || !adminFound.getPassword().equals(adminCredentials.getPassword())){
			throw new AdminException("password is incorrect");
		}
		return adminFound;
	}

}
