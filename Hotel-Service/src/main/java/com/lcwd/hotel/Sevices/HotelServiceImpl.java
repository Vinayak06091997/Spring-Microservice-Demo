package com.lcwd.hotel.Sevices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.Entities.Hotel;
import com.lcwd.hotel.Exceptions.ResourceNotFoundException;
import com.lcwd.hotel.Repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	
	
	public Hotel create(Hotel hotel) {
		String id=UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepository.save(hotel);
	}

	
	

	public List<Hotel> getAll() {
		
		return hotelRepository.findAll();
	}
	
	

	public Hotel getHotel(String id) {
		
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel id not found"));
	}
}
