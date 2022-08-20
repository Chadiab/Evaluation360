import { Component } from '@angular/core';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Plateforme360';

  links = [
    { path: '/home', icon: 'home', title: 'Home' },
    { path: '/evaluation', icon: 'view_list', title: 'Evaluations' },
    
  ];



}
