import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {CollectionInterface} from "../models/collection.model";

@Injectable({
  providedIn: 'root'
})
export class CollectionService {
  getAllCollectionsUrl: string = "http://localhost:8080/library/collections/all";
  addCollectionUrl: string = "http://localhost:8080/library/collections/collection/add"

  constructor(
    private http: HttpClient
  ) {}

  getAllCollections() {
    return this.http.get(this.getAllCollectionsUrl);
  }

  addCollection(collection: CollectionInterface): void {
    this.http.post<CollectionInterface>(this.addCollectionUrl, collection).subscribe();
  }
}
