package com.infosys.poolcarz.fare.exception;

import com.infosys.poolcarz.fare.utility.ClientErrors;

public class FareException extends Exception {

    private static final long serialVersionUID=1L;

    private  transient ClientErrors errors;

    public FareException(String message) {
        super(message);
    }

    public FareException(String message, ClientErrors errors) {
        super(message);
        this.errors = errors;
    }

    public ClientErrors getErrors() {
        return errors;
    }
}
