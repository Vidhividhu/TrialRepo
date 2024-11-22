package com.icwd.hotel.service;


import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.exception.ResourceNotFoundException;
import com.icwd.hotel.repository.HotelRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRespository hotelRespository;

    @Override
    public Hotel create(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRespository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRespository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        Hotel hotel = hotelRespository.findById(id).orElseThrow(() -> new ResourceAccessException("Resurce not found exception!!"));
        return hotel;
    }
}
