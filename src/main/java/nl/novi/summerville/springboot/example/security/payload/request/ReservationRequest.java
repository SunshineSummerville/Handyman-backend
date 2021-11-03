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

    private long customerId;

    private long categoryId;

    private String image;

//    private String categoryName;

    public ReservationRequest() {}

    public void setHandymanId(long handymanId) {
        this.handymanId = handymanId;
    }

    public long getHandymanId() {
        return handymanId;
    }

//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }

    @JsonProperty ("reservationDate")
    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

//test ff kijken of het wordt meegestuurd