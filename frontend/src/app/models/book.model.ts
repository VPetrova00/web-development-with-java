import {Genre} from "./enums/Genre";
import {CoverType} from "./enums/CoverType";
import {Author} from "./author.model";

export interface BookInterface {
  title: string;
  description: string;
  price: number;
  pages: number;
  genre: Genre;
  coverType: CoverType;
  authors: Author[];
}

export class Book implements BookInterface {
  title: string = '';
  description: string = '';
  price!: number;
  pages!: number;
  genre!: Genre;
  coverType!: CoverType;
  authors: Author[] = [];

  constructor(title: string, description: string, price: number, pages: number, genre: Genre, coverType: CoverType, authors: Author[]) {
    this.title = title;
    this.description = description;
    this.price = price;
    this.pages = pages;
    this.genre = genre;
    this.coverType = coverType;
    this.authors = authors;
  }
}
