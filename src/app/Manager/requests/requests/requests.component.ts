import { Component, OnInit } from '@angular/core';
import { RequestService } from 'src/app/common/services/request-service/request.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss']
})
export class RequestsComponent implements OnInit {

  constructor(private requestService : RequestService) { }

  ngOnInit(): void {
    this.getRequests();
  }


  test : boolean = true;

  requests :any[]=[];

  public getRequests(){
    this.requestService.getRequests()
    .subscribe((response) =>{
      console.log(response);
      for(const element of response){
        if(element.evaluationRequest.status != "Accepted" && element.evaluationRequest.status != "Declined" ){
          this.requests.push(element);
  
        }
    }})
  }

  public acceptRequest(requestId:number){
    this.test = false;
    this.requestService.acceptRequest(requestId)
    .subscribe((response) =>{
      console.log(response);
      this.requests=this.requests.slice(1);

    })
  }

  public declineRequest(requestId:number){
    this.test = true;
    this.requestService.declineRequest(requestId)
    .subscribe((response) =>{
      console.log(response);
      this.requests=this.requests.slice(1);

    })
  }

}
