import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ProductService {

	constructor(private http:HttpClient){

	}

	create(product,cb){
		this.http.post("/products/new",product)
		.subscribe(data=>cb(data));
	}

	all(cb){
		this.http.get("/products")
		.subscribe(data=>cb(data));
	}
}
