import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './component/add-product/add-product.component';
import { CartComponent } from './component/cart/cart.component';
import { DeleteUpdateComponent } from './component/delete-update/delete-update.component';
import { LoginComponent } from './component/login/login.component';
import { OrderItemComponent } from './component/order-item/order-item.component';
import { ProductsComponent } from './component/products/products.component';
import { RegisterComponent } from './component/register/register.component';
import { UpdateDaleteComponent } from './component/update-dalete/update-dalete.component';
import { UpdateProductComponent } from './component/update-product/update-product.component';
import { UserProfileoperationsComponent } from './component/user-profileoperations/user-profileoperations.component';

const routes: Routes = [
  {path:'', redirectTo:'products',pathMatch:'full'},
  {path:'products', component: ProductsComponent},
  {path:'cart', component: CartComponent},
  {path:'register', component: RegisterComponent},
  {path:'login', component: LoginComponent},
  {path:'addProduct', component: AddProductComponent},
  {path:'updateDelete', component: UpdateDaleteComponent},
  {path:'deleteUpdate', component: DeleteUpdateComponent},
  {path:'order', component: OrderItemComponent},
  {path:'userProfile', component: UserProfileoperationsComponent},
  {path:'updateProduct/:productId', component:UpdateProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
