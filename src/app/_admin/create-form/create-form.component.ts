import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Criteria } from 'src/app/common/models/criteria';
import { Theme } from 'src/app/common/models/theme';
import { CreateFormService } from 'src/app/common/services/create-form-service/create-form.service';
import { RequestService } from 'src/app/common/services/request-service/request.service';

@Component({
  selector: 'app-create-form',
  templateUrl: './create-form.component.html',
  styleUrls: ['./create-form.component.scss']
})
export class CreateFormComponent implements OnInit {

  constructor(private fb : FormBuilder, private createFormService : CreateFormService, private router:Router, 
    private requestService : RequestService) { }

  ngOnInit(): void {


    this.getRequests();
    this.themes.push({...this.theme});   

  }

criterias : Criteria[] = [];


criteria : Criteria = {
  criteriaName : ""
}

theme : Theme = {
  themeName : "",
  criterias : this.criterias
}

themes : Theme[] = [];

formName : any = "";
createdAt:any = "";
targetCollaborator:any ="";

addTheme(){
 const theme1 : Theme = {
    themeName : "",
    criterias : []
  }


  this.themes.push({...theme1});

}

addCriteria(theme : Theme){
  const criteria1 : Criteria = {
    criteriaName : ""
  }
  theme.criterias.push({...criteria1});
}

formObject = {
  formName : "",
  createdAt :"",
  targetCollaborator:"",
  themes : this.themes

}
requests : any;
acceptedRequests : any[] = [];

createEvaluationForm(){
  this.acceptedRequests=this.acceptedRequests.splice(1);
  console.log(this.acceptedRequests);
  this.createFormService.createEvaluationForm({...this.formObject})
  .subscribe((response : any) =>{
    console.log(response)

    this.router.navigate(['/forms'])
  })
}

public removeAcceptedRequest(requestId : number){
  this.requestService.declineRequest(requestId)
  .subscribe((response) =>{
    console.log(response);
  })

}

public getRequests(){
  this.requestService.getRequests()
  .subscribe((response) =>{
    console.log(response);
    this.requests=response;
    for(const element of this.requests){
      if(element.evaluationRequest.status === "Accepted"){
        this.acceptedRequests.push(element);

      }
    }

    console.log(this.acceptedRequests);
    this.formObject.targetCollaborator = this.acceptedRequests[0].requestCollaborator.username;
    this.removeAcceptedRequest(this.acceptedRequests[0].evaluationRequest.id);



  })
}
}
