package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.PropertyRepository;
import com.project.entity.LoginUser;
import com.project.entity.Messages;
import com.project.entity.Property;
import com.project.entity.ResponsePage;
import com.project.entity.UserDetail;
import com.project.service.LoginUserService;
import com.project.service.UserDetailService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private LoginUserService loginUserService;

	@Autowired
	private PasswordEncoder encoder;

	
	
	@PostMapping("/register")
	public ResponsePage registerUser(@RequestBody UserDetail userDetail) throws Exception{
		System.out.println("Registering the user......");
		System.out.println(userDetail);
		try {
			if(this.userDetailService.insertUser(userDetail)) {
				LoginUser user = new LoginUser();
				user.setEmail(userDetail.getEmail());
				user.setPassword(encoder.encode(userDetail.getPassword()));
				this.loginUserService.insertUser(user);		
				return new ResponsePage(Messages.SUCCESS, "Registration successfull");
			}else
				return new ResponsePage(Messages.FAILURE, "Registration unsuccessfull");
		}catch(Exception e) {
			System.out.println("Registration unsuccessfull");
			return new ResponsePage(Messages.FAILURE, "Registration unsuccessfull");
		}
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginUser user) throws Exception
	{
		System.out.println("authenticate ......");
		System.out.println(user);
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			System.out.println("login failed");
			return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE,"Login failed"));
		}
		return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS,"Login success"));
	}

	
}
