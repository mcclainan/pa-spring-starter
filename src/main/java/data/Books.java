package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Books {
	private HashMap<Long,Book> bookList;
	private Long sequence;
	
	public Books() {
		bookList = new HashMap<>();
		sequence = 1L;
	}
	
	public Book addBook(Book book) {
		book.setId(sequence++);
		bookList.put(book.getId(), book);
		return book;
	}

	public List getSortedBooks() {
		List values = new ArrayList(bookList.values());
		Collections.sort(values, new Book());
		return values;
	}

	public void deleteBooks() {
		this.bookList = new HashMap<>();
	}
	

}
