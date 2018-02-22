import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from "./user/user.component";
import {DashboardComponent} from "./dashboard/dashboard.component";

const routes: Routes = [
	{path:"register",component:UserComponent},
	{path:"dashboard",component:DashboardComponent},
	{ path: '', pathMatch: 'full', redirectTo: 'register' },
	{ path: '**', component:UserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
