package com.ratingService.services;

import java.util.List;

import com.ratingService.entities.Rating;

public interface RatingService {

	Rating addRating(Rating rating);

	List<Rating> getAllRatings();

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);

}
