package com.example.License.License_Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.License.License_Backend.Entity.Admin;
import com.example.License.License_Backend.Repository.AdminRepository;
@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository repository;
	
	@GetMapping("/getadmin")
	public List<Admin> retriveAllAdmins(){
		return repository.findAll();
	}
	@PostMapping("/admin")
	public void addAdmin(@RequestBody Admin admin) {

		repository.save(admin);
	}
	
	

}
