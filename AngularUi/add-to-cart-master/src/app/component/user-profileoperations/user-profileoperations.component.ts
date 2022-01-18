import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-user-profileoperations',
  templateUrl: './user-profileoperations.component.html',
  styleUrls: ['./user-profileoperations.component.scss']
})
export class UserProfileoperationsComponent implements OnInit {
user:any
  constructor(private apiService:ApiService) { }

  ngOnInit(): void {
   
  }
  public deleteUser(uId:any)
  {
    let resp=this.apiService.deleteUser(uId)
    resp.subscribe((data)=>this.user=data)
  }

}
