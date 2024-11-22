package com.icwd.hotel.entities;


import ch.qos.logback.core.joran.spi.NoAutoStart;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
//@Table(name = "hotel")
public class Hotel {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String hotelId;
    private String name;
    private String location;
    private String about;

}
