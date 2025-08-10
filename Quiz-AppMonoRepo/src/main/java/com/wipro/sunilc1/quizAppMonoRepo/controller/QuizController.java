package com.wipro.sunilc1.quizAppMonoRepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.sunilc1.quizAppMonoRepo.entities.QuestionWrapper;
import com.wipro.sunilc1.quizAppMonoRepo.entities.Quiz;
import com.wipro.sunilc1.quizAppMonoRepo.entities.Response;
import com.wipro.sunilc1.quizAppMonoRepo.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	
	@PostMapping("/create")
	public Quiz createQuiz(@RequestParam String category,@RequestParam String level,@RequestParam String title) {
		return quizService.createQuiz(category,level,title);
	}
	
	
	@GetMapping("/getQuizById/{id}")
	public List<QuestionWrapper> getQuizQuestions(@PathVariable Long id){
		return quizService.getQuizQuestions(id);
	}
	

	@PostMapping("/submit/{id}")
	public Long submitQuiz(@PathVariable Long id,@RequestBody List<Response> responses) {
		return quizService.calculateResult(id,responses);
	}
	
	
	

}
