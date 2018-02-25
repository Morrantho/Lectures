import { Component, OnInit } from '@angular/core';
import {UserService} from "../user/user.service";
import {Router} from "@angular/router";
import {ProductService} from "../product/product.service";
import {CategoryService} from "../category/category.service";
import {ProcatService} from "../procat/procat.service";

@Component({
	selector: 'app-dash',
	templateUrl: './dash.component.html',
	styleUrls: ['./dash.component.css']
})

export class DashComponent implements OnInit {
	private category:any;
	private product:any;
	private procat:any;

	private products:any;
	private categories:any;
	private procats:any;

	constructor(private us:UserService,private router:Router,private ps:ProductService,private cs:CategoryService,private pcs:ProcatService){

	}

	ngOnInit(){
		this.us.session((data)=>{
			if(data.errors){
				this.router.navigate(["/register"]);
			}
		});

		this.category = {title:""};
		this.product = {title:""};
		this.procat = {
			category:"",
			product:""
		};

		this.ps.all((data)=>{
			this.products = data;
		});
		this.cs.all((data)=>{
			this.categories = data;
		});
		this.pcs.all(data=>{
			this.procats = data;
		});
	}

	createProduct(){
		this.ps.create(this.product,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				// this.products.push(data);
				this.product = {title:""};
			}
		});
	}

	createCategory(){
		this.cs.create(this.category,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				// this.categories.push(data);
				this.category = {title:""};
			}
		});
	}

	createProCat(){
		this.pcs.create(this.procat,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				// this.procats.push(data);

				this.procat = {
					category:"",
					product:""
				};
			}
		});
	}
}
