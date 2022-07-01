export interface UserInterface {
  username: string;
  password: string;
  email: string;
}

export class User implements UserInterface {
  email: string = '';
  password: string = '';
  username: string = '';

  constructor(username: string, password: string, email: string) {
    this.email = email;
    this.username = username;
    this.password = password;
  }
}
