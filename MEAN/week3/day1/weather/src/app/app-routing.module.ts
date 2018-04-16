import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CityComponent} from "./components/city/city.component";

const routes: Routes = [
	{ path: '', pathMatch: 'full', component: CityComponent},
	{path:":city",component:CityComponent},
	{ path: '**', redirectTo:"" },
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})

export class AppRoutingModule { }