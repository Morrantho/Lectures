import { Component, OnInit } from '@angular/core';
import {UserService} from "../user/user.service";
import {ListingService} from "../listing.service";
import {Router} from "@angular/router";

@Component({
	selector: 'NewlistingComponent',
	templateUrl: './newlisting.component.html',
	styleUrls: ['./newlisting.component.css']
})

export class NewlistingComponent implements OnInit {
	private listing:any;

	constructor(private us:UserService,private ls:ListingService,private router:Router){

	}

	init(){
		this.listing = {
			title:"",
			description:"",
			price:0,
			location:"",
			src:"",
			user:this.us.session()
		};
	}

	ngOnInit(){
		if(!this.us.isValid())
			this.router.navigate(["/register"]);

		this.init();
	}

	create(){
		this.ls.create(this.listing,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				console.log(data);
				this.init();
			}
		});
	}
}
