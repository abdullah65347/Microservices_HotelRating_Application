package com.hotelService.controllers;

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
import com.hotelService.entities.Hotel;
import com.hotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping()
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotel));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(id));
	}

}
