package com.chadi.springjwt.controllers;


import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.SelectedCollaborator;
import com.chadi.springjwt.repository.CollaboratorRepository;
import com.chadi.springjwt.service.SelectedCollaboratorService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@Data
public class SelectedCollaboratorController {

    private final SelectedCollaboratorService selectedCollaboratorService;


    @PostMapping(path = "/add/selected/collaborators/{managerUsername}")
    public ResponseEntity<SelectedCollaborator>addSelectedCollaborator(@PathVariable("managerUsername") String managerUsername,
                                                                       @RequestBody String selectedCollaboratorUsername) {
        SelectedCollaborator selectedCollaborator1 = this.selectedCollaboratorService.addSelectedCollaborator(managerUsername,selectedCollaboratorUsername);
        return new ResponseEntity<SelectedCollaborator>(selectedCollaborator1,HttpStatus.OK);
    }

    @GetMapping("/all/selected/collaborators")
    public ResponseEntity<List<SelectedCollaborator>> getSelectedCollaborators() {
        List<SelectedCollaborator> selectedCollaborators= this.selectedCollaboratorService.getSelectedCollaborators();
        return  new ResponseEntity<>(selectedCollaborators, HttpStatus.OK);
    }
}
