package com.schoolapp.example.service;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.schoolapp.example.entities.School;
import com.schoolapp.example.repository.SchoolRepository;


@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

	@Autowired
    private final SchoolRepository schoolRepository;

    
	@Override
	public School save(School school) {
		// TODO Auto-generated method stub
		return schoolRepository.save(school);
	}


	@Override
	public School getSchoolById(Long id) {
		
		return schoolRepository.findById(id).orElse(null);
	}


	@Override
	public List<School> findAll() {
		return schoolRepository.findAll();
	}


	@Override
	public void deleteById(Long id) {
		schoolRepository.deleteById(id);
		
	}


	@Override
	public School updateById(Long id, School school) {
	
		School existedSchool=schoolRepository.findById(id).orElseThrow(()->new RuntimeException("user with that id not present"+id));
		existedSchool.setSchoolName(school.getSchoolName());
		existedSchool.setSchoolAddress(school.getSchoolAddress());
       
		
		return schoolRepository.save(existedSchool);
				}


	@Override
	public School patchById(Long id, School school) {
		School existedSchool=schoolRepository.findById(id).orElseThrow(()->new RuntimeException("user with that id not found:"+id));
		if(existedSchool.getSchoolAddress()!=null) {
			
			 existedSchool.setSchoolName(school.getSchoolName());
	    }

	    if (school.getSchoolAddress() != null) {
	        existedSchool.setSchoolAddress(school.getSchoolAddress());
	    }

	   
	    return schoolRepository.save(existedSchool);
			}


	

	@Override
	public List<School> findByAddressContains(String city) {
	    return schoolRepository.findByAddressContains(city);
	}


	@Override
	public Page<School> findAllSchoolPage(Pageable pageable) {
		
		return schoolRepository.findAll(pageable);
	}

	

	
}
