package com.lcdw.user.service.controller;





import com.lcdw.user.service.entities.Hotel;
import com.lcdw.user.service.entities.Rating;
import com.lcdw.user.service.entities.User;
import com.lcdw.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;

	// create user
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	
	// get User by Id
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
			
		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
		
		 List<Rating>ratings = Arrays.stream(ratingOfUser).toList();
		 
			//List<Hotel> hotels = restTemplate.getForObject("http://localhost:8085/hotels/"+rating.getHotelId(), ArrayList.class);
			
		 List<Rating>ratingList =  ratings.stream().map(rating->{
			 
			 ResponseEntity<Hotel> hotels =  restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			 
			 Hotel hotel = hotels.getBody();
			 
			 rating.setHotel(hotel);
			 
			 return rating;
		 }).collect(Collectors.toList());
		
		user.setRating(ratingList);
	
	
	//return ResponseEntity.ok(userService.getUser(userId));
		return ResponseEntity.ok(user);
		
	}

	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
		
	}

}
