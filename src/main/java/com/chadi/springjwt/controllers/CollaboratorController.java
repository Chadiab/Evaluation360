package com.chadi.springjwt.controllers;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.Evaluation;
import com.chadi.springjwt.entity.Role;
import com.chadi.springjwt.model.RoleToCollaboratorForm;
import com.chadi.springjwt.service.CollaboratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api")
public class CollaboratorController {
    private final CollaboratorServiceImpl collaboratorService;

    @Autowired
    public CollaboratorController(CollaboratorServiceImpl collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Collaborator>> getCollaborators() {
        List<Collaborator> collaborators= this.collaboratorService.getCollaborators();
        return  new ResponseEntity<>(collaborators, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Collaborator>saveCollaborator(@RequestBody Collaborator collaborator) {
        Collaborator collaborator1 = this.collaboratorService.saveCollaborator(collaborator);
        return new ResponseEntity<Collaborator>(collaborator1, HttpStatus.OK);
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(collaboratorService.saveRole(role));
    }
    @PostMapping("/role/addtocollaborator")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToCollaboratorForm form) {
        collaboratorService.addRoleToCollaborator(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{collaboratorId}")
    public void deleteCollaborator(@PathVariable("collaboratorId") Long id){
        this.collaboratorService.deleteCollaborator(id);
    }

    @PutMapping(path = "/update/{collaboratorId}")
    public ResponseEntity<Collaborator> updateCollaborator(@RequestBody Collaborator newCollaborator,@PathVariable("collaboratorId") Long id){

        Collaborator updateCollaborator = collaboratorService.updateCollaborator(newCollaborator,id);
        return new ResponseEntity<>(updateCollaborator, HttpStatus.OK);
    }






}
