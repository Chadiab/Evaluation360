package com.chadi.springjwt.controllers;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.EvaluationRequest;
import com.chadi.springjwt.model.RequestCollab;
import com.chadi.springjwt.service.EvaluationRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class RequestController {

    public final EvaluationRequestService evaluationRequestService;

    @PostMapping("/post/request/{collaboratorUsername}")
    public ResponseEntity<EvaluationRequest> addRequest(@RequestBody EvaluationRequest evaluationRequest,
                                                        @PathVariable("collaboratorUsername") String collaboratorUsername) {
        EvaluationRequest evaluationRequest1 = this.evaluationRequestService.addRequest(evaluationRequest, collaboratorUsername);
        return new ResponseEntity<EvaluationRequest>(evaluationRequest1, HttpStatus.OK);
    }

    @PutMapping(path = "/update/request/status/{requestId}")
    public ResponseEntity<EvaluationRequest> updateRequest(@RequestBody EvaluationRequest newRequest, @PathVariable("requestId") Long id) {

        EvaluationRequest updatedRequest = evaluationRequestService.updateRequest(newRequest, id);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/all/requests")
    public ResponseEntity<List<RequestCollab>> getRequests() {
        List<RequestCollab> requests= this.evaluationRequestService.getRequests();
        return  new ResponseEntity<>(requests, HttpStatus.OK);
    }
}
