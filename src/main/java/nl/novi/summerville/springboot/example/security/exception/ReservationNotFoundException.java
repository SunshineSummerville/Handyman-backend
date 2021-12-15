package nl.novi.summerville.springboot.example.security.exception;

public class ReservationNotFoundException extends RuntimeException {

    /**
     * Creates the ReservationNotFoundException
     * @param id of the reservation that was not found in the database
     */
    public ReservationNotFoundException(Long id) {
        super("Could not find reservation : " + id);
    }
    public ReservationNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}