import { Component, OnInit } from '@angular/core';
import { TaskService } from "../task.service";

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  constructor(private tS:TaskService) { }

  ngOnInit(){
  	this.tS.findPokemon();
  }

}
