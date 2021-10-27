package nl.novi.summerville.springboot.example.security.controller;

import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.payload.request.ReservationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class TestReservationController {
    @Autowired
    ReservationController reservationController;

//    @Test
//    void createReservation(){
//        Reservation reservation = new Reservation();
//        SimpleDateFormat formatter= new SimpleDateFormat("dd-mm-yyyy");
//        reservation.setReservationDate(formatter.format(new Date()));
//        //reservation.setCategoryName("categorie dienst");//TODO
//        //reservationRequest.getHandymanId();
//
//        reservationController.saveReservation(reservation);
//
//
//
//
//
//
//    }
}
