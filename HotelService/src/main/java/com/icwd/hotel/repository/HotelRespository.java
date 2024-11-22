package com.icwd.hotel.repository;

import com.icwd.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRespository extends JpaRepository<Hotel, String> {
}
