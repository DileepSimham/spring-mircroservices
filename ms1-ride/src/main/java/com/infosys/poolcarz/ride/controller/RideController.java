package com.infosys.poolcarz.ride.controller;

import com.infosys.poolcarz.ride.dto.BookingConfirmationDTO;
import com.infosys.poolcarz.ride.dto.BookingDetailsDTO;
import com.infosys.poolcarz.ride.exception.PoolcarzException;
import com.infosys.poolcarz.ride.repository.BookingRepository;
import com.infosys.poolcarz.ride.repository.RideRepository;
import com.infosys.poolcarz.ride.service.RideServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Validated
public class RideController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RideServiceImpl rideService;

//    @GetMapping("/hello")
//    public String m1(){
//
////        return bookingRepository.findById(601).toString()+" "+rideRepository.findById(1).toString();
//
////        return restTemplate.getForObject("http://FareMS/fare/hello",String.class);
////        return rideService.hello();
//
//    }


    @PostMapping("/rides")
    public BookingConfirmationDTO bookride(@RequestBody @Valid BookingDetailsDTO bookingDetailsDTO) throws PoolcarzException {
       return rideService.bookRide(bookingDetailsDTO);

    }



}
