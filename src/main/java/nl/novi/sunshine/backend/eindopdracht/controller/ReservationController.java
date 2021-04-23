package nl.novi.sunshine.backend.eindopdracht.controller;


import nl.novi.sunshine.backend.eindopdracht.domain.Reservation;
import nl.novi.sunshine.backend.eindopdracht.domain.User;
import nl.novi.sunshine.backend.eindopdracht.exception.ReservationNotFoundException;
import nl.novi.sunshine.backend.eindopdracht.payload.request.ReservationRequest;
import nl.novi.sunshine.backend.eindopdracht.repository.ReservationRepository;
import nl.novi.sunshine.backend.eindopdracht.repository.UserRepository;
import nl.novi.sunshine.backend.eindopdracht.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    public UserRepository userRepository;

    @GetMapping(value = "/reservation")
    public List<Reservation> getReservations() {
        List<Reservation> ReservationList = reservationService.getAllReservations();
        return ReservationList;
    }

    @GetMapping(value = "/reservation/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationByNr(id).orElseThrow(
                () -> new ReservationNotFoundException(id));
    }

    @PostMapping(value = "/reservation")
    public Reservation saveReservation(@RequestBody ReservationRequest reservationRequest, Principal principal) {
        return reservationService.saveReservation (reservationRequest, principal);
    }


    @DeleteMapping(value = "/reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationByNr(id);
    }

    @PutMapping(value = "/reservation/{userid}")
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