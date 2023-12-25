package com.infosys.poolcarz.ride.utility;

import lombok.ToString;

@ToString
public class ClientErrorInfo {

    String code;

    String message;

    public ClientErrorInfo() {
    }

    public ClientErrorInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
