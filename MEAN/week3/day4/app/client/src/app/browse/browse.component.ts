import { Component, OnInit } from '@angular/core';
import {UserService} from "../user/user.service";
import {ListingService} from "../listing.service";
import {Router} from "@angular/router";

@Component({
	selector: 'app-browse',
	templateUrl: './browse.component.html',
	styleUrls: ['./browse.component.css']
})

export class BrowseComponent implements OnInit {
	private text:String;
	private listings:any;
	private user:any;

	constructor(private us:UserService,private ls:ListingService,private router:Router){

	}

	ngOnInit(){
		if(!this.us.isValid()) this.router.navigate(["/register"]);
		this.text = "";

		this.ls.all((data)=>{
			this.listings = data;
			this.user = this.us.session();
		});
	}

}
