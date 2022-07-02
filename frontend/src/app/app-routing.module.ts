import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./pages/homePage/home.component";
import {RegistrationComponent} from "./pages/registrationPage/registration.component";
import {LoginComponent} from "./pages/loginPage/login.component";
import {UserComponent} from "./user/user.component";
import {AllBooksComponent} from "./all-books/all-books.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegistrationComponent},
  { path: 'profile', component: UserComponent},
  { path: 'all-books', component: AllBooksComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
