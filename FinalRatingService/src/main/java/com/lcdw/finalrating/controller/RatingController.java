package com.lcdw.finalrating.controller;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcdw.finalrating.entities.Rating;
import com.lcdw.finalrating.service.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	org.slf4j.Logger logger  = LoggerFactory.getLogger(RatingController.class);
	
	@Autowired
	private RatingService ratingService;
	
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
	     String ratingId = UUID.randomUUID().toString();
	     rating.setRatingId(ratingId);
	     return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
		     
	}
	
	//getAllRating
	
	@GetMapping
	public ResponseEntity<List<Rating>>getAllRating()
	{
		return ResponseEntity.ok(ratingService.getAllRating());
		
	}
	
	@Value("${server.port}")
	private String port;
	
	//getAllRating by UserId
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating> >getRatingByUserId(@PathVariable String userId)
	{
		//System.out.println("->>>>>>>This is port no->>>>>>>"+port);
		
		logger.info(port);
		
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	
	//getAllRating by HotelId
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating> >getByHotelId(@PathVariable String hotelId)
	{
		
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}
	

	

}
