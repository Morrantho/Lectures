import { Component, OnInit, Input } from '@angular/core';
import {ListingService} from "../listing.service";

@Component({
  selector: 'UserlistingComponent',
  templateUrl: './userlisting.component.html',
  styleUrls: ['./userlisting.component.css']
})
export class UserlistingComponent implements OnInit {
	@Input() user;
	@Input() listing;

	constructor(private ls:ListingService){

	}

	ngOnInit(){

	}

	update(){
		this.ls.update(this.listing,(data)=>{
			if(data.errors){
				console.log(data.errors);
			}else{
				this.listing = data;
			}
		});
	}

	destroy(){
		this.ls.destroy(this.listing._id,(data)=>{
			console.log(data);
		});
	}
}
