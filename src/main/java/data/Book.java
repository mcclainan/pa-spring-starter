package data;

import java.util.Comparator;

public class Book implements Comparator<Book>{
	private Long id;
	private String author;
	private String title;
	private int yearPublished;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", yearPublished=" + yearPublished + "]";
	}
	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.title.compareTo(o2.title);
	}
	
	
}
