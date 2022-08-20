import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HomeComponent } from './Manager/home/home.component';
import { EvaluationComponent } from './_user/evaluation/evaluation.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserComponent } from './_user/user/user.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { RouterModule } from '@angular/router';
import { AdminComponent } from './_admin/admin/admin.component';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { LoginServiceService } from './common/services/login-service/login-service.service';
import { ToastrModule } from 'ngx-toastr';
import { CreateFormComponent } from './_admin/create-form/create-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { EvaluationFormsComponent } from './_admin/evaluation-forms/evaluation-forms.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CurrentFormComponent } from './Manager/current-form/current-form.component';
import { SelectCollabsComponent } from './Manager/select-collabs/select-collabs.component';
import { RequestsComponent } from './Manager/requests/requests/requests.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EvaluationComponent,
    LoginComponent,
    NavbarComponent,
    UserComponent,
    ForbiddenComponent,
    AdminComponent,
    CreateFormComponent,
    EvaluationFormsComponent,
    CurrentFormComponent,
    SelectCollabsComponent,
    RequestsComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ToastrModule.forRoot({
      timeOut:1000,
      progressBar: true
    }),
    ReactiveFormsModule,
    FontAwesomeModule


    
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    LoginServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
