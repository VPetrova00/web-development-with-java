import { Component, OnInit } from '@angular/core';
import {Genre} from "../models/enums/Genre";
import {CoverType} from "../models/enums/CoverType";

@Component({
  selector: 'book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  title: string = '';
  genre!: Genre;
  coverType!: CoverType;
  description: string = '';
  price!: number;
  pages!: number;
  authors: [] = [];
  ISBN: string = '';


  constructor() { }

  ngOnInit(): void {
  }

}
