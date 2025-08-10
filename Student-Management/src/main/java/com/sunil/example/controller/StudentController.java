package com.sunil.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sunil.example.entities.Student;
import com.sunil.example.service.StudentService;

@Controller
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	
	 @GetMapping("/")
	    public String viewHome(Model model) {
	        model.addAttribute("list", studentService.getAll());
	        return "index";
	    }
	 @GetMapping("/addStudent")
	    public String showAddForm(Model model) {
	        model.addAttribute("student", new Student());
	        return "add";
	    }
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		
		studentService.save(student);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/edit/{rollno}")
	public String showEdit(@PathVariable Long rollno,Model model) {
		Student student=studentService.getById(rollno);
		model.addAttribute("student", student);
		return "edit";		
	}
	
	
	@PostMapping("/update")
	public String UpdateStudent(@ModelAttribute Student student) {
		studentService.save(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{rollno}")
	public String deleteStudent(@PathVariable Long rollno) {
		studentService.delete(rollno);
		return "redirect:/";
	}
	
	
	
	

}
