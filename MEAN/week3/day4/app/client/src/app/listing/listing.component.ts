import { Component, OnInit, Input } from '@angular/core';
import {UserService} from "../user/user.service";
import {ListingService} from "../listing.service";

@Component({
	selector: 'ListingComponent',
	templateUrl: './listing.component.html',
	styleUrls: ['./listing.component.css']
})

export class ListingComponent implements OnInit {
	@Input() listing;
	@Input() user;

	constructor(private ls:ListingService){

	}

	ngOnInit(){
	}

	destroy(){
		this.ls.destroy(this.listing._id,(data)=>{
			console.log(data);
		});
	}

	contact(creator){
		alert("Name: "+creator.email);
	}
}
