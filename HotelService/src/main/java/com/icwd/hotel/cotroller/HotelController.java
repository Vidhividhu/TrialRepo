package com.icwd.hotel.cotroller;

import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    @Autowired
    private final HotelService hotelService;

    //create hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //get single user
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
