package com.infosys.poolcarz.fare.service;

import com.infosys.poolcarz.fare.entity.FareDetailsEntity;
import com.infosys.poolcarz.fare.exception.ExceptionConstants;
import com.infosys.poolcarz.fare.exception.FareException;
import com.infosys.poolcarz.fare.repository.FareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fareService")
public class FareServiceImpl implements FareService{

    @Autowired
    FareRepository fareRepository;

    public Integer getFare(String source, String destination) throws FareException{
        FareDetailsEntity entity=fareRepository.findBySourceAndDestination(source,destination);
        if(entity==null)
            throw new FareException(ExceptionConstants.FARE_INVALID_SOURCE_DESTINATION.toString());

        return entity.getFare();
    }
}
