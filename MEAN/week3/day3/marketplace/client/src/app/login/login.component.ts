import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import {UserService} from "../../services/user.service";
import {ListingService} from "../../services/listing.service";
import {ActivatedRoute,Router} from "@angular/router";

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
	private loginUser:any;
	private registerUser:any;
	private botd:any;

	constructor(private us:UserService,private ls:ListingService,private route:Router,private activatedRoute:ActivatedRoute){}

	ngOnInit(){
		this.loginUser = {
			email:"",
			password:""
		};

		this.registerUser = {
			email:"",
			password:""
		};

		this.ls.botd(data=>this.botd=data);
		this.us.clear();
	}

	login(){
		this.us.login(this.loginUser,(data)=>{
			if(data.errors){

			}else{
				this.route.navigate(["/browse"]);
			}
		});
	}

	register(){
		this.us.register(this.registerUser,(data)=>{
			if(data.errors){

			}else{
				this.route.navigate(["/browse"]);
			}
		});
	}
}
