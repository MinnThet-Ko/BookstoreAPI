package com.api.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
	
	public Set<Book> findAll();
	public Set<Book> findByAuthor(String author);
	public Book findByIsbnNumber(String isbnNumber);

}
