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

	constructor(private router:Router,private us:UserService){

	}

	register(){
		this.us.register(this.user,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				localStorage.setItem("user",data._id);
				this.router.navigate(["/browse"]);
			}
		});
	}

	login(){
		this.us.login(this.loggedIn,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				localStorage.setItem("user",data._id);
				this.router.navigate(["/browse"]);
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

		this.us.logout();
	}
}
