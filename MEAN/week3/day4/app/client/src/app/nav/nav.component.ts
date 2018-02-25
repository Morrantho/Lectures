import { Component, OnInit, Input } from '@angular/core';
import {UserService} from "../user/user.service";

@Component({
	selector: 'NavComponent',
	templateUrl: './nav.component.html',
	styleUrls: ['./nav.component.css']
})

export class NavComponent implements OnInit {
	private user:any;

	constructor(private us:UserService){

	}

	ngOnInit(){
		this.user = this.us.session();
	}
}
