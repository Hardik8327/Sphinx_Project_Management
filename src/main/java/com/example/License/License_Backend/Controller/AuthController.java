package com.example.License.License_Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.License.License_Backend.Entity.Admin;
import com.example.License.License_Backend.Entity.User;
import com.example.License.License_Backend.Repository.AdminRepository;
import com.example.License.License_Backend.Repository.UserRepository;

@RestController
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
	   
	    User existingUser = userRepository.findByUsername(user.getUsername());

	    if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
	        return ResponseEntity.ok().body(existingUser);
	    } else {
	        
	        return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Invalid username or password\"}");
	    }
	}
	 
	 @PostMapping("/Adminlogin")
	    public ResponseEntity<?> adminLogin(@RequestBody Admin admin) {
	        
	        Admin existingAdmin = adminRepository.findByUsername(admin.getUsername());

	        
	        if (existingAdmin != null && existingAdmin.getPassword().equals(admin.getPassword())) {
	            return ResponseEntity.ok().body("{\"success\": true}");
	        } else {
	            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Invalid username or password\"}");
	        }
	    }

}
