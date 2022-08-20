package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.EvaluationRequest;
import com.chadi.springjwt.model.RequestCollab;
import com.chadi.springjwt.repository.CollaboratorRepository;
import com.chadi.springjwt.repository.EvaluationRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //lambok will inject the repos for us
@Transactional
@Slf4j
public class EvaluationRequestServiceImpl implements EvaluationRequestService{

    private  final EvaluationRequestRepository evaluationRequestRepository;
    private final CollaboratorRepository collaboratorRepository;

    @Override
    public EvaluationRequest addRequest(EvaluationRequest evaluationRequest, String collaboratorUsername) {
        Collaborator collaborator = collaboratorRepository.findByUsername(collaboratorUsername);
        evaluationRequest.setCollaborator(collaborator);
        return this.evaluationRequestRepository.save(evaluationRequest);
    }

    @Override
    public EvaluationRequest updateRequest(EvaluationRequest newEvaluationRequest, Long requestId) {
        return this.evaluationRequestRepository.findById(requestId).map(evaluationRequest -> {
            evaluationRequest.setStatus(newEvaluationRequest.getStatus());

            return this.evaluationRequestRepository.save(evaluationRequest);

        }).orElseGet(() -> {
            newEvaluationRequest.setId(requestId);
            return this.evaluationRequestRepository.save(newEvaluationRequest);
        });
    }

    @Override
    public List<RequestCollab> getRequests() {
        List<EvaluationRequest> requests = new ArrayList<>();
        List<RequestCollab> requestsWithCollab = new ArrayList<>();
        requests = this.evaluationRequestRepository.findAll();

        requests.forEach(request -> {
            Collaborator collaborator = request.getCollaborator();
            RequestCollab requestCollab = new RequestCollab();
            requestCollab.setEvaluationRequest(request);
            requestCollab.setRequestCollaborator(collaborator);
            requestsWithCollab.add(requestCollab);
        });


        return requestsWithCollab;
    }
}
