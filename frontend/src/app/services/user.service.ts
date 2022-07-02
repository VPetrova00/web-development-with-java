import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {UserInterface} from "../models/user.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  getAllUsersUrl: string = "http://localhost:8080/library/users";
  addUserUrl: string = "http://localhost:8080/library/user/add"
  getUserByIdUrl: string = "http://localhost:8080/library/user/id/";
  updateUserUrl: string = "http://localhost:8080/library/user/update"

  constructor(
    private http: HttpClient
  ) {}

  getAllUsers() {
    return this.http.get<any>(this.getAllUsersUrl);
  }

  //after subscribe the returned data can be manipulated
  addUser(user: UserInterface): void {
    this.http.post<UserInterface>(this.addUserUrl, user).subscribe();
  }

  getUserById(id: string | null) {
    if(id) {
      let finalUrl = this.getUserByIdUrl + id;
      return this.http.get<any>(finalUrl);
    }

    return null;
  }

  updateUser(user: UserInterface) {
    this.http.put<UserInterface>(this.updateUserUrl, user).subscribe();
  }
}
