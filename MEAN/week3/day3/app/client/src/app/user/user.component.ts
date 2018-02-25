import { Component, OnInit } from '@angular/core';
import {UserService} from "../user/user.service";
import {Router} from "@angular/router";

@Component({
	selector: 'app-user',
	templateUrl: './user.component.html',
	styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
	private user:any;
	private loggedIn:any;

	constructor(private _router:Router,private _us:UserService){

	}

	register(){
		this._us.create(this.user,(data)=>{
			console.log(data);

			if(data.errors){
				console.log(data.errors);
			}else{
				console.log(this._router);
				this._router.navigate(["/"]);
			}
		});
	}

	login(){
		this._us.login(this.loggedIn,(data)=>{
			console.log(data);

			if(data.errors){
				console.log(data.errors);
			}else{
				this._router.navigate(["/"]);
			}
		});
	}

	ngOnInit(){
		this.user = {
			email:"",
			password:""
		};

		this.loggedIn = {
			email:"",
			password:""
		};
	}
}
