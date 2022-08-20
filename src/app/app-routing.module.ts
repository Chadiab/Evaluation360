import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './_admin/admin/admin.component';
import { EvaluationComponent } from './_user/evaluation/evaluation.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './Manager/home/home.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './_user/user/user.component';
import { AuthGuard } from './_auth/auth.guard';
import { CreateFormComponent } from './_admin/create-form/create-form.component';
import { EvaluationFormsComponent } from './_admin/evaluation-forms/evaluation-forms.component';
import { CurrentFormComponent } from './Manager/current-form/current-form.component';
import { SelectCollabsComponent } from './Manager/select-collabs/select-collabs.component';
import { RequestsComponent } from './Manager/requests/requests/requests.component';

const routes: Routes = [
  {
    path:'manager', component: HomeComponent, canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']}
  },
  {
    path:'current-form', component: CurrentFormComponent, canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']}
  },
  {
    path:'select-collaborators', component: SelectCollabsComponent, canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']}
  },
  {
    path:'requests', component: RequestsComponent, canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']}
  },
  {
    path:'evaluation', component: EvaluationComponent,
  },
  {
    path:'user', component: UserComponent, canActivate:[AuthGuard], data:{roles:['ROLE_USER']}
  },
  {
    path:'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['ROLE_ADMIN']}
  },
  {
    path:'forbidden', component: ForbiddenComponent,
  },
  {
    path:'login', component: LoginComponent,
  },
  {
    path:'create', component: CreateFormComponent,
  },
  {
    path:'forms', component: EvaluationFormsComponent,
  },
  {
    path: '**', redirectTo: '/login' 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
