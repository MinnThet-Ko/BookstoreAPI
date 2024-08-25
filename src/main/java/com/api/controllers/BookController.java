package com.api.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Book;
import com.api.services.BookService;

@RestController
@RequestMapping(path = "/book", produces = "application/json")
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(path = "/getAllBooks")
	public Set<Book> getAllBooks(){
		return this.bookService.getAllBooks();
	}
	
	@PostMapping(path = "/saveBook",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveBook(@RequestBody Book book) {
		
		System.out.println(book.toString());
		this.bookService.saveBook(book);
	}

}
