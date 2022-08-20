package com.chadi.springjwt.controllers;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.Evaluation;
import com.chadi.springjwt.entity.EvaluationForm;
import com.chadi.springjwt.model.AddEvaluationToCollab;
import com.chadi.springjwt.repository.CollaboratorRepository;
import com.chadi.springjwt.repository.EvaluationRepository;
import com.chadi.springjwt.service.EvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class EvaluationController {
    public final EvaluationService evaluationService;
    private final CollaboratorRepository collaboratorRepository;
    private final EvaluationRepository evaluationRepository;

    @CrossOrigin
    @GetMapping(path = "/evaluation/{collaboratorUsername}")
    public ResponseEntity<List<EvaluationForm>> getEvaluationsByCollaborator(@PathVariable("collaboratorUsername") String collaboratorUsername){
        List<EvaluationForm> evaluations = this.evaluationService.getEvaluationsByCollaborator(collaboratorUsername);
        return  new ResponseEntity<>(evaluations, HttpStatus.OK);
    }
    @GetMapping(path = "/evaluation/all")
    public ResponseEntity<List<Evaluation>> getAllEvaluations(){
        List<Evaluation> evaluations = this.evaluationService.getAllEvaluations();
        return  new ResponseEntity<>(evaluations, HttpStatus.OK);
    }
    @PostMapping(path = "/evaluation/add/{collaboratorUsername}")
    public ResponseEntity<?>saveEvaluation(@RequestBody EvaluationForm evaluationForm, @PathVariable("collaboratorUsername") String collaboratorUsername) {
         this.evaluationService.saveEvaluation(evaluationForm, collaboratorUsername);
        return ResponseEntity.ok().build();
    }




}
