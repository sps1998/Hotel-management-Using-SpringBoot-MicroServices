package com.lcdw.finalrating.service;

import java.util.List;

import com.lcdw.finalrating.entities.Rating;

public interface RatingService {
	
	//create
	   Rating create(Rating rating);
	   
	   //geatall
	   List<Rating> getAllRating();
	   
	   //getall rating by userid
	   List<Rating> getRatingByUserId(String userId);
	   
	 //getall rating by hotelid
	   List<Rating> getRatingByHotelId(String HotelId);
	   
     	    
	

}
