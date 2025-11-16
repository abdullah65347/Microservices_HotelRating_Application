package com.hotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelService.entities.Hotel;
import com.hotelService.exceptions.ResourceNotFoundException;
import com.hotelService.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	private static int counter = 3001;

	public String generateRatingId() {
		return "H" + counter++;
	}
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		String hotelId = generateRatingId();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hotel found with this Id"));
	}

}
