package nl.novi.summerville.springboot.example.security.repository;

import nl.novi.summerville.springboot.example.security.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteByReservationNr(Long aLong);
    //Reservation addReservationToUserById(Long userid, ReservationRequest reservationRequest);
    //Optional<Reservation> findByReservation(Long reservationNr);
    //<Reservation> findAllReservations(Long reservationNr);
    //Boolean existsByReservationNr(String reservationNr);


}