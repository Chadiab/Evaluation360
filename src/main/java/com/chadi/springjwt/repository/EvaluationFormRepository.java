package com.chadi.springjwt.repository;

import com.chadi.springjwt.entity.EvaluationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvaluationFormRepository extends JpaRepository<EvaluationForm,Long> {
    EvaluationForm findEvaluationFormById(long id);
}
