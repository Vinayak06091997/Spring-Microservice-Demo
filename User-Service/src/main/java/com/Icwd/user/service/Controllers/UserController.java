package com.Icwd.user.service.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Icwd.user.service.Entities.User;
import com.Icwd.user.service.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	private Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1=userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	int retryCount=1;
	@GetMapping("/{userid}")
//	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
//	@Retry(name="ratingHotelService",fallbackMethod="ratingHotelFallBack")
	@RateLimiter(name="userRateLimiter" , fallbackMethod="ratingHotelFallBack")
	public ResponseEntity<User> getSingleUser(@PathVariable String userid)
	{
		logger.info("Count : {}",retryCount);
		retryCount++;
		User user1=userService.getUserById(userid);
		return ResponseEntity.ok(user1);
	}
	
	//creating fallback method for circute breaker\

	public ResponseEntity<User> ratingHotelFallBack(String userId,Exception ex)
	{
	//		logger.info("FallBack is Excuted because service is down",ex.getMessage());
		
			User user=User.builder()
			.email("dummy@gmail.com")
			.name("Dummy")
			.about("This is the user created dummy because service down")
			.ratings(null)
			.userId("122")
			.build();
			return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	
	

}
