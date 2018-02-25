import { Component, OnInit } from '@angular/core';
import {ListingService} from "../listing.service";
import {UserService} from "../user/user.service";

@Component({
  selector: 'app-listings',
  templateUrl: './listings.component.html',
  styleUrls: ['./listings.component.css']
})
export class ListingsComponent implements OnInit {
	private listings:any;
	private user:any;

	constructor(private us:UserService,private ls:ListingService){

	}

	ngOnInit(){
		this.listings = [];
		this.user = this.us.session();

		this.ls.all((data)=>{
			for(let i=0; i < data.length; i++){
				if(data[i].user._id == this.user){
					this.listings.push(data[i]);
				}
			}
		});
	}
}
