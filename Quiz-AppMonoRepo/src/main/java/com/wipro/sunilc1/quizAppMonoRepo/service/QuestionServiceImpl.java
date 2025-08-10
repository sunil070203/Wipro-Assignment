package com.wipro.sunilc1.quizAppMonoRepo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.sunilc1.quizAppMonoRepo.entities.Question;
import com.wipro.sunilc1.quizAppMonoRepo.enums.Category;
import com.wipro.sunilc1.quizAppMonoRepo.enums.DifficultyLevel;
import com.wipro.sunilc1.quizAppMonoRepo.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	

	@Override
	public Question save(Question question) {
		
		return questionRepository.save(question);
	}


	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}


	


	

	@Override
	public Question findById(Long id) {
		
		return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found with id:"+id));
	}


	@Override
	public void deleteById(Long id) {
		questionRepository.deleteById(id);
		
	}


	


	@Override
	public Page<Question> findAlls(Pageable pageable) {
		// TODO Auto-generated method stub
		return questionRepository.findAll(pageable);
	}


	@Override
	public Question findById(Long id, Question question) {
	    Question existingQuestion = questionRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("user not found with id:" + id));

	    if (question.getQuestionTitle() != null) {
	        existingQuestion.setQuestionTitle(question.getQuestionTitle());
	    } else {
	        existingQuestion.setQuestionTitle(existingQuestion.getQuestionTitle());
	    }

	    if (question.getOptionA() != null) {
	        existingQuestion.setOptionA(question.getOptionA());
	    } else {
	        existingQuestion.setOptionA(existingQuestion.getOptionA());
	    }

	    if (question.getOptionB() != null) {
	        existingQuestion.setOptionB(question.getOptionB());
	    } else {
	        existingQuestion.setOptionB(existingQuestion.getOptionB());
	    }

	    if (question.getOptionC() != null) {
	        existingQuestion.setOptionC(question.getOptionC());
	    } else {
	        existingQuestion.setOptionC(existingQuestion.getOptionC());
	    }

	    if (question.getOptionD() != null) {
	        existingQuestion.setOptionD(question.getOptionD());
	    } else {
	        existingQuestion.setOptionD(existingQuestion.getOptionD());
	    }

	    if (question.getCorrectAnswer() != null) {
	        existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
	    } else {
	        existingQuestion.setCorrectAnswer(existingQuestion.getCorrectAnswer());
	    }

	    if (question.getDifficultyLevel() != null) {
	        existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
	    } else {
	        existingQuestion.setDifficultyLevel(existingQuestion.getDifficultyLevel());
	    }

	    if (question.getCategory() != null) {
	        existingQuestion.setCategory(question.getCategory());
	    } else {
	        existingQuestion.setCategory(existingQuestion.getCategory());
	    }

	    

	    return questionRepository.save(existingQuestion);
	}


	@Override
	public List<Question> findByCategory(Category category) {
	    return questionRepository.findByCategory(category);
	}



	@Override
	public List<Question> findByDifficultyLevel(DifficultyLevel difficultyLevel) {
	    return questionRepository.findByDifficultyLevel(difficultyLevel);
	}


	@Override
	public Question getPatch(Long id, Question question) {
		
		return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found with id for patching :"+id));
	}






	

}
