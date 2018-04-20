import { Injectable } from '@angular/core';

import { HttpClient } from "@angular/common/http";

@Injectable()
export class TaskService {

	constructor(private http:HttpClient){

	}

	findPokemon(){
		this.http.get("https://pokeapi.co/api/v2/pokemon/2/")
		.subscribe(
			(data)=>{
				console.log(data);
			}
		);
	}
}
