export interface AuthorInterface {
  firstName: string;
  lastName: string;
  description: string;
}

export class Author implements AuthorInterface {
  firstName: string = '';
  lastName: string = '';
  description: string = '';

  constructor(firstName: string, lastName: string, description: string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
  }
}
