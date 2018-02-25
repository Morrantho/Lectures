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

	create(listing,cb){
		this.http.post("/api/listings/new",listing)
		.subscribe(data=>cb(data));
	}

	findById(id,cb){
		this.http.get("/api/listings/"+id)
		.subscribe(data=>cb(data));
	}

	update(listing,cb){
		this.http.put("/api/listings/"+listing._id+"/update",listing)
		.subscribe(data=>cb(data));
	}

	destroy(id,cb){
		this.http.delete("/api/listings/"+id+"/destroy")
		.subscribe(data=>cb(data));
	}

	lotd(cb){
		this.http.get("/api/listings/lotd")
		.subscribe(data=>cb(data));
	}
}
