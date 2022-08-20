import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EvaluationFormService {

  constructor(private httpClient : HttpClient) { }
  
  BASE_URL  = environment.baseUrl;
  model1= "api";



  public getForms():Observable<any>{
    return this.httpClient.get<any>(`${this.BASE_URL}/${this.model1}/all/forms`);
  }

  deleteForm(formId: number):Observable<any>{
    return this.httpClient.delete<any>(`${this.BASE_URL}/${this.model1}/delete/form/${formId}`);

  }


}
