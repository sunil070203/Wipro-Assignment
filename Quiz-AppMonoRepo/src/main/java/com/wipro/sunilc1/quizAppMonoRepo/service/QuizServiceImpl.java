package com.wipro.sunilc1.quizAppMonoRepo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wipro.sunilc1.quizAppMonoRepo.entities.Question;
import com.wipro.sunilc1.quizAppMonoRepo.entities.QuestionWrapper;
import com.wipro.sunilc1.quizAppMonoRepo.entities.Quiz;
import com.wipro.sunilc1.quizAppMonoRepo.entities.Response;
import com.wipro.sunilc1.quizAppMonoRepo.repository.QuestionRepository;
import com.wipro.sunilc1.quizAppMonoRepo.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Quiz createQuiz(String category, String level, String title) {
		
		List<Question>questions=questionRepository.findRandomQuestionsByCategoryAndLevel(category, level);
		Quiz quiz=new Quiz();
		quiz.setQuestions(questions);
		quiz.setTitle(title);
		return quizRepository.save(quiz);
		
	}

	@Override
	public List<QuestionWrapper> getQuizQuestions(Long id) {
		
		Quiz quiz = quizRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));

	    List<Question> questions = quiz.getQuestions(); // @ManyToMany in Quiz

	    List<QuestionWrapper> questionWrappers = new ArrayList<>();

	    for (Question q : questions) {
	        QuestionWrapper wrapper = new QuestionWrapper(
	                q.getId(),
	                q.getQuestionTitle(),
	                q.getOptionA(),
	                q.getOptionB(),
	                q.getOptionC(),
	                q.getOptionD()
	        );
	        questionWrappers.add(wrapper);
	    }
	    return questionWrappers;
	}

	public Long calculateResult(Long id, List<Response> responses) {
	    Quiz quiz = quizRepository.findById(id).orElse(null);
	    if (quiz == null) return 0L;

	    List<Question> questions = quiz.getQuestions();
	    long rightAnswer = 0;

	    for (Response response : responses) {
	        for (Question question : questions) {
	            if (question.getId().equals(response.getId())) {
	                String correct = question.getCorrectAnswer().trim();
	                String given = response.getResponse().trim();
	                if (correct.equalsIgnoreCase(given)) {
	                    rightAnswer++;
	                }
	            }
	        }
	    }
	    return rightAnswer;
	}


	
	

}
