package com.chadi.springjwt.controllers;

import com.chadi.springjwt.entity.EvaluationForm;
import com.chadi.springjwt.entity.Theme;
import com.chadi.springjwt.model.CreateForm;
import com.chadi.springjwt.repository.EvaluationFormRepository;
import com.chadi.springjwt.service.EvaluationFormServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
@Transactional
public class EvaluationFormController {

    private final EvaluationFormServiceImpl evaluationFormService;

    @PostMapping(path = "/create/form")
    public void createForm(@RequestBody EvaluationForm evaluationForm){
        this.evaluationFormService.createForm(evaluationForm);
    }

    @GetMapping(path = "/all/forms")
    public List<EvaluationForm> getForms(){
        return this.evaluationFormService.getForms();
    }

    @DeleteMapping(path = "/delete/form/{formId}")
    public void deleteForm(@PathVariable("formId") long formId){
        this.evaluationFormService.deleteForm(formId);
    }
}
