import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class UserService {
	constructor(private http:HttpClient){

	}

	login(user,cb){
		this.http.post("/api/login",user)
		.subscribe(data=>{
			cb(data);
		});
	}

	register(user,cb){
		this.http.post("/api/register",user)
		.subscribe(data=>{
			cb(data);
		});
	}

	session(cb){
		this.http.get("/api/session")
		.subscribe(data=>cb(data));
	}

	clear(){
		this.http.get("/api/clear")
		.subscribe();
	}
}
