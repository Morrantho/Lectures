import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class CategoryService {

	constructor(private http:HttpClient){

	}

	create(cat,cb){
		this.http.post("/categories/new",cat)
		.subscribe(data=>cb(data));
	}

	all(cb){
		this.http.get("/categories")
		.subscribe(data=>cb(data));
	}
}
