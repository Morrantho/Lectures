import { Component, OnInit } from '@angular/core';
import { NoteService } from "../note.service";

@Component({
	selector: 'app-new-note',
	templateUrl: './new-note.component.html',
	styleUrls: ['./new-note.component.css']
})

export class NewNoteComponent implements OnInit {
	private task;

	constructor(private ns:NoteService){
		this.task = {
			title:"",
			description:""
		};
	}

	ngOnInit(){

	}

	createNote(){
		this.ns.create(this.task,( data )=>{
			console.log(data);
		});

		this.task = {
			title:"",
			description:""
		};
	}
}
