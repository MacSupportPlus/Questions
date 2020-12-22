package com.macsupport.questions.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.macsupport.questions.Models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer>findAll();
}