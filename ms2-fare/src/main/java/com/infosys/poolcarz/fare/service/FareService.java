package com.infosys.poolcarz.fare.service;

import com.infosys.poolcarz.fare.exception.FareException;
import org.springframework.stereotype.Service;


public interface FareService {

    public Integer getFare(String source, String destination) throws FareException;
}
