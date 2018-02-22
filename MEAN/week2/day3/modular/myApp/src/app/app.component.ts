import { Component } from '@angular/core';
import { UserService } from "./user.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  	title = 'Users';
  	private users:any;

  	constructor(private _userService:UserService){
    
  	}

  	ngOnInit(){
  		this._userService.getUsers()
  		.subscribe( (data) => this.users = data );
  	}
}
