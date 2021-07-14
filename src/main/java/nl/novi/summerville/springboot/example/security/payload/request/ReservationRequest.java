package nl.novi.summerville.springboot.example.security.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

public class ReservationRequest {

    @NotBlank
    @FutureOrPresent(message = "reservation must not be in the past.")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-mm-yyyy") //@JsonFormat is used to control the output format of the Date
    private String reservationDate;

    private long handymanId;

    private String categoryName;

    public ReservationRequest() {}

    public void setHandymanId(long handymanId) {
        this.handymanId = handymanId;
    }

    public long getHandymanId() {
        return handymanId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty ("reservationdate")
    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

//    public User getHandyman() {
//        return handyman;
//    }
//
//    public void setHandyman(User handyman) {
//        this.handyman = handyman;
//    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    } // nu staat er een String waardoor de customer handmatig aan de reservering moet worden toegevoegd. uiteindelijk is het de bedoeling dat de "customer" automatisch wordt toegevoegd.

//    public JobCategory getJobCategory() {
//        return jobCategory;
//    }
//
//    public void setJobCategory(JobCategory jobCategory) {
//        this.jobCategory = jobCategory;
//    }
//
}
