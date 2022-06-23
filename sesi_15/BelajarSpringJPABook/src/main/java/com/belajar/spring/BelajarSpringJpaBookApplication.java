package com.belajar.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.belajar.spring.model.Book;
import com.belajar.spring.model.BookCategory;
import com.belajar.spring.repository.BookCategoryRepository;
import com.belajar.spring.repository.BookRepository;

@SpringBootApplication
public class BelajarSpringJpaBookApplication implements CommandLineRunner {
	private final Logger LOG = LoggerFactory.getLogger(BelajarSpringJpaBookApplication.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringJpaBookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// insert data into book table
//		Book book1 = new Book();
//		book1.setTitle("Belajar spring boot");
//		book1.setWriter("Brandon Sanderson");
//		book1.setIsbn("IS-0808881");
//		
//		Book book2 = new Book();
//		book2.setTitle("Belajar spring boot");
//		book2.setWriter("Joe Abercrombie");
//		book2.setIsbn("IS-18091981");
//		
//		bookRepository.save(book1);
//		bookRepository.save(book2);
//		
//		LOG.info("Berhasil menyimpan "+book1);
//		LOG.info("Berhasil menyimpan "+book2);

		// queries

		List<Book> books = bookRepository.findAll();

		LOG.info("Books: " + books);

		// find book by writer

		List<Book> books2 = bookRepository.findAllByWriter("Teten N.");

		LOG.info("Books: " + books2);

		// find book by isbn
		Book bookByISBN = bookRepository.findByIsbn("UE0EI829");
		LOG.info("Book: " + bookByISBN);

		// find all book with native query
		List<Book> booksNative = bookRepository.findAllQueryNative();
		LOG.info("Books with native query: " + booksNative);

		// find all book by writer with native query
		List<Book> bookByWriterNative = bookRepository.findAllByWriterQueryNative("Joe Abercrombie");
		LOG.info("Books by writer native query: " + bookByWriterNative);

		// create book category
//		BookCategory bookCategory = bookCategoryRepository.save(new BookCategory("Programming",
//				new Book("Java 1", "Teten N.", "SEI92002"), new Book("Java2", "Teten N.", "UE0EI829")));
		
	
//		LOG.info("BookCategory:"+bookCategory);

	}

}
