import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  username: string = '';
  password: string = '';
  email: string = '';

  constructor() { }

  ngOnInit(): void {
  }

}
