import { Component, OnInit } from '@angular/core';
import {UserService} from "../user/user.service";
import {CategoryService} from "../category/category.service";
import {ProductService} from "../product/product.service";
import {ProductcategoryService} from "../productcategory/productcategory.service";
import {Router} from "@angular/router";

@Component({
	selector: 'DashComponent',
	templateUrl: './dash.component.html',
	styleUrls: ['./dash.component.css']
})

export class DashComponent implements OnInit {
	private user:any;
	private category:any;
	private product:any;

	private products:any;
	private categories:any;

	private procats:any;
	private procat:any;

	constructor(private _us:UserService,private _router:Router,private _cs:CategoryService,private _ps:ProductService,private _pcs:ProductcategoryService){}

	init(){
		this.product = {title:""};
		this.category = {title:""};
		this.procat={
			category:{},
			product:{}
		};

		this.products=[];
		this.categories=[];
		this.procats=[];
	}

	ngOnInit(){
		this.init();

		this._us.session((data)=>{
			if(data.errors)
				this._router.navigate(["/register"]);
		});

		this._cs.all((data)=>{
			this.categories=data;
		});

		this._ps.all((data)=>{
			this.products=data;
		});

		this._pcs.all(data=>{
			this.procats=data;
		});
	}

	newCategory(){
		this._cs.create(this.category,(data)=>{
			if(data.errors){

			}else{
				this.categories.push(data);
			}

			this.init();
		});
	}

	newProduct(){
		this._ps.create(this.product,(data)=>{
			if(data.errors){

			}else{
				this.products.push(data);
			}

			this.init();
		});
	}

	newProCat(){
		this._pcs.create(this.procat,(data)=>{
			if(data.errors){

			}else{
				this.procats.push(data);
			}

			this.init();
		});
	}
}
