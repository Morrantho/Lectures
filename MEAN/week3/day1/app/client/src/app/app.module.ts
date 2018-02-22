import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import {HttpClientModule } from "@angular/common/http";
import {FormsModule} from "@angular/forms";

import { UserComponent } from './user/user.component';
import {UserService} from "./user/user.service";
import { DashboardComponent } from './dashboard/dashboard.component';
import { PostComponent } from './post/post.component';
import { CommentComponent } from './comment/comment.component';

@NgModule({
	declarations: [
		AppComponent,
		UserComponent,
		DashboardComponent,
		PostComponent,
		CommentComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule,
		FormsModule
	],
	providers: [
		UserService
	],
	bootstrap:[
		AppComponent
	]
})
export class AppModule { }
