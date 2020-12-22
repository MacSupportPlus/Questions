package com.macsupport.questions.Services;

import org.springframework.stereotype.Service;

import com.macsupport.questions.Models.Answer;
import com.macsupport.questions.Repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository aRepository) {
		this.answerRepository = aRepository;
	}
	
	public Answer addAnswer(Answer answer) {
		return this.answerRepository.save(answer);
	}
}
