import { Component, OnInit } from '@angular/core';
import {UserService} from "./user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
	private user:any;
	private userErrors:any;

	constructor(private _us:UserService,private _router:Router){

	}

	register(){
		this._us.register(this.user,(data)=>{
			if(data.errors){
				this.user.errors = [];
				for(let err in data.errors){
					this.user.errors.push(data.errors[err]);
				}
			}else{
				this._router.navigate(["/dashboard"]);
			}
		});
	}

	init(){
		this.user = {
			email:"",
			password:"",
			errors:[]
		};
	}

	ngOnInit() {
		this.init();
		this._us.logout();
	}

}
