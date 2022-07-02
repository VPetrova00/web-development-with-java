import { Component, OnInit } from '@angular/core';
import {BookService} from "../services/book.service";
import {Book} from "../models/book.model";

@Component({
  selector: 'app-all-books',
  templateUrl: './all-books.component.html',
  styleUrls: ['./all-books.component.scss']
})
export class AllBooksComponent implements OnInit {

  searchText: any;
  public books:any;

  constructor(private bookService: BookService) {
  }

  ngOnInit(): void {
    this.books = this.bookService.getAllBooks();
  }

}
