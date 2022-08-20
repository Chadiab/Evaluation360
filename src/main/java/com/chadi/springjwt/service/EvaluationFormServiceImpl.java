package com.chadi.springjwt.service;

import com.chadi.springjwt.entity.EvaluationForm;
import com.chadi.springjwt.entity.Theme;
import com.chadi.springjwt.repository.EvaluationFormRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
@Data
@AllArgsConstructor

public class EvaluationFormServiceImpl implements EvaluationFormService{

    private final EvaluationFormRepository evaluationFormRepository;

    @Override
    public void createForm(EvaluationForm evaluationForm) {
        EvaluationForm evaluationForm1 = new EvaluationForm();
        Theme theme = new Theme();
        evaluationForm1.setFormName(evaluationForm.getFormName());
        evaluationForm1.setCreatedAt(evaluationForm.getCreatedAt());
        evaluationForm1.setTargetCollaborator(evaluationForm.getTargetCollaborator());
        evaluationForm1.setThemes(evaluationForm.getThemes());
        evaluationFormRepository.save(evaluationForm1);
    }



    @Override
    public List<EvaluationForm> getForms() {
        return this.evaluationFormRepository.findAll();
    }

    @Override
    public void deleteForm(long formId) {
        boolean formExists = this.evaluationFormRepository.existsById(formId);
        if(!formExists){
            throw new IllegalStateException("Form with id "+ formId + "does not exist");
        }
        this.evaluationFormRepository.deleteById(formId);
    }
}
