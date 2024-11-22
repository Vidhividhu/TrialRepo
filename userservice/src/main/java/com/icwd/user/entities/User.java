package com.icwd.user.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="micro_users")
public class User {
    @Id
    @Column(name = "id")
    private String userId;
    @Column(length = 20)
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings;
}
