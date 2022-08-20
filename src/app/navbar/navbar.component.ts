import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from '../common/services/login-service/login-service.service';
import { UserAuthService } from '../common/services/user-auth-service/user-auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private userAuthService : UserAuthService, private router:Router,
     private loginService :LoginServiceService) { }

  ngOnInit(): void {
  }

  public logout(){
    this.userAuthService.clear();
    this.router.navigate(['/login']);
  }

  public roleMatch(role : string):boolean{
    return this.loginService.roleMatch(role);
  }

}
