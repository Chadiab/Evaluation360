import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


const BASE_URL = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})
export class RequestService {


  constructor(private http : HttpClient) { }

  model = 'collaborators';
  model1 = 'collaborator';
  model2= 'api';


  public sendRequest(collaboratorUsername : String): Observable<any>{
    return this.http.post<any>(`${BASE_URL}/${this.model2}/post/request/${collaboratorUsername}`,{});
  }

  public getRequests():Observable<any>{
    return this.http.get<any>(`${BASE_URL}/${this.model2}/all/requests`);
  }

  public acceptRequest(requestId : number):Observable<any>{

    const acceptedRequest = {
      "status":"Accepted"
    }

    return this.http.put<any>(`${BASE_URL}/${this.model2}/update/request/status/${requestId}`,acceptedRequest);

  }

  public declineRequest(requestId : number):Observable<any>{
    
    const acceptedRequest = {
      "status":"Declined"
    }

    return this.http.put<any>(`${BASE_URL}/${this.model2}/update/request/status/${requestId}`,acceptedRequest);

  }
}
