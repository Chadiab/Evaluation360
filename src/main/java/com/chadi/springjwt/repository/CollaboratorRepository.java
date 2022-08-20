package com.chadi.springjwt.repository;

import java.util.Optional;

import com.chadi.springjwt.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
	Collaborator findByUsername(String username);
	Collaborator findCollaboratorsById(Long id);

	Boolean existsByUsername(String username);

}
