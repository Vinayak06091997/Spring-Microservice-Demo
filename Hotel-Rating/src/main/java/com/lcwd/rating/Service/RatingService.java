package com.lcwd.rating.Service;

import java.util.List;

import com.lcwd.rating.Entities.Rating;

public interface RatingService {

	
	//create 
	public Rating create(Rating rating);
	
	//get All rating
	public List<Rating> getAll();
	
	//Get getAll by user id
	public List<Rating> getRatingByUserId(String uid);

	
	//Get all by hotel;
	public List<Rating> getRatingByHotelId(String uid);
}
