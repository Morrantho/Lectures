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
		console.log("USER REGISTER");

		this._http.post("/users/new",user)
		.subscribe((data)=>cb(data));
	}

	logout(){
		this._http.get("/logout")
		.subscribe(data=>{})
	}

	createPost(post,cb){
		this._http.post("/posts/new",post)
		.subscribe(data=>cb(data));
	}

	createComment(comment,post_id,cb){
		this._http.post("/posts/"+post_id+"/comments/new",comment)
		.subscribe(data=>cb(comment));
	}

	allPosts(cb){
		this._http.get("/posts")
		.subscribe(data=>cb(data));
	}

	getPostById(cb){

	}
}
