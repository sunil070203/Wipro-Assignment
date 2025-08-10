package com.schoolapp.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.schoolapp.example.entities.School;

public interface SchoolService {

	School save(School school);

	School getSchoolById(Long id);

	List<School> findAll();

	void deleteById(Long id);

	School updateById(Long id, School school);

	School patchById(Long id, School school);

	

	List<School> findByAddressContains(String city);

	Page<School> findAllSchoolPage(Pageable pageable);

	

}
