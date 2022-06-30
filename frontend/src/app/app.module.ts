import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoggedOutNavBarComponent } from './logged-out-nav-bar/logged-out-nav-bar.component';
import { LoggedInNavBarComponent } from './logged-in-nav-bar/logged-in-nav-bar.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoggedOutNavBarComponent,
    LoggedInNavBarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
