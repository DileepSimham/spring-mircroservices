package com.infosys.poolcarz.ride.exception;

public enum ExceptionConstants {
    RIDE_ALREADY_EXISTS("service.ride.exists"),
    RIDE_SAME_SOURCE_DESTINATION("validation.source.destination.same"),

    RIDE_NOT_FOUND("service.ride.notavailable"),

    RIDE_BOOKING_EXISTS("service.booking.exists"),
    RIDE_INVALID_BOOKINGID("service.bookingid.invalid"),
    RIDE_SEATS_NOTAVAILABLE("service.seats.notavailable"),

    REQUESTED_OBJECT_NOT_FOUND("requested.object.not found"),

    INPUT_PARAM_MISSING("input.parameter.missing"),

    MEDIA_TYPE_NOT_SUPPORTED("media.type.not.supported"),

    MESSAGE_NOT_READABLE("message.not.readable");




    private final String type;

    private ExceptionConstants(String type){
        this.type=type;
    }

    @Override
    public String toString(){
        return this.type;
    }

}
