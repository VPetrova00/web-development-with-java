import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoggedOutNavBarComponent } from './logged-out-nav-bar/logged-out-nav-bar.component';
import { LoggedInNavBarComponent } from './logged-in-nav-bar/logged-in-nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { BookComponent } from './book/book.component';
import { UserComponent } from './user/user.component';
import { LibraryComponent } from './library/library.component';

@NgModule({
  declarations: [
    AppComponent,
    LoggedOutNavBarComponent,
    LoggedInNavBarComponent,
    FooterComponent,
    BookComponent,
    UserComponent,
    LibraryComponent
  ],
  imports: [
    BrowserModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
