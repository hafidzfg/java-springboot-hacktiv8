package com.belajar.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.belajar.spring.model.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>{
	
}
