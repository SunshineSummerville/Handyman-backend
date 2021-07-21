package nl.novi.summerville.springboot.example.security.service;

import nl.novi.summerville.springboot.example.security.domain.Category;
import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.domain.User;
import nl.novi.summerville.springboot.example.security.exception.ReservationNotFoundException;
import nl.novi.summerville.springboot.example.security.exception.UserNotFoundException;
import nl.novi.summerville.springboot.example.security.payload.request.ReservationRequest;
import nl.novi.summerville.springboot.example.security.repository.CategoryRepository;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService  {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public ReservationRepository reservationRepository;

    @Autowired
    public UserRepository userRepository;

    //@Override
    public Optional<Reservation> getReservationByNr (Long reservationNr) {
        return reservationRepository.findById(reservationNr);
    }

    public List<Reservation> getAllReservations(){
        List<Reservation> allReservations = reservationRepository.findAll();
        return allReservations;
    }

    public Reservation saveCustomerReservation(ReservationRequest reservationRequest) {

        String username = "";

        // Haal gegevens ingelogde gebruiker op
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();
            username = userPrincipal.getUsername();
        }

        User handyman = userRepository.findById(reservationRequest.getHandymanId()).orElseThrow( () ->
                new UserNotFoundException("Handyman Not Found"));

        User customer = userRepository.findByUsername(username).orElseThrow( () ->
                new UserNotFoundException("Customer Not Found"));

        Category category = categoryRepository.findById(reservationRequest.getCategoryName()).orElseThrow( () ->
                new UserNotFoundException("Category Not Found"));

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setHandyman(handyman);
        reservation.setReservationDate(reservationRequest.getReservationDate());
        reservation.setCategory(category);

        return reservationRepository.save(reservation);
    }

//    public Reservation saveReservation(ReservationRequest reservationRequest, Principal principal) {
//        // principal.getName() == 'handyman'
//        User handyman = userRepository.findByUsername(principal.getName())
//                .orElseThrow(() -> new UserNotFoundException("Handyman Not Found: " + principal.getName()));
//
//        //User customer = userRepository.findByUsername(reservationRequest.getCustomer())
//        //        .orElseThrow(() -> new UserNotFoundException("Customer Not Found: " + reservationRequest.getCustomer()));
//
//
//        // /api/reservaction
//        // Controller > Request (2 paramaters uit postman) + authorization token
//        // Service > vertaalt de request naar een custom reservation
//        // principal: daarmee haal je huidige ingelogde gebruiker op
//
//        return reservationRepository.save(new Reservation(
//                reservationRequest.getReservationDate(),
//                handyman,
//                customer
//        ));
//    }



    //@Override
//    public Reservation addResevation (Reservation newResevation) {
//        return reservationRepository.save(newResevation);
//    }

    //@Override
    public String deleteReservationByNr (Long reservatonNr) {
        Optional<Reservation> reservation = reservationRepository.findById(reservatonNr);
        if (reservation.isPresent()) {
            reservationRepository.deleteById(reservatonNr);
            return "Reservation " + reservation.get().getReservationNr() + " is verwijderd";
        }
        throw new ReservationNotFoundException( "Reservering bestaat niet.");
    }

    //@Override
    public Reservation updateReservationByNr(Long id, Reservation updatedReservation) {
        Optional<Reservation> reservationFromDb = reservationRepository.findById(id);

        if(reservationFromDb.isPresent()) { // check of reservering aanwezig is adhv nr
            Reservation oldReservation = reservationFromDb.get();
            oldReservation.setReservationDate(updatedReservation.getReservationDate());
            oldReservation.setCustomer(updatedReservation.getCustomer());

            return reservationRepository.save(oldReservation);
        }
        throw new ReservationNotFoundException(id);
    }





}
