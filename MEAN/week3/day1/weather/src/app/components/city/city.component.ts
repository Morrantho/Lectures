import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,Router} from "@angular/router";
import {WeatherService} from "../../services/weather.service";

@Component({
	selector: 'app-city',
	templateUrl: './city.component.html',
	styleUrls: ['./city.component.css']
})

export class CityComponent implements OnInit {
	private url:any;
	private city:any;
	private img:any;

	constructor(private route:ActivatedRoute,private router:Router,private ws:WeatherService){

	}

	ngOnInit(){
		this.route.params
		.subscribe(
			data=>{
				this.url = data;
				
				this.ws.getCity(this.url,(data2)=>{
					this.city = data2;
				});
			}
		);		

	}
}
