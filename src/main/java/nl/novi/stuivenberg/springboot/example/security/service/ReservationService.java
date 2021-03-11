package nl.novi.stuivenberg.springboot.example.security.service;

import nl.novi.stuivenberg.springboot.example.security.domain.Reservation;
import nl.novi.stuivenberg.springboot.example.security.payload.request.ReservationRequest;
import nl.novi.stuivenberg.springboot.example.security.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@Autowired
@Service
public class ReservationService  {


    public ReservationRepository reservationRepository;

//    public List<Reservation> getAllReservations(){
//        List<Reservation> allReservations = reservationRepository.();
//        return allReservations;
//    }

//    @Override
//    public Optional<Reservation> getReservationByNr (Long reservationNr) {
//        return reservationRepository.findById(reservationNr);
//    }
//
//    @Override
//    public Reservation addResevation (Reservation newResevation) {
//        return reservationRepository.save(newResevation);
//    }
//
//    @Override
//    public String deleteReservationByNr (Long reservatonNr) {
//        Optional<Reservation> reservation = reservationRepository.findById(reservatonNr);
//        if (reservation.isPresent()) {
//            reservationRepository.deleteById(reservatonNr);
//            return "Reservation " + reservation.get().getReservationNr() + " is verwijderd";
//        }
//        throw new ReservationNotFoundException( "Reservering bestaat niet.");
//    }
//
//    @Override
//    public Reservation updateReservationByNr(Long id, Reservation updatedReservation) {
//        Optional<Reservation> reservationFromDb = reservationRepository.findById(id);
//
//        if(reservationFromDb.isPresent()) { // check of reservering aanwezig is adhv nr
//            Reservation oldReservation = reservationFromDb.get();
//            oldReservation.setReservationDate(updatedReservation.getReservationDate());
//            oldReservation.setCustomer(updatedReservation.getCustomer());
//
//            return reservationRepository.save(oldReservation);
//        }
//        throw new ReservationNotFoundException(id);
//    }
//




}
