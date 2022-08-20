import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CreateFormService {

  constructor(private httpClient : HttpClient) { }

  BASE_URL  = environment.baseUrl;
  model1= "api";


  createEvaluationForm(formObject : any): Observable<void>{
    console.log(formObject);
    return this.httpClient.post<void>(`${this.BASE_URL}/${this.model1}/create/form`,formObject);
  }
}
