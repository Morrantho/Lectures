import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";

@Component({
	selector: 'app-listings',
	templateUrl: './listings.component.html',
	styleUrls: ['./listings.component.css']
})

export class ListingsComponent implements OnInit {
	private user:any;

	constructor(private us:UserService){

	}

	ngOnInit(){
		this.us.session(data=>this.user=data);
	}
}
