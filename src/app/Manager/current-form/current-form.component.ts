import { Component, OnInit } from '@angular/core';
import { EvaluationFormService } from 'src/app/common/services/evaluation-forms/evaluation-form.service';

@Component({
  selector: 'app-current-form',
  templateUrl: './current-form.component.html',
  styleUrls: ['./current-form.component.scss']
})
export class CurrentFormComponent implements OnInit {

  constructor(private evaluationFormService : EvaluationFormService) { }

  currentForm : any = {};

  ngOnInit(): void {
    this.getEvaluationForm();
  }

  public getEvaluationForm(): any{
  
    return this.evaluationFormService.getForms()
    .subscribe((response) => {
      this.currentForm = response[response.length - 1];
      console.log(this.currentForm);
    })
  }

}
