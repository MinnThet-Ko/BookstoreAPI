package com.api.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Book;
import com.api.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Set<Book> getAllBooks(){
		return this.bookRepository.findAll();
	}
	
	public void saveBook(Book book) {
		this.bookRepository.save(book);
	}
}
