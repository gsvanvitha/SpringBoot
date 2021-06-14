package com.springbootassignment.springbootassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.assignment.entity.Review;

public class SpringbootAssignmentApplicationTesting extends SpringbootAssignmentApplicationTests{
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	@Test
	public void getReviewsList() throws Exception {
	   String uri = "/books/reviews";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Review[] reviewList = super.mapFromJson(content, Review[].class);
	   assertTrue(reviewList.length > 0);
	}
	 @Test
	   public void createReview() throws Exception {
	      String uri = "/reviews";
	      Review review = new Review();
	     review.setBookId(15);
	     review.setComment("Great Book");
	      String inputJson = super.mapToJson(review);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "review is created successfully");
	   }
	  
}
