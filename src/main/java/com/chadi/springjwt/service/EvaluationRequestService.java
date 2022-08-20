package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.EvaluationRequest;
import com.chadi.springjwt.model.RequestCollab;

import java.util.List;

public interface EvaluationRequestService {
    EvaluationRequest addRequest(EvaluationRequest evaluationRequest, String collaboratorUsername);
    EvaluationRequest updateRequest(EvaluationRequest evaluationRequest, Long requestId);
    List<RequestCollab> getRequests();


}
