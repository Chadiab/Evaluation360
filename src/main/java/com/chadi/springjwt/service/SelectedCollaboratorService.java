package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.SelectedCollaborator;

import java.util.List;

public interface SelectedCollaboratorService {


    public SelectedCollaborator addSelectedCollaborator(String managerUsername,String selectedCollaboratorUsername);
    public List<SelectedCollaborator> getSelectedCollaborators();
}
