package com.ratingService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingService.entities.Rating;
import com.ratingService.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository ratingRepository;

	private static int counter = 1001;

	public String generateRatingId() {
		return "R" + counter++;
	}

	@Override
	public Rating addRating(Rating rating) {
		String id = generateRatingId();
		rating.setRatingId(id);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
