import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ListingService {

	constructor(private http:HttpClient){

	}

	all(cb){
		this.http.get("/api/listings")
		.subscribe(data=>cb(data));
	}

	find(listing,cb){
		this.http.get("/api/listings/"+listing._id)
		.subscribe(data=>cb(data));
	}

	create(listing,cb){
		this.http.post("/api/listings",listing)
		.subscribe(data=>cb(data));
	}

	destroy(listing,cb){
		this.http.delete("/api/listings/"+listing._id)
		.subscribe(data=>cb(data));
	}

	update(listing,cb){
		this.http.put("/api/listings/"+listing._id,listing)
		.subscribe(data=>cb(data));
	}

	botd(cb){
		this.http.get("/api/botd")
		.subscribe(data=>cb(data));
	}
}
