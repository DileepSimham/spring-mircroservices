package com.infosys.poolcarz.fare.controller;

import com.infosys.poolcarz.fare.exception.FareException;
import com.infosys.poolcarz.fare.repository.FareRepository;
import com.infosys.poolcarz.fare.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fare")
public class FareController {

    @Autowired
//    @Qualifier("fareService")
    private FareService rideService;

    @Autowired
    private FareRepository fareRepository;

    @GetMapping(value = "/{source}/{destination}")
    public Integer getRideById(@PathVariable String source, @PathVariable String destination) throws FareException{
        System.out.println(" in FAREMS ====");
        return rideService.getFare(source,destination);
    }

    @GetMapping("/hello")
    public String m1(){
        return fareRepository.findById(1).toString();
    }
}
