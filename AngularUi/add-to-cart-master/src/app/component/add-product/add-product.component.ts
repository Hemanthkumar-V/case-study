import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {
product:Product=new Product(0,"","","","",0,0,"")
message:any
  constructor(private apiService:ApiService) { }

  ngOnInit(): void {
  }
public addProduct()
{
  let resp=this.apiService.addProducts(this.product)
  resp.subscribe((data)=>this.message=data)
}
}
