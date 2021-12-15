package nl.novi.summerville.springboot.example.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;


@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )

    @Column(columnDefinition = "serial")
    private long id;

    @Column(nullable = false)
    private String reservationDate;

    @ManyToOne
    private User handyman;

    @ManyToOne
    @JsonIgnore
    private User customer;

    @ManyToOne
    private Category category;

    @Column(columnDefinition="TEXT")
    private String image;

    public Reservation() {
    }


    public Reservation(String reservationDate) { // constructor gelinkt met controller
        this.reservationDate = reservationDate;
    }

    public Reservation(String reservationDate, User handyman, User customer,Category category,String image) {
        this.reservationDate = reservationDate;
        this.handyman = handyman;
        this.customer = customer;
        this.category = category;
        this.image = image;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
