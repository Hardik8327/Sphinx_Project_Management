package com.example.License.License_Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.License.License_Backend.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	  User findByUsername(String username);
}
