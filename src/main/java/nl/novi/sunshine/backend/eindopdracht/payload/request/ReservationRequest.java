package nl.novi.sunshine.backend.eindopdracht.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
//import nl.novi.stuivenberg.springboot.example.security.domain.JobCategory;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

public class ReservationRequest {

    @NotBlank
    @FutureOrPresent(message = "reservation must not be in the past.")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-mm-yyyy") //@JsonFormat is used to control the output format of the Date
    private String reservationDate;

    private String customer;



//    @ManyToOne
//    private JobCategory jobCategory;


    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
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
