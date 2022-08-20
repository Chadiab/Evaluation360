import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequestPayload } from 'src/app/common/models/login.request.payload';
import { environment } from 'src/environments/environment';
import { UserAuthService } from '../user-auth-service/user-auth.service';


@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http : HttpClient, private userAuthService : UserAuthService) { }
   BASE_URL = environment.baseUrl;


   headers = new HttpHeaders({
    'Content-Type': 'application/json'
  
   })
    options = {
    headers: this.headers

    
};



  
  public login(loginData :LoginRequestPayload){

    console.log("Logging in")
    return this.http.post(this.BASE_URL + "/api/signin",loginData, this.options);

  }

  public roleMatch(role : string):boolean{
    let verif = false;
    let user_roles = this.userAuthService.getRoles();

    if(role === user_roles[0]){
      verif = true;
      return verif;
    }else{
      return verif;
    }

  }


}
