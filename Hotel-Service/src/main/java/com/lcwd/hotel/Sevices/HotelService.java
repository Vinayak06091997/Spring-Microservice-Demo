package com.lcwd.hotel.Sevices;

import java.util.List;

import com.lcwd.hotel.Entities.Hotel;

public interface HotelService {
	
	
	public Hotel create(Hotel hotel);
	
	
	public List<Hotel> getAll();
	
	
	public Hotel getHotel(String id);
	
	

}
