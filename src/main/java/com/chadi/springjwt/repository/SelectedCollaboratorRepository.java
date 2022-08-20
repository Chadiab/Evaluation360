package com.chadi.springjwt.repository;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.SelectedCollaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectedCollaboratorRepository extends JpaRepository<SelectedCollaborator, Long> {
}
