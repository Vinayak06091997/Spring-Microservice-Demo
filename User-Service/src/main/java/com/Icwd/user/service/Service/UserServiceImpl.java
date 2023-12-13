package com.Icwd.user.service.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Icwd.user.service.Entities.Hotel;
import com.Icwd.user.service.Entities.Rating;
import com.Icwd.user.service.Entities.User;
import com.Icwd.user.service.Exception.ResourceNotFoundException;
import com.Icwd.user.service.External.HotelService;
import com.Icwd.user.service.Repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private HotelService hotelService;
	

	private Logger logger=LoggerFactory.getLogger(UserService.class);
	
	
	public User saveUser(User user) {
		String id=UUID.randomUUID().toString();
		user.setUserId(id);
		return userRepository.save(user);
	}
	
	public List<User> getAllUser() {
	
		
		return userRepository.findAll();
	}

	
	public User getUserById(String userId) 
	{
		
		User user=userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User id is not Found "+userId));
		
		
		//Get rating of the above user from RATING Service

		
		Rating[] list=restTemplate.
				getForObject("http://HOTEL-RATING/rating/user/"+userId,Rating[].class);
	
//		System.out.println(list);
		
		List<Rating> ratings =Arrays.stream(list).toList();		
		
		
		List<Rating> ratingList=ratings.stream().map(rating->{
			
			ResponseEntity<Hotel> forEntity=restTemplate.
					getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
			Hotel hotel=forEntity.getBody();
			
		//For Feign Client Interface 
		//	Hotel hotel=hotelService.getHotel(rating.getHotelId());
			
			rating.setHotel(hotel);
			return  rating;
		}).collect(Collectors.toList()); 
	
		user.setRatings(ratingList);
		
		
		return user;
	}


	public User updateUser(User user) {
		
		return null;
	}


	public User deleteUser(String userId) {
		
		return null;
	}

}
