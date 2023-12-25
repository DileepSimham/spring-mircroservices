package com.infosys.poolcarz.ride.service;

import com.infosys.poolcarz.ride.dto.BookingConfirmationDTO;
import com.infosys.poolcarz.ride.dto.BookingDetailsDTO;
import com.infosys.poolcarz.ride.exception.PoolcarzException;

public interface RideService {

    public BookingConfirmationDTO bookRide(BookingDetailsDTO bookingDTO) throws PoolcarzException;

    public BookingDetailsDTO getRideByBookingId(int id) throws PoolcarzException;

    public boolean isValidSourceAndDestination(String source,String destination);


}
