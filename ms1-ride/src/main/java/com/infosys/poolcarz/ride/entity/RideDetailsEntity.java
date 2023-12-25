package com.infosys.poolcarz.ride.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RideDetails")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RideDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rideId;
    @Column(name = "carType")
    private String car;

    private String source;

    private String destination;

    private Integer seatsAvailable;
}
