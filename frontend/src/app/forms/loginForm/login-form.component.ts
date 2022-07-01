import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { UserService } from "../../services/user.service";
import {User} from "../../models/user.model";

@Component({
  selector: 'login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
  public loginForm: any = FormGroup;
  public users: User[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.compose([Validators.required, Validators.email])],
      password: ['', Validators.required]
    });

    this.userService.getAllUsers().subscribe((data: any) => {
      this.users = data;
    });
  }

  login(data: any) {
    if (data) {
      this.users.forEach((user: User) => {
        if (user.email === data.email && user.password === data.password) {
          sessionStorage.setItem('isLoggedIn', 'true');
          console.log("Hello, " + user.username);
          this.router.navigate(['home']);
        }
        else {
          sessionStorage.clear();
        }
      });
    }
  }
}
