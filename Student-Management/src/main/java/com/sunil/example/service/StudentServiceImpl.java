package com.sunil.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.example.entities.Student;
import com.sunil.example.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public List<Student> getAll() {
		
		return studentRepository.findAll();
	}
	@Override
	public void save(Student student) {
		studentRepository.save(student);
		
	}
	@Override
	public Student getById(Long rollno) {
		
		return studentRepository.findById(rollno).orElse(null);
	}
	@Override
	public void delete(Long rollno) {
		studentRepository.deleteById(rollno);
		
	}

}
