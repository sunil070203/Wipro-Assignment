package com.wipro.sunilc1.quizAppMonoRepo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
	
	private Long id;
	private String questionTitle;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;

}
