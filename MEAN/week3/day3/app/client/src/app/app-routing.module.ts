import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {DashComponent} from "./dash/dash.component";

const routes: Routes = [
	{path:"register",component:UserComponent},
	{path:"",component:DashComponent},
	{path:"**",component:UserComponent},
	// {path:"products",component:ProductComponent},
	// {path:"categories",component:CategoryComponent},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})

export class AppRoutingModule { }
