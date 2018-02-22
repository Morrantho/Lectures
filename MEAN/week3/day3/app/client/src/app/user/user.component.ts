import { Component, OnInit } from '@angular/core';
import {UserService} from "./user.service";
import {Router} from "@angular/router";

@Component({
	selector: 'UserComponent',
	templateUrl: './user.component.html',
	styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
	private user:any;

 	constructor(private _us:UserService,private _router:Router){

	}

	register(){
		this._us.register(this.user,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				this._router.navigate(["/"]);
			}
		});
	}

	init(){
		this.user = {
			email:"",
			password:"",
		};
	}

	ngOnInit() {
		this.init();
		this._us.logout();
	}
}
