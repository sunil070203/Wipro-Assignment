package com.wipro.sunilc1.quizAppMonoRepo.controller;

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

import com.wipro.sunilc1.quizAppMonoRepo.entities.Question;
import com.wipro.sunilc1.quizAppMonoRepo.enums.Category;
import com.wipro.sunilc1.quizAppMonoRepo.enums.DifficultyLevel;
import com.wipro.sunilc1.quizAppMonoRepo.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	
	@PostMapping("/add")
	public Question addQuestions(  @Valid @RequestBody Question question) {
	
		log.info("this question is coming from "+question);
		return questionService.save(question);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteQuestions(@PathVariable Long id) {
		questionService.deleteById(id);
		return "Question deleted successfully";
	}
	
	
	
	@GetMapping("/all")
	public List<Question> getQuestionAll() {
		log.info("get method done successfully");
		return  questionService.findAll();
	}
	
	@GetMapping("/getPage")
	public Page<Question> getQuestion(Pageable pageable){
		log.info("/getpage is done successfull");
		return questionService.findAlls(pageable);
	}
	@GetMapping("/Category/{category}")
	public List<Question> getByCategory(@PathVariable Category category) {
		log.info("/getCategory is done ");
		return questionService.findByCategory(category);
		
	}
	
	@GetMapping("/difficulty/{difficultyLevel}") 
	public List<Question> getByDifficulty(@PathVariable DifficultyLevel difficultyLevel) {
		log.info("getDifficulty is done");
	    return questionService.findByDifficultyLevel(difficultyLevel);
	}
	@PutMapping("/get/{id}")
	public Question getUpdateQuestion(@PathVariable Long id,@RequestBody Question question) {
		log.info("putmapping is done");
		return questionService.findById(id,question);
	}
	
	@PatchMapping("/patch/{id}")
	public Question getPatach(@PathVariable Long id,@RequestBody Question question) {
		return questionService.getPatch(id,question);
	}

}
