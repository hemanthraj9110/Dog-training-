package com.dogtraining.DogTraining.Register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dogtraining.DogTraining.Register.dto.Admin;
import com.dogtraining.DogTraining.Register.dto.User;
import com.dogtraining.DogTraining.Register.service.AdminRegisterService;

@RestController
public class AdminController {
		
	@Autowired
	private AdminRegisterService service;
	
	//save register
	@PostMapping("save/admin/Register")
	public String adminRegisterController(@RequestParam("name")String name,
									@RequestParam("phoneNumber") long phoneNumber,
									@RequestParam("email") String email,
									@RequestParam("password") String password) {
		Admin l=new Admin(name,phoneNumber,email,password);
		return service.registerservice(l); 
		}
		//get all admin details in admin login
		@GetMapping("getadmin/Register")
		public Object getLoginDetails(){
		return service.getRegisterdAdminDetails();
		}
	
		//get all login details in admin login
		@GetMapping("getuser/Register")
		public Object getRegisterdDetails(){
			return service.getRegisterdUserDetails();
		}
		
		//fetch admin by phone number in admin login 
				@GetMapping("getAdmin/ByPhoneNumber/{phno}")
				public Admin fetchByAdminphoneNumber(@PathVariable long phno) {
					return service.fetchByAdminphoneNumber(phno);
		}
				
		//fetch user by phone number in admin login 
		@GetMapping("getUser/ByPhoneNumber/{phno}")
		public User fetchByphoneNumber(@PathVariable long phno) {
			return service.fetchByphoneNumber(phno);
		}
		
		//update user Email by __ in admin login 
		@PutMapping("updateAdmin/RegisterdEmail")
		public String updateAdminEmail(long phoneNumber,String newEmail) {
			return service.updateAdminEmail(phoneNumber,newEmail);
		}
				
		//update user Email by __ in admin login 
		@PutMapping("updateUser/RegisterdEmail")
		public String updateEmail(long phoneNumber,String newEmail) {
			return service.updateEmail(phoneNumber,newEmail);
		}
}
