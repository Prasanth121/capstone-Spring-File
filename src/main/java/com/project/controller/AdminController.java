package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.AdminDetail;
import com.project.entity.LoginUser;
import com.project.entity.Messages;
import com.project.entity.ResponsePage;
import com.project.service.AdminDetailService;
import com.project.service.LoginUserService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AdminDetailService adminDetailService;

	@Autowired
	private LoginUserService loginUserService;

	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/adminAuthenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginUser admin) throws Exception
	{
		List<AdminDetail> adminList=this.adminDetailService.getAllAdmin();
		for(AdminDetail adminDetail:adminList) {
			LoginUser loginAdmin = new LoginUser();
			loginAdmin.setEmail(adminDetail.getEmail());
			loginAdmin.setPassword(encoder.encode(adminDetail.getPassword()));
			this.loginUserService.insertAdmin(loginAdmin);
		}
		System.out.println("Admin authenticate ......");
		System.out.println(admin);
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(admin.getEmail(), admin.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			System.out.println("login failed");
			return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE,"Login failed"));
		}
		return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS,"Login success"));
	}


}
