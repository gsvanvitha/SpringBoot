package com.springboot.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.assignment.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
