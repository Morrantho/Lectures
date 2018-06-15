import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable()
export class NoteService {
	constructor(private http:HttpClient){}

	create(task,cb){
		this.http.post("/api/tasks",task)
		.subscribe( data => cb( data ) );
	}
}
