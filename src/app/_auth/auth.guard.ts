import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginServiceService } from '../common/services/login-service/login-service.service';
import { UserAuthService } from '../common/services/user-auth-service/user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private userAuthService : UserAuthService, private router:Router,
     private loginService:LoginServiceService){}

  canActivate(
    route: ActivatedRouteSnapshot, //helps us to collect the data from the route in app.routes.module.ts
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      if(this.userAuthService.getToken !== null){
        const role = route.data["roles"] as Array<string>;

        if(role){
          const match = this.loginService.roleMatch(role[0]);

          if(match){
            return true;
          }else{
            this.router.navigate(['/forbidden']);
            return false;
          }
        }
      }

      this.router.navigate(['/login']);
      return false;


  }
  
}
