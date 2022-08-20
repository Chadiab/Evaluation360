package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.Evaluation;
import com.chadi.springjwt.entity.EvaluationForm;
import com.chadi.springjwt.model.AddEvaluationToCollab;
import com.chadi.springjwt.repository.CollaboratorRepository;
import com.chadi.springjwt.repository.EvaluationFormRepository;
import com.chadi.springjwt.repository.EvaluationRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Data
@Slf4j
public class EvaluationServiceImpl implements EvaluationService{

    private final CollaboratorRepository collaboratorRepository;
    private final EvaluationRepository evaluationRepository;
    private final EvaluationFormRepository evaluationFormRepository;

    @Override
    public List<EvaluationForm> getEvaluationsByCollaborator(String collaboratorUsername) {
        Collaborator collaborator = collaboratorRepository.findByUsername(collaboratorUsername);
        List<EvaluationForm> evaluationForms = new ArrayList<>();

        collaborator.getEvaluations().forEach(evaluation -> {
            evaluationForms.add(evaluation.getEvaluationForm());
        });
        return evaluationForms;
    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        return this.evaluationRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEvaluation(EvaluationForm evaluationForm, String collaboratorUsername) {
        Collaborator collaborator = collaboratorRepository.findByUsername(collaboratorUsername);
        //EvaluationForm evaluationForm = evaluationFormRepository.findEvaluationFormById(addEvaluationToCollab.getEvaluationForm().getId());
        Evaluation evaluation = new Evaluation();
        evaluation.setCollaborator(collaborator);
        evaluation.setEvaluationForm(evaluationForm);
        System.out.println(evaluation.getCollaborator());
        evaluationRepository.save(evaluation);
    }


}

