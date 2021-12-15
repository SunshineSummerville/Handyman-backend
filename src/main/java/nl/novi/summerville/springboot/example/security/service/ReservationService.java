package nl.novi.summerville.springboot.example.security.service;

import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.payload.request.ModifyReservationRequest;
import nl.novi.summerville.springboot.example.security.repository.CategoryRepository;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ReservationService  {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public ReservationRepository reservationRepository;

    @Autowired
    public UserRepository userRepository;


    public Reservation modifyReservationsById(Long id, ModifyReservationRequest modifyReservationRequest) {
        Optional<Reservation> reservationFromDb = reservationRepository.findById(id);
        Reservation oldReservation = reservationFromDb.get();
        oldReservation.setReservationDate(modifyReservationRequest.getReservationDate());


        return reservationRepository.save(oldReservation);


    }


}
