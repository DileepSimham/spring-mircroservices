package com.infosys.poolcarz.fare.exception;

public enum ExceptionConstants {

    FARE_INVALID_SOURCE_DESTINATION("service.fare.invalid"),

    REQUESTED_OBJECT_NOT_FOUND("requested.object.not.found"),

    INPUT_PARM_MISSING("input.parameter.missing"),
    MEDIA_TYPE_NOT_SUPPORTED("media.type.not.supported"),
    MESSAGE_NOT_READABLE("message.not.readable"),
    SERVER_ERROR("server.error")

    ;

    private final String type;

    private ExceptionConstants(String type){
        this.type=type;
    }

    @Override
    public  String toString(){
        return this.type;
    }
}
