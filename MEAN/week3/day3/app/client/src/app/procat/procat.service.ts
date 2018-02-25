import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ProcatService {

	constructor(private http:HttpClient){

	}

	create(procat,cb){
		this.http.post("/procats/new",procat)
		.subscribe(data=>cb(data));
	}

	all(cb){
		this.http.get("/procats")
		.subscribe(data=>cb(data));
	}
}
