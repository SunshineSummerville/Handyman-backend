package nl.novi.summerville.springboot.example.security.controller;


import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.domain.User;
import nl.novi.summerville.springboot.example.security.exception.ReservationNotFoundException;
import nl.novi.summerville.springboot.example.security.payload.request.ReservationRequest;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import nl.novi.summerville.springboot.example.security.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    public UserRepository userRepository;

    @GetMapping(value = "/api/reservation")
    public List<Reservation> getReservations() {
        List<Reservation> ReservationList = reservationRepository.findAll();
        return ReservationList;
    }

    @GetMapping(value = "/api/Reservation/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationRepository.findById(id).orElseThrow(
                () -> new ReservationNotFoundException(id));
    }

    @PostMapping(value = "/api/reservation")
    public Reservation saveReservation(@RequestBody Reservation newReservation) {
        return reservationRepository.save (newReservation);
    }


    @DeleteMapping(value = "/api/reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteByReservationNr(id);
    }

    @PostMapping(value = "/api/customer/reservation")
    @PreAuthorize("hasRole('USER')")
    public Reservation addReservationToHandyman(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.saveCustomerReservation(reservationRequest);
    }

    @PostMapping(value = "/api/reservation/{userid}")
    public Reservation addReservationToUserById(@PathVariable long userid,
                                                @RequestBody ReservationRequest reservationRequest) {

        Reservation reservation = new Reservation(
                reservationRequest.getReservationDate()
        );

        Optional<User> user =
                userRepository.findById(userid);
        if(user.isPresent()) {
            reservation.setCustomer(user.get());
            reservation.setHandyman(user.get());
            reservationRepository.save(reservation);
        }
        return reservationRepository.save(reservation);


    }


}