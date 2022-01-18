import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.scss']
})
export class UpdateProductComponent implements OnInit {
product:Product=new Product(0,"","","","",0,0,"")
productId:any
message:any

  constructor(private apiService:ApiService,private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {

    this.productId=this.activeRoute.snapshot.params['productId']
    console.log(this.productId)
   let resp= this.apiService.getProductById(this.productId)
   console.log(resp)
   resp.subscribe((data)=>this.product=data)
  console.log(resp)
  }
public updateProduct()
{
  let resp=this.apiService.addProducts(this.product)
  console.log(resp)
  resp.subscribe((data:any)=>this.message=data)
  console.log(resp)
}
}
