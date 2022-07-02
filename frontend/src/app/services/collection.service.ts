import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {CollectionInterface} from "../models/collection.model";

@Injectable({
  providedIn: 'root'
})
export class CollectionInterface {
  getAllCollectionsUrl: string = "http://localhost:8080/library/collections";
  addCollectionUrl: string = "http://localhost:8080/library/collection/add"

  constructor(
    private http: HttpClient
  ) {}

  getAllCollections() {
    return this.http.get(this.getAllCollectionsUrl);
  }

  //after subscribe the returned data can be manipulated
  addCollection(collection: CollectionInterface): void {
    this.http.post<CollectionInterface>(this.addCollectionUrl, collection).subscribe();
  }
}
