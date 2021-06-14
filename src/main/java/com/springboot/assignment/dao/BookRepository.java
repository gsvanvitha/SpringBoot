package com.springboot.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.assignment.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
