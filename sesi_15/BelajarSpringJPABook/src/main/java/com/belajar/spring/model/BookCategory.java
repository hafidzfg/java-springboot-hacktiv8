package com.belajar.spring.model;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class BookCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(
			mappedBy = "bookCategory",
			cascade = CascadeType.ALL
			)
	private List<Book> books;
	
	// default constructor
	public BookCategory() {
		
	}
	
	// add constructor to get values of columns
	public BookCategory(String name, Book...books) {
		this.name = name;
		this.books = Stream.of(books).collect(Collectors.toList());
		this.books.forEach(x -> x.setBookCategory(this));
	}

	// all the getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "BookCategory{" +
		"id=" +id+", name="+name+'\''+", books=" + books+'}';
	}
}
