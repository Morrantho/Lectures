import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router,ActivatedRoute,Params} from "@angular/router";

@Injectable()
export class UserService {

	constructor(private _http:HttpClient){

	}

	session(cb){
		this._http.get("/session")
		.subscribe((data)=>cb(data));
	}

	register(user,cb){
		this._http.post("/users/new",user)
		.subscribe((data)=>cb(data));
	}

	logout(){
		this._http.get("/logout")
		.subscribe()
	}
}
