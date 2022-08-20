import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { first } from 'rxjs';
import { UserAuthService } from 'src/app/common/services/user-auth-service/user-auth.service';
import { Collaborator } from '../../common/models/collaborator';
import { HomeService } from '../../common/services/manager-service/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private homeService : HomeService, private userAuthService : UserAuthService) { }
  
  collaborators :Collaborator[] = [];

  deletedCollaboratorId : any;
  updatedCollaboratorId : any;





  ngOnInit(): void {                //Since our component implements OnInit then we're gonna overwrite the ngOnInit() method.
    this.getCollaborators();
  }

  // fetchAllCollaborators(){
  //   this.homeService.all()
  //   .subscribe((result:any)=>this.collaborators=result);
  // }


  editCollaborator : Collaborator = {
    id:0,
    username:"",
    password:"",
    firstName:"",
    lastName:"",
    avatar:"",
    code:"",
  }


  managerName = this.userAuthService.getUsername();



  



// selectEvaluation(evaluation : Evaluation){
//   this.selectedEvaluation = evaluation;
  
// }

public getCollaborators() : void {
  this.homeService.getCollaborators()
  .subscribe((response : Collaborator[]) => {this.collaborators = response;}
  );
}


public onAddCollaborator(addForm : NgForm){

  document.getElementById('add-employee-form')?.click();
  this.homeService.addCollaborator(addForm.value).
  subscribe((response : Collaborator) => {
    console.log("adding now!")
    console.log(response);
    this.getCollaborators();
  });

}

getDeleteCollaborator(collaboratorId: number){
  this.deletedCollaboratorId = collaboratorId;
}
getUpdatedCollaborator(collaborator:Collaborator,collaboratorId:number){
  this.updatedCollaboratorId = collaboratorId;
  this.editCollaborator = collaborator;
}

onDeleteCollaborator(collaboratorId : number){
  this.homeService.deleteCollaborator(collaboratorId).
  subscribe((result : any) => this.getCollaborators())

}

onUpdateCollaborator(collaborator : Collaborator,updatedCollaboratorId:number){
  this.homeService.updateCollaborator(collaborator,updatedCollaboratorId).
  subscribe((result : any) => this.getCollaborators());
}



}
