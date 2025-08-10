package com.swathi.collegeApp.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.swathi.collegeApp.entities.College;
import com.swathi.collegeApp.service.CollegeService;

@Controller
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	
	@GetMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("list", collegeService.getAll());
		model.addAttribute("college", new College());
		return "index";
		
	}
	
	@PostMapping("/save")
	public String saveCollege(@ModelAttribute College college) {
		
		collegeService.save(college);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Long id,Model model) {
		College college=collegeService.getById(id);
		model.addAttribute("college", college);
		return "edit";		
	}
	
	
	@PostMapping("/update")
	public String UpdateCollege(@ModelAttribute College college) {
		collegeService.save(college);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCollege(@PathVariable Long id) {
		collegeService.delete(id);
		return "redirect:/";
	}
	
	
	

}
