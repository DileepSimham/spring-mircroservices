package com.infosys.poolcarz.ride.repository;

import com.infosys.poolcarz.ride.entity.BookingDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingDetailsEntity,Integer> {

    public BookingDetailsEntity findByUserEmailAndBookingStatus(String email, String status);

    public BookingDetailsEntity findByRideId(Integer rideId);
}
