package com.icwd.ratings.service;

import com.icwd.ratings.entities.Rating;
import com.icwd.ratings.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{

    private final RatingRepository ratingRepository;


    @Override
    public Rating create(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        List<Rating> all = ratingRepository.findAll();
        return all;
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        List<Rating> byUserId = ratingRepository.findByUserId(userId);
        return byUserId;
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        List<Rating> byHotelId = ratingRepository.findByHotelId(hotelId);
        return byHotelId;
    }
}
