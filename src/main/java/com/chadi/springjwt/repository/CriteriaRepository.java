package com.chadi.springjwt.repository;

import com.chadi.springjwt.entity.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
}
