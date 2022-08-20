package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.EvaluationForm;

import java.util.List;

public interface EvaluationFormService {

    public void createForm(EvaluationForm evaluationForm);
    public List<EvaluationForm> getForms();
    public void deleteForm(long formId);
}
