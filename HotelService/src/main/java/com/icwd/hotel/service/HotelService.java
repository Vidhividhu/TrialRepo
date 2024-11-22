package com.icwd.hotel.service;

import com.icwd.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {


    //create a new hotel
    Hotel create(Hotel hotel);

    //get all hotels detail
    List<Hotel> getAll();


    //get single hotel
    Hotel getHotel(String id);
}
