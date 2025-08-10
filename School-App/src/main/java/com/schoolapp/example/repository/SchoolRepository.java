package com.schoolapp.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolapp.example.entities.School;


@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
	
	// Inside SchoolRepository
	@Query("SELECT s FROM School s WHERE LOWER(s.schoolAddress) LIKE LOWER(CONCAT('%', :city, '%'))")
	List<School> findByAddressContains(@Param("city") String city);

	



}
