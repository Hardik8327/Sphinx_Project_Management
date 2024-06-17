package com.example.License.License_Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.License.License_Backend.Entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	Admin findByUsername(String username);
}
