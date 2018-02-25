import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { DashComponent } from './dash/dash.component';
import { ProductComponent } from './product/product.component';
import { CategoryComponent } from './category/category.component';
import { ProcatComponent } from './procat/procat.component';

import {UserService} from "./user/user.service";
import {ProductService} from "./product/product.service";
import {CategoryService} from "./category/category.service";
import {ProcatService} from "./procat/procat.service";

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    DashComponent,
    ProductComponent,
    CategoryComponent,
    ProcatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
  	UserService,
  	ProductService,
  	CategoryService,
  	ProcatService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
