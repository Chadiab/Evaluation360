package com.chadi.springjwt.repository;

import com.chadi.springjwt.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
