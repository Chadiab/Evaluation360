package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.Evaluation;
import com.chadi.springjwt.entity.Role;
import com.chadi.springjwt.repository.CollaboratorRepository;
import com.chadi.springjwt.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor //lambok will inject the repos for us
@Transactional
@Slf4j
public class CollaboratorServiceImpl implements CollaboratorService{
    private final CollaboratorRepository collaboratorRepo;
    private final RoleRepository roleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Collaborator saveCollaborator(Collaborator collaborator) {
        Collaborator collaboratorTest =  collaboratorRepo.findByUsername(collaborator.getUsername());
        if(collaboratorTest != null){
            throw new IllegalStateException("This username is taken !");
        }
        log.info("Saving new user {} to the database", collaborator.getFirstName());
        collaborator.setPassword(passwordEncoder.encode(collaborator.getPassword()));

        return collaboratorRepo.save(collaborator);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());

        return roleRepo.save(role);
    }

    @Override
    public void deleteCollaborator(Long collaboratorId) {
        boolean collaboratorExists = this.collaboratorRepo.existsById(collaboratorId);
        if(!collaboratorExists){
            throw new IllegalStateException("Collaborator with id "+ collaboratorId + "does not exist");
        }
        this.collaboratorRepo.deleteById(collaboratorId);
    }

    @Override
    public Collaborator updateCollaborator(Collaborator newCollaborator, Long id) {
        return this.collaboratorRepo.findById(id).map(collaborator -> {
            collaborator.setFirstName(newCollaborator.getFirstName());
            collaborator.setLastName(newCollaborator.getLastName());
            collaborator.setUsername(newCollaborator.getUsername());
            collaborator.setPassword(passwordEncoder.encode(newCollaborator.getPassword()));
            collaborator.setAvatar(newCollaborator.getAvatar());
            return this.collaboratorRepo.save(collaborator);

        }).orElseGet(() -> {
            newCollaborator.setId(id);
            return this.collaboratorRepo.save(newCollaborator);
        });
    }



    @Override
    public void addRoleToCollaborator(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);

        Collaborator collaborator  = collaboratorRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        collaborator.getRoles().clear();
        collaborator.getRoles().add(role);

    }

    @Override
    public Collaborator getCollaborator(String username) {
        log.info("Fetching user {}", username);

        return collaboratorRepo.findByUsername(username);
    }

    @Override
    public List<Collaborator> getCollaborators() {
        log.info("Fetching all users");

        return collaboratorRepo.findAll();
    }




}
