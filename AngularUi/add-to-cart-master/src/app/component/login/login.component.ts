import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,FormControl,Validator,NgForm} from '@angular/forms';
import { ApiService } from 'src/app/service/api.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
uName:any
User:any
dbusernname:any
dbpassword:any

loginform:any
  constructor(private apiService:ApiService,private formBuilder:FormBuilder,private router:Router) {
   this.loginform=formBuilder.group({ uName:new FormControl(),
    password:new FormControl()
   })
  }

  ngOnInit(): void {
  }
 
  public getUserByUserName(loginform:NgForm)
  {
let res=this.apiService.getUserByuName(this.loginform.value.uName)

res.subscribe( (response: any) =>{​this.User =response;
   
   ​​ this.dbusernname = response.uName;
    this.dbpassword = response.password;
    console.log(response)
    console.log(loginform.value.password)
    console.log(this.dbpassword)
    

     //login validation           
      if( loginform.value.password == this.dbpassword)
      { 
        console.log("login success");
        window.alert("Login Success Enjoy Your Shopping") 
        console.log(res)
        this.router.navigate(['/products']);
       }​​else{
        ​this.router.navigate(['/login']);
         console.log("login failed");
         window.alert("login failed enter correct credentials")
         console.log(res) }​​
         }​​
          );
         }​​
         

}
