import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { User } from 'src/app/model/user';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {


user:User=new User(0,"","","",0,"","")
message:any
  constructor(private apiService:ApiService) {
    
   }

  ngOnInit(): void {
    
  }
  public registerNow()
  {
    let resp=this.apiService.doRegistration(this.user)
    resp.subscribe((data)=>this.message=data)
  }

}
