import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class UserService {

	constructor(private _http:HttpClient){

	}

	create(user,cb){
		this._http.post("/users/new",user)
		.subscribe(data=>cb(data));
	}

	login(user,cb){
		console.log(user);

		this._http.post("/login",user)
		.subscribe(data=>cb(data));
	}

	logout(){
		this._http.get("/logout")
		.subscribe();
	}

	session(cb){
		this._http.get("/session")
		.subscribe(data=>cb(data));
	}
}
