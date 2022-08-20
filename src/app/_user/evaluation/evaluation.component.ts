import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { EvaluationFormService } from 'src/app/common/services/evaluation-forms/evaluation-form.service';
import { EvaluationService } from 'src/app/common/services/evaluation-service/evaluation.service';
import { SelectCollabService } from 'src/app/common/services/manager-service/select-collab.service';
import { UserAuthService } from 'src/app/common/services/user-auth-service/user-auth.service';

@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.scss']
})
export class EvaluationComponent implements OnInit {

  constructor(private evaluationService : EvaluationService, 
    private evaluationFormService : EvaluationFormService, 
    private selectCollabService : SelectCollabService,
    private userAuth : UserAuthService,
    private router : Router) { }
    currentForm : any = {};


  ngOnInit(): void {
    this.getEvaluationForm();
  }

test : boolean = false;
selectedCollabs : any

  public getEvaluationForm(): any{
  
    return this.evaluationFormService.getForms()
    .subscribe((response) => {
      this.currentForm = response[response.length - 1];
      console.log(this.currentForm);
      this.selectCollabService.getSelectedCollabs()
      .subscribe((response2) =>{this.selectedCollabs = response2 ;
        
        this.selectedCollabs.forEach((selectedCollab: { id:number,selectedCollaboratorUsername: string; }) => {
          if(selectedCollab.selectedCollaboratorUsername === this.userAuth.getUsername() ){
            this.test = true;
          }
          
        });
        console.log(this.test);
      }
      )
    })
  }


  public addEvaluation(){
   
    this.evaluationService.addEvaluation(this.currentForm,this.currentForm.targetCollaborator).subscribe((reponse : any) =>{

      this.router.navigate(['/user']);
    })
  }



  }




