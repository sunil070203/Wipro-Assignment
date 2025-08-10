package com.schoolapp.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapp.example.entities.School;
import com.schoolapp.example.repository.TeacherRepository;
import com.schoolapp.example.service.SchoolService;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	
	
	@PostMapping("/add")
	public School addSchool(@RequestBody School school) {
		return schoolService.save(school);
		
	}
	
	
	@GetMapping("/get/{id}")
	public School getSchoolById(@PathVariable Long id) {
		return schoolService.getSchoolById(id);
		
	}

	@GetMapping("/all")
	public List<School> getAllSchools() {
		return schoolService.findAll();
	}
	
	@GetMapping("/all-school")
	public Page<School> getAllSchoolsPage(Pageable pageable){
		return schoolService.findAllSchoolPage(pageable);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		schoolService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public School updateById(@PathVariable Long id,@RequestBody School school) {
		return schoolService.updateById(id,school);
	}
	
	
	@PatchMapping("/patch/{id}")
	public School patchById(@PathVariable Long id,@RequestBody School school) {
		return schoolService.patchById(id,school);
	}
	
	
	@GetMapping("/searchByAddress")
	public List<School> getSchoolsByAddress(@RequestParam String city) {
	    return schoolService.findByAddressContains(city);
	}


	
}
