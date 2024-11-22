package com.icwd.ratings.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;




}
