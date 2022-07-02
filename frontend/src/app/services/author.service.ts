import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {AuthorInterface} from "../models/author.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  getAllAuthorsUrl: string = "http://localhost:8080/library/authors";
  addAuthorUrl: string = "http://localhost:8080/library/author/add"

  constructor(
    private http: HttpClient
  ) {}

  getAllAuthors() {
    return this.http.get(this.getAllAuthorsUrl);
  }

  addAuthor(author: AuthorInterface): void {
    this.http.post<AuthorInterface>(this.addAuthorUrl, author).subscribe();
  }
}
