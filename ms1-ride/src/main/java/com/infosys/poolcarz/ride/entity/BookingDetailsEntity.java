package com.infosys.poolcarz.ride.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BookingDetails")
@Setter
@Getter
public class BookingDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private Integer rideId;

    private String userEmail;

    private String bookingStatus;

    @Override
    public String toString(){
        return "BookingDetailsEntity [bookingId="+bookingId+", rideId="+rideId+ ", userEmail="+userEmail+", " +
                " bookingStatus="+bookingStatus+"]";
    }
}
