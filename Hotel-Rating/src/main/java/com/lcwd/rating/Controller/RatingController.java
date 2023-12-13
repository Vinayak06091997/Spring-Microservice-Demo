package com.lcwd.rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.Entities.Rating;
import com.lcwd.rating.Service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	
	//create Rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	
	
	//Get All Rating 
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAll());
	}
	
	
	// Get Rating by user id
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String uid)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(uid));
	}
	
	
	// Get Rating by hotel id
	@GetMapping("/hotel/{hotelid}")
	public ResponseEntity<List<Rating>> getRatingByhotelId(@PathVariable String hotelid)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(hotelid));
	}
	
	
	
	
	
	
	
	

}
