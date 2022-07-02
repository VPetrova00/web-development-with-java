export interface UserInterface {
  id: string;
  username: string;
  password: string;
  email: string;
}

export class User implements UserInterface {
  id: string = '';
  email: string = '';
  password: string = '';
  username: string = '';

  constructor(username: string, password: string, email: string, id?: string) {
    if (id) this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
  }
}
