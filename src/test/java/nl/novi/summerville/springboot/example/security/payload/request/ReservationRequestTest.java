package nl.novi.summerville.springboot.example.security.payload.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRequestTest {

    @Test
    void createReservationRequest() {
        //arrange
        ReservationRequest testRequest = new ReservationRequest();
        // act
        testRequest.setHandymanId(2);
        testRequest.setCustomerId(1);
        testRequest.setCategoryId(5);
        testRequest.setReservationDate("2021-12-2");
        // assert
        assertEquals(2,testRequest.getHandymanId());
        assertEquals(1,testRequest.getCustomerId());
        assertEquals(5,testRequest.getCategoryId());
        assertEquals("2021-12-2", testRequest.getReservationDate());


    }


}