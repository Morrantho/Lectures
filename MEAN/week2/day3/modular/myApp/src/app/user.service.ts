import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UserService {

	constructor(private _http: HttpClient){

	}

	getUsers(){
		return this._http.get("/users");
	}
}
