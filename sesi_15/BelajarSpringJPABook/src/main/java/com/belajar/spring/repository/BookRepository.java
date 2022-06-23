package com.belajar.spring.repository;

import com.belajar.spring.model.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
	// find book by writer
	List<Book> findAllByWriter(String writer);
	
	// find book by isbn
	Book findByIsbn(String isbn);
	
	// find all book with native query
	@Query(
			nativeQuery = true,
			value = "select * from book")
	List<Book> findAllQueryNative();
	
	// find all book by writer with native query
	@Query(
			nativeQuery = true,
			value = "select * from book where writer = ?1")
	List<Book> findAllByWriterQueryNative(String writer);
}
