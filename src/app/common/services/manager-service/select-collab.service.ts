import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const BASE_URL = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})
export class SelectCollabService {

  constructor(private httpClient : HttpClient) { }

  model = 'collaborators';
  model1 = 'collaborator';
  model2= 'api';
  
  public selectCollab( selectedCollabUsername : string, managerUsername : string): Observable<any>{

    return this.httpClient.post<any>(`${BASE_URL}/${this.model2}/add/selected/collaborators/${managerUsername}`,selectedCollabUsername);

  }

  public getSelectedCollabs():Observable<any>{
    return this.httpClient.get<any>(`${BASE_URL}/${this.model2}/all/selected/collaborators`);

  }
}
