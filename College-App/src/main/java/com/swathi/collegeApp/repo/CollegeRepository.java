package com.swathi.collegeApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swathi.collegeApp.entities.College;


@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
	
	

}
