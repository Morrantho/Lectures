import { Component, OnInit } from '@angular/core';
import {ListingService} from "../listing.service";

@Component({
	selector: 'LotdComponent',
	templateUrl: './lotd.component.html',
	styleUrls: ['./lotd.component.css']
})

export class LotdComponent implements OnInit {
	private lotd:any;

	constructor(private ls:ListingService){

	}

	ngOnInit(){
		this.ls.lotd((data)=>{
			this.lotd = data;
		});
	}
}
