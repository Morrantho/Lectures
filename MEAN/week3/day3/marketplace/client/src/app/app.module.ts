import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { ListingComponent } from './listing/listing.component';

import {ListingService} from "../services/listing.service";
import {UserService} from "../services/user.service";
import { LoginComponent } from './login/login.component';
import { UpdatelistingComponent } from './updatelisting/updatelisting.component';
import { CreatelistingComponent } from './createlisting/createlisting.component';
import { NavComponent } from './nav/nav.component';
import { BrowseComponent } from './browse/browse.component';
import { ListingsComponent } from './listings/listings.component';
import { SearchPipe } from './search.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ListingComponent,
    LoginComponent,
    UpdatelistingComponent,
    CreatelistingComponent,
    NavComponent,
    BrowseComponent,
    ListingsComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
  	UserService,
  	ListingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
