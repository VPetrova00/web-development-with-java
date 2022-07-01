import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoginFormComponent} from "./forms/loginForm/login-form.component";
import {AppComponent} from "./app.component";
import {HomeComponent} from "./pages/homePage/home.component";
import {RegistrationFormComponent} from "./forms/registrationForm/registration-form.component";

const routes: Routes = [
  { path: 'login', component: LoginFormComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegistrationFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
