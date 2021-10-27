package nl.novi.summerville.springboot.example.security.repository;

import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.domain.User;
import nl.novi.summerville.springboot.example.security.payload.request.ReservationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteById(Long aLong);
//    Reservation addReservationToUserById(Long userid, ReservationRequest reservationRequest);
//    Optional<Reservation> findByReservation(Long reservationNr);
      List<Reservation> findAll();
//    Boolean existsByReservationNr(String reservationNr);

    List<Reservation> findByCustomerId(long id);



}
