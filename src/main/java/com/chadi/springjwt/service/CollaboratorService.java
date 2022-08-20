package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.Evaluation;
import com.chadi.springjwt.entity.Role;

import java.util.List;

public interface CollaboratorService {
    Collaborator saveCollaborator(Collaborator collaborator);
    Role saveRole(Role role);
    void addRoleToCollaborator(String username, String roleName);
    Collaborator getCollaborator(String username);
    List<Collaborator> getCollaborators();
    public void deleteCollaborator(Long collaboratorId);
    public Collaborator updateCollaborator(Collaborator newCollaborator,Long id);

}
