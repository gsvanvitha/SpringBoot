package com.springboot.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.assignment.dao.BookRepository;
import com.springboot.assignment.dao.ReviewRepository;
import com.springboot.assignment.entity.Book;
import com.springboot.assignment.entity.Review;

@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	private ReviewRepository reviewRepository;
	
	 @Autowired
	  public BookServiceImpl(BookRepository bookRepository, ReviewRepository reviewRepository) {
	        this.bookRepository = bookRepository;
	        this.reviewRepository = reviewRepository;
	  }
	 
	@Override
	@Transactional
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Book> result = bookRepository.findById(theId);
		Book theEmployee=null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("No book exists with Id: "+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Book theBook) {
		// TODO Auto-generated method stub
		bookRepository.save(theBook);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(theId);
	}

	@Override
	public List<Review> findReviewsByBookId(int theId) {
		// TODO Auto-generated method stub
		Book theBook = findById(theId);
		List<Review> listReviews = theBook.getReviews();
		return listReviews;
	}

	@Override
	public List<Review> findAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Override
	public void saveReview(Review theReview) {
		// TODO Auto-generated method stub
		reviewRepository.save(theReview);
	}

}
