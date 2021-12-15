package nl.novi.summerville.springboot.example.security.payload.request;

public class ModifyReservationRequest {
    private String reservationDate;

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
}
