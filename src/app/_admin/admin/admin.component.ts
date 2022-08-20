import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Collaborator } from 'src/app/common/models/collaborator';
import { HomeService } from 'src/app/common/services/manager-service/home.service';
import { UserAuthService } from 'src/app/common/services/user-auth-service/user-auth.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor(private homeService : HomeService, private userAuth : UserAuthService) { }

  collaborators :Collaborator[] = [];

  deletedCollaboratorId : any;
  updatedCollaboratorId : any;
  collaboratorUsername : any;
  collaboratorRole : any;





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

  adminName = this.userAuth.getUsername();
  
public getCollaboratorUsername(username  : string){
  this.collaboratorUsername = username;
}


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


public onAddCollaboratorRole(){

  document.getElementById('add-employee-form')?.click();
  this.homeService.addCollaboratorRole(this.collaboratorRole,this.collaboratorUsername).
  subscribe((response : any) => {
    console.log("adding role now!");
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
