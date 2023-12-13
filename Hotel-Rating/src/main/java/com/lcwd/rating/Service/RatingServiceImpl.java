package com.lcwd.rating.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.Entities.Rating;
import com.lcwd.rating.Repository.RatingRepository;


@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	//Create Rating
	public Rating create(Rating rating) 
	{
			String id=UUID.randomUUID().toString();
			rating.setRatingId(id);

		return ratingRepository.save(rating);
	}

	
	
	//Get ALL  Rating
	public List<Rating> getAll() 
	{
		
		return ratingRepository.findAll();
	}

	
	
	//Get Rating By User id 
	public List<Rating> getRatingByUserId(String uid) 
	{
		
		return ratingRepository.findByUserId(uid);
	}
	
	
	//Get Rating by Hotel Id
	public List<Rating> getRatingByHotelId(String uid) 
{
		
		return ratingRepository.findByHotelId(uid);
	}

}
