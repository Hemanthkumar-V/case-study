import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/order';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrls: ['./order-item.component.scss']
})
export class OrderItemComponent implements OnInit {
order:Order=new Order(0,0,"",0,"",0,0,0,"","")
message:any
  constructor(private apiService:ApiService) { }

  ngOnInit(): void {
  }
  public buyNow()
{
  let resp=this.apiService.palceOrder(this.order)
  resp.subscribe((data)=>this.message=data)
}
}

