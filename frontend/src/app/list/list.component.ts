import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  name: string = '';
  searchText: any;
  books:[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
