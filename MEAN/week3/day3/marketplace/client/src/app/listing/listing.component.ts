import { Component, OnInit,Input } from '@angular/core';
import {ListingService} from "../../services/listing.service";

@Component({
	selector: 'app-listing',
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

	delete(){
		this.ls.destroy(this.listing,(data)=>{
			console.log("WE DELETED A LISTING SUCCESSFULLY");
		});
	}

	contact(){
		alert(
			"Email: "+this.listing.user.email+"\n"+
			"Location: "+this.listing.location
		);
	}
}
