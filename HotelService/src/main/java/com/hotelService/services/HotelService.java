package com.hotelService.services;

import java.util.List;

import com.hotelService.entities.Hotel;

public interface HotelService {

	Hotel addHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(String id);
}
