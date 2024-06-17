package com.example.License.License_Backend.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.License.License_Backend.Entity.License;
import com.example.License.License_Backend.Entity.User;
import com.example.License.License_Backend.Repository.LicenseRepository;
import com.example.License.License_Backend.Repository.UserRepository;
@RestController
public class LicenseController {

	@Autowired
	private LicenseRepository repository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LicenseRepository licenseRepository; 
	
	@PostMapping("user/{id}/license")
    public void addLicense(@RequestBody License license, @PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            license.setUser(user); 
            repository.save(license); 
        } else {
           
        }
    }
	
	 @GetMapping("/user/{id}/getLicenses")
	    public List<License> retrieveAllLicenses(@PathVariable int id) {
	        Optional<User> optionalUser = userRepository.findById(id);
	        if (optionalUser.isPresent())  {
	            User user = optionalUser.get();
	            return user.getLicenses(); 
	        } else {
	            return Collections.emptyList(); 
	        }
	    }
	@GetMapping("/user/id/getLicense/{id}")
    public License retrieveUser(@PathVariable int id) {

		return repository.getById(id);
    }
	
	@DeleteMapping("/user/{userId}/license/{licenseId}")
	public ResponseEntity<?> deleteLicense(@PathVariable int userId, @PathVariable int licenseId) {
	   
	    licenseRepository.deleteByLicenseId(licenseId);
	    
	    
	    return ResponseEntity.ok().build();
	}

}
