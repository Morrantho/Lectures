import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {DashComponent} from "./dash/dash.component";

const routes: Routes = [
	{path:"",component:DashComponent},
	{path:"register",component:UserComponent},
	{path:"**",redirectTo:"register"},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
