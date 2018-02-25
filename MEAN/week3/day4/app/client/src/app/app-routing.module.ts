import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {BrowseComponent} from "./browse/browse.component";
import {ListingsComponent} from "./listings/listings.component";

const routes: Routes = [
	{path:"register",component:UserComponent},
	{path:"listings",component:ListingsComponent},
	{path:"browse",component:BrowseComponent},
	{path:"**",redirectTo:"register"},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})

export class AppRoutingModule{}
