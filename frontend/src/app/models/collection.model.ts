import {User} from "./user.model";

export interface CollectionInterface {
  name: string;
  user: User;
}

export class Collection implements CollectionInterface {
  name: string = '';
  user!: User;

  constructor(name: string, user: User) {
    this.name = name;
    this.user = user;
  }
}
