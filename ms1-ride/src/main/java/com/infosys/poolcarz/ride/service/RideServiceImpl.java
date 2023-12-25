package com.infosys.poolcarz.ride.service;

import com.infosys.poolcarz.ride.dto.BookingConfirmationDTO;
import com.infosys.poolcarz.ride.dto.BookingDetailsDTO;
import com.infosys.poolcarz.ride.entity.BookingDetailsEntity;
import com.infosys.poolcarz.ride.entity.RideDetailsEntity;
import com.infosys.poolcarz.ride.exception.ExceptionConstants;
import com.infosys.poolcarz.ride.exception.PoolcarzException;
import com.infosys.poolcarz.ride.repository.BookingRepository;
import com.infosys.poolcarz.ride.repository.RideRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    @CircuitBreaker(name = "bookRideFB", fallbackMethod = "bookRideFB")
    public BookingConfirmationDTO bookRide(BookingDetailsDTO bookingDTO) throws PoolcarzException {
        if (!isValidSourceAndDestination(bookingDTO.getSource(), bookingDTO.getDestination())) {
            throw new PoolcarzException(ExceptionConstants.RIDE_SAME_SOURCE_DESTINATION.toString());
        }

        BookingDetailsEntity bookingDetailsEntity = bookingRepository.findByUserEmailAndBookingStatus(bookingDTO.getUserEmail(), bookingDTO.getBookingStatus());
        System.out.println(bookingDetailsEntity);
        for (int i = 0; i < 5; i++) {
            System.out.print("------");
        }

        if (bookingDetailsEntity != null) {
            throw new PoolcarzException(ExceptionConstants.RIDE_BOOKING_EXISTS.toString());
        }

        RideDetailsEntity rideDetailsEntity = rideRepository.findBySourceAndDestinationAndCar(bookingDTO.getSource(), bookingDTO.getDestination(), bookingDTO.getCarType());

        if (rideDetailsEntity == null) {
            throw new PoolcarzException(ExceptionConstants.RIDE_NOT_FOUND.toString());
        }

        if (rideDetailsEntity.getSeatsAvailable() < 1) {
            throw new PoolcarzException(ExceptionConstants.RIDE_SEATS_NOTAVAILABLE.toString());
        }

        String url = "http://FareMS/fare/" + rideDetailsEntity.getSource() + "/" + rideDetailsEntity.getDestination();

        Integer fare = restTemplate.getForObject(url, Integer.class);
        bookingDTO.setBookingStatus("Booked");
        bookingDTO.setRideId(rideDetailsEntity.getRideId());

        BookingDetailsEntity bookingDetailsEntity1 = BookingDetailsDTO.prepareBookingEntity(bookingDTO);

        BookingDetailsEntity bookingDetailsEntity2 = bookingRepository.save(bookingDetailsEntity1);

        rideDetailsEntity.setSeatsAvailable(rideDetailsEntity.getSeatsAvailable() - 1);


        return BookingConfirmationDTO.prepareConfirmationDTO(bookingDetailsEntity2.getBookingId(), bookingDetailsEntity2.getUserEmail(), bookingDetailsEntity2.getBookingStatus(), fare);
    }

    public BookingConfirmationDTO bookRideFB(BookingDetailsDTO bookingDetailsDTO, Throwable throwable) throws PoolcarzException {
        BookingConfirmationDTO bookingConfirmationDTO = new BookingConfirmationDTO();
        if (throwable instanceof PoolcarzException) {
            throw (PoolcarzException) throwable;
        }
        bookingConfirmationDTO.setBookingId(0);
        bookingConfirmationDTO.setBookedBy(bookingDetailsDTO.getUserEmail());
        bookingConfirmationDTO.setFare(0);
        bookingConfirmationDTO.setBookingStatus("An error occured. please try again");
        return bookingConfirmationDTO;
    }

    @Override
    public BookingDetailsDTO getRideByBookingId(int id) throws PoolcarzException {
        return null;
    }

//    @CircuitBreaker(name = "check", fallbackMethod = "check")
//    public String hello() {
//
//            return restTemplate.getForObject("http://FareMS/fare/hello", String.class);
//
//    }
//
//    public String check(Throwable t) {
//        return "sorry try again";
//    }

    @Override
    public boolean isValidSourceAndDestination(String source, String destination) {
        return false;
    }
}
