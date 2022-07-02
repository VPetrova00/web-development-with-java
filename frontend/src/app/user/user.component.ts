import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user.service";
import {User, UserInterface} from "../models/user.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  public id = sessionStorage.getItem("id");
  public user: any;
  public profileForm: any = FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.profileForm = this.formBuilder.group({
      username: [''],
      password: ['']
    });

    this.userService.getUserById(this.id)?.subscribe((res) => {
      this.user = res;
    });
  }

  updateUser(data: any) {
    if(data) {
      if (data.username == "") {
        data.username = this.user.username;
      }

      if (data.password == "") {
        data.password = this.user.password;
      }

      let newUser = new User(data.username, data.password, this.user.email, this.user.id);

      this.userService.updateUser(newUser);
      this.router.navigate(['home']);
    }
  }
}
