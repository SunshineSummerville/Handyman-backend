package nl.novi.summerville.springboot.example.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReservationNotFoundAdvice { // hiermee laat je springboot weten hoe het met de exceptie moet omgaan

    /**
     * Met ResponseBody geven we aan dat we een naar JSON geserialized object teruggeven. Dit object wordt in een
     * HTTPResponse gezet.
     *
     * De ExceptionHandler moet een verwijzing bevatten naar de Exceptie die we gemaakt hebben. Let op, hier moet class
     * achter.
     *
     * Met ResponseStatus geven we aan welke HTTP status we willen meegeven. HTTP 404 is zo'n status. De 404 betekent
     * not found. Je kunt ze hier allemaal vinden:
     * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
     * @param ex De exceptie.
     * @return The error message.
     */
    @ResponseBody
    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String reservationNotFoundHandler(ReservationNotFoundException ex) {
        return ex.getMessage();
    }
}