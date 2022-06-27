package com.belajar.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.jwt.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

}
