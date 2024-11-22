package com.icwd.ratings.controller;


import com.icwd.ratings.entities.Rating;
import com.icwd.ratings.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    //create ratings
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    //get all by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    //get all by hotelId
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }
}
