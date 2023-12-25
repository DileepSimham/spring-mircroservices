package com.infosys.poolcarz.ride.utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientErrors {

    List<ClientErrorInfo> errors;

    public ClientErrors(String errorCode, String errorMessage) {
        super();
        errors = new ArrayList<>();
        errors.add(new ClientErrorInfo(errorCode, errorMessage));
    }

    public void addError(String errorCode, String errorMessage) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(new ClientErrorInfo(errorCode, errorMessage));
    }




}
