import { Component, OnInit } from '@angular/core';
import {ListingService} from "../../services/listing.service";

@Component({
	selector: 'app-createlisting',
	templateUrl: './createlisting.component.html',
	styleUrls: ['./createlisting.component.css']
})

export class CreatelistingComponent implements OnInit {
	private listing:any;

	constructor(private ls:ListingService){}

	init(){
		this.listing = {
			title:"",
			description:"",
			price:0,
			location:"",
			src:""
		};
	}

	ngOnInit(){
		this.init();
	}

	create(){
		this.ls.create(this.listing,(data)=>{
			console.log(data);
		});
	}
}
