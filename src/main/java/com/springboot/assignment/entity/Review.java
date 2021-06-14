package com.springboot.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	
	private String comment;
	
	 @Column(name = "book_id")
	    private int bookId;
	 	@Autowired
	    public Review( String comment, Integer bookId) {
	      
	        this.comment = comment;
	        this.bookId = bookId;
	        System.out.println("==================="+bookId);
	    }
	 	@Autowired
	    public Review(int id, String comment, int bookId) {
	        this.id = id;
	        this.comment = comment;
	        this.bookId = bookId;
	    }
	public Review() {
		
	}

	public Review(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
		System.out.println(bookId);
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + ", bookId= "+ bookId + "]";
	}
	
}

