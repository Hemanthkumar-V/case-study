import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators';
import { Product } from '../model/product';
import { User } from '../model/user';
import { Order } from '../order';
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http : HttpClient) { }

  getProduct(){
    return this.http.get<any>("http://localhost:8081/product/getProducts")
    .pipe(map((res:any)=>{
      return res;
    }))   
    }
    public getProducts()
    {
      return this.http.get<any>("http://localhost:8081/product/getProducts")
    }
    public getProductByCategory(productCategory:any)
    {
      return this.http.get<any>("http://localhost:8081/product/getproduct/"+productCategory)
    }

    public deleteProduct(productId:any)
      {
        return this.http.delete<Product[]>("http://localhost:8081/product/deleteProduct/"+productId)
      }

      public getProductById(productId:number)
      {
        console.log(productId)
        
        console.log( this.http.get<Product>("http://localhost:8081/product/getProduct/"+productId))
        return this.http.get<any>("http://localhost:8081/product/getProduct/"+productId)
      }
    
    public doRegistration(user:User){
      return this.http.post("http://localhost:8082/user/saveUser",user,{responseType:'text' as 'json'});
    }

    public getAllUsers()
    {
return this.http.get("http://localhost:8082/user/getUsers")
    }
    public getUserByuName(uName:any)
    {
      return this.http.get<any>("http://localhost:8082/user/getByUserName/"+uName)
    }
    public deleteUser(uId:any)
    {
      return this.http.delete("http://localhost:8082/user/delete/"+uId)
    }

    public addProducts(product:Product){
      console.log(product)
      console.log(this.http.post("http://localhost:8081/product/saveProduct",product,{responseType:'text' as 'json'}))
      return this.http.post("http://localhost:8081/product/saveProduct",product,{responseType:'text' as 'json'});
    }
  public palceOrder(order:Order)
  {
    return this.http.post("http://localhost:8086/order/place",order,{responseType:'text' as 'json'});
  }
      
  }
    
  

