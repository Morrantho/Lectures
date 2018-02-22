import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {HttpClientModule } from "@angular/common/http";
import {FormsModule} from "@angular/forms";

import {UserService} from "./user/user.service";
import {ProductService} from "./product/product.service";
import {CategoryService} from "./category/category.service";
import {ProductcategoryService} from "./productcategory/productcategory.service";

import { UserComponent } from './user/user.component';
import { DashComponent } from './dash/dash.component';
import { ProductComponent } from './product/product.component';
import { CategoryComponent } from './category/category.component';
import { ProductcategoryComponent } from './productcategory/productcategory.component';

@NgModule({
	declarations: [
		AppComponent,
		UserComponent,
		DashComponent,
		ProductComponent,
		CategoryComponent,
		ProductcategoryComponent,
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
		ProductcategoryService
	],
	bootstrap:[
		AppComponent
	]
})
export class AppModule { }
