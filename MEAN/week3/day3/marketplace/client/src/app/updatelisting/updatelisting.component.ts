import { Component, OnInit,Input } from '@angular/core';
import {ListingService} from "../../services/listing.service";

@Component({
	selector: 'app-updatelisting',
	templateUrl: './updatelisting.component.html',
	styleUrls: ['./updatelisting.component.css']
})

export class UpdatelistingComponent implements OnInit {
	@Input() listing;

	constructor(private ls:ListingService){

	}

	ngOnInit(){
	
	}

	update(){
		this.ls.update(this.listing,(data)=>{
			this.listing = data;
		});
	}

	destroy(){
		this.ls.destroy(this.listing,(data)=>{
			console.log(data);
		});
	}
}
