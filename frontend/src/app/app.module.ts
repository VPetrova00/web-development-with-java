import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoggedOutNavBarComponent } from './logged-out-nav-bar/logged-out-nav-bar.component';
import { LoggedInNavBarComponent } from './logged-in-nav-bar/logged-in-nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { BookComponent } from './book/book.component';
import { UserComponent } from './user/user.component';
import {LoginFormComponent} from "./forms/loginForm/login-form.component";
import {FormBuilder, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./services/user.service";
import {HomeComponent} from "./pages/homePage/home.component";
import {RegistrationFormComponent} from "./forms/registrationForm/registration-form.component";

@NgModule({
  declarations: [
    AppComponent,
    LoggedOutNavBarComponent,
    LoggedInNavBarComponent,
    FooterComponent,
    BookComponent,
    UserComponent,
    LoginFormComponent,
    HomeComponent,
    RegistrationFormComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
