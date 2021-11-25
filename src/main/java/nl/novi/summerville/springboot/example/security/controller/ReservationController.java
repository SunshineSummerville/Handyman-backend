package nl.novi.summerville.springboot.example.security.controller;


import nl.novi.summerville.springboot.example.security.domain.Category;
import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.domain.User;
import nl.novi.summerville.springboot.example.security.exception.ReservationNotFoundException;
import nl.novi.summerville.springboot.example.security.payload.request.ModifyReservationRequest;
import nl.novi.summerville.springboot.example.security.payload.request.ReservationRequest;
import nl.novi.summerville.springboot.example.security.payload.response.ReservationResponse;
import nl.novi.summerville.springboot.example.security.repository.CategoryRepository;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import nl.novi.summerville.springboot.example.security.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @GetMapping(value = "/api/reservation")
    public List<Reservation> getReservations() {
        List<Reservation> ReservationList = reservationRepository.findAll();
        return ReservationList;
    }

    @GetMapping(value = "/api/reservation/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationRepository.findById(id).orElseThrow(
                () -> new ReservationNotFoundException(id));
    }


    @PostMapping(value = "/api/reservation")
    public ResponseEntity<ReservationResponse> saveReservation(@RequestBody ReservationRequest reservationRequest) {
        long handymanId = reservationRequest.getHandymanId();
        Optional<User> handyman = userRepository.findById(handymanId);
        long customerId = reservationRequest.getCustomerId();
        Optional<User> customer = userRepository.findById(customerId);
        long categoryId = reservationRequest.getCategoryId();
        Optional <Category> category = categoryRepository.findById(categoryId);
        String date = reservationRequest.getReservationDate();
        String image = reservationRequest.getImage();
        if (handyman.isPresent()&& customer.isPresent()&& category.isPresent()){
            Reservation newReservation = new Reservation(date,handyman.get(),customer.get(), category.get(), image);
            reservationRepository.save(newReservation);

            return ResponseEntity.status(HttpStatus.CREATED).body( new ReservationResponse(newReservation.getId(),newReservation.getReservationDate(), newReservation.getCustomer(), newReservation.getHandyman(), newReservation.getCategory(), newReservation.getImage()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ReservationResponse());
    }


    @DeleteMapping(value = "/api/reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
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



    @PatchMapping(value = "/api/reservation/{id}")
    public ResponseEntity<Reservation> modifyReservationsById  (@PathVariable long id, @RequestBody ModifyReservationRequest modifyReservationRequest) {
        Reservation updatedReservation = reservationService.modifyReservationsById(id,modifyReservationRequest);

        return ResponseEntity.status(HttpStatus.OK).body(updatedReservation);

    }


}