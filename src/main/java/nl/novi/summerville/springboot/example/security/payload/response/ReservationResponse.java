package nl.novi.summerville.springboot.example.security.payload.response;

import nl.novi.summerville.springboot.example.security.domain.Category;
import nl.novi.summerville.springboot.example.security.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class ReservationResponse {
    private long id;
    private String reservationDate;
    private User customer;
    private User handyman;
    private Category category;
    private String image;

    public ReservationResponse(long id, String reservationDate, User customer, User handyman, Category category, String image) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.customer = customer;
        this.handyman = handyman;
        this.category = category;
        this.image = image;
    }

    public ReservationResponse(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getHandyman() {
        return handyman;
    }

    public void setHandyman(User handyman) {
        this.handyman = handyman;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
