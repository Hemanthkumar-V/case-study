import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-delete-update',
  templateUrl: './delete-update.component.html',
  styleUrls: ['./delete-update.component.scss']
})
export class DeleteUpdateComponent implements OnInit {

  constructor(private apiService:ApiService ){ }
product:any
  ngOnInit(): void {

  }
  public getProduct()
  {
    let resp=this.apiService.getProduct()
    resp.subscribe((data)=>this.product=data)
  }

}
