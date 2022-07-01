import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {HomeComponent} from "./pages/homePage/home.component";
import {RegistrationComponent} from "./pages/registrationPage/registration.component";
import {LoginComponent} from "./pages/loginPage/login.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
