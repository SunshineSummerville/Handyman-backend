package nl.novi.stuivenberg.springboot.example.security.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import nl.novi.stuivenberg.springboot.example.security.domain.JobCategory;
import nl.novi.stuivenberg.springboot.example.security.domain.User;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class ReservationRequest {

    @NotBlank
    private long reservationNr; // reservationNr = primary key
    @NotBlank
    private String reservationDate;

    @ManyToOne
    private User handyman;

    @ManyToOne
    @JsonIgnoreProperties
    // om te voorkomen dat dat er oneindige loop van users worden aangemaakt. De bidirectionele relatie zorgt ervoor dat we de "user" kunnen opvragen en de "reservation" automatisch meekomt. De reservering  heeft ook users en die komt ook automatisch mee.
    private User customer;

//    @ManyToOne
//    private JobCategory jobCategory;

    public long getReservationNr() {
        return reservationNr;
    }

    public void setReservationNr(long reservationNr) {
        this.reservationNr = reservationNr;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getHandyman() {
        return handyman;
    }

    public void setHandyman(User handyman) {
        this.handyman = handyman;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

//    public JobCategory getJobCategory() {
//        return jobCategory;
//    }
//
//    public void setJobCategory(JobCategory jobCategory) {
//        this.jobCategory = jobCategory;
//    }
//
}
