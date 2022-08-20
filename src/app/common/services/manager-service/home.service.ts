import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Collaborator } from '../../models/collaborator';
import { Roletocollab } from '../../models/roletocollab';
import { LoginServiceService } from '../login-service/login-service.service';
import { UserAuthService } from '../user-auth-service/user-auth.service';


const BASE_URL = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})


export class HomeService {

  model = 'collaborators';
  model1 = 'collaborator';
  model2= 'api';


  constructor(private http : HttpClient, private userAuthService : UserAuthService) { }







  private getUrl(){
    return `${BASE_URL}/${this.model}`;
  }


  all(){
    return this.http.get(this.getUrl());
  }

  
  getCollaborators() : Observable<Collaborator[]>{
    return this.http.get<Collaborator[]>(`${BASE_URL}/${this.model2}/all`);
  }

  addCollaborator(collaborator : Collaborator) : Observable<Collaborator>{
    console.log("adding employee");
    return this.http.post<Collaborator>(`${BASE_URL}/${this.model2}/add`,collaborator);
  }


  addCollaboratorRole(collaboratorRole:string, collaboratorUsername:string) : Observable<void>{
    console.log("adding Role to employee");
    const addRoleForm = {
      "username":collaboratorUsername,
      "roleName":collaboratorRole
    }
   
    return this.http.post<void>(`${BASE_URL}/${this.model2}/role/addtocollaborator`,addRoleForm);
  }

  updateCollaborator(collaborator : Collaborator,collaboratorId:number) : Observable<Collaborator>{
    return this.http.put<Collaborator>(`${BASE_URL}/${this.model2}/update/${collaboratorId}`, collaborator);
  }

  deleteCollaborator(collaboratorId : number) : Observable<void>{
    return this.http.delete<void>(`${BASE_URL}/${this.model2}/delete/${collaboratorId}`);
  }





















//   evaluations=[
//     {
//       id : "1",
//       title:"third evaluation",
//       date:"2022",
//       score:"10",
//       content:"evaluation3 content goes here"

//     },
//     {
//       id : "1",
//       title:"third evaluation",
//       date:"2022",
//       score:"10",
//       content:"evaluation2 content goes here"

//     },    
//     {
//       id : "1",
//       title:"third evaluation",
//       date:"2022",
//       score:"10",
//       content:"evaluation1 content goes here"

//     }
//   ]
// }
}


