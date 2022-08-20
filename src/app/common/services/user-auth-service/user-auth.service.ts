import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  
  constructor() { }

  public setRoles(roles:[]){
    localStorage.setItem("roles", JSON.stringify(roles));
}

public getRoles():string[]{
  return JSON.parse(localStorage.getItem("roles") || "{}");
}

public setToken(jwtToken:string){
  localStorage.setItem("jwtToken", JSON.stringify(jwtToken));
}
public setUsername(username:string){
  localStorage.setItem("username", JSON.stringify(username));
}

public getToken():string{
 return  JSON.parse(localStorage.getItem("jwtToken") || "{}");

}

public getUsername():string{
  return  JSON.parse(localStorage.getItem("username") || "{}");

}

//Getters and Setters for token and roles from the localStorage.

public clear(){
  localStorage.clear();
}

public isLoggedIn(){
  return this.getRoles() && this.getToken();
}

}
