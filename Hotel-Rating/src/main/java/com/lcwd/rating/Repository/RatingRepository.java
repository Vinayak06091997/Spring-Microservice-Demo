package com.lcwd.rating.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.rating.Entities.Rating;

public interface RatingRepository extends JpaRepository< Rating, String> 
{

	
	// Custome Finder methods
	
	public List<Rating> findByUserId(String userid);
	
	
	
	public List<Rating> findByHotelId(String hotelid);
}
