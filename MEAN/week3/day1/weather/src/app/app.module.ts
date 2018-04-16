import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { CityComponent } from './components/city/city.component';

import {AppRoutingModule} from "./app-routing.module";

import {WeatherService} from "./services/weather.service";

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    CityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    WeatherService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
