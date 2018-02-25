import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';

import { SearchPipe } from './pipes/search.pipe';

import {UserService} from "./user/user.service";
import {ListingService} from "./listing.service";

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { NavComponent } from './nav/nav.component';
import { BrowseComponent } from './browse/browse.component';
import { ListingComponent } from './listing/listing.component';
import { NewlistingComponent } from './newlisting/newlisting.component';
import { UserlistingComponent } from './userlisting/userlisting.component';
import { ListingsComponent } from './listings/listings.component';
import { LotdComponent } from './lotd/lotd.component';

@NgModule({
  declarations: [
      AppComponent,
      UserComponent,
      SearchPipe,
      NavComponent,
      BrowseComponent,
      ListingComponent,
      NewlistingComponent,
      UserlistingComponent,
      ListingsComponent,
      LotdComponent,
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
