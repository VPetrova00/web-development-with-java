import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoginFormComponent} from "./forms/loginForm/login-form.component";
import {AppComponent} from "./app.component";

const routes: Routes = [
  { path: '', component: AppComponent },
  { path: 'login', component: LoginFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
