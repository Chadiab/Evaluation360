package com.chadi.springjwt.model;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.EvaluationRequest;
import lombok.Data;

@Data
public class RequestCollab {
    private EvaluationRequest evaluationRequest;
    private Collaborator requestCollaborator;
}
