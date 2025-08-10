package com.schoolapp.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
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
import com.schoolapp.example.entities.Teacher;
import com.schoolapp.example.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@PostMapping("/add")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherService.save(teacher);
		
	}
	
	
	@GetMapping("/{id}")
	public Teacher getTeacherById(@PathVariable Long id) {
		return teacherService.getTeacherById(id);
	}
	
	@GetMapping("/All")
	public List<Teacher> getAllTeachers() {
		return teacherService.findAll();
	}
	
	@GetMapping("/AllTeacher")
	public Page<Teacher> getTeacherPage(Pageable pageable){
		return teacherService.findTeacherPage(pageable);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		teacherService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Teacher updateById(@PathVariable Long id, @RequestBody Teacher teacher) {
		return teacherService.updateById(id,teacher);
	}

	@PatchMapping("/patch/{id}")
	public Teacher patchById(@PathVariable Long id,@RequestBody Teacher teacher) {
		return teacherService.patchById(id,teacher);
	}
	
	@GetMapping("/namesByAge")
	public List<String> getTeacherNamesByAge(@RequestParam int age) {
	    return teacherService.getTeacherNamesByAgeGreaterThan(age);
	}

	@GetMapping("/nativeQualification")
	public List<Teacher> getTeachersNative(@RequestParam String qualification) {
	    return teacherService.getTeachersByQualificationNative(qualification);
	}


}
