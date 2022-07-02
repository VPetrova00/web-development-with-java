import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {BookInterface} from "../models/book.model";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  getAllBooksUrl: string = "http://localhost:8080/library/books";
  getBooksFromCollectionUrl: string = "http://localhost:8080/library/books/collection_id";
  addBookUrl: string = "http://localhost:8080/library/book/add"

  constructor(
    private http: HttpClient
  ) {}

  getAllBooks() {
    return this.http.get(this.getAllBooksUrl);
  }

  getBooksFromCollection() {
    return this.http.get(this.getBooksFromCollectionUrl);
  }

  //after subscribe the returned data can be manipulated
  addBook(book: BookInterface): void {
    this.http.post<BookInterface>(this.addBookUrl, book).subscribe();
  }
}
