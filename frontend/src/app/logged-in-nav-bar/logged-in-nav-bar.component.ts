import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'logged-in-nav-bar',
  templateUrl: './logged-in-nav-bar.component.html',
  styleUrls: ['./logged-in-nav-bar.component.scss']
})
export class LoggedInNavBarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onLogoutClick() {
    sessionStorage.setItem('isLoggedIn', "false");
    this.router.navigate(['']);
  }
}
