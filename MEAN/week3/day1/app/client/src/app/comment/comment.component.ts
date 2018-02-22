import { Component, OnInit, Input } from '@angular/core';
import {UserService} from "../user/user.service";

@Component({
	selector: 'CommentComponent',
	templateUrl: './comment.component.html',
	styleUrls: ['./comment.component.css']
})

export class CommentComponent implements OnInit {
	private comment:any;
	@Input() post;

	constructor(private _us:UserService){

	}

	create(){
		this._us.createComment(this.comment,this.post._id,(data)=>{
			if(data.errors){
				this.init();
			}else{
				// this.post.comments.push(data);
			}
		});
	}

	init(){
		this.comment = {
			content:""
		};
	}

	ngOnInit(){
		this.init();
	}
}
