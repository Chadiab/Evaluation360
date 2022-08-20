import { Component, OnInit } from '@angular/core';
import { EvaluationFormService } from 'src/app/common/services/evaluation-forms/evaluation-form.service';
import { faSquareMinus } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';

@Component({
  selector: 'app-evaluation-forms',
  templateUrl: './evaluation-forms.component.html',
  styleUrls: ['./evaluation-forms.component.scss']
})
export class EvaluationFormsComponent implements OnInit {

  constructor(private evaluationFormService : EvaluationFormService, private router:Router) { }


  ngOnInit(): void {
    this.getForms();
  }
  faSquareMinus = faSquareMinus;


  
  evaluationForms : any

  public getForms():any{
    return this.evaluationFormService.getForms()
    .subscribe((response) => {
      this.evaluationForms = response;
      console.log(this.evaluationForms)
    })
  }

  deleteForm(formId : number){
    return this.evaluationFormService.deleteForm(formId)
    .subscribe((response) => {
      this.getForms();
    })
  }

  
}
