package nl.novi.summerville.springboot.example.security.repository;

import nl.novi.summerville.springboot.example.security.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteById(Long aLong);
    List<Reservation> findAll();
    List<Reservation> findByCustomerId(long id);
    List<Reservation> findByHandymanId(long id);



}
