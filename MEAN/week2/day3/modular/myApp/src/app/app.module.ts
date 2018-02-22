import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserService } from "./user.service";
import { TestComponent } from './test/test.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
  	UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
