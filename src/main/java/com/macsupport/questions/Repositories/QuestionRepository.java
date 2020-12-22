package com.macsupport.questions.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.macsupport.questions.Models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question>findAll();
}
