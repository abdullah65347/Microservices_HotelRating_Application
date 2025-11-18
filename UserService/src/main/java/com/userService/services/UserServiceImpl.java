package com.userService.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.userService.entities.Hotel;
import com.userService.entities.Rating;
import com.userService.external.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.userService.entities.User;
import com.userService.repositories.UserRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;


	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user =  userRepository.findById(userId).orElseThrow(() -> new ResourceAccessException("User with given id is not found on server !!: "+ userId));

		String ratingUrl = "http://RATING-SERVICE/ratings/users/{userId}";
		Rating[] ratingArray = restTemplate.getForObject(ratingUrl, Rating[].class, userId);

		List<Rating> ratings = Arrays.asList(ratingArray);

//		String hotelUrl = "http://HOTEL-SERVICE/hotels/{hotelId}";

		for (Rating r : ratings) {
//			Hotel hotel = restTemplate.getForObject(hotelUrl, Hotel.class, r.getHotelId());
			Hotel hotel = hotelService.getHotel(r.getHotelId());
			r.setHotel(hotel);
		}
		user.setRating(ratings);

		return user;
	}

}
