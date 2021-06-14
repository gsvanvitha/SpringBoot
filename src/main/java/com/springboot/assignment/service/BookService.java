package com.springboot.assignment.service;

import java.util.List;

import com.springboot.assignment.entity.Book;
import com.springboot.assignment.entity.Review;

public interface BookService {
	
public List<Book> findAll();
	
	public Book findById(int theId);
	
	public void save(Book theBook);
	
	public void deleteById(int theId);
	
    List<Review> findReviewsByBookId(int theId);

    List<Review> findAllReviews();

    void saveReview(Review theReview);
}
