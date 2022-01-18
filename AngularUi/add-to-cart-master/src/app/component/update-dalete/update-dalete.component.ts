import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-update-dalete',
  templateUrl: './update-dalete.component.html',
  styleUrls: ['./update-dalete.component.scss']
})
export class UpdateDaleteComponent implements OnInit {
  message:any
  product:any
  productCategory:any
  
  constructor(private apiService:ApiService,private router:Router) {
    
   }
   public deleteProduct(productId:number)
{
  let resp=this.apiService.deleteProduct(productId)
  resp.subscribe((data)=>this.product=data)
  console.log(resp)
}

public getProductByCategory()
{
let resp=this.apiService.getProductByCategory(this.productCategory)
resp.subscribe((data)=>this.product=data)
}

public updateProduct(productId:number)
{
this.router.navigate(['updateProduct',productId])
}

  ngOnInit() {
    let resp=this.apiService.getProducts()
  resp.subscribe((data)=>this.product=data)
  }


}
