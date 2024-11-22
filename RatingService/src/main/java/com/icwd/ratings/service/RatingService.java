package com.icwd.ratings.service;

import com.icwd.ratings.entities.Rating;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getRatings();

    //get all by userId
    List<Rating> getRatingsByUserId(String userId);


    //get all by hotel
    List<Rating> getRatingsByHotelId(String hotelId);


}
