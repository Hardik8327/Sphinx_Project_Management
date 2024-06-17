package com.example.License.License_Backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.License.License_Backend.Entity.Admin;
import com.example.License.License_Backend.Entity.User;
import com.example.License.License_Backend.Repository.AdminRepository;
import com.example.License.License_Backend.Repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository; 
	@Autowired
	private AdminRepository adminRepository;
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		 Admin admin = adminRepository.findById(1).orElse(null);
	        if (admin != null) {
	           
	            user.setAdmin(admin);
	            
	            repository.save(user);
	        } else {
	            
	        }
	}
	
	@GetMapping("/getUsers")
	public List<User> retrieveAllUsers(){

		return repository.findAll();
		
	}
	  @GetMapping("/getUser/{id}")
	    public User retrieveUser(@PathVariable int id) {
	        Optional<User> optionalUser = repository.findById(id);
	        return optionalUser.orElse(null); 
	    }
	  
	  
	  
	  @DeleteMapping("/deleteUser/{id}")
	    public ResponseEntity<?> deleteUser(@PathVariable int id) {
	        
	        if (repository.existsById(id)) {
	            repository.deleteById(id);
	            return ResponseEntity.ok().body("{\"success\": true, \"message\": \"User deleted successfully\"}");
	        } else {
	            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"User not found\"}");
	        }
	    }
	  
	  
	  @PutMapping("/updateUser/{id}")
	    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
	        Optional<User> optionalUser = repository.findById(id);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            user.setName(updatedUser.getName()); 
	            user.setUsername(updatedUser.getUsername());
	            user.setPassword(updatedUser.getPassword());
	           

	            repository.save(user);
	            return ResponseEntity.ok().body("{\"success\": true, \"message\": \"User updated successfully\"}");
	        } else {
	            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"User not found\"}");
	        }
	    }
	
}
