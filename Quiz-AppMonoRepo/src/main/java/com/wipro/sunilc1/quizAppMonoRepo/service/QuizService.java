package com.wipro.sunilc1.quizAppMonoRepo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.sunilc1.quizAppMonoRepo.entities.QuestionWrapper;
import com.wipro.sunilc1.quizAppMonoRepo.entities.Quiz;
import com.wipro.sunilc1.quizAppMonoRepo.entities.Response;

public interface QuizService {

	



	Quiz createQuiz(String category, String level, String title);

	List<QuestionWrapper> getQuizQuestions(Long id);

	Long calculateResult(Long id, List<Response> responses);

}
