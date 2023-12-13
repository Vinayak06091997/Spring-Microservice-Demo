package com.lcwd.hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.Entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
