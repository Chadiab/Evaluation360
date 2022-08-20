package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.SelectedCollaborator;
import com.chadi.springjwt.repository.CollaboratorRepository;
import com.chadi.springjwt.repository.SelectedCollaboratorRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Slf4j
public class SelectedCollaboratorServiceImpl implements SelectedCollaboratorService {
    private final SelectedCollaboratorRepository selectedCollaboratorRepository;
    private final CollaboratorRepository collaboratorRepository;

    @Override
    public SelectedCollaborator addSelectedCollaborator(String managerUsername,String selectedCollaboratorUsername) {
        Collaborator manager = this.collaboratorRepository.findByUsername(managerUsername);
        SelectedCollaborator selectedCollaborator1 = new SelectedCollaborator();
        selectedCollaborator1.setSelectedCollaboratorUsername(selectedCollaboratorUsername);
        selectedCollaborator1.setManager(manager);
        return selectedCollaboratorRepository.save(selectedCollaborator1);
    }

    @Override
    public List<SelectedCollaborator> getSelectedCollaborators() {
        return this.selectedCollaboratorRepository.findAll();
    }
}
