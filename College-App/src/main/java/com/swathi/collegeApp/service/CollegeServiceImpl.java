package com.swathi.collegeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swathi.collegeApp.entities.College;
import com.swathi.collegeApp.repo.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	
	@Autowired
	private CollegeRepository collegeRepository;

	@Override
public List<College> getAll(){
	return collegeRepository.findAll();
		
	}

	@Override
	public void save(College college) {
		// TODO Auto-generated method stub
		collegeRepository.save(college);
		
	}
	
	@Override
	public College getById(Long id) {
		return collegeRepository.findById(id).orElse(null);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		collegeRepository.deleteById(id);
		
	}
	
	
	

}
