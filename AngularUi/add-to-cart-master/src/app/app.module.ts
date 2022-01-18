import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { CartComponent } from './component/cart/cart.component';
import { ProductsComponent } from './component/products/products.component';
import { HttpClientModule } from '@angular/common/http';
import { FilterPipe } from './shared/filter.pipe';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './component/register/register.component';
import { AddProductComponent } from './component/add-product/add-product.component';
import { UpdateDaleteComponent } from './component/update-dalete/update-dalete.component';
import { LoginComponent } from './component/login/login.component';
import { DeleteUpdateComponent } from './component/delete-update/delete-update.component';
import { OrderItemComponent } from './component/order-item/order-item.component';
import { UserProfileoperationsComponent } from './component/user-profileoperations/user-profileoperations.component';
import { UpdateProductComponent } from './component/update-product/update-product.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CartComponent,
    ProductsComponent,
    FilterPipe,
    RegisterComponent,
    AddProductComponent,
    UpdateDaleteComponent,
    LoginComponent,
    DeleteUpdateComponent,
    OrderItemComponent,
    UserProfileoperationsComponent,
    UpdateProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
