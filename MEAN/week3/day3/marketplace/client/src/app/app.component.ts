import { Component,OnInit } from '@angular/core';
import {UserService} from "../services/user.service";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
	title = 'app';
	private user:any;

	constructor(private us:UserService){

	}

	ngOnInit(){
		console.log("ROOT COMPONENT LOADED!");

		this.us.session(data=>{
			this.user=data
			console.log(data);
		});
	}
}
