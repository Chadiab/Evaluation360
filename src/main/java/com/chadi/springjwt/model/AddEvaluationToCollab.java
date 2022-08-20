package com.chadi.springjwt.model;

import com.chadi.springjwt.entity.EvaluationForm;
import lombok.Data;

@Data
public class AddEvaluationToCollab {

    private EvaluationForm evaluationForm;
    private String collaborator_username;
}
