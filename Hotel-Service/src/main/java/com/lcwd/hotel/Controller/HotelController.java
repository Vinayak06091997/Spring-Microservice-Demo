
package com.lcwd.hotel.Controller;

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

import com.lcwd.hotel.Entities.Hotel;
import com.lcwd.hotel.Sevices.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	
	//Create 
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	
	//Get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getallHotel()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
	}
	
	//getSingle
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(id));
	}
	
	
	

}




