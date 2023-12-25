package com.infosys.poolcarz.ride.dto;

import com.infosys.poolcarz.ride.entity.RideDetailsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDetailsDTO {
    private Integer rideId;

    private String car;

    private String source;

    private String destination;

    private Integer seatsAvailable;

    public static RideDetailsEntity prepareRideEntity(RideDetailsEntity rideDTO) {
        RideDetailsEntity rideEntity = new RideDetailsEntity();
        rideEntity.setCar(rideEntity.getCar());
        rideEntity.setSeatsAvailable(rideDTO.getSeatsAvailable());
        rideEntity.setDestination(rideEntity.getDestination());
        rideEntity.setSource(rideEntity.getSource());
        return rideEntity;
    }

    public static RideDetailsDTO prepareRideDTO(RideDetailsEntity rideEntity){
        RideDetailsDTO dto=new RideDetailsDTO();
        dto.setCar(rideEntity.getCar());
        dto.setSeatsAvailable(rideEntity.getSeatsAvailable());
        dto.setDestination(rideEntity.getDestination());
        dto.setSource(rideEntity.getSource());
        dto.setRideId(rideEntity.getRideId());
        return dto;
    }
}
