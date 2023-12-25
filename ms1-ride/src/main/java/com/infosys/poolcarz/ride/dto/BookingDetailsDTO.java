package com.infosys.poolcarz.ride.dto;

import com.infosys.poolcarz.ride.entity.BookingDetailsEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class BookingDetailsDTO {

    private Integer rideId;

    @NotNull(message = "{booking.email.mandatory}")
    private String userEmail;

    private String bookingStatus;

    @NotNull(message = "{booking.source.mandatory}")
    private String source;
    @NotNull(message = "{booking.destination.mandatory}")
    private String destination;

    @NotNull(message = "{booking.car.mandatory}")
    @Pattern(regexp = "(Economy|Sedan|Premier)", message ="{booking.carType.invalid}" )
    private String carType;

    public BookingDetailsDTO(){
        rideId=0;
        userEmail=null;
    }

    public static BookingDetailsEntity prepareBookingEntity(BookingDetailsDTO bookingDTO){
        BookingDetailsEntity bookingEntity=new BookingDetailsEntity();
        bookingEntity.setRideId(bookingDTO.getRideId());
        bookingEntity.setUserEmail(bookingDTO.getUserEmail());
        bookingEntity.setBookingStatus(bookingDTO.getBookingStatus());
        return bookingEntity;
    }






}
