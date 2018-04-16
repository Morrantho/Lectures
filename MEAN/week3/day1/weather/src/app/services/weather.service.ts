import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";

@Injectable()
export class WeatherService {
	private key:any;

	constructor(private http:HttpClient){
		this.key = "&APPID=0b7f1adc1b4c2d55a5878e491d617f4e";
	}

	getCity(params,cb){
		let url = "http://api.openweathermap.org/data/2.5/weather?q="+params.city+"&units=imperial"+this.key;
		this.http.get(url)
		.subscribe(data=>cb(data));		
	}
}
