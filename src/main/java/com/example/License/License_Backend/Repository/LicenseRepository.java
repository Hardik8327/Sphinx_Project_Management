package com.example.License.License_Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.License.License_Backend.Entity.License;

import jakarta.transaction.Transactional;
@Transactional
public interface LicenseRepository extends JpaRepository<License,Integer> {
	 @Modifying
	    @Query("DELETE FROM License l WHERE l.lId = :licenseId")
	    void deleteByLicenseId(@Param("licenseId") int licenseId);
}
