package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Evaluation;
import com.chadi.springjwt.entity.EvaluationForm;
import com.chadi.springjwt.model.AddEvaluationToCollab;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

public interface EvaluationService {

    public List<EvaluationForm> getEvaluationsByCollaborator(String collaboratorUsername);
    public List<Evaluation> getAllEvaluations();
    public void saveEvaluation (EvaluationForm evaluationForm, String collaboratorUsername);


    }
