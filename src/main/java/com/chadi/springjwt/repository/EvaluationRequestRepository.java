package com.chadi.springjwt.repository;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.EvaluationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRequestRepository extends JpaRepository<EvaluationRequest, Long> {
    EvaluationRequest findEvaluationRequestById(Long id);

}
