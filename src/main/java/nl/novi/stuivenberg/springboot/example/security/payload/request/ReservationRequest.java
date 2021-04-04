package nl.novi.stuivenberg.springboot.example.security.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import nl.novi.stuivenberg.springboot.example.security.domain.JobCategory;
import nl.novi.stuivenberg.springboot.example.security.domain.User;

import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

public class ReservationRequest {

    @NotBlank
    private long reservationNr; // reservationNr = primary key
    @NotBlank
    @FutureOrPresent(message = "reservation must not be in the past.")
//    @JsonFormat(shape = JsonFormat.Shape.STRING,
//            pattern = "dd-mm-yyyy") //@JsonFormat is used to control the output format of the Date
    private String reservationDate;


    private User handyman;

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
