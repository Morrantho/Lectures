import { Component, OnInit } from '@angular/core';
import {UserService} from "../user/user.service";

@Component({
	selector: 'PostComponent',
	templateUrl: './post.component.html',
	styleUrls: ['./post.component.css']
})

export class PostComponent implements OnInit {
	private posts:any;
	private post:any;
	private errs:any;

	constructor(private _us:UserService){}

	create(){
		this._us.createPost(this.post,(data)=>{
			if(data.errors){
				for(let err in data.errors){
					this.post.errors.push(data.errors[err]);
				}
			}else{
				this.init();
				this.posts.push(data);
			}
		});
	}

	init(){
		this.post = {
			content:"",
			errors:[]
		};
	}

	ngOnInit() {
		this.init();

		this._us.allPosts(
			(data)=>{
				if(data.errors){
					console.log(data.errors);
					// this.post.errs.push(data.errors);
				}else{
					this.posts = data;
				}
			}
		);
	}
}
