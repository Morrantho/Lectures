import { Component, OnInit } from '@angular/core';
import {ListingService} from "../../services/listing.service";
import {UserService} from "../../services/user.service";

@Component({
	selector: 'app-browse',
	templateUrl: './browse.component.html',
	styleUrls: ['./browse.component.css']
})

export class BrowseComponent implements OnInit {
	private listings:any;
	private user:any;
	private searchText:any;

	constructor(private ls:ListingService,private us:UserService){
	
	}

	ngOnInit(){
		this.ls.all((data)=>{
			this.listings = data;
		});

		this.us.session((user)=>{
			this.user = user;
		});

		this.searchText = "";
	}
}
