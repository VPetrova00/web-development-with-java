import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  getAllUsersUrl: string = "http://localhost:8080/library/users";
  addUserUrl: string = "http://localhost:8080/library/user/add"

  constructor(
    private http: HttpClient
  ) {}

  getAllUsers() {
    return this.http.get(this.getAllUsersUrl);
  }

  addUser(username: string, password: string, email: string) {
    let response = this.http.post(this.addUserUrl, {
      username: username,
      password: password,
      email: email
    });

    console.log(response);
  }
}
