package fmi.project.booklibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Book already exists in the database!")
public class BookAlreadyExists extends RuntimeException {}
