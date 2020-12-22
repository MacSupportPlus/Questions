package com.macsupport.questions.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.macsupport.questions.Models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findAll();
    Tag findBySubject(String subject);
}
