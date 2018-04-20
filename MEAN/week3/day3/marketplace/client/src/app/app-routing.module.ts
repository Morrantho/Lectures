import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListingComponent} from "./listing/listing.component";
import {LoginComponent} from "./login/login.component";
import {BrowseComponent} from "./browse/browse.component";
import {ListingsComponent} from "./listings/listings.component";

const routes: Routes = [
	{path:"",pathMatch:"full",component:LoginComponent},
	{path:"login",component:LoginComponent},
	{path:"browse",component:BrowseComponent},
	{path:"listings",component:ListingsComponent},
	{path:"**",redirectTo:""}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})

export class AppRoutingModule{

}
