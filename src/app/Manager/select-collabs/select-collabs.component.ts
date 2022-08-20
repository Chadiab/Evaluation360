import { Component, OnInit } from '@angular/core';
import { Collaborator } from 'src/app/common/models/collaborator';
import { HomeService } from 'src/app/common/services/manager-service/home.service';
import { SelectCollabService } from 'src/app/common/services/manager-service/select-collab.service';
import { UserAuthService } from 'src/app/common/services/user-auth-service/user-auth.service';

@Component({
  selector: 'app-select-collabs',
  templateUrl: './select-collabs.component.html',
  styleUrls: ['./select-collabs.component.scss']
})
export class SelectCollabsComponent implements OnInit {

  constructor(private homeService : HomeService, private userAuth : UserAuthService, 
    private selectCollabService : SelectCollabService) { }
  collaborators :Collaborator[] = [];


  ngOnInit(): void {
    this.getCollaborators();
  }

managerUsername : string = this.userAuth.getUsername();

  public getCollaborators() : void {
    this.homeService.getCollaborators()
    .subscribe((response : Collaborator[]) => {this.collaborators = response;
      console.log(this.collaborators)
    
    }
    );
  }

  public selectCollab(selectedCollabUsername : string){

    this.selectCollabService.selectCollab(selectedCollabUsername,this.managerUsername)
    .subscribe((response) => {
      console.log(response);
    })
  }

  public getCollabs(){
    this.selectCollabService.getSelectedCollabs()
    .subscribe((reponse) =>{
      console.log(reponse);
    })
  }



}
