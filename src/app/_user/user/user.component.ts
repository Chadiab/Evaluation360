import { Component, OnInit } from '@angular/core';
import { Evaluation1 } from 'src/app/common/models/evaluation1';
import { EvaluationService } from 'src/app/common/services/evaluation-service/evaluation.service';
import { RequestService } from 'src/app/common/services/request-service/request.service';
import { UserAuthService } from 'src/app/common/services/user-auth-service/user-auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  constructor(private userAuth : UserAuthService, private evaluationService : EvaluationService,
    private requestService : RequestService ) { }

  ngOnInit(): void {
    this.getUserEvaluations();
  }

  userEvaluationForms : any = [];


 userName = this.userAuth.getUsername();

 test : boolean = true;

  getUserEvaluations(){
    this.evaluationService.getUserEvaluationForms(this.userAuth.getUsername())
    .subscribe((response : any) => {
      this.userEvaluationForms = response;
      console.log(this.userEvaluationForms);
    })
  }
  sendRequest(){
    this.requestService.sendRequest(this.userAuth.getUsername())
    .subscribe((response:any) =>{
      console.log(response);
      this.test = false;
    })

  }



}
