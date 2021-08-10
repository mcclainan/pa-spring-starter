package com.galvanize.tmo.paspringstarter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import data.Book;
import data.BookContract;
import data.Books;

@RestController
public class LibraryController {
	
	private Books books = new Books();
	private Gson gson = new Gson();
	
	@GetMapping("/health")
    public void health() {

    }
    
    @PostMapping(path = "/api/books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addBook(@RequestBody Book newBook) {
    	System.out.println(newBook);
    	Book book = this.books.addBook(newBook);
    	return new ResponseEntity<>(this.gson.toJson(book),HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBooks(){
    	BookContract contract = new BookContract(this.books.getSortedBooks());
    	System.out.print(gson.toJson(contract));
    	return new ResponseEntity<>(gson.toJson(contract),HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/api/books")
    public ResponseEntity<String> deleteBooks(){
    	this.books.deleteBooks();
    	return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }
}
