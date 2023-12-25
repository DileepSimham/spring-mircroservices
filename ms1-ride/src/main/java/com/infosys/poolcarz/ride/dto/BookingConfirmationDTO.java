package com.infosys.poolcarz.ride.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingConfirmationDTO {

    private Integer bookingId;
    private String bookedBy;

    private String bookingStatus;

    private Integer fare;

    public static BookingConfirmationDTO prepareConfirmationDTO(Integer bookingId, String email,String status,Integer fare){
        return new BookingConfirmationDTO(bookingId,email,status,fare);
    }



}
