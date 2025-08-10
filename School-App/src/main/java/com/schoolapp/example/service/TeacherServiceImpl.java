package com.schoolapp.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.schoolapp.example.entities.Teacher;
import com.schoolapp.example.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	@Override
	public Teacher save(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.save(teacher); 
	}
	
	@Override
	public Teacher getTeacherById(Long id) {
		// TODO Auto-generated method stub
		return teacherRepository.findById(id).orElse(null);
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		teacherRepository.deleteById(id);
		
	}

	@Override
	public Teacher updateById(Long id, Teacher teacher) {
		Teacher existedTeacher=teacherRepository.findById(id).orElseThrow(()->new RuntimeException("user with that id not present"+id));
		existedTeacher.setTeacherName(teacher.getTeacherName());
		 existedTeacher.setTeacherAddress(teacher.getTeacherAddress());
	        existedTeacher.setQualification(teacher.getQualification());
	        existedTeacher.setAge(teacher.getAge());
	        existedTeacher.setDob(teacher.getDob());
	        existedTeacher.setExperience(teacher.getExperience());
		
		return teacherRepository.save(existedTeacher);
	}

	@Override
	public Teacher patchById(Long id, Teacher teacher) {
		Teacher existingTeacher = teacherRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Teacher with ID " + id + " not found"));

		    // Only update non-null fields
		    if (teacher.getTeacherName() != null) {
		        existingTeacher.setTeacherName(teacher.getTeacherName());
		    }

		    if (teacher.getTeacherAddress() != null) {
		        existingTeacher.setTeacherAddress(teacher.getTeacherAddress());
		    }

		    if (teacher.getQualification() != null) {
		        existingTeacher.setQualification(teacher.getQualification());
		    }

		    if (teacher.getAge() != 0) {
		        existingTeacher.setAge(teacher.getAge());
		    }

		    if (teacher.getDob() != null) {
		        existingTeacher.setDob(teacher.getDob());
		    }

		    if (teacher.getExperience() != 0) {
		        existingTeacher.setExperience(teacher.getExperience());
		    }

		    return teacherRepository.save(existingTeacher);
		}
	
	@Override
	public List<String> getTeacherNamesByAgeGreaterThan(int age) {
	    return teacherRepository.findTeacherNamesByAgeGreaterThan(age);
	}

	@Override
	public List<Teacher> getTeachersByQualificationNative(String qualification) {
	    return teacherRepository.findByQualificationNative(qualification);
	}

	@Override
	public Page<Teacher> findTeacherPage(Pageable pageable) {
		
		return teacherRepository.findAll(pageable);
	}

		
	}

	
