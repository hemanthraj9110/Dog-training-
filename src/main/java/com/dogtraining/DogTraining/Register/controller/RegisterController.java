package com.dogtraining.DogTraining.Register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dogtraining.DogTraining.Register.dto.User;
import com.dogtraining.DogTraining.Register.service.RegisterService;

@RestController
public class RegisterController {
	@Autowired
	private RegisterService service;
	
	//save user details
	@PostMapping("saveRegister")
	public String registerController(@RequestParam("name") String name,
									@RequestParam("phoneNumber") long phoneNumber,
									@RequestParam("email") String email,
									@RequestParam("password") String password) {
		User l=new User(name,phoneNumber,email,password);
		if (l!=null) {
			return service.registerservice(l);
		}
		 return "enter the values";
	}
	//get all user details
	@GetMapping("getRegister")
	public Object getRegisterdDetails(){
		return service.getRegisterdDetails();
	}
	
	//fetch by phone number
	@GetMapping("getByPhoneNumber/{phno}")
	public User fetchByphoneNumber(@PathVariable long phno) {
		return service.fetchByphoneNumber(phno);
	}
	//update Email by  
	@PutMapping("update/RegisterdEmail")
	public String updateEmail(long phoneNumber,String newEmail) {
		
		return service.updateEmail(phoneNumber,newEmail);
	}
}
