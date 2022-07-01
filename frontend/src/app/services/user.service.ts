import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  usersUrl: string = "http://localhost:8080/library/users";

  constructor(
    private http: HttpClient
  ) {}

  getAllUsers() {
    return this.http.get(this.usersUrl);
  }
}
