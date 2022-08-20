import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from '../common/services/login-service/login-service.service';
import { UserAuthService } from '../common/services/user-auth-service/user-auth.service';
import { LoginRequestPayload } from '../common/models/login.request.payload';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm : LoginRequestPayload = {
    username:"",
    password:""
  }
  

  constructor(private loginService : LoginServiceService, private router:Router,
    private userAuthService : UserAuthService) { }

  ngOnInit(): void {
  }

  public login(loginForm : NgForm){
    this.loginService.login(loginForm.value)
    .subscribe((response : any) => {
      this.userAuthService.setToken(response.accessToken);
      this.userAuthService.setRoles(response.roles);
      this.userAuthService.setUsername(response.username);

      const role = response.roles[0];

      if(role === "ROLE_MANAGER"){
        this.router.navigate(['/manager']);
      }else if(role === "ROLE_USER"){
        this.router.navigate(['/user']);
      }else{
        this.router.navigate(['/admin']);
      }


      
    },err =>{
      
    });
    
 
  }

}
