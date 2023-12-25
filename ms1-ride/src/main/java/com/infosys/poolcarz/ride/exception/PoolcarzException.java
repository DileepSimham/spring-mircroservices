package com.infosys.poolcarz.ride.exception;

import com.infosys.poolcarz.ride.utility.ClientErrors;

public class PoolcarzException extends Exception {

    private static final long serialVersionUID=1L;
    private transient ClientErrors errors;

    public PoolcarzException(String message, ClientErrors errors) {
        super(message);
        this.errors = errors;
    }

    public PoolcarzException(String message) {
        super(message);
    }

    public PoolcarzException() {
    }

    public ClientErrors getErrors() {
        return errors;
    }
}
