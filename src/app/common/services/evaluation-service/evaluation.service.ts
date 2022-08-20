import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Evaluation } from '../../models/evaluation';
import { UserAuthService } from '../user-auth-service/user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {

  constructor(private httpClient : HttpClient) { }

  BASE_URL  = environment.baseUrl;
  model1= "api";
  model2= 'evaluation';




  public getUsernameInput(username : string):string{
    return username;
  }

  public addEvaluation(currentForm : any, targetCollabUsername:string) : Observable<Evaluation>{
    return this.httpClient.post<Evaluation>(`${this.BASE_URL}/${this.model1}/${this.model2}/add/${targetCollabUsername}`,currentForm);
  }


  

  public getUserEvaluationForms(username : string) : Observable<any>{
    return this.httpClient.get<any>(`${this.BASE_URL}/${this.model1}/${this.model2}/${username}`)
  }
}
