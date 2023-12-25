package com.infosys.poolcarz.ride.repository;

import com.infosys.poolcarz.ride.entity.RideDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface RideRepository extends CrudRepository<RideDetailsEntity, Integer> {

    public RideDetailsEntity findBySourceAndDestinationAndCar(String source, String Destination,String Car);
}
